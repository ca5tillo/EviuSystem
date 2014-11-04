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
import static controlador.LeerDatos.getPreguntas;
import static controlador.LeerDatos.getRespuestas;
import controlador.modelos.Categoria;
import controlador.modelosRespuestas.Obj_respuestas;
import controlador.modelosRespuestas.Perfil;
import controlador.modelosRespuestas.Respuestas;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class GenerarReporte extends SwingWorker<Boolean, Integer> {
//    private final javax.swing.JProgressBar progreso;

    private final JProgressBar progreso;
    private final String nomProyecto;
    private final String pdf_nombre;
    private final String pdf_direccion;
    private boolean resultado = false;
    private int count=0;

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
        Documento.add(tituloSeccion());
        publish(80);

        seccionTest2(Documento);

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

    private Paragraph tituloSeccion() {
        Paragraph titulo = new Paragraph("Desglose de los Resultados\n\n",
                FontFactory.getFont("arial", // fuente
                        24, // tamaño
                        Font.BOLD, // estilo
                        BaseColor.BLACK));
        titulo.setAlignment(Element.ALIGN_CENTER);
        return titulo;
    }

    /*      seccion () es experimental  */
    private void seccionTest(Document Documento) {
        class Secciones {

            Secciones() {

            }

            public Paragraph tituloTest(String titulo) {
                Paragraph Paragraph = new Paragraph(
                        new Paragraph("" + titulo + "\n\n",
                                FontFactory.getFont("arial", // fuente
                                        20, // tamaño
                                        Font.BOLD, // estilo
                                        BaseColor.BLACK)));

                return Paragraph;
            }
            public Paragraph obj_respuestasRespuestas(
                    java.util.ArrayList<Respuestas> lst_Respuestas){                
                Paragraph Paragraph = new Paragraph();
                for (Respuestas respuestas : lst_Respuestas) {
                    Paragraph.add(new Paragraph(respuestas.getPregunta()+"  "
                            +respuestas.getRealizo()));
                }
                return Paragraph;
            }
        }
        Secciones seccion = new Secciones();

        java.util.ArrayList<String> Tests = controlador.Archivos.getTests(nomProyecto);
        for (String test : Tests) {//Recorro cada Test
            ArrayList<Obj_respuestas> 
                    lst_Obj_respuestas = getRespuestas(nomProyecto, test);
            if (!lst_Obj_respuestas.isEmpty()) {
                
                Paragraph Paragraph = new Paragraph();
                Paragraph.add(new Chunk().setNewPage());
                Paragraph.add(seccion.tituloTest(test));

                Paragraph.add(new Paragraph("Este Test contiene "
                        + getPreguntas(nomProyecto, test).size() + " preguntas"));

                for (Obj_respuestas obj_respuestas : lst_Obj_respuestas) {
                    //Aqui contiene cada test Resuelto 
                    if (obj_respuestas.getVersion().equals(controlador.LeerDatos.getVersion(nomProyecto))) {
                        
                        Paragraph.add(new Paragraph("ID: " + obj_respuestas.getID()));
                        Paragraph.add(seccion.obj_respuestasRespuestas(obj_respuestas.getRespuestas()));

                    }
                }
                try {
                    Documento.add(Paragraph);
                    String fotoo = Graficas.bar_Perfil(nomProyecto, test);
                    Image foto = Image.getInstance(fotoo);
                    foto.scaleToFit(500, 500);
                    foto.setAlignment(Chunk.ALIGN_MIDDLE);
                    Documento.add(foto);
                    new java.io.File(fotoo).delete();
                } catch (DocumentException | IOException e) {
                }
            }
        }
    }
    
    private void seccionTest2(Document Documento) {
        class Secciones {

            Secciones() {

            }

            public Paragraph tituloTest(String titulo) {
                Paragraph Paragraph = new Paragraph(
                        new Paragraph("" + titulo + "\n\n",
                                FontFactory.getFont("arial", // fuente
                                        20, // tamaño
                                        Font.BOLD, // estilo
                                        BaseColor.BLACK)));

                return Paragraph;
            }
            public Paragraph obj_respuestasRespuestas(
                    java.util.ArrayList<Respuestas> lst_Respuestas){                
                Paragraph Paragraph = new Paragraph();
                for (Respuestas respuestas : lst_Respuestas) {
                    Paragraph.add(new Paragraph(respuestas.getPregunta()+"  "
                            +respuestas.getRealizo()));
                }
                return Paragraph;
            }
            
            public Paragraph lst_Obj_respuestas (ArrayList<Obj_respuestas> lst_Obj_respuestas,String test){
                /*      Recibo todas las Encuestas Resueltas     */
                class r{
                    private String pregunta;
                    private int si_realozo;
                    private int no_realizo;

                    public r(String pregunta) {
                        this.pregunta = pregunta;
                    }

                    public void setPregunta(String pregunta) {
                        this.pregunta = pregunta;
                    }

                    public void setSi_realozo(int si_realozo) {
                        this.si_realozo += si_realozo;
                    }

                    public void setNo_realizo(int no_realizo) {
                        this.no_realizo += no_realizo;
                    }
                    
                    public String getPregunta() {
                        return pregunta;
                    }

                    public int getSi_realozo() {
                        return si_realozo;
                    }

                    public int getNo_realizo() {
                        return no_realizo;
                    }
                    
                }
                Paragraph Paragraph = new Paragraph();
                ArrayList<r>base = new ArrayList();
                for (controlador.modelos.Pregunta preguntas: getPreguntas(nomProyecto, test)){
                    base.add(new r (preguntas.getStr_pregunta()));
                }
                
                for (Obj_respuestas obj_respuestas : lst_Obj_respuestas) {
                    //Aqui contiene cada test Resuelto 
                    if (obj_respuestas.getVersion().equals(controlador.LeerDatos.getVersion(nomProyecto))) {
                        
                        
                        for (Respuestas respuestas : obj_respuestas.getRespuestas()) {
                            for(r baes :base){
                                if(respuestas.getPregunta().equals(baes.getPregunta())){
                                    if(respuestas.getRealizo().equals("si")){
                                        baes.setSi_realozo(1);
                                    }else{
                                        baes.setNo_realizo(1);
                                    }
                                }
                            }
                        }

                    }
                }
                //lst_Obj_respuestas
                for(r baes :base){
                    Paragraph.add(new Paragraph("La Tare: \""+baes.getPregunta()+
                            "\" contiene  "+(baes.getSi_realozo()*100)/lst_Obj_respuestas.size()
                            +"%  de Exitos y  "+
                            (baes.getNo_realizo()*100)/lst_Obj_respuestas.size()+"%  de Fracasos"
                    ));
                }
                return Paragraph;
                
            }
        }
        Secciones seccion = new Secciones();

        java.util.ArrayList<String> Tests = controlador.Archivos.getTests(nomProyecto);
        for (String test : Tests) {//Recorro cada Test
            ArrayList<Obj_respuestas> lst_Obj_respuestas = getRespuestas(nomProyecto, test);
            if (!lst_Obj_respuestas.isEmpty()) {
                
                Paragraph Paragraph = new Paragraph();
                if(count!=0){Paragraph.add(new Chunk().setNewPage());}
                count=1;
                Paragraph.add(seccion.tituloTest(test));
                
                Paragraph.add("Este test fue realizado  "+lst_Obj_respuestas.size()+"  veces "+
                        "y contiene "
                        + getPreguntas(nomProyecto, test).size() + " preguntas");
                
                /*      Envio todas las Encuestas Resueltas     */
                Paragraph.add(seccion.lst_Obj_respuestas(lst_Obj_respuestas,test));
                /*      FIN Envio todas las Encuestas Resueltas     */
                try {
                    Documento.add(Paragraph);
                    String fotoo = Graficas.bar_Perfil(nomProyecto, test);
                    Image foto = Image.getInstance(fotoo);
                    foto.scaleToFit(500, 500);
                    foto.setAlignment(Chunk.ALIGN_MIDDLE);
                    Documento.add(foto);
                    new java.io.File(fotoo).delete();
                } catch (DocumentException | IOException e) {
                }
            }
        }
    }

}
