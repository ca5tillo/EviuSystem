

package controlador.modelos;

import java.util.ArrayList;

public class Categoria {
    private String categoria;
    java.util.ArrayList<String> opciones = new java.util.ArrayList();
    public Categoria(){
        
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<String> opciones) {
        this.opciones = (ArrayList<String>) opciones.clone();
    }
    
}
