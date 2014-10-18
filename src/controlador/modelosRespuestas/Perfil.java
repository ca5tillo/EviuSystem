

package controlador.modelosRespuestas;

public class Perfil {
    private final String categoria;
    private final String opcion;

    public Perfil(String categoria, String opcion) {
        this.categoria = categoria;
        this.opcion = opcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getOpcion() {
        return opcion;
    }
    
}
