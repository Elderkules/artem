package com.artem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artem.dao.DoctorRepository;
import com.artem.dao.UserRepository;
import com.artem.model.Doctor;
import com.artem.model.User;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserDoctorServiceImpl implements UserDoctorService{

	@Autowired
	private UserRepository repository;
	private DoctorRepository dRepository;
	
	@Override
	public User createUser(User user) {
		String password = user.getPassword();
		String hashPass = BCrypt.withDefaults().hashToString(12, password.toCharArray());
		user.setPassword(hashPass);
		return repository.save(user);
	}
	
	@Override
	public Doctor createDoctor(Integer idUser, Doctor doctor) {
		doctor.setIdUser(idUser);
		return dRepository.save(doctor);
	}
	
	
	@Override
	public List<User> getAll() {
		
		return repository.findAll();
	}
	
	@Override
	public Optional <User> getById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public User update(Integer id, User user) {
		User userDB = getById(id).get();
		userDB.setName(user.getName());
		userDB.setLastName(user.getLastName());
		return repository.save(userDB);
	}
	
	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}
}
