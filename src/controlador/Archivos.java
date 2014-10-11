package controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Archivos {

    public static String Leer_Archivo(String path) {
        String inf = "";
        java.util.ArrayList<String> lineas = new java.util.ArrayList<>();

        //Lectura 
        try (java.util.Scanner archivo_entrada = new java.util.Scanner(new java.io.File(path));) {
            while (archivo_entrada.hasNext()) {
                lineas.add(archivo_entrada.nextLine());
            }
            archivo_entrada.close();
        } catch (java.io.FileNotFoundException e) {
            inf = "Error de lectura" + e;
        }
        //recorrer el ArrayList lineas
        for (String string : lineas) {
            inf += string;
        }
        return inf;
    }

    private static void carpeta(String _carpeta) {//revisa que exista si no existe la creara
        String carpeta = "proyectos";
        if (!_carpeta.equals("")) {
            carpeta = _carpeta;
        }
        java.io.File folder = new java.io.File(carpeta);

        if (!folder.exists()) {//si no existe la crea
            folder.mkdirs();
        }

    }

    private static boolean escribirEnArchivo(String path, String dato) {
        @SuppressWarnings("UnusedAssignment")
        boolean b = false;
        final java.util.Formatter archivo;
        try {
            archivo = new java.util.Formatter(path);
            archivo.format("%s", dato);
            archivo.close();
            b = true;
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error al escribir arcivo en Archivos.escribirEnArchivo");
            b = false;
        }
        return b;
    }

    private static boolean expresionRegular(String dato, String expRegular) {
        boolean a = false;
        java.util.regex.Pattern pat = java.util.regex.Pattern.compile(expRegular);
        java.util.regex.Matcher mat = pat.matcher(dato);
        if (mat.matches()) {
            a = true;
        }
        return a;
    }

    public static java.util.ArrayList<String> getProyectos() {
        /*
         Devuleve una lista de string de los nombres de proyecto q existen
         */
        java.util.ArrayList<String> lst_proyectos = new java.util.ArrayList();

        java.io.File[] lst_contenido;
        /*
         Tengo que entrar a la carpeta de los proyectos y obtener todos los proyectos
         */
        carpeta("");/* si no existe la carpeta especificada la creara. 
         si mando cadena vacia asume que la carpeta es proyectos
         */

        java.io.File folder = new java.io.File("proyectos");

        lst_contenido = folder.listFiles(); // extraigo el contenido de la carpeta
        for (int i = 0; i < lst_contenido.length; i++) {
            if (lst_contenido[i].isDirectory()) {
                java.io.File[] lstcontenido = lst_contenido[i].listFiles();
                boolean esproyecto = false;
                for (java.io.File file : lstcontenido) {
                    if (expresionRegular(file.getName(), lst_contenido[i].getName() + ".json")) {
                        /*
                         dentro de la carpeta proyectos tengo los proyectos en carpetas
                         para que sea considerado un proyecto la carpeta debe tener un archivo .json 
                         con el mismo nombre de la carpeta/proyecto
                         */
                        esproyecto = true;
                    }
                }
                if (esproyecto) {/*si es un proyecto lo añado a la lista solo el nombre*/

                    lst_proyectos.add(lst_contenido[i].getName());
                    esproyecto = false;
                }
            }
        }

        return lst_proyectos;
    }

    public static java.util.ArrayList<String> getTests(String str_proyecto) {
        /*
         Oviare que si se selecciono un proyecto 
         es porquela carpeta proyectos existe y esta tiene proyectos
         */
        java.util.ArrayList<String> arrayL_Tests = new java.util.ArrayList();
        String pathTest = "proyectos/" + str_proyecto + "/tests";
//        carpeta(pathTest);//si la carpeta no existe la creara

        if (new java.io.File(pathTest).isDirectory()) {//verifica que sea un directorio 
            java.io.File[] lst_contenido = new java.io.File(pathTest).listFiles();  //Saco su contenido
            for (java.io.File archivo : lst_contenido) {
                if (expresionRegular(archivo.getName(), ".*.json")) {//los test tienen extension .json
                    String[] str_nomtest = archivo.getName().split("\\.", 2);
                    arrayL_Tests.add(str_nomtest[0]);
                }
            }
        }

        return arrayL_Tests;
    }
    public static boolean existeArchivooCarpeta(String path) {
        //Si es existe que el archivo o carpeta existe devuelve true
        boolean estado = false;
        if (new java.io.File(path).exists()) {
            estado = true;
        }
        return estado;
    }
    @SuppressWarnings("UnusedAssignment")
    public static boolean crearProyectoSimple(String nomProyecto, String descripcion) {
        boolean a = false;
        String paht = "proyectos/" + nomProyecto + "/";
        if(existeArchivooCarpeta(paht)){
            JOptionPane.showMessageDialog(null, "Ya existe el proyecto: "+nomProyecto);
        }else{
            carpeta(paht);// creo la carpeta del proyecto
    //        String jsonProyecto = AES.encrypt(json_proyecto(nomProyecto, descripcion));
            String jsonProyecto = json_proyecto(nomProyecto, descripcion);
            a = escribirEnArchivo(paht + nomProyecto + ".json", jsonProyecto); // creo el arcivoproyecto 

            carpeta(paht + "tests/");//creo la carpetatest
    //        String jsonTest = AES.encrypt(json_test());
            String jsonTest = json_test();
            a = escribirEnArchivo(paht + "tests/testEjemplo.json", jsonTest);//creo unteset
        }
        return a;
    }

    private static String json_proyecto(String nombre, String descripcion) {
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/proyecto.json";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_proyecto = parser.parse(new java.io.FileReader(pantillaProyect));
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            jsonobj_proyecto.put("str_nombreProyecto", nombre);
            jsonobj_proyecto.put("str_descripcionDelProyecto", descripcion);
            jsonobj_proyecto.put("llave", GenerarLlave.getLlave(6));

            proyecto = "" + jsonobj_proyecto;

        } catch (IOException | ParseException ex) {
            System.out.println("Error en el parser de JSON");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }

    private static String json_test() {
        String proyecto = "";
        String pantillaProyect = "lib/plantillas/testEjemplo.json";
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object obj_proyecto = parser.parse(new java.io.FileReader(pantillaProyect));
            JSONObject jsonobj_proyecto = (JSONObject) obj_proyecto;

            jsonobj_proyecto.put("llave", GenerarLlave.getLlave(6));

            proyecto = "" + jsonobj_proyecto;

        } catch (IOException | ParseException ex) {
            System.out.println("Error en el parser de JSON");
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }

    public static void main(String[] args) {
        System.out.println("" + json_proyecto("", ""));
    }
}
