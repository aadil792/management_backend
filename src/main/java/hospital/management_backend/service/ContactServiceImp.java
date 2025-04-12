package hospital.management_backend.service;

import hospital.management_backend.model.Contact;
import hospital.management_backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImp implements ContactService{
    @Autowired
    ContactRepository contactRepository;
    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getList() {
        return contactRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }


}
