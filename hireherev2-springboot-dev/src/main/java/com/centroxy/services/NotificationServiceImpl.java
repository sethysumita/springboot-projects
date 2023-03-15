package com.centroxy.services;

import org.springframework.stereotype.Service;

import com.centroxy.entities.Notification;
import com.centroxy.repositories.NotificationRepository;
@Service
public class NotificationServiceImpl implements INotificationService{
	NotificationRepository notificationRepository;
	
	
	public NotificationServiceImpl(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	@Override
	public Notification saveNotification(Notification notification) {
		Notification savedNotification = notificationRepository.save(notification);
		return savedNotification;
	}
	
}
