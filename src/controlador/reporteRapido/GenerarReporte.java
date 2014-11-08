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
import controlador.modelos.Pregunta;
import controlador.modelosRespuestas.Obj_respuestas;
import controlador.modelosRespuestas.Perfil;
import controlador.modelosRespuestas.Respuestas;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
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
    private final Document Documento;
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
        /*      Iniciar el PDF       */
        Documento = new Document();
        try{
        FileOutputStream pdf = new FileOutputStream(pdf_direccion + "/" + pdf_nombre);
        PdfWriter.getInstance(Documento, pdf).setInitialLeading(20);
        Documento.open();
        }catch(FileNotFoundException | DocumentException e){
            System.out.println("Error enel constructor de GenerarReporte");
        }
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        resultado = false;
        publish(1);
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

        seccionTest2();

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
    
    private void seccionTest2( ) {
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
            
            public Paragraph lst_Obj_respuestas (
                    ArrayList<Obj_respuestas> lst_Obj_respuestas,
                    String test){
                /*      Recibo todas las Encuestas Resueltas     */
                class Clasificado {
                    private final String id;
                    protected ArrayList<Obj_respuestas> lst_Obj_respuestas = new ArrayList();

                    public Clasificado(String id) {
                    this.id = id;
                    }
                    
                    public void add_Lst_Obj_respuestas(
                            Obj_respuestas obj_respuestas ){
                        this.lst_Obj_respuestas.add(obj_respuestas);
                    }
                    
                    public String getId(){
                        return id;
                    }

                    public ArrayList<Obj_respuestas> getLst_Obj_respuestas() {
                        return lst_Obj_respuestas;
                    }
                    
                }
                class Herramientas{
                    public boolean addClasificado(
                            ArrayList<Clasificado> Clasificado,
                            String perfil,
                            Obj_respuestas obj_respuestas){
                        boolean a = false;
                        if(!Clasificado.isEmpty()){
                            for(Clasificado clasificado:Clasificado){
                                    if(clasificado.getId().equals(perfil)){
                                        clasificado.add_Lst_Obj_respuestas(obj_respuestas);
                                        a=true;
                                    }
                            }
                        }
                        return a;
                    }
                    
                    public ArrayList<Clasificado> clasificar(
                            ArrayList<Obj_respuestas> lst_Obj_respuestas) {
                        
                        ArrayList<Clasificado> Clasificados = new ArrayList();
                        for (Obj_respuestas obj_respuestas : lst_Obj_respuestas) {
//                            Aqui contiene cada test Resuelto 
                            if (obj_respuestas.getVersion().equals(controlador.LeerDatos.getVersion(nomProyecto))) {

                                String perfil = "";
                                for (Perfil perfil1 : obj_respuestas.getPerfil()) {
                                    String categoria = perfil1.getCategoria();
                                    String opcion = perfil1.getOpcion();
                                    perfil += categoria+": "+opcion+",  ";
                                }

                                if (!addClasificado(Clasificados, perfil, obj_respuestas)) {
                                    Clasificado Clasificado = new Clasificado(perfil);
                                    Clasificado.add_Lst_Obj_respuestas(obj_respuestas);
                                    Clasificados.add(Clasificado);
                                    
                                }

                            }
                        }
                        return Clasificados;
                    }
                    
                    public Paragraph getparrafoXperfil(
                            Clasificado Clasificado,
                            String test,
                            int totalEncuestas) {
                        class ParrafoXperfil{
                            private final String pregunta;
                            private final boolean tiempo;
                            private final boolean animo;
                            private int exito = 0;
                            private int fracaso = 0;
                            private int feliz = 0;
                            private int impaciente = 0;
                            private int desepcionado = 0;
                            private int enojado = 0;
                            private int n_a = 0;
                            private String comentarios = "";

                            public ParrafoXperfil(String pregunta, boolean tiempo, boolean animo) {
                                this.pregunta = pregunta;
                                this.tiempo = tiempo;
                                this.animo = animo;
                            }

                            public String getPregunta() {
                                return pregunta;
                            }

                            public boolean isTiempo() {
                                return tiempo;
                            }

                            public boolean isAnimo() {
                                return animo;
                            }
                            
                            public int getExito() {
                                return exito;
                            }

                            public void addExito(int exito) {
                                this.exito += exito;
                            }

                            public int getFracaso() {
                                return fracaso;
                            }

                            public void addFracaso(int fracaso) {
                                this.fracaso += fracaso;
                            }

                            public int getFeliz() {
                                return feliz;
                            }

                            public void addFeliz(int feliz) {
                                this.feliz += feliz;
                            }

                            public int getImpaciente() {
                                return impaciente;
                            }

                            public void addImpaciente(int impaciente) {
                                this.impaciente += impaciente;
                            }

                            public int getDesepcionado() {
                                return desepcionado;
                            }

                            public void addDesepcionado(int desepcionado) {
                                this.desepcionado += desepcionado;
                            }

                            public int getEnojado() {
                                return enojado;
                            }

                            public void addEnojado(int enojado) {
                                this.enojado += enojado;
                            }

                            public int getN_a() {
                                return n_a;
                            }

                            public void addN_a(int n_a) {
                                this.n_a += n_a;
                            }

                            public String getComentarios() {
                                return comentarios;
                            }

                            public void setComentarios(String comentarios) {
                                this.comentarios += "["+comentarios+"]";
                            }
                            
                            
                            
                            
                        }
                        
                        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
                        Paragraph Paragraph = new Paragraph();
                        
                        String id = Clasificado.getId();//perfil
                        ArrayList<Obj_respuestas> lst_Obj_respuestas =
                                Clasificado.getLst_Obj_respuestas();
                        
                        /*  Lista re respuestas por perfil  */
                        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
                        ArrayList<ParrafoXperfil> lst_ParrafoXperfil = new ArrayList();
                        
                        /*  Creo la base    */
                        ArrayList<controlador.modelos.Pregunta> preguntas =
                        getPreguntas(nomProyecto, test);
                        for (Pregunta pregunta : preguntas) {
                            lst_ParrafoXperfil.add(new ParrafoXperfil(pregunta.getStr_pregunta()
                            ,pregunta.isBoolean_seMediraPorTiempo(),pregunta.isBoolean_seTomaranCuentaElEstadoDeAnimo()));
                        }
                        //* *//
                        for (Obj_respuestas obj_respuestas : lst_Obj_respuestas) {
                            ArrayList<Respuestas> respuestas = obj_respuestas.getRespuestas();
                            for (Respuestas respuestas1 : respuestas) {
                                String pregunta = respuestas1.getPregunta();
                                for (ParrafoXperfil parrafoXperfil : lst_ParrafoXperfil) {
                                    if(parrafoXperfil.pregunta.equals(pregunta)){
                                        if(respuestas1.getRealizo().equals("si")){
                                            parrafoXperfil.addExito(1);
                                        }else parrafoXperfil.addFracaso(1);
                                        
                                        String animo = respuestas1.getAnimo();
                                        if(animo.equalsIgnoreCase("feliz")){
                                            parrafoXperfil.addFeliz(1);
                                        }else if(animo.equalsIgnoreCase("impaciente")){
                                            parrafoXperfil.addImpaciente(1);
                                        }else if(animo.equalsIgnoreCase("desepcionado")){
                                            parrafoXperfil.addDesepcionado(1);
                                        }else if(animo.equalsIgnoreCase("enojado")){
                                            parrafoXperfil.addEnojado(1);
                                        }else if(animo.equalsIgnoreCase("n-a")){
                                            parrafoXperfil.addN_a(1);
                                        }
                                        
                                        String nota = respuestas1.getNota();
                                        if(!nota.equalsIgnoreCase("")){
                                            parrafoXperfil.setComentarios(nota);
                                        }
                                    }
                                }
                            }
                        }
                        /**/
                        
                        Paragraph.add("El perfil:  "+id+" que representa el  "+
                                (lst_Obj_respuestas.size()*100)/totalEncuestas+"%  "
                                + "del total de los participantes y contiene  "+
                                lst_Obj_respuestas.size()+" encuestas realizadas, "
                                + "cuyos resultados son los siguientes:\n\n");
                        String resultados="";
                        for (ParrafoXperfil parrafoXperfil : lst_ParrafoXperfil) {
                            resultados += parrafoXperfil.getPregunta()+"";
                            
                            resultados +=
                                "   Exitos: "+parrafoXperfil.getExito()*100/lst_Obj_respuestas.size()+
                                        "% ( local )  "+parrafoXperfil.getExito()*100/totalEncuestas+
                                        "% ( global )";
                            
                            resultados +=
                                "   Exitos2: "+parrafoXperfil.getExito()*100/lst_Obj_respuestas.size()+
                                        "% ( local )  "+parrafoXperfil.getExito()*100/totalEncuestas+
                                        "% ( global )";
                        }
                        Chunk ck = new Chunk(resultados);
                        Paragraph.add(ck);
                        return Paragraph;
                    }
                }
                
                Paragraph Paragraph = new Paragraph();
                ArrayList<Clasificado> Clasificados;
                
                /*      CLASIFICO Obj_respuestas POR PERFIL     */
                
                Clasificados = new Herramientas().clasificar(lst_Obj_respuestas);
                /*      FIN DE CLASIFICO Obj_respuestas POR PERFIL     */
                
                for (Clasificado clasificado : Clasificados) {
                    Paragraph.add(new Herramientas().getparrafoXperfil(
                                    clasificado,test,lst_Obj_respuestas.size()));
                }
                //lst_Obj_respuestas
                
                return Paragraph;
                
            }
        }
        Secciones seccion = new Secciones();
        boolean newpag = false;
        java.util.ArrayList<String> Tests = controlador.Archivos.getTests(nomProyecto);
        for (String test : Tests) {//Recorro cada Test
            ArrayList<Obj_respuestas> lst_Obj_respuestas = getRespuestas(nomProyecto, test);
            if (!lst_Obj_respuestas.isEmpty()) {
                
                Paragraph Paragraph = new Paragraph();
                if(newpag){Paragraph.add(new Chunk().setNewPage());}
                newpag=true;
                Paragraph.add(seccion.tituloTest(test));
                
                 Paragraph.add("El test consta de "+ getPreguntas(nomProyecto, test).size() + " preguntas"+
                        " y fue realizado por  "+lst_Obj_respuestas.size()+"  participantes "
                        + "de los cuales se crean las siguientes secciones.  \n\n");
                
                
                /*      Envio todas las Encuestas Resueltas     */
                Paragraph.add(seccion.lst_Obj_respuestas(lst_Obj_respuestas,test));
//                seccion.lst_Obj_respuestas(lst_Obj_respuestas,test);
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
