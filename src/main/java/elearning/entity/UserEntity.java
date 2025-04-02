package elearning.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity(name="userEntity")
@Table(name="userEntity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="status")
    private String status;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="updatedDate")
    private Date updatedDate;
}
