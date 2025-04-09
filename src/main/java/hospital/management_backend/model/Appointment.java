package hospital.management_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;



@Entity

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-incremented ID
    private Long id;
    private String DoctorName;
    private String specializationDoctor;
    private LocalDate date;
    private LocalTime time;
    private String fullName;
    private String number;
    private String textArea;


    public Appointment() {
    }

    public Appointment(Long id , String doctorName , String specializationDoctor , LocalDate date , LocalTime time , String fullName , String number , String textArea) {
        this.id = id;
        DoctorName = doctorName;
        this.specializationDoctor = specializationDoctor;
        this.date = date;
        this.time = time;
        this.fullName = fullName;
        this.number = number;
        this.textArea = textArea;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getSpecializationDoctor() {
        return specializationDoctor;
    }

    public void setSpecializationDoctor(String specializationDoctor) {
        this.specializationDoctor = specializationDoctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }
}