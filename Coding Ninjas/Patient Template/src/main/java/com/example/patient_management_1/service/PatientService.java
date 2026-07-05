package com.example.patient_management_1.service;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.AddressRepository;
import com.example.patient_management_1.repository.DoctorRepository;
import com.example.patient_management_1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PatientService {
    
    @Autowired
    PatientRepository patientRepository;
    
    @Autowired
    DoctorRepository doctorRepository;
    
    @Autowired
    AddressRepository addressRepository;
    

    public Patient getPatient(Long id) {
        return patientRepository.findById(id).get();
    }
    
    
    public Patient createPatient(@RequestBody Patient patient) {
    	
    	Doctor doctor = null;
    	Address address = null;
    	
    	if(patient.getDoctor() != null) {
    		doctor= doctorRepository.save(patient.getDoctor());
    	}
    	
    	if(patient.getAddress() != null) {
    		address = addressRepository.save(patient.getAddress());
    	}
    	
    	patient.setDoctor(doctor);
    	patient.setAddress(address);
    	
        patientRepository.save(patient);
        
        return patient;
    }

    public Patient updatePatient(@RequestBody Patient patient) {
    	Doctor doctor = null;
    	Address address = null;
    	if(patient.getDoctor() != null) {
    		doctor= doctorRepository.save(patient.getDoctor());
    	}
    	
    	if(patient.getAddress() != null) {
    		address = addressRepository.save(patient.getAddress());
    	}
    	
    	patient.setDoctor(doctor);
    	patient.setAddress(address);
    	
        patientRepository.save(patient);
        return patient;
    }

    public void deletePatient(@PathVariable Long id) {
       patientRepository.deleteById(id);
    }
}
