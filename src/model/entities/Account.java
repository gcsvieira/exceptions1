package model.entities;

import model.exceptions.WithdrawalException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double witgdrawLimit;

    public Account(Integer number, String holder, Double balance, Double witgdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.witgdrawLimit = witgdrawLimit;
    }

    public Account(Integer number, String holder, Double witgdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = 0.0;
        this.witgdrawLimit = witgdrawLimit;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return this.holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return this.balance;
    }

    public Double getWitgdrawLimit() {
        return this.witgdrawLimit;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withdraw(Double amount) throws WithdrawalException {
        if (balance == 0.0)
            throw new WithdrawalException("Não há saldo disponível para saque.");

        if (amount > this.witgdrawLimit)
            throw new WithdrawalException("Valor do saque é superior ao limite permitido.");

        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "{" +
                " number='" + getNumber() + "'" +
                ", holder='" + getHolder() + "'" +
                ", balance='" + getBalance() + "'" +
                ", witgdrawLimit='" + getWitgdrawLimit() + "'" +
                "}";
    }

}
