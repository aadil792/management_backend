package hospital.management_backend.model;

import jakarta.persistence.*;

import java.time.LocalTime;


@Entity

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doctorName;
    private String specializationDoctor;
    private String email;
    private String password;
    private LocalTime availableFrom;
    private LocalTime availableTo;

    public Doctor() {
    }

    public Doctor(Long id , String doctorName , String specializationDoctor , String email , String password , LocalTime availableTo , LocalTime availableFrom) {
        this.id = id;
        this.doctorName = doctorName;
        this.specializationDoctor = specializationDoctor;
        this.email = email;
        this.password = password;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    public Long getId() {
        return id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecializationDoctor() {
        return specializationDoctor;
    }

    public void setSpecializationDoctor(String specializationDoctor) {
        this.specializationDoctor = specializationDoctor;
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

