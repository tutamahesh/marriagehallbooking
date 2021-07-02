package com.hallbooking.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hallbooking.admin.model.Hall;
import com.hallbooking.admin.model.Supervisor;

@Repository("sdao")
public interface SupervisorDao extends JpaRepository<Supervisor,String> {
	
	
	List<Supervisor> findSupervisorByLocation(String location);

	Supervisor save(Hall h);
}
