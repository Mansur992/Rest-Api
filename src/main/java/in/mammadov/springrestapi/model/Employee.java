package in.mammadov.springrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Getter
@Setter
@ToString
@Entity
@Table(name = "springrestapi")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name should not be null")
    private String name;

    private Long age = 0L;

    private String location;

    @Email(message = "Please enter the valid email address")
    private String email;

    @NotBlank(message = "Department should not be null")
    private String department;

    @CreationTimestamp
    @Column(name = "createdAt",nullable = false,updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updatetAt")
    private Date updatetAt;

}
