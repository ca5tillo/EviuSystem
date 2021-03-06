package controlador;

import controlador.modelosRespuestas.Obj_respuestas;
import controlador.modelosRespuestas.Perfil;
import controlador.modelosRespuestas.Respuestas;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeerDatos {
    private static String modTest(){
        return "{\"str_padre\":\"proyecto\",\"str_nombreDelTest\":\"testEjemplo\",\"lst_respuestas\":[],\"ID\":\"4db(AP\",\"str_IDpadre\":\"w?]amW\",\"lst_preguntas\":[{\"boolean_seMediraPorTiempo\":true,\"str_pregunta\":\"pregunta 1\",\"str_id\":\"01\",\"str_t2\":\"00:00:08:00\",\"str_t1\":\"00:00:03:01\",\"boolean_EstadoDeAnimo\":true},{\"boolean_seMediraPorTiempo\":true,\"str_pregunta\":\"pregunta 2\",\"str_id\":\"02\",\"str_t2\":\"00:00:06:00\",\"str_t1\":\"00:00:02:01\",\"boolean_EstadoDeAnimo\":false},{\"boolean_seMediraPorTiempo\":false,\"str_pregunta\":\"pregunta 3\",\"str_id\":\"03\",\"str_t2\":\"\",\"str_t1\":\"\",\"boolean_EstadoDeAnimo\":true},{\"boolean_seMediraPorTiempo\":false,\"str_pregunta\":\"pregunta 4\",\"str_id\":\"04\",\"str_t2\":\"\",\"str_t1\":\"\",\"boolean_EstadoDeAnimo\":false}]}";
     //   return "";
    }
    private static String  modProyecto(){
    //    return "{\"str_descripcionDelProyecto\":\"proyecto\",\"lst_perfil\":[{\"categoria\":\"Sexo\",\"opciones\":[\"hombre\",\"mujer\"]},{\"categoria\":\"Edad\",\"opciones\":[\"De 5 a 10\",\"De 10 a 15\",\"De 15 a 20\"]},{\"categoria\":\"Ocupacion\",\"opciones\":[\"estudiante\",\"profesor\",\"desempleado\"]}],\"ID\":\"w?]amW\",\"str_nombreProyecto\":\"proyecto\",\"str_versiones\":\"0\"}";
        return ""+
"{" +
"    \"str_nombreProyecto\": \"proyecto\"," +
"    \"str_descripcionDelProyecto\": \"proyecto\"," +
"    \"ID\": \"w?]amW\"," +
"    \"str_versiones\": \"0\"," +
"    \"lst_perfil\": [{" +
"            \"categoria\": \"Sexo\"," +
"            \"opciones\": [\"Hombre\", \"Mujer\"]" +
"        }, {" +
"            \"categoria\": \"Edad\"," +
"            \"opciones\": [\"De 5 a 10\", \"De 10 a 15\", \"De 15 a 20\"]" +
"        }, {" +
"            \"categoria\": \"Ocupacion\"," +
"            \"opciones\": [\"Estudiante\", \"Profesor\", \"Desempleado\"]" +
"        }]" +
"}";
    }
    
    public static java.util.ArrayList<controlador.modelos.Pregunta>
            getPreguntas(String str_nomProyecto, String str_nomTest) {
        /*
         FUNCION getPreguntas() REGRES un arreglo de PREGUNTA .
         Esta funcion RECIBE el nombre del PROYECTO y el nombre del TEST.
         */
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

    public static java.util.ArrayList<controlador.modelos.Categoria>
            getPerfil(String str_nomProyecto) {
        /*
         FUNCION getPerfil() REGRES un arreglo de categorias con sus opciones cada una.
         Esta funcion RECIBE el nombre del PROYECTO en formato String
         */
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

    /* FUNCIONES PARA PROYECTO BASICO  */
    public static String plantilla_Proyecto(String nombre, String descripcion) {
        /*
         SE USAN EN Archivos.java POR LA FUNCION crearProyectoSimple();
         */
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/proyecto.eviu";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            
        String str_= modProyecto();
                    
                    
//        String str_ = Archivos.Leer_Archivo(pantillaProyect);// leeo el Archivo 
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
        /*
         SE USAN EN Archivos.java POR LA FUNCION crearProyectoSimple();
         */
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/testEjemplo.eviutest";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

        String str_ =  modTest();
//        String str_ = Archivos.Leer_Archivo(pantillaProyect);// leeo el Archivo 
//        if (vista.Config.AES()) {
//            str_ = AES.decrypt(str_);
//        }
        try {
            Object obj_proyecto = parser.parse(str_);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            jsonobj_proyecto.put("str_padre", getnomProyecto(nomProyecto));
            jsonobj_proyecto.put("str_IDpadre", getIDProyecto(nomProyecto));
            jsonobj_proyecto.put("ID", GenerarID.getID(6));

            proyecto = "" + jsonobj_proyecto;

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "En leer datos en plantilla_Test()");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }
    /* FIN FUNCIONES PARA PROYECTO BASICO */

    /* CASO UNO */
    //Crear proyecto con nuevo perfil y nuevo test
    public static String plantilla_Proyecto(
            String nombre,
            String descripcion,
            org.json.simple.JSONArray lst_perfil) {
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/proyecto.eviu";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        
        String str_= modProyecto();
//        String str_ = Archivos.Leer_Archivo(pantillaProyect);// leeo el Archivo 
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

        String str_ =  modTest();
//        String str_ = Archivos.Leer_Archivo(pantillaProyect);// leeo el Archivo 
//        if (vista.Config.AES()) {
//            str_ = AES.decrypt(str_);
//        }
        try {
            Object obj_proyecto = parser.parse(str_);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            /* REESCRIBIR VALORES*/
            jsonobj_proyecto.put("str_padre", getnomProyecto(nomProyecto));
            jsonobj_proyecto.put("str_IDpadre", getIDProyecto(nomProyecto));
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

    /*GuardarRespuestas  Respuesta de la encuesta
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

    public static void setVersion(String nomP) {
        String pehtProyecto = "proyectos/" + nomP + "/" + nomP + ".eviu";
        String str_Proyecto = Archivos.Leer_Archivo(pehtProyecto);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_Proyecto = AES.decrypt(str_Proyecto);
        }
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_proyecto = parser.parse(str_Proyecto);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            int version = Integer.parseInt((String) jsonobj_proyecto.get("str_versiones"));
            version++;
            jsonobj_proyecto.put("str_versiones", "" + version);

            String srt_P = "" + jsonobj_proyecto;
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
        
    public static String getnomProyecto(String nomProyecto) {
        String str_nombreProyecto = "";
        String pehtProyecto = "proyectos/" + nomProyecto + "/" + nomProyecto + ".eviu";

        String str_Proyecto = Archivos.Leer_Archivo(pehtProyecto);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_Proyecto = AES.decrypt(str_Proyecto);
        }
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_proyecto = parser.parse(str_Proyecto);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            str_nombreProyecto = (String) jsonobj_proyecto.get("str_nombreProyecto");

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "en leerDatos en getversion(String nomProyecto)");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str_nombreProyecto;
    }
    
    public static String getIDProyecto(String nomProyecto) {
        String ID = "";
        String pehtProyecto = "proyectos/" + nomProyecto + "/" + nomProyecto + ".eviu";

        String str_Proyecto = Archivos.Leer_Archivo(pehtProyecto);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_Proyecto = AES.decrypt(str_Proyecto);
        }
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_proyecto = parser.parse(str_Proyecto);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            ID = (String) jsonobj_proyecto.get("ID");

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "en leerDatos en getversion(String nomProyecto)");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ID;
    }
    
    public static String getDescripcionProyecto(String nomProyecto) {
        String str_descripcionDelProyecto = "";
        String pehtProyecto = "proyectos/" + nomProyecto + "/" + nomProyecto + ".eviu";

        String str_Proyecto = Archivos.Leer_Archivo(pehtProyecto);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_Proyecto = AES.decrypt(str_Proyecto);
        }
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_proyecto = parser.parse(str_Proyecto);
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            str_descripcionDelProyecto = (String) jsonobj_proyecto.get("str_descripcionDelProyecto");

        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "en leerDatos en getversion(String nomProyecto)");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str_descripcionDelProyecto;
    }

    /*   que el test realmente pertenesca al proyecto 
         Funcion usada en Archivos.getTest()*/
    public static boolean validarTest(String nomProyecto,String nomTest){
        boolean a= false;
        String pathTest = "proyectos/" + nomProyecto + "/tests/"+nomTest;
        String str_Test = Archivos.Leer_Archivo(pathTest);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_Test = AES.decrypt(str_Test);
        }
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_Test = parser.parse(str_Test);
            JSONObject jsonobj_Test = (JSONObject) obj_Test;

            String str_padre = (String) jsonobj_Test.get("str_padre");
            String str_IDpadre = (String) jsonobj_Test.get("str_IDpadre");
            
            if(str_padre.equals(getnomProyecto(nomProyecto)) &&
                    str_IDpadre.equals(getIDProyecto(nomProyecto))){
                a = true;
            }
        } catch (ParseException ex) {
            System.out.println("Error en el parser de JSON"
                    + "en leerDatos en validarTest(String nomProyecto,String nomTest)");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
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

    @SuppressWarnings("UnusedAssignment")
    public static int importar1(String nomT, String pahtorigen) {
        //Recibo un test
        int count = 0;//numero de registros importados
        String str_ = Archivos.Leer_Archivo(pahtorigen + "/" + nomT);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_ = AES.decrypt(str_);
        }
        JSONParser parser = new JSONParser();
        try {
            /*      TEST EXTERNO    */
            Object obj = parser.parse(str_);
            JSONObject in_jsonTest = (JSONObject) obj;

            String in_str_padre = (String) in_jsonTest.get("str_padre");
            String in_str_nombreDelTest = (String) in_jsonTest.get("str_nombreDelTest");
            String in_ID = (String) in_jsonTest.get("ID");
            JSONArray in_lst_respuestas = (JSONArray) in_jsonTest.get("lst_respuestas");

            /*      TEST LOCAL      */
            String path_this_Test = "proyectos/" + in_str_padre + "/tests/" + nomT;
            String this_test = Archivos.Leer_Archivo(path_this_Test);// leeo el Archivo 

            if (this_test.equals("Error de lectura")) {
//                System.out.println("en el proyecto local no exites el test");
                count = -255;
            } else {
                if (vista.Config.AES()) {
                    this_test = AES.decrypt(this_test);
                }
                Object obj2 = parser.parse(this_test);
                JSONObject this_jsonTest = (JSONObject) obj2;

                String this_str_padre = (String) this_jsonTest.get("str_padre");
                String this_str_nombreDelTest = (String) this_jsonTest.get("str_nombreDelTest");
                String this_ID = (String) this_jsonTest.get("ID");
                JSONArray this_lst_respuestas = (JSONArray) this_jsonTest.get("lst_respuestas");

                /* Si los nombres y los IDs coinciden */
                if (in_str_nombreDelTest.equals(this_str_nombreDelTest)
                        && in_ID.equals(this_ID)) {
                    /*-----------------------------------------------------*/
                    ArrayList<String> this_IDs = new ArrayList();

                    if (!this_lst_respuestas.isEmpty()) {

                        for (Object this_respuesta : this_lst_respuestas) {
                            JSONObject this_jaosn_respuesta = (JSONObject) this_respuesta;
                            this_IDs.add((String) this_jaosn_respuesta.get("ID"));
                        }
                    }
////                    System.out.println("ids internos");
//                    for (String s : this_IDs) {
//                        System.out.println(s);
//                    }
////                    System.out.println("fin ids internos\n\nIds externos");
                    /*      Sacare las respuestas del archivo externo      */
                    for (Object in_respuesta : in_lst_respuestas) {
                        JSONObject in_json_respuesta = (JSONObject) in_respuesta;
                        String in_id = (String) in_json_respuesta.get("ID");
//                        System.out.println(in_id);
                        boolean bandera = true;// si es true puede ser añadido
                        if (!this_IDs.isEmpty()) {
                            for (String s : this_IDs) {
                                if (in_id.equals(s)) {
                                    bandera = false;
                                }
                            }
                        }
                        if (bandera) {
                            count++;
                            this_lst_respuestas.add(in_json_respuesta);
                        }

                    }
                    //se an pasado las respuestas
//                    System.out.println(this_jsonTest);
                    String ss = "" + this_jsonTest;
                    if (vista.Config.AES()) {
                        ss = AES.encrypt(ss);
                    }
                    if (count > 0) {
                        Archivos.escribirEnArchivo(path_this_Test, ss);
                    }
                } else {
                    count = -254;
//                    javax.swing.JOptionPane.showMessageDialog(null, "no coincide el test ");
                }
            }
        } catch (ParseException e) {

        }

        return count;
    }

    public static boolean borrarRespuestas(
            String nomProyecto,
            String nomTest) {
        boolean retorno = false;
        String test = "";
        String pathTest = "proyectos/" + nomProyecto + "/tests/" + nomTest + ".eviutest";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

        String str_Test = Archivos.Leer_Archivo(pathTest);// leeo el Archivo 
        if (vista.Config.AES()) {
            str_Test = AES.decrypt(str_Test);
        }
        try {

            Object obj_Test = parser.parse(str_Test);
            JSONObject jsonobj_Test = (JSONObject) obj_Test;

            org.json.simple.JSONArray all_respuestas = (org.json.simple.JSONArray) jsonobj_Test.get("lst_respuestas");
            /* AÑADIR RESPUESTA*/
            all_respuestas.clear();
            /* FIN AÑADIR RESPUESTA*/

            test = "" + jsonobj_Test;
            
            if (vista.Config.AES()) {
                test = AES.encrypt(test);
            }
            retorno=Archivos.escribirEnArchivo(pathTest, test);
            
            
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

        return retorno;
    }

    public static void main(String[] args) {
           
        System.out.println(getVersion("casa"));
        System.out.println(getnomProyecto("casa"));
        System.out.println(getIDProyecto("casa"));
        System.out.println(getDescripcionProyecto("casa"));
    }
}
