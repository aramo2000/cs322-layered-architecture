package am.cs322.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "\"BankAccount\"")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Bank(){

    }

    public Bank(User user, double balance){
        this.user = user;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bankAccount = (Bank) o;
        return balance==bankAccount.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    public double getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
