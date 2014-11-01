
package controlador.reporteRapido;

import java.util.List;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;


public class GenerarReporte extends SwingWorker<Boolean,Integer>{
//    private final javax.swing.JProgressBar progreso;
    private final JProgressBar progreso;  
    private final String nomProyecto;
    private final String pdf_nombre;
    private final String pdf_direccion;
    private boolean resultado = false ;

    public GenerarReporte(JProgressBar progreso, String nomProyecto, 
            String pdf_nombre, String pdf_direccion) {
        this.progreso = progreso;
        this.nomProyecto = nomProyecto;
        this.pdf_nombre = pdf_nombre;
        this.pdf_direccion = pdf_direccion;
    }
    
    @Override
    protected Boolean doInBackground() throws Exception {
        resultado = false ;
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("interrumpido");
            }
            resultado = true;

            // Se pasa valor para la barra de progreso. ESto llamara al metodo
            // process() en el hilo de despacho de eventos.
            
            publish(i+1);
            
        }
        return resultado;
    }
    
    @Override
    protected void done(){
        // cuando termine
        javax.swing.JOptionPane.showMessageDialog(null, "terminado");
    }
    
    @Override
    protected void process(List<Integer> lst){
        //actializa la barra de progreso
        progreso.setValue(lst.get(0));
    }
}
