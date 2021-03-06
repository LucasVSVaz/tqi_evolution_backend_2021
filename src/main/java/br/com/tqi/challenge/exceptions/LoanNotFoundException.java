package br.com.tqi.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoanNotFoundException extends Exception{

    public LoanNotFoundException(Long id) {
        super("Loan not found with ID " + id);
    }
}
