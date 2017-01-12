package DTOs;

import java.io.Serializable;

/**
 * Created by SergioC on 14/12/2016.
 */

public class ProveedorDTO implements Serializable {

    public int id_proveedor;
    public String nombre_proveedor;
    public String telefono;
    public String localidad;
    public String direccion;
    public String email;

    public ProveedorDTO(int id_proveedor, String nombre_proveedor, String telefono, String localidad, String direccion, String email) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono = telefono;
        this.localidad = localidad;
        this.direccion = direccion;
        this.email = email;
    }

    @Override
    public String toString() {
        return  "ID_proveedor: " + id_proveedor +".\n"+
                "Nombre del Proveedor: " + nombre_proveedor + ".\n" +
                "Telefono: " + telefono + ".\n" +
                "Localidad: " + localidad + ".\n" +
                "Direccion: " + direccion + ".\n" +
                "Email: " + email + ".\n";
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
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
