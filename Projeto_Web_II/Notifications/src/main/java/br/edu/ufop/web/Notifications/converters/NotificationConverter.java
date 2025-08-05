package br.edu.ufop.web.Notifications.converters;

import br.edu.ufop.web.Notifications.domains.NotificationsDomain;
import br.edu.ufop.web.Notifications.dtos.CreateNotificationDTO;
import br.edu.ufop.web.Notifications.dtos.NotificationDTO;
import br.edu.ufop.web.Notifications.models.NotificationModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NotificationConverter {
    // Domain to Model
    public static NotificationDTO toNotificationDTO(NotificationModel notificationModel){
        return new NotificationDTO(notificationModel.getId(), notificationModel.getUserId(), notificationModel.getService(), notificationModel.getNotificationType(), notificationModel.getSubject(), notificationModel.getContent(), notificationModel.getSentAt(), notificationModel.getReadAt());
    }

    // DTO to Domain
    public static NotificationModel toNotificationModel(NotificationsDomain notificationsDomain){
        return NotificationModel.builder().id(notificationsDomain.getId()).userId(notificationsDomain.getUserId()).service(notificationsDomain.getService()).notificationType(notificationsDomain.getNotificationType()).subject(notificationsDomain.getSubject()).content(notificationsDomain.getContent()).sentAt(notificationsDomain.getSentAt()).createdAt(notificationsDomain.getCreatedAt()).build();
    }

    // Create to Model
    public static NotificationModel toNotificationModel(CreateNotificationDTO createNotificationDTO){
        return NotificationModel.builder().userId(createNotificationDTO.userId()).service(createNotificationDTO.service()).notificationType(createNotificationDTO.notificationType()).subject(createNotificationDTO.subject()).content(createNotificationDTO.content()).build();
    }
}
