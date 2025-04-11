package hospital.management_backend.service;

import hospital.management_backend.model.Appointment;
import jdk.jfr.Description;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Appointment create (Appointment appointment);
    void deleteAppointmentById (Long id);
    List<Appointment> getAllList();
    Appointment update (Long id ,Appointment appointmentDetails);
    Optional<Appointment> getById (Long id);
    Appointment updatePrescription ( Long id, String Prescription);

}
