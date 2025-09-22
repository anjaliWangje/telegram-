package com.example.notificationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification_log", indexes = {
        @Index(name = "idx_event_id", columnList = "eventId")
})
public class NotificationLog {


}
