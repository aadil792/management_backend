package hospital.management_backend.service;

import hospital.management_backend.model.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorService
{
    Doctor addDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Long id, Doctor doctorDetails);

    void deleteDoctor(Long id);

    Optional<Doctor> findByEmailAndName (String email ,String name);

//    void saveDoctor(Doctor doctor);
}

