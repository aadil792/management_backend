package hospital.management_backend.service;

import hospital.management_backend.model.Appointment;
import hospital.management_backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImp implements AppointmentService{

    @Autowired private  AppointmentRepository appointmentRepository;

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
          appointmentRepository.delete(appointment);
    }

    @Override
    public Optional<Appointment> getAllList() {
        return Optional.empty();
    }


}
