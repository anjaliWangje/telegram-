package com.example.notificationservice.consumer;
import com.example.notificationservice.dto.NotificationRequestDto;
import com.example.notificationservice.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class KafkaListener {
//    @Autowired
//    private NotificationService notificationService;
//
//    @Autowired
//    private ObjectMapper objectMapper;

//    @KafkaListener(topics = {KafkaTopics.BOOKING_CREATED, KafkaTopics.PAYMENT_COMPLETED}, groupId = "notification-service-group")
//    public void listen(String message) {
//        try {
//            NotificationRequestDto dto = objectMapper.readValue(message, NotificationRequestDto.class);
//            log.info("Received event for processing: eventId={}, userId={}", dto.getEventId(), dto.getUserId());
//            notificationService.sendNotification(dto);
//        } catch (Exception e) {
//            log.error("Failed to process Kafka message: {}", message, e);
//            // Optionally handle dead-letter queue or retries here
//        }
    }

