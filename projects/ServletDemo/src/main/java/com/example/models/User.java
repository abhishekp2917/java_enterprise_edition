package com.example.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
