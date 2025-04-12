package hospital.management_backend.controller;

import hospital.management_backend.model.Contact;
import hospital.management_backend.service.ContactServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")

public class ContactController {
    @Autowired
    ContactServiceImp contactService;

    @PostMapping("/addContact")
    ResponseEntity<Contact> create (@RequestBody Contact contact){
       Contact  created=contactService.create(contact);
        return ResponseEntity.ok(created);
    }
    @GetMapping("/getAllList")
    List<Contact> getAll(){
        return contactService.getList();
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        contactService.deleteById(id);
        return ResponseEntity.ok("deleted Successfully");
    }
}
