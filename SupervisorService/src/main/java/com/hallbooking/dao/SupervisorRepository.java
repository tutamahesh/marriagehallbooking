package com.hallbooking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hallbooking.model.Hall;


@Repository("supervisorRepository")
public interface SupervisorRepository extends JpaRepository<Hall,String> {
		List<Hall> findByLocation(String location);
}
