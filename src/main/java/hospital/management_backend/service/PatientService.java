package hospital.management_backend.service;

import hospital.management_backend.model.Patient;
import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient updatePatient(Long id, Patient patientDetails);
    void deletePatient(Long id);
}

