package com.artem.service;

import java.util.List;
import java.util.Optional;

import com.artem.model.Doctor;
import com.artem.model.User;

public interface UserDoctorService {

	User createUser(User user);
	Doctor createDoctor(Integer idUser, Doctor doctor);
	List <User> getAll();
	Optional <User> getById(Integer id);
	User update(Integer id,User user);
	void delete(Integer id);
	
}
