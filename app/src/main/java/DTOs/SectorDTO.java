package DTOs;

import java.io.Serializable;

/**
 * Created by SergioC on 12/01/2017.
 */

public class SectorDTO implements Serializable {

    private String id_sector;
    private String sector_deposito;
    private String latitud;
    private String longitud;
    private String foto_sector;


    public SectorDTO(String id_sector, String sector_deposito, String latitud, String longitud, String foto_sector) {
        this.id_sector = id_sector;
        this.sector_deposito = sector_deposito;
        this.latitud = latitud;
        this.longitud = longitud;
        this.foto_sector = foto_sector;
    }

    public String getId_sector() {
        return id_sector;
    }

    public void setId_sector(String id_sector) {
        this.id_sector = id_sector;
    }

    public String getSector_deposito() {
        return sector_deposito;
    }

    public void setSector_deposito(String sector_deposito) {
        this.sector_deposito = sector_deposito;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getFoto_sector() {
        return foto_sector;
    }

    public void setFoto_sector(String foto_sector) {
        this.foto_sector = foto_sector;
    }
}
