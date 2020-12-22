package pl.gregorymartin.post;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice(annotations = IllegalExceptionProcessing.class)
class IllegalExceptionsControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalStateException.class)
    ResponseEntity<String> handleIllegalArgument(IllegalStateException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<String> handleIllegalArgument(NoSuchElementException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    ResponseEntity<String> handleIllegalArgument(EmptyResultDataAccessException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
