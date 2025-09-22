package com.example.notificationservice.exception;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.stream.Collectors;
@RestControllerAdvice
public class GlobalExceptionHandler {
private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));
        logger.warn("Validation failed: {}", errors);
        return ApiResponse.failure(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        String errors = ex.getConstraintViolations()
                .stream()
                .map(cv -> cv.getPropertyPath() + ": " + cv.getMessage())
                .collect(Collectors.joining("; "));
        logger.warn("Constraint violation: {}", errors);
        return ApiResponse.failure(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<ApiResponse> handleNotificationException(NotificationException ex) {
        logger.error("NotificationException: {}", ex.getMessage());
        return ApiResponse.failure(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleAllOtherExceptions(Exception ex) {
        logger.error("Unhandled exception", ex);
        return ApiResponse.failure("An internal error occurred. Please contact support.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

