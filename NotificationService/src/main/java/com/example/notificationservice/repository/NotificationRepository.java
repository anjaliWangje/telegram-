package com.example.notificationservice.repository;
import com.example.notificationservice.model.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity,Integer> {
    NotificationEntity findByEventId(String eventId);
}
