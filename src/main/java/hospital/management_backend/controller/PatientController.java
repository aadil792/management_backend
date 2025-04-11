package hospital.management_backend.controller;

import hospital.management_backend.model.Appointment;
import hospital.management_backend.model.UserAccount;
import hospital.management_backend.model.UserAppointment;
import hospital.management_backend.repository.UserAppointmentRepository;
import hospital.management_backend.service.PatientService;
import hospital.management_backend.service.PatientServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")  // Allows frontend requests from all origins
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientServiceImp patientServiceImp;

    // Add a new patient
    @PostMapping("/add")
    public ResponseEntity<UserAppointment> addPatient(@RequestBody UserAppointment patient , HttpSession session) {
        UserAppointment savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok(savedPatient);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<UserAppointment> getAppointmentById(@PathVariable Long id) {
        Optional<UserAppointment> appointment = patientService.getAppointmentById(id);
        return appointment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }


    @GetMapping("/get-name")
    public ResponseEntity<?> getUserName (HttpSession session){
        UserAppointment userName= (UserAppointment) session.getAttribute("user");
        if(userName !=null){
            return ResponseEntity.ok(Collections.singletonMap("name",userName.getFullName()));
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user name not found");
        }
    }

    // Get all patients
    @GetMapping("/all")
    public ResponseEntity<List<UserAppointment>> getAllPatients() {
        List<UserAppointment> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }
    @PutMapping("/prescription")
    public  ResponseEntity<UserAppointment>prescription(@RequestParam Long id , @RequestBody  UserAppointment prescription){
        UserAppointment prescriptionUp=patientService.updatePrescription(prescription.getId(),prescription.getPrescription());
        return ResponseEntity.ok(prescriptionUp);
    }

    // Update an existing patient's details
    @PutMapping("/update/{id}")
    public ResponseEntity<UserAppointment> updatePatient(@PathVariable Long id, @RequestBody UserAppointment patientDetails) {
        UserAppointment updatedPatient = patientService.updatePatient(id, patientDetails);
        return ResponseEntity.ok(updatedPatient);
    }
    @GetMapping("/getAllList")
    public List<UserAppointment> getALl(){
        return patientService.getAllList();
    }

    // Delete a patient by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.ok("Patient with ID " + id + " deleted successfully.");
    }

}

