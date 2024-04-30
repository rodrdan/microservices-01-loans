package cz.rodr.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NonNull;

@Data
public class LoanDto {

    @NotEmpty(message = "Mobile number can not be null or empty.")
    @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits.")
    private String mobileNumber;

    @NotEmpty(message = "Loan number can not be null or empty.")
    @Pattern(regexp = "(^$|\\d{12})", message = "Loan number must be 12 digits.")
    private String loanNumber;

    @NotEmpty(message = "Loan type can not be null or empty.")
    private String loanType;

    @Positive(message = "Total loan must be greater than zero.")
    private Integer totalLoan;

    @PositiveOrZero(message = "Amount paid must be zero or more.")
    private Integer amountPaid;

    @PositiveOrZero(message = "Outstanding amount must be zero or more.")
    private Integer outstandingAmount;


}