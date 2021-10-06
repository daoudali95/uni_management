package com.example.unimanagement.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.regex.Matcher;

public class LoginDto {

    @Pattern(regexp ="^[A-Za-z0-9+_.-]+@(.+)$", message="Invalid email address!")
    private String email;

    private String password;

//    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
//    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//    Matcher matcher = pattern.matcher(email);
//    if (pattern.matcher(email).matches())

//    public String getEmail() {
//        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
//        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(email);
//        if (pattern.matcher(email).matches()) {
//            return email;
//        }
//        else {
//            return "invalid email pattern";
//        }
//    }

public String getEmail() {
    return email;
}

    public void setEmail(String email) {
        this.email = email;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
