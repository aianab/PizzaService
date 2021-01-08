package whz.pti.praktikum_08.payment.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import whz.pti.praktikum_08.payment.common.BaseEntity;



@Entity
public class Account extends BaseEntity<Long> {

    private int balance;

    @JsonBackReference
    @OneToOne(mappedBy = "account")
    private PayUser payUser;

    public Account() {
        this.balance = 100;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public PayUser getPayUser() {
        return payUser;
    }

    public void setPayUser(PayUser payUser) {
        this.payUser = payUser;
    }

    public void depositBalance(int amount) {
        this.balance += amount;
    }

    public void withdrawBalance(int amount) {
        this.balance -= amount;
    }
}