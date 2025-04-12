package hospital.management_backend.service;

import hospital.management_backend.model.Contact;

import java.util.List;

public interface ContactService {

    Contact create (Contact contact);
    List<Contact> getList();
    void  deleteById (Long id);

}
