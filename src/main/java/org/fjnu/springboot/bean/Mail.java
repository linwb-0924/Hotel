package org.fjnu.springboot.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author wb_Lin
 * @create 2020-04-12 14:00
 */
public class Mail {
    @Email
    private String email;

    public Mail(String email) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
