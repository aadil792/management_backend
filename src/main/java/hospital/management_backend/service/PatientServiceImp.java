package hospital.management_backend.service;

import hospital.management_backend.model.Patient;
import hospital.management_backend.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImp implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImp(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }

    @Override
    public Patient updatePatient(Long id, Patient patientDetails) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            existingPatient.setName(patientDetails.getName());
            existingPatient.setAge(patientDetails.getAge());
            existingPatient.setDisease(patientDetails.getDisease());
            return patientRepository.save(existingPatient);
        } else {
            throw new RuntimeException("Patient not found with ID: " + id);
        }
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
