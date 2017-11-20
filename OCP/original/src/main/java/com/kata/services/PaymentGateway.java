package com.kata.services;

public class PaymentGateway {

    private String cardNumber;
    private String credentials;
    private String expiresMonth;
    private String expiresYear;
    private String nameOnCard;
    private double amountToCharge;

    public void charge() throws AvsMismatchException {
        //throw new AvsMismatchException();
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpiresMonth(String expiresMonth) {
        this.expiresMonth = expiresMonth;
    }

    public void setExpiresYear(String expiresYear) {
        this.expiresYear = expiresYear;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public void setAmountToCharge(double amountToCharge) {
        this.amountToCharge = amountToCharge;
    }

    public class AvsMismatchException extends Exception {

    }
}
