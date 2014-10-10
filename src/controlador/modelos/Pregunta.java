
package controlador.modelos;
public class Pregunta {
    /*
        "str_pregunta":"pregunta 2",
        "str_id":"02",
        "str_seMediraPorTiempo":"si",
        "str_seTomaranCuentaElEstadoDeAnimo":"si",
        "lst_estados-de-animo":["feliz","frustrado","molesto"],
        "str_t1":"00:08:00:00",
        "str_t2":"00:15:00:00",
    */
    private final String str_pregunta;
    private final String int_id;
    private final boolean boolean_seMediraPorTiempo;
    private final String[] t1;
    private final String[] t2;
    private final boolean boolean_seTomaranCuentaElEstadoDeAnimo;

    //El estado de animo se encuentra en un alcase aparte
    public Pregunta(String str_pregunta, String int_id, boolean boolean_seMediraPorTiempo, String[] t1, String[] t2, boolean boolean_seTomaranCuentaElEstadoDeAnimo) {
        this.str_pregunta = str_pregunta;
        this.int_id = int_id;
        this.boolean_seMediraPorTiempo = boolean_seMediraPorTiempo;
        this.t1 = t1;
        this.t2 = t2;
        this.boolean_seTomaranCuentaElEstadoDeAnimo = boolean_seTomaranCuentaElEstadoDeAnimo;
    }

    public String getStr_pregunta() {
        return str_pregunta;
    }

    public String getInt_id() {
        return int_id;
    }

    public boolean isBoolean_seMediraPorTiempo() {
        return boolean_seMediraPorTiempo;
    }

    public String[] getT1() {
        return t1;
    }

    public String[] getT2() {
        return t2;
    }

    public boolean isBoolean_seTomaranCuentaElEstadoDeAnimo() {
        return boolean_seTomaranCuentaElEstadoDeAnimo;
    }
   
}
