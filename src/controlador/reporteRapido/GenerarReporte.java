package controlador.reporteRapido;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.modelos.Categoria;
import controlador.modelosRespuestas.Obj_respuestas;
import controlador.modelosRespuestas.Perfil;
import controlador.modelosRespuestas.Respuestas;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
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
        publish(1);
        /*      Iniciar el PDF       */
        Document Documento = new Document();
        FileOutputStream pdf = new FileOutputStream(pdf_direccion + "/" + pdf_nombre);
        PdfWriter.getInstance(Documento, pdf).setInitialLeading(20);
        Documento.open();
        System.out.println(pdf_direccion + "/" + pdf_nombre);

        /*      Insertar datos          */
        publish(10);
        Documento.add(titulo());
        publish(20);
        Documento.add(subTitulo());
        publish(30);
        Documento.add(descripcionDelProyecto());
        publish(40);
        Documento.add(descripcionDeLosTest());
        publish(50);
        Documento.add(descripcionDePerfil());
        
        publish(60);
        
        Documento.add(new Paragraph(new Chunk().setNewPage()));
        publish(70);
        Paragraph seccion1 = new Paragraph("Desglose de los Resultados",
                FontFactory.getFont("arial", // fuente
                        20, // tamaño
                        Font.BOLD, // estilo
                        BaseColor.BLACK));
        seccion1.setAlignment(Element.ALIGN_CENTER);
        Documento.add(seccion1);
        publish(80);
        
        Documento.add(seccion(Documento));
        
        publish(90);
        
        /*      cerrar PDF      */
        Documento.close();
        publish(100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("interrumpido");
            }
            
        return resultado;
    }

    @Override
    protected void done() {
        // cuando termine
        try {
            //Abrira el pdf con el programa designado Sistema Operativo
            java.awt.Desktop.getDesktop().open(
                    new java.io.File(pdf_direccion + "/" + pdf_nombre));
        } catch (java.io.IOException ex) {
            System.out.println("Error en GrenerarReporte.java en la funcion done()");
        }
    }

    @Override
    protected void process(List<Integer> lst) {
        //actializa la barra de progreso
        progreso.setValue(lst.get(0));
    }

    /*          crear secciones de pdf      */
    private Paragraph titulo() {
        Paragraph titulo = new Paragraph(nomProyecto,
                FontFactory.getFont("arial", // fuente
                        26, // tamaño
                        Font.BOLD, // estilo
                        BaseColor.BLACK));
        titulo.setAlignment(Element.ALIGN_CENTER);
        return titulo;
    }

    private Paragraph subTitulo() {
        Paragraph subTitulo = new Paragraph("Versión: "
                + controlador.LeerDatos.getVersion(nomProyecto),
                FontFactory.getFont("arial", // fuente
                        14, // tamaño
                        Font.PLAIN, // estilo
                        BaseColor.BLACK));
        subTitulo.setAlignment(Element.ALIGN_RIGHT);
        return subTitulo;
    }

    private Paragraph descripcionDelProyecto() {
        Paragraph descripcionDelProyecto = new Paragraph("\n\n\nDescripción:\n"
                + controlador.LeerDatos.getDescripcionProyecto(nomProyecto),
                FontFactory.getFont("arial", // fuente
                        14, // tamaño
                        Font.PLAIN, // estilo
                        BaseColor.BLACK));
        return descripcionDelProyecto;
    }

    private Paragraph descripcionDeLosTest() {
        Paragraph descripcionDeLosTest = new Paragraph(
                "\nEste proyecto con tiene los siguientes Test:\n",
                FontFactory.getFont("arial", // fuente
                        14, // tamaño
                        Font.PLAIN, // estilo
                        BaseColor.BLACK));
        String intro_test = "";

        java.util.ArrayList<String> Tests = controlador.Archivos.getTests(nomProyecto);
        for (String test : Tests) {
            ArrayList<Obj_respuestas> EncuestasRealizadas = controlador.LeerDatos.getRespuestas(nomProyecto, test);
            intro_test += "* " + test + "  (Se realizo " + EncuestasRealizadas.size() + " veces)\n";
        }
        descripcionDeLosTest.add(intro_test);
        return descripcionDeLosTest;
    }

    private Paragraph descripcionDePerfil() {
        Paragraph descripcionDePerfil = new Paragraph(
                "\nDescripcion de la sección de Perfil:\n\n",
                FontFactory.getFont("arial", // fuente
                        14, // tamaño
                        Font.PLAIN, // estilo
                        BaseColor.BLACK));
        String pdf_perfil = "";
        java.util.ArrayList<controlador.modelos.Categoria> perfiles = controlador.LeerDatos.getPerfil(nomProyecto);
        for (Categoria categoria : perfiles) {
            String pdf_categoria = categoria.getCategoria();
            java.util.ArrayList<String> opciones = categoria.getOpciones();

            String pdf_opciones = "";
            for (String opcion : opciones) {
                pdf_opciones += "* " + opcion + "\n";
            }
            pdf_perfil += pdf_categoria + "\n" + pdf_opciones + "\n";
        }
        descripcionDePerfil.add(pdf_perfil);
        return descripcionDePerfil;
    }

    /*      seccion () es experimental  */
    private Paragraph seccion(Document Documento) {
        Paragraph seccion = new Paragraph();
        String ss = "";

        java.util.ArrayList<String> Tests = controlador.Archivos.getTests(nomProyecto);
        for (String test : Tests) {
            ss+="\n\nTest: "+test+"\n\n";
            try {
                String fotoo=Graficas.bar_Perfil(nomProyecto, test);
                Image foto = Image.getInstance(fotoo);
                foto.scaleToFit(500, 500);
                foto.setAlignment(Chunk.ALIGN_MIDDLE);
                Documento.add(foto);
                new java.io.File(fotoo).delete();
            } catch (DocumentException | IOException e) {
            }
            ArrayList<Obj_respuestas> getRespuestas
                    = controlador.LeerDatos.getRespuestas(nomProyecto, test);
            for (Obj_respuestas a : getRespuestas) {
                String ID = a.getID();
                String version = a.getVersion();
                String tiempodeencuesta = a.getTiempodeencuesta();
                ss += "\nID: " + ID;
                ss += "\n\t version: " + version;
                ss += "\n\t tiempodeencuesta: " + tiempodeencuesta;
                java.util.ArrayList<controlador.modelosRespuestas.Perfil> perfil = a.getPerfil();

                java.util.ArrayList<controlador.modelosRespuestas.Respuestas> respuestas = a.getRespuestas();
                ss += "\n\t\t-----PERFIL-----";
                for (Perfil perfil1 : perfil) {
                    String categoria = perfil1.getCategoria();
                    String opcion = perfil1.getOpcion();

                    ss += "\n\t\t\t" + opcion;
                }
                ss += "\n\t\t-----RESPUESTAS-----";
                for (Respuestas respuestas1 : respuestas) {
                    String id_pregunta = respuestas1.getId_pregunta();
                    String pregunta = respuestas1.getPregunta();
                    String realizo = respuestas1.getRealizo();
                    String tiempo = respuestas1.getTiempo();
                    String animo = respuestas1.getAnimo();
                    String nota = respuestas1.getNota();

                    ss += "\n\t\t\tpregunta: " + pregunta;
                    ss += "\n\t\t\t\trealizo: " + realizo;
                    ss += "\n\t\t\t\ttiempo: " + tiempo;
                    ss += "\n\t\t\t\tanimo: " + animo;
                    ss += "\n\t\t\t\tnota: " + nota;
                }
            }

        }
        seccion.add(ss);
        return seccion;
    }
}
