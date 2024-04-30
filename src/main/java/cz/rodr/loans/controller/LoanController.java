package cz.rodr.loans.controller;

import cz.rodr.loans.constants.LoanConstants;
import cz.rodr.loans.dto.LoanDto;
import cz.rodr.loans.dto.ResponseDto;
import cz.rodr.loans.service.ILoanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class LoanController {

    private ILoanService loanService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(
            @Valid
            @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits.")
            String mobileNumber) {
        loanService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoanConstants.STATUS_200,LoanConstants.MESSAGE_200));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> getLoanDetails(
            @Valid
            @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits.")
            String mobileNumber) {
        LoanDto loanDto = loanService.getLoanDetails(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanDto);
    }

}
