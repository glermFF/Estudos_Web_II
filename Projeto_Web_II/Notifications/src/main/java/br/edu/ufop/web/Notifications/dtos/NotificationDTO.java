package br.edu.ufop.web.Notifications.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.edu.ufop.web.Notifications.enums.EnumNotificationType;

public record NotificationDTO(UUID id, UUID userId, String service, EnumNotificationType notificationType, String subject, String sontent, LocalDateTime sentAt, LocalDateTime readAt) {}
