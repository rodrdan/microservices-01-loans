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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class LoanController {

    private ILoanService loanService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(
            @Valid
            @RequestParam
            @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits.")
            String mobileNumber) {
        loanService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoanConstants.STATUS_201,LoanConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> getLoanDetails(
            @Valid
            @RequestParam
            @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits.")
            String mobileNumber) {
        LoanDto loanDto = loanService.getLoanDetails(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoan(@Valid @RequestBody LoanDto loanDto) {
        boolean isUpdated = loanService.updateLoan(loanDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoan(
            @Valid
            @RequestParam
            @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits.")
            String mobileNumber) {
        boolean isDeleted = loanService.deleteLoan(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_DELETE));
        }
    }


}
