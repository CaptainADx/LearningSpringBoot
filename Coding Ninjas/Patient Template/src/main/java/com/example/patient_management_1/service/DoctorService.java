package com.example.patient_management_1.service;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.DoctorRepository;
import com.example.patient_management_1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.List;
//import java.util.Optional;

@Service
public class DoctorService {
    
    @Autowired
    DoctorRepository doctorRepository;
    
    @Autowired
    PatientRepository patientRepository;

    
    public Doctor getDoctor(Long id) {
    	return doctorRepository.findById(id).get();
    }

    public Doctor createDoctor(Long patientId,Doctor doctor) {
    	Patient patient = patientRepository.findById(patientId).get();
    	
    	patient.setDoctor(doctor);
    	
    	doctorRepository.save(doctor);
    	
    	patientRepository.save(patient);
    	
    	
    	return doctor;
    }

    public Doctor updateDoctor(Doctor doctor) {
    	doctorRepository.save(doctor);
    	
    	return doctor;
    }

    public void deleteDoctor(Long id) {

    // You need to use the similar approach as used for deleting address.
    	
    	for(Patient p : patientRepository.findAll()) {
    		if(p.getDoctor() != null && p.getDoctor().getId().equals(id)) {
    			p.setDoctor(null);
    			patientRepository.save(p);
    			doctorRepository.deleteById(id);
    		}
    	}

    }

}
