package pl.fitfinder.microservices.fitfinder.gymService.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class GymNotFound extends RuntimeException{
    public GymNotFound(String message) {
        super(message);
    }
}
