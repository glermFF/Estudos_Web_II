package br.edu.ufop.web.Notifications.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufop.web.Notifications.dtos.CreateNotificationDTO;
import br.edu.ufop.web.Notifications.dtos.NotificationDTO;
import br.edu.ufop.web.Notifications.services.NotificationService;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {
    
    private final NotificationService notificationService;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Notification service is running");
    }

    @GetMapping("/notifications-list")
    public ResponseEntity<List<NotificationDTO>> listAll(){
        List<NotificationDTO> notificationList = notificationService.listAll();

        return ResponseEntity.ok(notificationList);
    }

    @PostMapping
    public ResponseEntity<NotificationDTO> create(@RequestBody CreateNotificationDTO createNotificationDTO){
        NotificationDTO dto = notificationService.create(createNotificationDTO);

        return ResponseEntity.ok(dto);
    }
}
