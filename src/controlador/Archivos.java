package controlador;

import java.io.File;
import javax.swing.JOptionPane;

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
//            inf = "Error de lectura" + e;
            inf = "Error de lectura";
        }
        //recorrer el ArrayList lineas
        for (String string : lineas) {
            inf += string;
        }
        return inf;
    }

    private static void carpeta(String _carpeta) {//revisa que exista si no existe la creara
        /*
         La funcion:
         carpeta(String _carpeta)
         Se utiliza para crear una Carpeta o un a direccion de carpetas.
         recibe el nombre que tendra la carpeta la direccion de donse se creara la carpeta 
         * Si esta direccion no existe la creara.
         */
        String carpeta = "proyectos";
        if (!_carpeta.equals("")) {
            carpeta = _carpeta;
        }
        java.io.File folder = new java.io.File(carpeta);

        if (!folder.exists()) {//si no existe la crea
            folder.mkdirs();
        }

    }

    public static boolean escribirEnArchivo(String path, String dato) {
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
                    if (expresionRegular(file.getName(), lst_contenido[i].getName() + ".eviu")) {
                        /*
                         dentro de la carpeta proyectos tengo los proyectos en carpetas
                         para que sea considerado un proyecto la carpeta debe tener un archivo .eviu 
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
                if (expresionRegular(archivo.getName(), ".*.eviutest")) {//los test tienen extension .eviutest
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
        /*
         La funcion
         crearProyectoSimple()
         Crear un nuevo proyecto usando las pllantillas de PROYECTO Y TEST
         que se encuentran el la carpeta lib/plantillas/
         PROYECTO SIMPLE copia perfil y preguntas de las plantillas.
    
         SE USA EN JD_crearProyecto.java
         */
        boolean a = false;
        String paht = "proyectos/" + nomProyecto + "/";
        if (existeArchivooCarpeta(paht)) {
            JOptionPane.showMessageDialog(null, "Ya existe el proyecto: " + nomProyecto);
        } else {
            carpeta(paht);// creo la carpeta del proyecto
            String jsonProyecto = LeerDatos.plantilla_Proyecto(nomProyecto, descripcion);
            if (vista.Config.AES()) {
                jsonProyecto = AES.encrypt(jsonProyecto);
            }
            a = escribirEnArchivo(paht + nomProyecto + ".eviu", jsonProyecto); // creo el arcivoproyecto 

            carpeta(paht + "tests/");//creo la carpetatest
            String jsonTest = LeerDatos.plantilla_Test(nomProyecto);
            if (vista.Config.AES()) {
                jsonTest = AES.encrypt(jsonTest);
            }
            a = escribirEnArchivo(paht + "tests/testEjemplo.eviutest", jsonTest);//creo unteset
        }
        return a;
    }

    @SuppressWarnings("UnusedAssignment")
    public static boolean crearProyectoCasoUno(
            String nomProyecto,
            String descripcion,
            String nomTest,
            org.json.simple.JSONArray lst_perfil,
            org.json.simple.JSONArray lst_preguntas) {
        /*
         Crear proyecto con nuevo perfil y nuevo test. CASO UNO
         */
        /*
         La funcion
         crearProyectoCasoUno();
         Crear proyecto con nuevo perfil y nuevo test. CASO UNO
         ES USA EN JD_crearPT.java
         */
        boolean a = false;
        String paht = "proyectos/" + nomProyecto + "/";
        if (existeArchivooCarpeta(paht)) {
            JOptionPane.showMessageDialog(null, "Ya existe el proyecto: " + nomProyecto);
        } else {
            carpeta(paht);// creo la carpeta del proyecto
            String jsonProyecto = LeerDatos.plantilla_Proyecto(nomProyecto, descripcion, lst_perfil);//crear el objJSON
            if (vista.Config.AES()) {
                jsonProyecto = AES.encrypt(jsonProyecto);
            }
            a = escribirEnArchivo(paht + nomProyecto + ".eviu", jsonProyecto); // creo el arcivoproyecto 

            carpeta(paht + "tests/");//creo la carpetatest
            String jsonTest = LeerDatos.plantilla_Test(nomProyecto, nomTest, lst_preguntas);
            if (vista.Config.AES()) {
                jsonTest = AES.encrypt(jsonTest);
            }
            a = escribirEnArchivo(paht + "tests/" + nomTest + ".eviutest", jsonTest);//creo unteset
        }
        return a;
    }

    public static boolean crearCasoCuatro(
            String nomProyecto,
            String nomTest,
            org.json.simple.JSONArray lst_preguntas) {
        //CASO CUATRO
        //crear un nuevo test en un proyecto ya existente.
        /*
         proyecto;
         nomTest;
         lst_preguntas;
         */
        boolean a = false;
        String path = "proyectos/" + nomProyecto + "/tests/" + nomTest + ".eviutest";
        String jsonTest = LeerDatos.plantilla_Test(nomProyecto, nomTest, lst_preguntas);
        if (vista.Config.AES()) {
            jsonTest = AES.encrypt(jsonTest);
        }
        a = escribirEnArchivo(path, jsonTest);//creo unteset
        return a;
    }

    public static boolean guardarRespuestas(
            String nomProyecto,
            String nomTest,
            org.json.simple.JSONArray perfil,
            org.json.simple.JSONArray lst_respuestas,
            String tiempodeencuesta) {
        boolean a = false;

        String pathTest = "proyectos/" + nomProyecto + "/tests/" + nomTest + ".eviutest";

        String jsontest = LeerDatos.guardarRespuestas(nomProyecto, nomTest, perfil, lst_respuestas, tiempodeencuesta);
        if (vista.Config.AES()) {
            jsontest = AES.encrypt(jsontest);
        }

        a = escribirEnArchivo(pathTest, jsontest); // creo el arcivoproyecto 

        return a;
    }

    public static boolean importarRespuestas(String nombreOrigen, String pathOrigen) {
        boolean a = false;
        /*si i == -255 es no existe el archivo
         si i == -254 el archivo no coincide con el nombre y el id
         si i == -253 se cancela la operacion
         si i > 0 es el numero de registros insertados
         */
        int i = 0;
        String[] nombreO = nombreOrigen.split("\\.");
        switch (nombreO[1]) {
            case "eviu":
                System.out.println("Seleccionaste un Proyecto");
                break;
            case "eviutest":
                System.out.println("Seleccionaste un test");
                Object[] opciones = {"Aceptar", "Cancelar"};
                int eleccion = javax.swing.JOptionPane.showOptionDialog(null,
                        "Se importaran las respuestas de " + nombreOrigen,
                        "Mensaje de Confirmacion",
                        javax.swing.JOptionPane.YES_NO_OPTION,
                        javax.swing.JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
                if (eleccion == javax.swing.JOptionPane.YES_OPTION) {
                    i = controlador.LeerDatos.importar1(nombreOrigen, pathOrigen);
                } else {
                    i = -253;
                }
                break;
        }
        System.out.println("i = " + i);
        return a;
    }

    public static boolean borrarRespuestas(String nomProyecto, String nomTest) {
        boolean a = false;
        a = controlador.LeerDatos.borrarRespuestas(nomProyecto, nomTest);

        return a;
    }

    public static boolean eliminarTest(String nomProyecto, String nomTest) {
        boolean a = false;
        String path = "proyectos/" + nomProyecto + "/tests/" + nomTest + ".eviutest";
        java.io.File fichero = new java.io.File(path);
        a = fichero.delete();
        return a;
    }

    public static boolean eliminarProyecto(String nomProyecto) {
        boolean a = false;
        try {
            String path = "proyectos/" + nomProyecto;
            java.io.File fichero = new java.io.File(path);
            eliminarCarpeta(fichero);
            a = fichero.delete();
        } catch (java.lang.NullPointerException e) {
            System.out.println("error en Archivos.eliminarProyecto()");
            a = false;
        }
        return a;
    }

    private static void eliminarCarpeta(java.io.File carpeta) {
        java.io.File[] ficheros = carpeta.listFiles();
        for (java.io.File fichero : ficheros) {
            if (fichero.isDirectory()) {
                eliminarCarpeta(fichero);
            }
            fichero.delete();
        }
    }

}
