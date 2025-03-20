package hospital.management_backend.service;

import hospital.management_backend.model.UserAccount;
import hospital.management_backend.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserAccountService {

    @Autowired
    private UserAccountRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserAccount create(UserAccount userAccount) {
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword())); // Encrypt password
        return repo.save(userAccount);
    }

    @Override
    public String deleteByEmail(String email, String rawPassword) {
        Optional<UserAccount> userOptional = repo.findByEmail(email);

        if (userOptional.isPresent()) {
            UserAccount user = userOptional.get();

            if (passwordEncoder.matches(rawPassword, user.getPassword())) {
                repo.delete(user);
                return "User deleted successfully";
            } else {
                throw new RuntimeException("Incorrect password");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public Optional<UserAccount> findByMail(String mail) {
        return repo.findByEmail(mail);
    }

    @Override
    public UserAccount updateByEmail(String mail, UserAccount updateUser) {
        Optional<UserAccount> existingUser = repo.findByEmail(mail);

        if (existingUser.isPresent()) {
            UserAccount user = existingUser.get();

            if (updateUser.getPassword() != null && !updateUser.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(updateUser.getPassword()));
            }

            return repo.save(user);
        } else {
            throw new RuntimeException("Email not found: " + mail);
        }
    }

    public boolean authenticate(String mail, String rawPassword) {
        Optional<UserAccount> userOptional = repo.findByEmail(mail);

        if (userOptional.isPresent()) {
            UserAccount user = userOptional.get();
            return passwordEncoder.matches(rawPassword, user.getPassword());
        }

        return false;
    }
}
