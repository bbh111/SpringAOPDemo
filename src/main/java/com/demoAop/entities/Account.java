package com.demoAop.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Account implements Serializable {
    private String username;
    private String password;

    @Override
    public String toString() {
        return username+"|"+password;
    }
}
