package sergioc6.stockserverandroid;

import android.app.Application;

/**
 * Created by SergioC on 10/01/2017.
 */

public class TokenApplication{

    private static TokenApplication instance;
    private String tokenGlobal;

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
}
