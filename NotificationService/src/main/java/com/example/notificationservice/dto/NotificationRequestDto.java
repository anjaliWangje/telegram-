package com.example.notificationservice.dto;
import com.example.notificationservice.model.Channels;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
public class NotificationRequestDto {
    @NotBlank(message = "User ID cannot be blank")
    @Size(max = 50, message = "User ID cannot have more than 50 characters")
    private String userId;
    @NotBlank(message = "Event ID cannot be blank")
    @Size(max = 100, message = "Event ID cannot have more than 100 characters")
    private String eventId;
    @NotEmpty(message = "At least one channel must be specified")
    private List<Channels> channels;
    @NotBlank(message = "Subject cannot be blank")
    @Size(max = 255, message = "Subject cannot have more than 255 characters")
    private String subject;
    @NotBlank(message = "Message cannot be blank")
    @Size(max = 2000, message = "Message cannot have more than 2000 characters")
    private String message;
    private Map<String, String> metadata;
}
