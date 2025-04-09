package hospital.management_backend.repository;

import hospital.management_backend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    // get method
    // route: /getAppointments?choose_department=demo&choose_doctor=dr demo
    // const query = `select * from appointment where choose_department = ${req.params.choose_department} AND choose_doctor = ${req.params.choose_department}`
}
