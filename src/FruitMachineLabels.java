//Nikolaos Alexiadis - 2491021A

import javax.swing.*;
import java.awt.*;

//This class handles the labels at the upper left part of the program
public class FruitMachineLabels extends JPanel {
    protected JLabel balanceLabel;
    protected JLabel resultLabel;
    protected JLabel endLabel;
    public FruitMachineModel modelObject;

    public FruitMachineLabels(FruitMachineModel model) {
        modelObject = model;

//        The balance label portrays the current balance. Uses the getBalance method from the model class
//        to retrieve the balance
        balanceLabel = new JLabel("balance is " + modelObject.getBalance());

//        The result label shows the result of each "spin". At the start of each game says "Welcome"
        resultLabel = new JLabel("Welcome!");

//        The end label shows whether the player has won or lost a game. Initially empty
        endLabel = new JLabel("");

//        Sets the layout to GridLayout and adds the labels to the JPanel
        this.setLayout(new GridLayout(3, 1));
        this.add(balanceLabel);
        this.add(resultLabel);
        this.add(endLabel);
    }
}