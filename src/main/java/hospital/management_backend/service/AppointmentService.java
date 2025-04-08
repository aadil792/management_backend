package hospital.management_backend.service;

import hospital.management_backend.model.Appointment;
import hospital.management_backend.repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Appointment create (Appointment appointment);
    void deleteAppointmentById (Long id);
    List<Appointment> getAllList();

}
