package com.artem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artem.model.Doctor;
import com.artem.model.User;
import com.artem.service.UserDoctorService;

@RestController
@RequestMapping("v1/users")
public class UserDoctorController {
	
	@Autowired
	private UserDoctorService service;
	
	@GetMapping
	public ResponseEntity<List <User>> getAll(){
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<>(service.createUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") Integer Id) {
		return new ResponseEntity<>(service.getById(Id).get(),HttpStatus.OK);
	}
	
	@PostMapping("/{id}/doctors")
	public ResponseEntity<Doctor> createDoctor(@PathVariable("id") Integer idUser,@RequestBody Doctor doctor) {
		return new ResponseEntity<>(service.createDoctor(idUser, doctor),HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<User>update(@PathVariable("id") Integer id, @RequestBody User user) {
		return new ResponseEntity<>(service.update(id, user), HttpStatus.OK);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity <Void> delete(@PathVariable("id")Integer id){
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
	


