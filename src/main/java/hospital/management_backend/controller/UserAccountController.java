package hospital.management_backend.controller;

import hospital.management_backend.dto.LoginRequest;
import hospital.management_backend.model.UserAccount;
import hospital.management_backend.model.UserAppointment;
import hospital.management_backend.service.PatientServiceImp;
import hospital.management_backend.service.UserServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserAccountController {
    @Autowired
    UserServiceImp service;
    @Autowired
    PatientServiceImp patientServiceImp;

    @PostMapping("/create")
    ResponseEntity<UserAccount> create(@RequestBody UserAccount userAccount) {
        UserAccount done = service.create(userAccount);
        return ResponseEntity.ok(done);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        String message = service.deleteByEmail(email , password);
        return ResponseEntity.ok(message);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest , HttpSession session) {
        Optional<UserAccount> userOptional = service.findByMail(loginRequest.getEmail());
        if (userOptional.isPresent()) {
            UserAccount user = userOptional.get();
            if (service.authenticate(loginRequest.getEmail() , loginRequest.getPassword())) {

                session.setAttribute("user" , user);
                return ResponseEntity.ok("Login successful"+user.getFullName());
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }

    @GetMapping("/check-session")
    public ResponseEntity<Boolean> checkSession(HttpSession session) {
        return ResponseEntity.ok(session.getAttribute("user") != null);
    }

    @GetMapping("/get-name")
    public ResponseEntity<?> getUserName (HttpSession session){
        UserAccount userName= (UserAccount) session.getAttribute("user");
        if(userName !=null){
            return ResponseEntity.ok(Collections.singletonMap("name",userName.getFullName()));
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user name not found");
        }
    }
    @GetMapping("/prescription")
    public ResponseEntity<?> getAppointment(HttpSession session) {
        UserAccount userAccount = (UserAccount) session.getAttribute("user");
        if (userAccount == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not logged in");
        }
        List<UserAppointment> appointments = service.getFullName(userAccount.getFullName());

        if (appointments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No appointments found for user");
        }
        return ResponseEntity.ok(appointments);
    }


}
