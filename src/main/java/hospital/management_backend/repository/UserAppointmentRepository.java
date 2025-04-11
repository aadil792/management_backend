package hospital.management_backend.repository;

import hospital.management_backend.model.Appointment;
import hospital.management_backend.model.UserAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAppointmentRepository extends JpaRepository<UserAppointment, Long> {
    List<UserAppointment> findByAndSpecializationDoctor(String specializationDoctor);
    List<UserAppointment>findByFullName(String fullName);
}

