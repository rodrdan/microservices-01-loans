package cz.rodr.loans.service;

import cz.rodr.loans.dto.LoanDto;

public interface ILoanService {

    /**
     *
     * @param mobileNumber - Mobile number to register with loan
     */
    void createLoan(String mobileNumber);

    /**
     *
     * @param mobileNumber - Mobile number registered with loan
     * @return LoanDto object
     */
    LoanDto getLoanDetails(String mobileNumber);
}
