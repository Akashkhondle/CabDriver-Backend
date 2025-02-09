package com.cabdriver.Cab.Driver.requestbody;


//import lombok.*;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class UserCredentialsRequestBody {

    private String email;
    private String password;

    public UserCredentialsRequestBody(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserCredentialsRequestBody() {
    }


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
