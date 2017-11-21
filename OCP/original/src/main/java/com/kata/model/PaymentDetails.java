package com.kata.model;

public class PaymentDetails {

    private String creditCardNumber;
    private String expiresMonth;
    private String expiresYear;
    private String cardHolderName;
    private PaymentMethod paymentMethod;

    public PaymentDetails(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
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

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public static enum PaymentMethod {
        CreditCard,
        Cash
    }
}
