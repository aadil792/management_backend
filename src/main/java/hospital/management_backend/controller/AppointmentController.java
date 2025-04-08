package hospital.management_backend.controller;


import hospital.management_backend.model.Appointment;
import hospital.management_backend.service.AppointmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImp services;


    @PostMapping("/saveAppointment")
    ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {
        Appointment done = services.create(appointment);
        return ResponseEntity.ok(done);

    }


}
