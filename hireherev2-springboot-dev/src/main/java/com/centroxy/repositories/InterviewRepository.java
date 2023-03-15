package com.centroxy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroxy.entities.Interview;

/**
 * @author Jogesh Krupa Dash 06-Jul-2022 7:27:51 pm
 */
public interface InterviewRepository extends JpaRepository<Interview, String> {
	//@Query(value = "select * from Book b where b.name=?1", nativeQuery = true)
	@Query(value = "SELECT * FROM interview WHERE panel_id = ?1", nativeQuery = true)
	public List<Interview>findByPanelId(String panelId);
}
