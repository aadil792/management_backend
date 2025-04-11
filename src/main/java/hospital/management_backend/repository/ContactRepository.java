package hospital.management_backend.repository;

import hospital.management_backend.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact ,Long> {
}
