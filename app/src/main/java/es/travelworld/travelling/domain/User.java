package es.travelworld.travelling.domain;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("usuario")
    public String userName;
    @SerializedName("password")
    public String userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /*public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }*/
}
