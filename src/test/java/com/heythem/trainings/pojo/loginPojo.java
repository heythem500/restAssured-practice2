package com.heythem.trainings.pojo;

public class loginPojo {


//two variables
    private String email;
    private String password;

    //new addon: we may need to deactivate this because it'll affect the students files force us to add arguments
    public loginPojo(String email, String password) {
        this.email = email;
        this.password = password;

    }


    // setters and getters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
