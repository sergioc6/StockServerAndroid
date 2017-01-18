package DTOs;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by SergioC on 09/01/2017.
 */

public class TokenDTO implements Serializable {

    //ATRIBUTOS
    private String token;
    private String foto_base64;

    //METODOS

    public TokenDTO(String token, String foto_base64) {
        this.token = token;
        this.foto_base64 = foto_base64;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFoto_base64() {
        return foto_base64;
    }

    public void setFoto_base64(String foto_base64) {
        this.foto_base64 = foto_base64;
    }
}
