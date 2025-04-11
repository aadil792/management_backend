package hospital.management_backend.repository;

import hospital.management_backend.model.Appointment;
import hospital.management_backend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByDoctorNameAndSpecializationDoctor(String doctorName, String specializationDoctor);
}
