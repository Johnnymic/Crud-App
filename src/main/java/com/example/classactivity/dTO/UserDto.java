package com.example.classactivity.dTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserDto {
    private String  username;

    private String  email;

    private String  password;
}
