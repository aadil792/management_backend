package hospital.management_backend.service;

import hospital.management_backend.model.UserAccount;

import java.util.Optional;

public interface UserAccountService {

    UserAccount create (UserAccount userAccount);
    String deleteByEmail(String email ,String password);

    Optional<UserAccount> findByMail(String mail);

    public UserAccount updateByEmail(String mail , UserAccount updateUser);
}
