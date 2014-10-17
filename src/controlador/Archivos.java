package controlador;

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
            inf = "Error de lectura" + e;
        }
        //recorrer el ArrayList lineas
        for (String string : lineas) {
            inf += string;
        }
        return inf;
    }
    /*
    La funcion:
        carpeta(String _carpeta)
    Se utiliza para crear una Carpeta o un a direccion de carpetas.
    recibe el nombre que tendra la carpeta la direccion de donse se creara la carpeta 
    * Si esta direccion no existe la creara.
    */
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
    
    /*
    La funcion
        crearProyectoSimple()
    Crear un nuevo proyecto usando las pllantillas de PROYECTO Y TEST
    que se encuentran el la carpeta lib/plantillas/
    PROYECTO SIMPLE copia perfil y preguntas de las plantillas.
    
    SE USA EN JD_crearProyecto.java
    */
    @SuppressWarnings("UnusedAssignment")
    public static boolean crearProyectoSimple(String nomProyecto, String descripcion) {
        boolean a = false;
        String paht = "proyectos/" + nomProyecto + "/";
        if(existeArchivooCarpeta(paht)){
            JOptionPane.showMessageDialog(null, "Ya existe el proyecto: "+nomProyecto);
        }else{
            carpeta(paht);// creo la carpeta del proyecto
            String jsonProyecto = LeerDatos.plantilla_Proyecto(nomProyecto, descripcion);
            if (vista.Config.AES()) jsonProyecto = AES.encrypt(jsonProyecto);
            a = escribirEnArchivo(paht + nomProyecto + ".json", jsonProyecto); // creo el arcivoproyecto 

            carpeta(paht + "tests/");//creo la carpetatest
            String jsonTest = LeerDatos.plantilla_Test();
            if (vista.Config.AES()) jsonTest = AES.encrypt(jsonTest);
            a = escribirEnArchivo(paht + "tests/testEjemplo.json", jsonTest);//creo unteset
        }
        return a;
    }
    /*
    La funcion
        crearProyectoCasoUno();
            Crear proyecto con nuevo perfil y nuevo test. CASO UNO
    ES USA EN JD_crearPT.java
    */
    public static boolean crearProyectoCasoUno(
            String nomProyecto, 
            String descripcion,
            String nomTest,
            org.json.simple.JSONArray lst_perfil,
            org.json.simple.JSONArray lst_preguntas){
        /*
        Crear proyecto con nuevo perfil y nuevo test. CASO UNO
        */
        boolean a = false;
        String paht = "proyectos/" + nomProyecto + "/";
        if(existeArchivooCarpeta(paht)){
            JOptionPane.showMessageDialog(null, "Ya existe el proyecto: "+nomProyecto);
        }else{
            carpeta(paht);// creo la carpeta del proyecto
            String jsonProyecto = LeerDatos.plantilla_Proyecto(nomProyecto, descripcion,lst_perfil);//crear el objJSON
            if (vista.Config.AES()) jsonProyecto = AES.encrypt(jsonProyecto);
            a = escribirEnArchivo(paht + nomProyecto + ".json", jsonProyecto); // creo el arcivoproyecto 

            carpeta(paht + "tests/");//creo la carpetatest
            String jsonTest = LeerDatos.plantilla_Test(nomTest,lst_preguntas);
            if (vista.Config.AES()) jsonTest = AES.encrypt(jsonTest);
            a = escribirEnArchivo(paht + "tests/"+nomTest+".json", jsonTest);//creo unteset
        }
        return a;
    }
}
