//Nikolaos Alexiadis - 2491021A

import javax.swing.*;
import java.awt.*;

//This class creates the buttons of the program
public class FruitMachineButtons extends JPanel {
    protected JButton spinButton;
    protected JButton newGameButton;
    private FruitMachineController controllerObject;

    public FruitMachineButtons(FruitMachineController controller) {
        controllerObject = controller;

//        Creates the spin and newGame buttons
        spinButton = new JButton("spin");
        newGameButton = new JButton("new game");

//        Adds action listeners to the two buttons
        spinButton.addActionListener(controllerObject);
        newGameButton.addActionListener(controllerObject);

//        Sets the newGame button to be disabled at the start of the game
        newGameButton.setEnabled(false);

//        Adds the buttons to the JPanel and sets the layout
        this.add(spinButton);
        this.add(newGameButton);
        this.setLayout(new GridLayout(2, 1));
    }
}
