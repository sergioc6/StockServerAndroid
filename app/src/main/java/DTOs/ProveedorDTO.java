package DTOs;

/**
 * Created by SergioC on 14/12/2016.
 */

public class ProveedorDTO {

    public int idProveedor;
    public String nombreProveedor;
    public String telefonoProveedor;
    public String localidadProveedor;
    public String direccionProveedor;
    public String emailProveedor;

    public ProveedorDTO(int idProveedor, String nombreProveedor, String telefonoProveedor, String localidadProveedor, String direccionProveedor, String emailProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.localidadProveedor = localidadProveedor;
        this.direccionProveedor = direccionProveedor;
        this.emailProveedor = emailProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getLocalidadProveedor() {
        return localidadProveedor;
    }

    public void setLocalidadProveedor(String localidadProveedor) {
        this.localidadProveedor = localidadProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }
}
