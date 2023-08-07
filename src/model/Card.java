package model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Card {
  private long id;
    private String cardNumber;
    double currentBalance;
    LocalDateTime updateDate;

  public Card(long id, String cardNumber, double currentBalance, LocalDateTime updateDate) {
    this.id = id;
    this.cardNumber = cardNumber;
    this.currentBalance = currentBalance;
    this.updateDate = updateDate;
  }

  public Card() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public double getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(double currentBalance) {
    this.currentBalance = currentBalance;
  }

  public LocalDateTime getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(LocalTime updateDate) {
    this.updateDate = LocalDateTime.from(updateDate);
  }
}
