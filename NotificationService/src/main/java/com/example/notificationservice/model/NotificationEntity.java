package com.example.notificationservice.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "notification-entity",
        indexes = {
                @Index(name = "idx_event_id", columnList = "eventId")
        }
)
public class NotificationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length=50)
    @NotBlank(message = "User ID cannot be blank")
    @Size(max = 50, message = "User ID cannot have more than 50 characters")
    private String userId;
    @Column(nullable = false, length = 100)
    @NotBlank(message = " Event Id cannot be blank")
    @Size(max=100, message = "Event Id cannot have more than 100 characters")
    private String eventId;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "notification_channels", joinColumns = @JoinColumn(name = "notification_id"))
    @Column(name = "channel", length = 50)
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "channel name cannot be blank")
    @NotEmpty(message = "At least one channel must be specified")
    private List<String> channels;
    @NotBlank(message = "Subject cannot be blank")
    @Size(max=255, message ="subject cannot have more than 255 characters" )
    private String subject;
    @Column(nullable = false, length = 2000)
    @NotBlank(message = "message cannot be blank")
    @Size(max=2000, message = "message cannot have more than 2000 characters")
    private String message;
    @ElementCollection
    @CollectionTable(name = "notification_metadata", joinColumns = @JoinColumn(name = "notification_id"))
    @MapKeyColumn(name = "meta_key")
    @Column(name = "meta_value", length = 2000)
    private Map<String,String> metadata;
    @Enumerated(EnumType.STRING) // stores enum name in DB (e.g., "SUCCESS")
    @Column(nullable = false, length = 20)
    private NotificationStatus status;
    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
}


