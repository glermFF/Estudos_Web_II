package br.edu.ufop.web.Notifications.dtos;

import java.util.UUID;

import br.edu.ufop.web.Notifications.enums.EnumNotificationType;

public record CreateNotificationDTO(UUID userId, String service, EnumNotificationType notificationType, String subject, String content) {}
