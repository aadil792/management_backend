package hospital.management_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-incremented ID
    private Long id;
    private String chooseDepartment;
    private String chooseDoctor;
    private LocalDate date;
    private LocalTime time;
    private String fullName;
    private String number;
    private String textArea;
}