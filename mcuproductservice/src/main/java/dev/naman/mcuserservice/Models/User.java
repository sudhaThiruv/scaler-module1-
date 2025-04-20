package dev.naman.mcuserservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class User {
    @Id
    private Long id;
    private  String email;
    private  String password;
    private Date createdAt;
    private  Date lastModifiedAt;


}
