package controlador;

import controlador.modelosRespuestas.Obj_respuestas;
import controlador.modelosRespuestas.Perfil;
import controlador.modelosRespuestas.Respuestas;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class LeerDatos {
    /*
     FUNCION getPreguntas() REGRES un arreglo de PREGUNTA .
     Esta funcion RECIBE el nombre del PROYECTO y el nombre del TEST.
     */

    public static java.util.ArrayList<controlador.modelos.Pregunta>
            getPreguntas(String str_nomProyecto, String str_nomTest) {

        /* Variables globales de la funcion */
        String pathTest = "proyectos/" + str_nomProyecto + "/tests/" + str_nomTest + ".eviutest";
        java.util.ArrayList<controlador.modelos.Pregunta> arrayL_preguntas = new java.util.ArrayList();
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        /* fin de Varialbes globales de la funcion */

        String str_teset = Archivos.Leer_Archivo(pathTest);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_teset = AES.decrypt(str_teset);
        }

        try {
            /*
             Ir a la carpeta test y abrir el archivo del test correspondiente
             leer preguntas
             */
            Object obj_test = parser.parse(str_teset);
            JSONObject jsonobj_test = (JSONObject) obj_test;

            JSONArray jsonArray_preguntas = (JSONArray) jsonobj_test.get("lst_preguntas");

            for (Object _pregunta : jsonArray_preguntas) {
                JSONObject jsonobj_pregunta = (JSONObject) _pregunta;
                /*
                 private String str_pregunta;
                 private int int_id;
                 private boolean boolean_seMediraPorTiempo;
                 private String str_t1;
                 private String str_t2;
                 private boolean boolean_seTomaranCuentaElEstadoDeAnimo;
                 */
                String p = (String) jsonobj_pregunta.get("str_pregunta");
                String id = (String) jsonobj_pregunta.get("str_id");
                boolean t = (boolean) jsonobj_pregunta.get("boolean_seMediraPorTiempo");
                String t1 = (String) jsonobj_pregunta.get("str_t1");
                String t2 = (String) jsonobj_pregunta.get("str_t2");
                boolean a = (boolean) jsonobj_pregunta.get("boolean_EstadoDeAnimo");
                String[] t1s = null;
                String[] t2s = null;
                if (t) {
                    t1s = t1.split(":");
                    t2s = t2.split(":");
                }
                arrayL_preguntas.add(new controlador.modelos.Pregunta(p, id, t, t1s, t2s, a));
            }

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON en la funcion getPreguntas()");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayL_preguntas;
    }

    /*
     FUNCION getPerfil() REGRES un arreglo de categorias con sus opciones cada una.
     Esta funcion RECIBE el nombre del PROYECTO en formato String
     */
    public static java.util.ArrayList<controlador.modelos.Categoria> getPerfil(String str_nomProyecto) {

        /* Variables globales de la funcion */
        java.util.ArrayList<controlador.modelos.Categoria> perfil = new java.util.ArrayList();
        java.util.ArrayList<String> opciones = new java.util.ArrayList();
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        /* fin de Varialbes globales de la funcion */

        try {
            String proyecto = Archivos.Leer_Archivo("proyectos/" + str_nomProyecto + "/"
                    + str_nomProyecto + ".eviu");
            if (vista.Config.AES()) {
                proyecto = AES.decrypt(proyecto);
            }

            Object obj_proyecto = parser.parse(proyecto);

            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            JSONArray lst_perfil = (JSONArray) jsonobj_proyecto.get("lst_perfil");
            for (Object categoria : lst_perfil) {
                org.json.simple.JSONObject json_categoria = (org.json.simple.JSONObject) categoria;
                String str_categoria = (String) json_categoria.get("categoria");

                JSONArray lst_opciones = (JSONArray) json_categoria.get("opciones");
                for (Object opc : lst_opciones) {
                    opciones.add("" + opc);
                }
                controlador.modelos.Categoria cate = new controlador.modelos.Categoria();
                cate.setCategoria(str_categoria);
                cate.setOpciones(opciones);
                perfil.add(cate);
                opciones.clear();
            }
        } catch (org.json.simple.parser.ParseException e) {
            System.out.println("Error en el parser en getPerfil() ");
        }
        return perfil;
    }

    /*
     Las funciones 
     plantilla_Proyecto()
     plantilla_Test()
     Son las que se utilizan para  crear un  proyecto basico 
     Las dos regresan un string en formato JSON para ser almacenadas en disco.
     plantilla_Proyecto()
     Recibe el NUEVO NOMBRE que tendra con su nueva DESCRIPCION.
    
     SE USAN EN Archivos.java POR LA FUNCION crearProyectoSimple();
     */
    public static String plantilla_Proyecto(String nombre, String descripcion) {
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/proyecto.eviu";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

        String str_ = Archivos.Leer_Archivo(pantillaProyect);// leeo el Archivo 
//        if (vista.Config.AES()) {
//            str_ = AES.decrypt(str_);
//        }
        try {
            Object obj_proyecto = parser.parse(str_);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            jsonobj_proyecto.put("str_nombreProyecto", nombre);
            jsonobj_proyecto.put("str_descripcionDelProyecto", descripcion);
            jsonobj_proyecto.put("ID", GenerarID.getID(6));

            proyecto = "" + jsonobj_proyecto;

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + " en leerDatos en plantilla_Proyecto(String nombre, String descripcion)");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }

    public static String plantilla_Test(String nomProyecto) {
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/testEjemplo.eviutest";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

        String str_ = Archivos.Leer_Archivo(pantillaProyect);// leeo el Archivo 
//        if (vista.Config.AES()) {
//            str_ = AES.decrypt(str_);
//        }
        try {
            Object obj_proyecto = parser.parse(str_);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;
            
            jsonobj_proyecto.put("str_padre", nomProyecto);
            jsonobj_proyecto.put("ID", GenerarID.getID(6));

            proyecto = "" + jsonobj_proyecto;

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "En leer datos en plantilla_Test()");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }
    /*
     Crear proyecto con nuevo perfil y nuevo test. CASO UNO
        
     En este momento ya deven de tener valor asignado las siguientes variables
        
     proyecto;
     descripcion;
     nomTest;
     lst_perfil;
     lst_preguntas;
    
     */

    public static String plantilla_Proyecto(
            String nombre,
            String descripcion,
            org.json.simple.JSONArray lst_perfil) {
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/proyecto.eviu";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        String str_ = Archivos.Leer_Archivo(pantillaProyect);// leeo el Archivo 
//        if (vista.Config.AES()) {
//            str_ = AES.decrypt(str_);
//        }
        try {
            Object obj_proyecto = parser.parse(str_);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            /* REESCRIBIR VALORES*/
            jsonobj_proyecto.put("str_nombreProyecto", nombre);
            jsonobj_proyecto.put("str_descripcionDelProyecto", descripcion);
            jsonobj_proyecto.put("ID", GenerarID.getID(6));
            jsonobj_proyecto.put("lst_perfil", lst_perfil);
            /* FIN REESCRIBIR VALORES*/

            proyecto = "" + jsonobj_proyecto;

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "En leerDatos en plantilla_Proyecto(\n"
                    + "            String nombre,\n"
                    + "            String descripcion,\n"
                    + "            org.json.simple.JSONArray lst_perfil)");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }

    public static String plantilla_Test(String nomProyecto, String nomTest, org.json.simple.JSONArray lst_preguntas) {
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/testEjemplo.eviutest";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

        String str_ = Archivos.Leer_Archivo(pantillaProyect);// leeo el Archivo 
//        if (vista.Config.AES()) {
//            str_ = AES.decrypt(str_);
//        }
        try {
            Object obj_proyecto = parser.parse(str_);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            /* REESCRIBIR VALORES*/
            jsonobj_proyecto.put("str_padre", nomProyecto);
            jsonobj_proyecto.put("str_nombreDelTest", nomTest);
            jsonobj_proyecto.put("ID", GenerarID.getID(6));
            jsonobj_proyecto.put("lst_preguntas", lst_preguntas);
            /* FIN REESCRIBIR VALORES*/

            proyecto = "" + jsonobj_proyecto;

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "en LeerDatos en \n"
                    + "plantilla_Test(String nomTest,org.json.simple.JSONArray lst_preguntas)");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }
    /*  FIN CASO UNO */
    /*
     guardarRespuestas  Respuesta de la encuesta
     Es usada en Archivos.java por la funcion guardarRespuestas();
    
     */

    public static String guardarRespuestas(
            String nomProyecto,
            String nomTest,
            org.json.simple.JSONArray perfil,
            org.json.simple.JSONArray lst_respuestas,
            String tiempodeencuesta) {
        String test = "";
        String pathTest = "proyectos/" + nomProyecto + "/tests/" + nomTest + ".eviutest";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

        String str_Test = Archivos.Leer_Archivo(pathTest);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_Test = AES.decrypt(str_Test);
        }
        try {
            /*CREAR OBJ DE RESPUESTA*/

            org.json.simple.JSONObject jsonobj_respuesta = new org.json.simple.JSONObject();
            jsonobj_respuesta.put("ID", GenerarID.getID(32));
            jsonobj_respuesta.put("version", getVersion(nomProyecto));
            jsonobj_respuesta.put("tiempodeencuesta", tiempodeencuesta);
            jsonobj_respuesta.put("perfil", perfil);
            jsonobj_respuesta.put("respuestas", lst_respuestas);
            /*FIN CREAR OBJ DE RESPUESTA*/

            Object obj_Test = parser.parse(str_Test);
            JSONObject jsonobj_Test = (JSONObject) obj_Test;

            org.json.simple.JSONArray all_respuestas = (org.json.simple.JSONArray) jsonobj_Test.get("lst_respuestas");
            /* AÑADIR RESPUESTA*/
            all_respuestas.add(jsonobj_respuesta);
            /* FIN AÑADIR RESPUESTA*/

            test = "" + jsonobj_Test;

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "EN leer Datos en \n"
                    + "guardarRespuestas(\n"
                    + "            String nomProyecto,\n"
                    + "            String nomTest,\n"
                    + "            org.json.simple.JSONArray perfil,\n"
                    + "            org.json.simple.JSONArray lst_respuestas,\n"
                    + "            String tiempodeencuesta)");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return test;
    }

    public static String getVersion(String nomProyecto) {
        String version = "";
        String pehtProyecto = "proyectos/" + nomProyecto + "/" + nomProyecto + ".eviu";

        String str_Proyecto = Archivos.Leer_Archivo(pehtProyecto);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_Proyecto = AES.decrypt(str_Proyecto);
        }
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_proyecto = parser.parse(str_Proyecto);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            version = (String) jsonobj_proyecto.get("str_versiones");

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "en leerDatos en getversion(String nomProyecto)");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return version;
    }
    public static void setVersion(String nomP){
        String pehtProyecto = "proyectos/"+nomP+"/"+nomP+".eviu";
        String str_Proyecto = Archivos.Leer_Archivo(pehtProyecto);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_Proyecto = AES.decrypt(str_Proyecto);
        }
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_proyecto = parser.parse(str_Proyecto);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            int  version = Integer.parseInt((String) jsonobj_proyecto.get("str_versiones"));
            version++;
            jsonobj_proyecto.put("str_versiones",""+version);
            
            String srt_P=""+jsonobj_proyecto;
            if (vista.Config.AES()) {
                srt_P = AES.encrypt(srt_P);
            }
            Archivos.escribirEnArchivo(pehtProyecto, srt_P);//creo unteset

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "en leerDatos en getversion(String nomProyecto)");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @SuppressWarnings("UnusedAssignment")
    public static ArrayList<Obj_respuestas> getRespuestas(String nomProyecto, String nomTest) {
        String pathTest = "proyectos/" + nomProyecto + "/tests/" + nomTest + ".eviutest";
        ArrayList<Obj_respuestas> Lst_respuestas = new ArrayList();
        String test = Archivos.Leer_Archivo(pathTest);
        if (vista.Config.AES()) {
            test = AES.decrypt(test);
        }
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_test = parser.parse(test);
            JSONObject json_test = (JSONObject) obj_test;

            JSONArray lst_respuestas = (JSONArray) json_test.get("lst_respuestas");
            for (Object obj_rDencuesta : lst_respuestas) {
                Obj_respuestas Obj_respuestas = new Obj_respuestas();
                
                JSONObject objson_rDencuesta = (JSONObject) obj_rDencuesta;

                String ID = (String) objson_rDencuesta.get("ID");
                String version = (String) objson_rDencuesta.get("version");
                String tiempodeencuesta = (String) objson_rDencuesta.get("tiempodeencuesta");
                JSONArray perfil = (JSONArray) objson_rDencuesta.get("perfil");
                JSONArray respuestas = (JSONArray) objson_rDencuesta.get("respuestas");

                Obj_respuestas.setID(ID);
                Obj_respuestas.setVersion(version);
                Obj_respuestas.setTiempodeencuesta(tiempodeencuesta);
                for (Object obj_per : perfil) {
                    JSONObject objson_per = (JSONObject) obj_per;
                    String categoria = (String) objson_per.get("categoria");
                    String opcion = (String) objson_per.get("opcion");

                    Obj_respuestas.addPerfil(new Perfil(categoria, opcion));

                }
                for (Object obj_res : respuestas) {
                    JSONObject objson_res = (JSONObject) obj_res;

                    String id_pregunta = (String) objson_res.get("id_pregunta");
                    String pregunta = (String) objson_res.get("pregunta");
                    String realizo = (String) objson_res.get("realizo");
                    String tiempo = (String) objson_res.get("tiempo");
                    String animo = (String) objson_res.get("animo");
                    String nota = (String) objson_res.get("nota");

                    Obj_respuestas.addRespuestas(
                            new Respuestas(id_pregunta, pregunta, realizo, tiempo, animo, nota));

                }
                Lst_respuestas.add(Obj_respuestas);
            }

        } catch (ParseException e) {
            System.out.println("Error en parser de Leer datos en getRespuestas(proyecto,test)");
        }
        return Lst_respuestas;
    }
 
    public static void main(String[] args) {
        ArrayList<Obj_respuestas> a = getRespuestas("a", "a");
        for (Obj_respuestas x : a) {
            System.out.println(x.getID());
            System.out.println(x.getVersion());
            System.out.println(x.getTiempodeencuesta());
            ArrayList<Perfil> perfil = x.getPerfil();
            for (Perfil per : perfil) {
                System.out.println(per.getCategoria());
                System.out.println(per.getOpcion());
            }
            ArrayList<Respuestas> Respuestas = x.getRespuestas();
            for (Respuestas res : Respuestas) {
                System.out.println(res.getId_pregunta());
                System.out.println(res.getPregunta());
                System.out.println(res.getRealizo());
                System.out.println(res.getTiempo());
                System.out.println(res.getAnimo());
                System.out.println(res.getNota());
            }
        }
    }
}
