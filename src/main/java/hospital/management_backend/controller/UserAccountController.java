package hospital.management_backend.controller;
import hospital.management_backend.model.UserAccount;
import hospital.management_backend.service.UserServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

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
        String email = request.get("email");
        String password = request.get("password");
        String message = service.deleteByEmail(email, password);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserAccount userAccount, HttpSession session) {
        Optional<UserAccount> userOptional = service.findByMail(userAccount.getEmail());
        if (userOptional.isPresent()) {
            UserAccount user = userOptional.get();
            if (service.authenticate(userAccount.getEmail(), userAccount.getPassword())) {
                //  Store user session
                session.setAttribute("user", user);
                return ResponseEntity.ok("Login successful");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); //  Destroy session
        return ResponseEntity.ok("Logged out successfully");
    }

    @GetMapping("/check-session")
    public ResponseEntity<Boolean> checkSession(HttpSession session) {
        return ResponseEntity.ok(session.getAttribute("user") != null);
    }
}
