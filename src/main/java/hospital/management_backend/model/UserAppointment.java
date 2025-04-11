package hospital.management_backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity

public class UserAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doctorName;
    private String specializationDoctor;
    private LocalDate date;
    private LocalTime time;
    private String fullName;
    private String number;
    private String textArea;
    private String disease;
    @Lob
    @Column(length = 10000)
    private String prescription;

    public UserAppointment() {
    }

    public UserAppointment(Long id , String disease ,String doctorName , String specializationDoctor , LocalDate date , LocalTime time , String fullName , String number , String textArea , String prescription) {
        this.id = id;
        this.doctorName = doctorName;
        this.specializationDoctor = specializationDoctor;
        this.date = date;
        this.time = time;
        this.fullName = fullName;
        this.number = number;
        this.textArea = textArea;
        this.prescription = prescription;
        this.disease=disease;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
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

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
