package hospital.management_backend.service;

import hospital.management_backend.model.Appointment;
import hospital.management_backend.model.Doctor;
import hospital.management_backend.repository.AppointmentRepository;
import hospital.management_backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImp implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Doctor addDoctor(Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
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
            existingDoctor.setDoctorName(doctorDetails.getDoctorName());
            existingDoctor.setSpecializationDoctor(doctorDetails.getSpecializationDoctor());
            existingDoctor.setPassword(doctorDetails.getPassword());
            existingDoctor.setAvailableFrom(doctorDetails.getAvailableFrom());
            existingDoctor.setAvailableTo(doctorDetails.getAvailableTo());
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
    public Optional<Doctor> findByEmailAndDoctorName(String email ,String doctorName) {
        return doctorRepository.findByEmailAndDoctorName(email,doctorName);
    }
    public  Boolean auth (String email ,String rawPassword ,String doctorName){
        Optional<Doctor> doctorOptional=doctorRepository.findByEmailAndDoctorName(email ,doctorName);
        if(doctorOptional.isPresent()){
            Doctor doctor= doctorOptional.get();
            return passwordEncoder.matches(rawPassword,doctor.getPassword());
        }
        return false;
    }

    public List<Appointment> getDoctorNameAndSpecializationDoctor(String doctorName, String specializationDoctor) {
        return  appointmentRepository.findByDoctorNameAndSpecializationDoctor(doctorName,specializationDoctor);

    }




}
