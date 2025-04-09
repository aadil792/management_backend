package hospital.management_backend.service;

import hospital.management_backend.model.Appointment;
import hospital.management_backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImp implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }


    @Override
    public List<Appointment> getAllList() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment update(Long id , Appointment appointmentDetails) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            appointment.setTime(appointmentDetails.getTime());
            appointment.setDate(appointmentDetails.getDate());
            return appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Doctor not found with ID: " + id);
        }
    }

    @Override
    public Optional<Appointment> getById(Long id) {
        return appointmentRepository.findById(id);
    }


}
