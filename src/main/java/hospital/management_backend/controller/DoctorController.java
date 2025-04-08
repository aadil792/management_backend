package hospital.management_backend.controller;

import hospital.management_backend.model.Doctor;
import hospital.management_backend.service.DoctorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
