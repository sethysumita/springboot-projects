package spring.websocket.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.websocket.api.entity.Notification;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Integer> {

}
