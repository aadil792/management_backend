package hospital.management_backend.controller;

import hospital.management_backend.model.Appointment;
import hospital.management_backend.model.Doctor;
import hospital.management_backend.service.DoctorServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorServiceImp doctorServiceImp;

    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor done= doctorServiceImp.addDoctor(doctor);
        return ResponseEntity.ok(done);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorServiceImp.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Doctor doctor, HttpSession session) {
        Optional<Doctor> doctorOpt = doctorServiceImp.findByEmailAndDoctorName(doctor.getEmail(), doctor.getDoctorName());

        if (doctorOpt.isPresent() && doctorServiceImp.auth(doctor.getEmail(), doctor.getPassword(), doctor.getDoctorName())) {
            session.setAttribute("user", doctorOpt.get());
            return ResponseEntity.ok("Login successful");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout (HttpSession session){
        session.invalidate();
        return  ResponseEntity.ok("logout");
    }
    @GetMapping("/check-session")
    public ResponseEntity<Boolean> checkSession(HttpSession session) {
        return ResponseEntity.ok(session.getAttribute("user") != null);
    }
    @GetMapping("/get-name")
    public ResponseEntity<?> getName (HttpSession session){
        Doctor doctor =(Doctor) session.getAttribute("user");
        if(doctor !=null){
            return ResponseEntity.ok(Collections.singletonMap("name",doctor.getDoctorName()));
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("did not found name");
        }
    }
    @GetMapping("/getAll")
    public List<Doctor> getAll(){
        return doctorServiceImp.getAllDoctors();
    }

    @GetMapping("/appointment")
    public ResponseEntity<?> getAppointments(HttpSession session) {
        Doctor doctor = (Doctor) session.getAttribute("user");
        if (doctor == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Doctor not logged in");
        }
        List<Appointment> appointments = doctorServiceImp.getDoctorNameAndSpecializationDoctor(doctor.getDoctorName() ,
                doctor.getSpecializationDoctor());
        return ResponseEntity.ok(appointments);
    }


}

