package hospital.management_backend.service;

import hospital.management_backend.model.Appointment;
import hospital.management_backend.model.UserAppointment;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    UserAppointment addPatient(UserAppointment patient);
    List<UserAppointment> getAllPatients();
    UserAppointment getById(Long id);
    UserAppointment updatePatient(Long id, UserAppointment patientDetails);
    void deleteById(Long id);
    UserAppointment updatePrescription ( Long id, String Prescription);
    List<UserAppointment> getAllList();
    Optional<UserAppointment> getAppointmentById(Long id);
}

