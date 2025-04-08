package hospital.management_backend.controller;

import hospital.management_backend.model.Doctor;
import hospital.management_backend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
        try {
            // Get current date and time
            Date todaysDate = new Date();
            DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String dateAndTime = df2.format(todaysDate);

            // Set the current timestamp to the doctor object (if applicable)
            doctor.setTimestamp(dateAndTime);

            // Call service to save doctor
            doctorService.saveDoctor(doctor);

            return ResponseEntity.status(HttpStatus.CREATED).body("Doctor added successfully!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + ex.getMessage());
        }
    }
}
