package hospital.management_backend.controller;


import hospital.management_backend.model.Appointment;
import hospital.management_backend.service.AppointmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAllList")
    public List<Appointment> getALl(){
        return services.getAllList();
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String>  delete (@PathVariable Long id){
        services.deleteAppointmentById(id);
        return ResponseEntity.ok("Deleted Successful ");
    }
    @PutMapping("/update")
    public ResponseEntity<Appointment> update (@RequestParam Long id ,@RequestBody Appointment appointment){
        Appointment up= services.update(id ,appointment);
        return ResponseEntity.ok(up);
    }
    @GetMapping("/get/{id}")
    public Appointment getById(@PathVariable Long id){
        return  services.getById(id).get();
    }

}
