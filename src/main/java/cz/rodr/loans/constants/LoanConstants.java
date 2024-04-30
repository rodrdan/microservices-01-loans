package cz.rodr.loans.constants;

import org.springframework.http.HttpStatus;

public class LoanConstants {
    private LoanConstants() {
        // restrict instantiation
    }
    public static final String HOME_LOAN = "Home Loan";

    public static Integer NEW_LOAN_LIMIT = 1_00_000;

    public static String STATUS_200 = "200";

    public static String MESSAGE_200 = "Loan successfully created";



}
