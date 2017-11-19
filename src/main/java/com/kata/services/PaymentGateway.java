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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiresMonth() {
        return expiresMonth;
    }

    public void setExpiresMonth(String expiresMonth) {
        this.expiresMonth = expiresMonth;
    }

    public String getExpiresYear() {
        return expiresYear;
    }

    public void setExpiresYear(String expiresYear) {
        this.expiresYear = expiresYear;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public double getAmountToCharge() {
        return amountToCharge;
    }

    public void setAmountToCharge(double amountToCharge) {
        this.amountToCharge = amountToCharge;
    }

    public class AvsMismatchException extends Exception {

    }
}
