package com.artem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artem.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}
