package hospital.management_backend.service;

import hospital.management_backend.model.UserAccount;
import hospital.management_backend.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserAccountService {

    @Autowired
    UserAccountRepository repo;

    @Override
    public UserAccount create(UserAccount userAccount) {
        return repo.save(userAccount);
    }

    @Override
    public String deleteByEmail(String email ,String password) {
        Optional<UserAccount> user = repo.findByEmailAndPassword(email ,password);
        if (user.isPresent()) {
            repo.delete(user.get());
            return "user is deleted";
        } else {
            throw new RuntimeException("user is not found");
        }

    }
}
