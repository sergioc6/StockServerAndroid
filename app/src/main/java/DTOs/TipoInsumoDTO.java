package DTOs;

import java.io.Serializable;

/**
 * Created by SergioC on 12/01/2017.
 */

public class TipoInsumoDTO implements Serializable{

    private String id_tipoinsumo;
    private String tipo;

    public TipoInsumoDTO(String id_tipoinsumo, String tipo) {
        this.id_tipoinsumo = id_tipoinsumo;
        this.tipo = tipo;
    }

    public String getId_tipoinsumo() {
        return id_tipoinsumo;
    }

    public void setId_tipoinsumo(String id_tipoinsumo) {
        this.id_tipoinsumo = id_tipoinsumo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
