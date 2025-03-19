package hospital.management_backend.controller;

import hospital.management_backend.model.UserAccount;
import hospital.management_backend.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserAccountController {
    @Autowired
    UserServiceImp service;

    @PostMapping("/create")
    ResponseEntity<UserAccount> create(@RequestBody UserAccount userAccount) {
        UserAccount done = service.create(userAccount);
        return ResponseEntity.ok(done);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Map<String, String> request) {
        String email = request.get("email");// Extract email from JSON request body
        String password =request.get("password");
        String message = service.deleteByEmail(email,password);
        return ResponseEntity.ok(message);
    }


}
