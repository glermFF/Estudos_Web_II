package br.edu.ufop.web.Notifications.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.Notifications.converters.NotificationConverter;
import br.edu.ufop.web.Notifications.domains.NotificationsDomain;
import br.edu.ufop.web.Notifications.dtos.CreateNotificationDTO;
import br.edu.ufop.web.Notifications.dtos.NotificationDTO;
import br.edu.ufop.web.Notifications.models.NotificationModel;
import br.edu.ufop.web.Notifications.repositories.INotificationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService {
    
    private final INotificationRepository notificationRepository;

    //GET
    public List<NotificationDTO> listAll(){
        List<NotificationModel> listNotification = notificationRepository.findAll();
        return listNotification.stream().map(NotificationConverter::toNotificationDTO).toList();
    }


    // CREATE
    public NotificationDTO create(CreateNotificationDTO createNotificationDTO){
        NotificationsDomain notificationsDomain = NotificationConverter.toNotificationDomain(createNotificationDTO);

        NotificationModel model = NotificationConverter.toNotificationModel(notificationsDomain);
        return NotificationConverter.toNotificationDTO(notificationRepository.save(model));
    }
}