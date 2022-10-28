package br.com.LibraryAPI.exception;

import br.com.LibraryAPI.exception.Exceptions.*;
import br.com.LibraryAPI.exception.dto.apiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class LibraryExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({BookNotFoundException.class, AuthorNotFoundException.class, PublisherNotFoundException.class})
    public ResponseEntity<apiError> idNotFound(Exception exception) {

        apiError error = new apiError(exception.getMessage(), 404, LocalDateTime.now());
        return ResponseEntity.status(404).body(error);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({AuthorAlreadyExistsException.class, PublisherAlreadyExistsException.class, BookAlreadyExistsException.class})
    public ResponseEntity<apiError> AlreadyExistsException(Exception exception) {

        apiError error = new apiError(exception.getMessage(), 400, LocalDateTime.now());
        return ResponseEntity.status(400).body(error);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {

        apiError error = apiError.builder()
                .message("Os valores informados são invalídos")
                .timestamp(LocalDateTime.now())
                .status(status.value()).build();

        return ResponseEntity.status(status).body(error);
    }

}
