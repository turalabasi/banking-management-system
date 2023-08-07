package model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Customer {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean status;
    private byte blockStatus;
    LocalDateTime registerDate;
    LocalDateTime updateDate;
    private Card card;

    public Customer(long id, String name, String surname, String email, String password, boolean status, byte blockStatus, LocalDateTime registerDate, LocalDateTime updateDate, Card card) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.status = status;
        this.blockStatus = blockStatus;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
        this.card = card;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public byte getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(byte blockStatus) {
        this.blockStatus = blockStatus;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", blockStatus='" + blockStatus + '\'' +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                ", card=" + card +
                '}';
    }
    public String getInfo() {
        return ", name ='" + name + '\'' +
                ", surname ='" + surname + '\'' +
                ", email ='" + email + '\'' +
                ", cardNumber ='" + card.getCardNumber() + '\'' +
                ", currentBalance ='" + card.currentBalance + '\'' +
                ", email ='" + email;
    }
}
