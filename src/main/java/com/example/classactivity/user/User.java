package com.example.classactivity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name= "_user")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @Column(name ="first_name")
    private String firstname;
    @NotNull
    @Column(name= "last_name", nullable= false)
    private String lastname;

    private String username;
    private String password;
    private String email;

}
