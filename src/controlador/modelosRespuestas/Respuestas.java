
package controlador.modelosRespuestas;

public class Respuestas {
    private final String id_pregunta;
    private final String pregunta;
    private final String realizo;
    private final String tiempo;
    private final String animo;
    private final String nota;

    public Respuestas(String id_pregunta, String pregunta, String realizo, String tiempo, String animo, String nota) {
        this.id_pregunta = id_pregunta;
        this.pregunta = pregunta;
        this.realizo = realizo;
        this.tiempo = tiempo;
        this.animo = animo;
        this.nota = nota;
    }

    public String getId_pregunta() {
        return id_pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRealizo() {
        return realizo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public String getAnimo() {
        return animo;
    }

    public String getNota() {
        return nota;
    }
    
    
}
