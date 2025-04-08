package hospital.management_backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String speciality;
    private String email;
    private String password;
    private LocalTime availableFrom;
    private LocalTime availableTo;

    public Doctor() {
    }

    public Doctor(Long id , String name , String speciality , String email , String password , LocalTime availableTo , LocalTime availableFrom) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.email = email;
        this.password = password;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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

    public LocalTime getAvailableFrom() {
        return availableFrom;
    }


    public void setAvailableFrom(LocalTime availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalTime getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(LocalTime availableTo) {
        this.availableTo = availableTo;
    }
}

