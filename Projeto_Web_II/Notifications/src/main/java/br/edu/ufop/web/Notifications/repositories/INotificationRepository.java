package br.edu.ufop.web.Notifications.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufop.web.Notifications.models.NotificationModel;

public interface INotificationRepository extends JpaRepository<NotificationModel, UUID>{
    
    List<NotificationModel> findAllByuserId(UUID userId);
    
}
