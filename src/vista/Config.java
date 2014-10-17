/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.awt.Color;
import java.awt.Font;

public class Config {
    private static final java.awt.Font tam_Titulo = new java.awt.Font("Ubuntu", 1, 24);
    private static final java.awt.Font tam_subTitulo = new java.awt.Font("Ubuntu", 1, 18);

 
    public static Font getTam_Titulo() {
        return tam_Titulo;
    }
    
    public static Font getTam_subTitulo() {
        return tam_subTitulo;
    }

    public static Color colorDeSeleccionado (){
        return java.awt.Color.MAGENTA;
    }
    public static boolean AES(){
        return false;
    }
}
