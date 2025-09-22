package com.example.notificationservice.dto;
import com.example.notificationservice.model.Channels;
import com.example.notificationservice.model.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {
    private String eventId;               // Unique identifier of the notification event
    private String userId;                // User associated with the notification
    private List<Channels> channels;        // Channels used (EMAIL, SMS, WHATSAPP)
    private NotificationStatus status;    // SUCCESS, FAILED, PARTIAL
    private String message;               // Human-readable response message
    private Map<String, String> metadata;

    public ResponseDto(String failed, String message) {
    }
}
