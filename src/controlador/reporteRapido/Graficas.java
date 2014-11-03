
package controlador.reporteRapido;

import controlador.modelos.Categoria;
import controlador.modelosRespuestas.Obj_respuestas;
import controlador.modelosRespuestas.Perfil;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graficas {
    public static String bar_Perfil(String str_nomProyecto,String str_nomTest) {
        String path = "bar_Perfil.jpg";
        JFreeChart Grafica;
        DefaultCategoryDataset Datos = new DefaultCategoryDataset();

        /*CREO LA BASE DE LA GRAFICA*/
        java.util.ArrayList<controlador.modelos.Categoria> perfil = new java.util.ArrayList();
        perfil = controlador.LeerDatos.getPerfil(str_nomProyecto);
        for (Categoria cat : perfil) {
            String categoria = cat.getCategoria();
            java.util.ArrayList<String> opciones = cat.getOpciones();
            for (String opcion : opciones) {
                Datos.addValue(0, categoria, opcion);
            }
        }
        /* FIN DE CREO LA BASE DE LA GRAFICA*/

        /* INCREMENTO LOS VALORES */
        /*TIENES QUE SELECCINAR UN TEST PARA QUE str_nomTest TENGA UN VALOR */
        ArrayList<Obj_respuestas> getRespuestas
                = controlador.LeerDatos.getRespuestas(str_nomProyecto, str_nomTest);
        for (Obj_respuestas a : getRespuestas) {

            java.util.ArrayList<controlador.modelosRespuestas.Perfil> lst_perfil = a.getPerfil();

            for (Perfil perfil1 : lst_perfil) {
                String categoria = perfil1.getCategoria();
                String opcion = perfil1.getOpcion();

                Datos.incrementValue(1, categoria, opcion);
            }
        }

        Grafica = ChartFactory.createBarChart("Perfiles del Test "+str_nomTest,
                "Opciones", "Número", Datos,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel Panel = new ChartPanel(Grafica);
//        JFrame Ventana = new JFrame("JFreeChart");
//        Ventana.getContentPane().add(Panel);
//        Ventana.pack();
//        Ventana.setVisible(true);
//        Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            org.jfree.chart.ChartUtilities.saveChartAsJPEG(new java.io.File(path), Grafica, 900, 400);
        } catch (java.io.IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Se ha producido un error al intentar guardar", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return path;
    }

}
