package com.artem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artem.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

}
