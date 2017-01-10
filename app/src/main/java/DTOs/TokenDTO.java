package DTOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SergioC on 09/01/2017.
 */

public class TokenDTO {

    //ATRIBUTOS
    @SerializedName("token")
    public String token;

    //METODOS
    public TokenDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
