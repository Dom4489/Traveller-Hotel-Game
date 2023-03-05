package model;

// this class represents the user's virtual wallet
public class Wallet {

    private int amount;


    // MODIFIES: this
    // EFFECTS: creates a wallet with initial amount
    public Wallet(int initialAmount) {
        this.amount =  initialAmount;
    }

    // EFFECTS: gets the current amount of funds in wallet
    public int getAmount() {
        return amount;
    }

    // REQUIRES: add must be a non-negative integer
    // MODIFIES: this
    // EFFECTS: adds the specified amount to the funds in the wallet
    public void addAmount(int add) {
        amount += add;
    }

    // REQUIRES: sub must be a non-negative integer
    // MODIFIES: this
    // EFFECTS: subtracts the specified amount from the funds in the wallet,
    // if the sub amount is greater than the amount of funds in wallet, funds in wallet become 0
    public void subAmount(int sub) {
        if (sub > amount) {
            amount = 0;
        } else  {
            amount -= sub;
        }
    }
}
