
package controlador.modelosRespuestas;

import java.util.ArrayList;

public class Obj_respuestas {
    private String ID;
    private String version;
    private String tiempodeencuesta;
    private java.util.ArrayList<Perfil> perfil = new java.util.ArrayList();
    private java.util.ArrayList<Respuestas> respuestas = new java.util.ArrayList();

    
    
    public void addPerfil(Perfil Perfil){
        perfil.add(Perfil);
    }
    public void addRespuestas(Respuestas Respuestas){
        respuestas.add(Respuestas);
    }
    public ArrayList<Perfil> getPerfil() {
        return perfil;
    }

    public void setPerfil(ArrayList<Perfil> perfil) {
        this.perfil = (ArrayList<Perfil>) perfil.clone();
    }

    public ArrayList<Respuestas> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuestas> respuestas) {
        this.respuestas = (ArrayList<Respuestas>) respuestas.clone();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTiempodeencuesta() {
        return tiempodeencuesta;
    }

    public void setTiempodeencuesta(String tiempodeencuesta) {
        this.tiempodeencuesta = tiempodeencuesta;
    }
    
    
}
