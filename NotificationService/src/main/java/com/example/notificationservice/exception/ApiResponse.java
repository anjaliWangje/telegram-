package com.example.notificationservice.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
    public static ResponseEntity<ApiResponse> success(String message) {
        return ResponseEntity.ok(new ApiResponse(message, true, HttpStatus.OK));
    }
    public static ResponseEntity<ApiResponse> failure(String message, HttpStatus status) {
        return new ResponseEntity<>(new ApiResponse(message, false, status), status);
    }
}
