package hospital.management_backend.model;

import jakarta.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private  String phone;
    private String subject;
    @Lob
    @Column(length = 10000)
    private String thoughts;

    public Contact() {
    }

    public Contact(Long id , String name , String email , String phone , String subject , String thoughts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.thoughts = thoughts;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }
}
