/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.reporteRapido;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * Ejemplo de SwingWorker con una barra de progreso.<br>
 * El SwingWorker contará hasta 10 con esperas de un segundo en cada iteración y
 * actualizará una barra de progreso.
 *
 * @author Chuidiang
 *
 */
public class Principal2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        Principal2 principal2 = new Principal2();
    }

    /**
     * Muestra una ventana con una etiqueta, un dialogo con un progress bar y
     * lanza un SwingWorker. Cierra la ventana de progreso cuando termina el
     * worker.
     * @param Eviu    */
    public Principal2(vista.Eviu Eviu) {
        
        // La ventana principal, con una etiqueta que pondrá "Hecho" cuando
        // termine el SwingWorker.
//        JFrame ventanaPrincipal = new JFrame();
        JLabel etiqueta = new JLabel("Sin hacer");
//        ventanaPrincipal.getContentPane().add(etiqueta);
//        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventanaPrincipal.pack();
//        ventanaPrincipal.setLocationRelativeTo(null);
//        ventanaPrincipal.setVisible(true);

        // Una ventana con la barra de progreso
        JProgressBar barraProgreso = new JProgressBar(0, 100);
        JDialog dialogoProgreso = new JDialog(Eviu, "progreso");
        dialogoProgreso.getContentPane().add(barraProgreso);
        dialogoProgreso.pack();
        dialogoProgreso.setLocationRelativeTo(null);

        // Hacemos visible la barra de progreso y lanzamos
        // el SwingWorker.
        dialogoProgreso.setVisible(true);
        Worker2 worker = new Worker2(etiqueta, barraProgreso);
        worker.execute();
        // w.execute() devuelve el control inmediatamente, por lo que
        // no debemos ocultar la barra de progreso aqui
        
        respuesta a = new respuesta(worker);
        a.start();
//
//        dialogoProgreso.dispose();
    }
    public class respuesta  extends Thread{
        final Worker2 worker;
        public respuesta(Worker2 worker) {
            this.worker=worker;
        }

        @Override
        public void run() {
            try {
                System.out.println("respuesta "+worker.get());
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Principal2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
