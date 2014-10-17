package controlador;

import java.io.IOException;
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
        String pathTest = "proyectos/" + str_nomProyecto + "/tests/" + str_nomTest + ".json";
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
                    + str_nomProyecto + ".json");
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
    */
    public static String plantilla_Proyecto(String nombre, String descripcion) {
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/proyecto.json";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_proyecto = parser.parse(new java.io.FileReader(pantillaProyect));
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            jsonobj_proyecto.put("str_nombreProyecto", nombre);
            jsonobj_proyecto.put("str_descripcionDelProyecto", descripcion);
            jsonobj_proyecto.put("ID", GenerarLlave.getLlave(6));

            proyecto = "" + jsonobj_proyecto;

        } catch (IOException | ParseException ex) {
            System.out.println("Error en el parser de JSON");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }

    public static String plantilla_Test() {
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/testEjemplo.json";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_proyecto = parser.parse(new java.io.FileReader(pantillaProyect));
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            jsonobj_proyecto.put("ID", GenerarLlave.getLlave(6));

            proyecto = "" + jsonobj_proyecto;

        } catch (IOException | ParseException ex) {
            System.out.println("Error en el parser de JSON");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }

}
