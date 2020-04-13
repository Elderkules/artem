package com.artem.service;

import java.util.List;
import java.util.Optional;

import com.artem.model.Patient;
import com.artem.model.User;

public interface UserPatientService {

	User createUser(User user);
	Patient createPatient(Integer idUser, Patient patient);
	List <User> getAll();
	Optional<User> getById(Integer id);
	User update(Integer id, User user);
	void delete(Integer id);
}
