package hospital.management_backend.service;

import hospital.management_backend.model.UserAppointment;
import hospital.management_backend.repository.UserAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImp implements PatientService {

    private final UserAppointmentRepository patientRepository;

    public PatientServiceImp(UserAppointmentRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public UserAppointment addPatient(UserAppointment patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<UserAppointment> getAllPatients() {
        return patientRepository.findAll();
    }


    @Override
    public UserAppointment getById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }

    @Override
    public UserAppointment updatePatient(Long id , UserAppointment patientDetails) {
        Optional<UserAppointment> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            UserAppointment existingPatient = optionalPatient.get();
            existingPatient.setFullName(patientDetails.getFullName());
            existingPatient.setDate(patientDetails.getDate());
            existingPatient.setTime(patientDetails.getTime());
            existingPatient.setDisease(patientDetails.getDisease());
            existingPatient.setDoctorName(patientDetails.getDoctorName());
            return patientRepository.save(existingPatient);
        } else {
            throw new RuntimeException("Patient not found with ID: " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public UserAppointment updatePrescription(Long id , String Prescription) {
        Optional<UserAppointment> optionalAppointment = patientRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            UserAppointment appointment = optionalAppointment.get();
            appointment.setPrescription(Prescription);
            return patientRepository.save(appointment);
        } else {
            throw new RuntimeException("Appointment prescription not found" + id);
        }
    }

    @Override
    public List<UserAppointment> getAllList() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<UserAppointment> getAppointmentById(Long id) {
        return patientRepository.findById(id);
    }


}
