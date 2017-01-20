package DTOs;

import java.io.Serializable;

/**
 * Created by SergioC on 21/12/2016.
 */

public class InsumoDTO implements Serializable {

    private String id_insumo;
    private String nombre_insumo;
    private String descripcion;
    private String stock_min;
    private String stock_max;
    private String id_tipoinsumo;
    private String tipo;
    private String id_sector;
    private String sector_deposito;
    private String cantidad;

    public InsumoDTO(String id_insumo, String nombre_insumo, String descripcion, String stock_min, String stock_max, String id_tipoinsumo, String id_sector, String cantidad) {
        this.id_insumo = id_insumo;
        this.nombre_insumo = nombre_insumo;
        this.descripcion = descripcion;
        this.stock_min = stock_min;
        this.stock_max = stock_max;
        this.id_tipoinsumo = id_tipoinsumo;
        this.id_sector = id_sector;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return  "Cód. Insumo: " + id_insumo + ".\n" +
                "Nombre Insumo: " + nombre_insumo + ".\n" +
                "Descripción: " + descripcion + ".\n" +
                "Stock Min: " + stock_min + ".\n" +
                "Stock Max: " + stock_max + ".\n" +
                "Tipo de Insumo: " + tipo + ".\n" +
                "Sector en Depósito: " + sector_deposito + ".\n";
    }

    public String getId_insumo() {
        return id_insumo;
    }

    public void setId_insumo(String id_insumo) {
        this.id_insumo = id_insumo;
    }

    public String getNombre_insumo() {
        return nombre_insumo;
    }

    public void setNombre_insumo(String nombre_insumo) {
        this.nombre_insumo = nombre_insumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStock_min() {
        return stock_min;
    }

    public void setStock_min(String stock_min) {
        this.stock_min = stock_min;
    }

    public String getStock_max() {
        return stock_max;
    }

    public void setStock_max(String stock_max) {
        this.stock_max = stock_max;
    }

    public String getId_tipoinsumo() {
        return id_tipoinsumo;
    }

    public void setId_tipoinsumo(String id_tipoinsumo) {
        this.id_tipoinsumo = id_tipoinsumo;
    }

    public String getId_sector() {
        return id_sector;
    }

    public void setId_sector(String id_sector) {
        this.id_sector = id_sector;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSector_deposito() {
        return sector_deposito;
    }

    public void setSector_deposito(String sector_deposito) {
        this.sector_deposito = sector_deposito;
    }
}
