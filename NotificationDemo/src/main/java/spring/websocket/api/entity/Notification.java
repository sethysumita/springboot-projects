package spring.websocket.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int notificationId;
	private String message;

}
