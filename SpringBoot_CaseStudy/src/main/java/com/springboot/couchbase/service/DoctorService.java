package com.springboot.couchbase.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.couchbase.entity.Doctor;
import com.springboot.couchbase.exception.EntityNotFound;
import com.springboot.couchbase.repository.DoctorRepository;

//spring annotation
@Service
public class DoctorService {

    @Autowired
    DoctorRepository repository;

    //save new doctor in the couchbase
    public void save(final Doctor e) {
        repository.save(e);
    }

    //get total count in the couchbase
    public long count() {
        return repository.count();
    }

    //get all doctors from the couchbase
    public List<Doctor> getDoctors() {
        final Iterable<Doctor> doctorIterable = repository.findAll();
        return StreamSupport.stream(doctorIterable.spliterator(), false).collect(Collectors.toList());
    }

    //get doctor by id from the couchbase
    public Doctor getDoctor(final String docid) throws EntityNotFound {
        return repository.findById(docid).orElseThrow(EntityNotFound::new);
    }

  //insert doctor by id from the couchbase
    public Doctor insertDoctor(final Doctor doctor) throws EntityNotFound {
        return repository.save(doctor);
    }
    
  //update doctor by id from the couchbase
    public Doctor updateDoctor(final Doctor doctor) throws EntityNotFound {
        return repository.save(doctor);
    }
    
  //delete doctor by id from the couchbase
    public void deleteDoctor(final String docid) throws EntityNotFound{
        repository.deleteById(docid);
    }
    //get doctors by department from the couchbase
    public List<Doctor> getDoctorsByWorkDepartment(final String workDepartment) {
        return repository.findAllByWorkDepartment(workDepartment);
    }
}
