package DTOs;

/**
 * Created by SergioC on 09/01/2017.
 */

public class TokenDTO {

    //ATRIBUTOS
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
