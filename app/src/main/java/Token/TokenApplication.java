package Token;

/**
 * Created by SergioC on 10/01/2017.
 */

public class TokenApplication{

    private static TokenApplication instance;
    private String tokenGlobal;
    private String fotouser_base64;

    public static TokenApplication getInstance() {
        if(instance == null) instance = new TokenApplication();
        return instance;
    }

    public String getTokenGlobal() {
        return tokenGlobal;
    }

    public void setTokenGlobal(String tokenGlobal) {
        this.tokenGlobal = tokenGlobal;
    }

    public void deleteTokenGlobal() {
        this.tokenGlobal = "";
    }

    public String getFotouser_base64() {
        return fotouser_base64;
    }

    public void setFotouser_base64(String fotouser_base64) {
        this.fotouser_base64 = fotouser_base64;
    }
}
