package hospital.management_backend.service;

import hospital.management_backend.model.Doctor;
import hospital.management_backend.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImp implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImp(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(Math.toIntExact(id));
        if (optionalDoctor.isPresent()) {
            Doctor existingDoctor = optionalDoctor.get();
            existingDoctor.setName(doctorDetails.getName());
            existingDoctor.setSpeciality(doctorDetails.getSpeciality());
            existingDoctor.setEmail(doctorDetails.getEmail());
            return doctorRepository.save(existingDoctor);
        } else {
            throw new RuntimeException("Doctor not found with ID: " + id);
        }
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public void saveDoctor(Doctor doctor) {

    }
}
