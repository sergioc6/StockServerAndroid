package DTOs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SergioC on 11/01/2017.
 */

public class CompraDTO {

    private int id_compra;

    private int numero_oc;

    private String estado;

    private String fecha;

    private String id_prov;

    private String monto;

    private String nombre_proveedor;

    private String telefono;

    private String localidad;

    private String direccion;

    private String email;

    public CompraDTO(int id_compra, int numero_oc, String estado, String fecha, String id_prov, String monto, String nombre_proveedor, String telefono, String localidad, String direccion, String email) {
        this.id_compra = id_compra;
        this.numero_oc = numero_oc;
        this.estado = estado;
        this.fecha = fecha;
        this.id_prov = id_prov;
        this.monto = monto;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono = telefono;
        this.localidad = localidad;
        this.direccion = direccion;
        this.email = email;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getNumero_oc() {
        return numero_oc;
    }

    public void setNumero_oc(int numero_oc) {
        this.numero_oc = numero_oc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId_prov() {
        return id_prov;
    }

    public void setId_prov(String id_prov) {
        this.id_prov = id_prov;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
