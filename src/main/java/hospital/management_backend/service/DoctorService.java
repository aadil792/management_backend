package hospital.management_backend.service;

import hospital.management_backend.model.Doctor;
import java.util.List;

public interface DoctorService
{
    Doctor addDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Long id, Doctor doctorDetails);

    void deleteDoctor(Long id);

    void saveDoctor(Doctor doctor);
}

