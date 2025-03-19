package hospital.management_backend.service;

import hospital.management_backend.model.UserAccount;

public interface UserAccountService {

    UserAccount create (UserAccount userAccount);
    String deleteByEmail(String email ,String password);
}
