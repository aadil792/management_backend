package hospital.management_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String disease;
    private String RequireDoctor;

    public Patient() {
    }

    public Patient(Long id , String name , int age , String disease ,String RequireDoctor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.RequireDoctor=RequireDoctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
    public String getRequireDoctor(){
        return RequireDoctor;
    }
    public void setRequireDoctor(String RequireDoctor){
        this.RequireDoctor=RequireDoctor;
    }
}

