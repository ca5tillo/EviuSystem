package controlador.reporteRapido;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.modelos.Categoria;
import controlador.modelosRespuestas.Obj_respuestas;
import controlador.modelosRespuestas.Perfil;
import controlador.modelosRespuestas.Respuestas;
import java.awt.Font;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class GenerarReporte extends SwingWorker<Boolean, Integer> {
//    private final javax.swing.JProgressBar progreso;

    private final JProgressBar progreso;
    private final String nomProyecto;
    private final String pdf_nombre;
    private final String pdf_direccion;
    private boolean resultado = false;

    public GenerarReporte(JProgressBar progreso, String nomProyecto,
            String pdf_nombre, String pdf_direccion) {
        this.progreso = progreso;
        this.nomProyecto = nomProyecto;
        this.pdf_nombre = pdf_nombre;
        this.pdf_direccion = pdf_direccion;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        resultado = false;

        /*      Iniciar el PDF       */
        Document Documento = new Document();
        FileOutputStream pdf = new FileOutputStream(pdf_direccion + "/" + pdf_nombre);
        PdfWriter.getInstance(Documento, pdf).setInitialLeading(20);
        Documento.open();
        System.out.println(pdf_direccion + "/" + pdf_nombre);

        /*      Insertar datos          */
        Paragraph titulo = new Paragraph(nomProyecto,
                FontFactory.getFont("arial", // fuente
                        26, // tamaño
                        Font.BOLD, // estilo
                        BaseColor.BLACK));
        titulo.setAlignment(Element.ALIGN_CENTER);
        Documento.add(titulo);

        Paragraph descripcion = new Paragraph();
        descripcion.add("\n\n\nDescripción:\n\n");
        descripcion.add(controlador.LeerDatos.getDescripcionProyecto(nomProyecto));
        descripcion.add("\n\n\nEste proyecto con tiene los siguientes Test:\n\n");
        
        String intro_test= "";

        java.util.ArrayList<String> 
                Tests = controlador.Archivos.getTests(nomProyecto);
        for (String test : Tests) {
            int numRegistros = 0;
            ArrayList<Obj_respuestas> 
                    Respuestas = controlador.LeerDatos.getRespuestas(nomProyecto, test);
            for (Obj_respuestas obj_respuestas : Respuestas) {
                java.util.ArrayList<controlador.modelosRespuestas.Respuestas> 
                        respuestas = obj_respuestas.getRespuestas();
                numRegistros = respuestas.size();
            }
            intro_test += "* " + test + "  (Se realizo " + numRegistros + " veces)\n";

        }
        descripcion.add(intro_test);
        descripcion.add("\n\n\nPerfil:\n\n");

        String pdf_perfil = "";
        java.util.ArrayList<controlador.modelos.Categoria> 
                perfil = controlador.LeerDatos.getPerfil(nomProyecto);
        for (Categoria cat : perfil) {
            String pdf_categoria = cat.getCategoria();
            java.util.ArrayList<String> opciones = cat.getOpciones();
            String pdf_opciones = "";
            for (String opcion : opciones) {
                pdf_opciones += "* " + opcion + "\n";
            }
            pdf_perfil += pdf_categoria + "\n" + pdf_opciones + "\n";
        }
        descripcion.add(pdf_perfil);

        Documento.add(descripcion);
        
        Paragraph seccion1 = new Paragraph("Desglose de los Resultados",
                FontFactory.getFont("arial", // fuente
                        20, // tamaño
                        Font.BOLD, // estilo
                        BaseColor.BLACK));
        titulo.setAlignment(Element.ALIGN_CENTER);
        Documento.add(seccion1);
        
        for (String test : Tests) {
            int numRegistros = 0;
            ArrayList<Obj_respuestas> 
                    Respuestas = controlador.LeerDatos.getRespuestas(nomProyecto, test);
            for (Obj_respuestas obj_respuestas : Respuestas) {
                String ID = obj_respuestas.getID();
                String version = obj_respuestas.getVersion();
                String tiempodeencuesta = obj_respuestas.getTiempodeencuesta();
                java.util.ArrayList<Perfil> 
                        perfill = obj_respuestas.getPerfil();
                for (Perfil perfil1 : perfill) {
                    
                }
                java.util.ArrayList<Respuestas> 
                        respuestas = obj_respuestas.getRespuestas();
                for (Respuestas respuestas1 : respuestas) {
                    
                }
                numRegistros = respuestas.size();
            }

        }
        

        /*      cerrar PDF      */
        Documento.close();

        /*      Lista de Test y Lista de Respuestas por Test*/
//        java.util.ArrayList<String> 
//                Tests = controlador.Archivos.getTests(nomProyecto);
//        for (String Test : Tests) {
//            ArrayList<Obj_respuestas> 
//                    Respuestas = controlador.LeerDatos.getRespuestas(nomProyecto, Test);            
//        }
//        
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("interrumpido");
            }
            resultado = true;

            // Se pasa valor para la barra de progreso. ESto llamara al metodo
            // process() en el hilo de despacho de eventos.
            publish(i + 1);

        }
        return resultado;
    }

    @Override
    protected void done() {
        // cuando termine
        try {
            java.io.File path = new java.io.File(pdf_direccion + "/" + pdf_nombre);
            java.awt.Desktop.getDesktop().open(path);
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void process(List<Integer> lst) {
        //actializa la barra de progreso
        progreso.setValue(lst.get(0));
    }
}
