//Nikolaos Alexiadis - 2491021A

import javax.swing.*;
import java.awt.*;

public class FruitMachineView extends JFrame {
    private FruitMachineController controllerObject;
    private FruitMachineModel modelObject;
    private FruitMachineLabels labels;
    private FruitMachineCards cards;
    protected FruitMachineButtons buttons;

    public FruitMachineView(FruitMachineModel model, FruitMachineController controller) {
        controllerObject = controller;
        modelObject = model;

//        Sets ups the JFrame GUI and calls the layoutComponents method
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocation(500, 200);
        setTitle("Fruitmachine GUI");
        this.setLayout(new GridLayout(2, 2, 20, 20));
        layoutComponents();
    }

    private void layoutComponents() {
//        Creates variables set to instances of the labels, cards and buttons objects
        labels = new FruitMachineLabels(modelObject);
        cards = new FruitMachineCards();
        buttons = new FruitMachineButtons(controllerObject);

//        Adds the above JPanels (and an empty one) to the JFrame
        this.add(labels);
        this.add(new JPanel());
        this.add(cards);
        this.add(buttons);
    }

    public void updateCards(String[] cardArray) {
//        Changes the card labels to correspond to the ones generated by the change method in the modelObject
//        The parameter(cardArray) contains three Strings, representing a card name for each card
        cards.firstLabel.setText(cardArray[0]);
        cards.secondLabel.setText(cardArray[1]);
        cards.thirdLabel.setText(cardArray[2]);
}

    public void jokerUpdate(int jokerCount) {
//        If at least one joker exists in the new cards, changes the balanceLabel to accurately represent the new one
//        Also changes the resultLabel text based on the number of Jokers
        labels.balanceLabel.setText("balance is " + modelObject.getBalance());
        if(jokerCount > 1) labels.resultLabel.setText(jokerCount + " jokers: you lose " + (jokerCount * 25) + " points");
        else labels.resultLabel.setText(jokerCount + " joker: you lose 25 points");
    }

    public void updateLabels(int pairs) {
//        Changes the balanceLabel to reflect the new one after spinning. Also alters the resultLabel text based on the
//        number of pairs
        labels.balanceLabel.setText("balance is " + modelObject.getBalance());
        if (pairs == 2) labels.resultLabel.setText("Three of a kind - you win 50 points");
        else if (pairs == 1) labels.resultLabel.setText("Two of a kind - you win 20 points");
        else labels.resultLabel.setText("Balance unchanged");
    }

    public void win() {
//        Displays "you win!" if the player has won the game
        labels.endLabel.setText("You win!");
    }

    public void lose() {
//        Displays "you lose" if the player lost the game
        labels.endLabel.setText("You lose");
    }

    public void endGame() {
//        Disables the spin button and enables the new game button once the game is over
        buttons.spinButton.setEnabled(false);
        buttons.newGameButton.setEnabled(true);
    }

    public void resetGame() {
//        Restores all labels, cards and buttons to their original state
        labels.balanceLabel.setText("balance is " + modelObject.getBalance());
        labels.resultLabel.setText("Welcome!");
        labels.endLabel.setText("");

        cards.firstLabel.setText("King");
        cards.secondLabel.setText("Queen");
        cards.thirdLabel.setText("Jack");

        buttons.spinButton.setEnabled(true);
        buttons.newGameButton.setEnabled(false);
    }

}