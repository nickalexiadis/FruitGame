//Nikolaos Alexiadis - 2491021A

import java.awt.event.*;

public class FruitMachineController implements ActionListener {
    private FruitMachineView viewObject;
    private FruitMachineModel modelObject;

    public FruitMachineController(FruitMachineModel model) {
        modelObject = model;
        viewObject = new FruitMachineView(model,this);
        viewObject.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
//        If the "spin" button is pressed, calls the spin method.
//        Else if the new game button is pressed, calls the reset method
        if (e.getSource() == viewObject.buttons.spinButton) {
            spin();
        } else if (e.getSource() == viewObject.buttons.newGameButton) {
            reset();
        }
    }

    private void spin() {
//        Creates an array and sets it to the value of calling the change method in the FruitMachineModel class
        String[] cards = modelObject.change();

//        Calls the updateCards method in the View class, passing in the array of cards from above as parameter
        viewObject.updateCards(cards);

//        Calls the jokerCheck function from the model class and saves the result(jokerCount) in a new variable
        int jokers = modelObject.jokerCheck();

//        If at least one joker exists in the cards calls the jokerUpdate method from View. If not, calls the
//        updateLabels method passing in the number of pairs, after they have been retrieved from the model object's
//        pairCheck method
        if (jokers > 0) {
            viewObject.jokerUpdate(jokers);
        } else {
            int pairs = modelObject.pairCheck();
            viewObject.updateLabels(pairs);
        }

//        If the player's balance is at least 150, calls the win method from view. If the balance is less than 0 calls
//        the lose method. In both cased the endGame method is called afterwards
        if (modelObject.getBalance() > 149) {
            viewObject.win();
            viewObject.endGame();
        } else if (modelObject.getBalance() < 0) {
            viewObject.lose();
            viewObject.endGame();
        }
    }

    private void reset() {
//        Uses the model object's setter method, to set the balance to the original 100 and then calls the resetGame
//        method from the view object
        modelObject.setBalance(100);
        viewObject.resetGame();
    }
}
