package com.example.notificationservice.service;
import com.example.notificationservice.dto.NotificationRequestDto;
public interface NotificationService{
    void sendNotification(NotificationRequestDto dto);
    void sendOtp(String phoneNumber, String otpMessage);
    void sendSmsNotification(NotificationRequestDto dto);
    void sendWhatsAppNotification(NotificationRequestDto dto);
    void sendEmailNotification(NotificationRequestDto dto);
    void sendAllNotifications(NotificationRequestDto dto);
}
