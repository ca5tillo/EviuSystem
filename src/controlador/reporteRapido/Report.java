
package controlador.reporteRapido;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Report  extends SwingWorker<Double, Integer>{
    private final JLabel etiqueta;
    private final JProgressBar progreso;
    public Report(JLabel unaEtiqueta, JProgressBar unaBarraProgreso) {
        etiqueta = unaEtiqueta;
        progreso = unaBarraProgreso;
    }

    /**
     * Tarea que tarda mucho y se ejecutara en un hilo separado.
     * @return 
     * @throws java.lang.Exception
     */
    @Override
    protected Double doInBackground() throws Exception {
        System.out.println("doInBackground() esta en el hilo "
                + Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            

            // Se pasa valor para la barra de progreso. ESto llamara al metodo
            // process() en el hilo de despacho de eventos.
            publish(i + 1);
        }

        // Supuesto resultado de la tarea que tarda mucho.
        return 100.0;
    }

    /**
     * Tarea terminada, SwingWorker llama a este metodo en el hilo de despacho
     * de eventos. Aqui actualizamos la etiqueta para que ponga "Hecho".
     */
    @Override
    protected void done() {
        System.out.println("done() esta en el hilo "
                + Thread.currentThread().getName());
        etiqueta.setText("hecho");
    }

    /**
     * SwingWorker llama a este metodo en el hilo de despacho de eventos cuando
     * llamamos a publish() y le pasa los mismos parametros que nosotros
     * pongamos en publish().<br>
     * En este ejemplo, nosotros pasamos el valor de la barra de progreso.
     * @param chunks
     */
    @Override
    protected void process(List<Integer> chunks) {
        System.out.println("process() esta en el hilo "
                + Thread.currentThread().getName());
        progreso.setValue(25);
    }
}