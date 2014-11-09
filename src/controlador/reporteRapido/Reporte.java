package controlador.reporteRapido;

import controlador.modelosRespuestas.Obj_respuestas;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import vista.Eviu;

public class Reporte{
    private final vista.Eviu Eviu;
    private final String str_nomProyecto;
    private final String pdf_nombre;
    private final String pdf_direccion;

    public Reporte(Eviu Eviu, String str_nomProyecto, String pdf_nombre, String pdf_direccion) {
        this.Eviu = Eviu;
        this.str_nomProyecto = str_nomProyecto;
        this.pdf_nombre = pdf_nombre;
        this.pdf_direccion = pdf_direccion;
        
        if(!controlador.Archivos.expresionRegular(pdf_nombre, ".*.pdf")){
            String[] tem = pdf_nombre.split("\\.");
            pdf_nombre= tem[0]+".pdf";
        }
        
        generarReporte();
    }
    
    private void generarReporte(){
        
        int count = 0;
        java.util.ArrayList<String> 
                lst_Tests = controlador.Archivos.getTests(str_nomProyecto);
        for (String test : lst_Tests) {
            ArrayList<Obj_respuestas> 
                    getRespuestas = controlador.LeerDatos.getRespuestas(str_nomProyecto, test);            
        }
        
    
        /*      Crear JDialog para la barra de progreso         */
        JProgressBar barraProgreso = new JProgressBar (0,100);
        JDialog JD_Progreso = new JDialog(Eviu,"Progreso");
        JD_Progreso.setSize(100, 900);
        JD_Progreso.getContentPane().add(barraProgreso);
        JD_Progreso.pack();
        JD_Progreso.setLocationRelativeTo(null);
        JD_Progreso.setVisible(true);
        /*      FIN de Crear JDialog para la barra de progreso      */
        
        /*      Ejecuto SwingWorker     */
        GenerarReporte GenerarReporte = new GenerarReporte(barraProgreso,
                str_nomProyecto,pdf_nombre,pdf_direccion);
        GenerarReporte.execute();
        
        /*      Le pido el resultado a GenerarReporte      */
        /*      Se llama en un nuevo hilo porque es bloqueante     */
        new RespuestaWorker(GenerarReporte,JD_Progreso).start();
    }
    public class RespuestaWorker  extends Thread{
        final GenerarReporte worker;
        JDialog JD_Progreso;
        public RespuestaWorker(GenerarReporte worker, JDialog JD_Progreso) {
            this.worker=worker;
            this.JD_Progreso = JD_Progreso;
        }

        @Override
        public void run() {
            try {
                System.out.println("respuesta "+worker.get());
                JD_Progreso.dispose();
            } catch (InterruptedException | ExecutionException ex) {
                System.out.println("Error en calss Reporte subclass RespuestaWorker");
                JD_Progreso.dispose();
                javax.swing.JOptionPane.showMessageDialog(null,"error al crear pdf");
            }
        }
        
    }
    
}
