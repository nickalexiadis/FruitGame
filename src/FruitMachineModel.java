//Nikolaos Alexiadis - 2491021A

import java.util.Random;

public class FruitMachineModel {
    private int balance;
    private String[] cardArray;

    public FruitMachineModel() {
        this.balance = 100;
    }

    public int getBalance() {
//        getter for the balance variable
        return balance;
    }

    public void setBalance(int value) {
//        setter for the balance variable
        balance = value;
    }

    public String[] change() {
//        This method creates an array to represent the 3 cards of the program and randomly assigns
//        one of five values to each index. It returns the new random array of cards.
        cardArray = new String[3];
        Random rand = new Random();
        int num;

        for(int i = 0; i < cardArray.length; i++) {
            num = rand.nextInt(5);
            if (num == 0) cardArray[i] = "Ace";
            else if (num == 1) cardArray[i] = "King";
            else if (num == 2) cardArray[i] = "Queen";
            else if (num == 3) cardArray[i] = "Jack";
            else if (num == 4) cardArray[i] = "Joker";
        }
        return cardArray;
    }

    public int jokerCheck() {
//        Loops over the cardArray, counting the number of "Joker" cards. Decreases the balance by 25 points
//        for each Joker in the array. Finally, returns the number of Joker cards.
        int jokerCount = 0;
        for (int i = 0; i < cardArray.length; i++) {
            if (cardArray[i] == "Joker") jokerCount++;
        }
        if (jokerCount > 0) {
            for (int i = 0; i < jokerCount; i++) {
                balance -= 25;
            }
        }
        return jokerCount;
    }

    public int pairCheck() {
//        Checks the card array for pairs of cards. If there are two pairs (three of a kind) increments balance
//        by 50. If there is one pair, increments balance by 20. Finally returns the number of pairs.
        int pairs = 0;
        for (int i = 1; i < cardArray.length ; i++) {
            if (cardArray[i] == cardArray[i-1]) pairs++;
        }
        if (pairs == 2) balance += 50;
        else if (pairs == 1) balance += 20;

        return pairs;
    }
}
