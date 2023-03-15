package com.centroxy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.centroxy.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>{
	

}
