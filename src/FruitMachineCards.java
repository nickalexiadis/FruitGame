//Nikolaos Alexiadis - 2491021A

import javax.swing.*;
import java.awt.*;

//This class represents the cards of the program
public class FruitMachineCards extends JPanel {
    private JPanel firstCard;
    private JPanel secondCard;
    private JPanel thirdCard;
    protected JLabel firstLabel;
    protected JLabel secondLabel;
    protected JLabel thirdLabel;


    public FruitMachineCards() {
//        Creates a JPanel for each card
        firstCard = new JPanel();
        secondCard = new JPanel();
        thirdCard = new JPanel();

//        Sets the background color and borderline for each card
        firstCard.setBackground(Color.yellow);
        firstCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        secondCard.setBackground(Color.yellow);
        secondCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        thirdCard.setBackground(Color.yellow);
        thirdCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));

//        Creates the 3 initial card labels
        firstLabel = new JLabel("King");
        secondLabel = new JLabel("Queen");
        thirdLabel = new JLabel("Jack");

//        Adds the labels to each card
        firstCard.add(firstLabel);
        secondCard.add(secondLabel);
        thirdCard.add(thirdLabel);

//        Adds the card JPanels to the class object
        this.add(firstCard);
        this.add(secondCard);
        this.add(thirdCard);

//        Sets the layout to GridLayout
        this.setLayout(new GridLayout(1, 3, 20, 0));
    }
}
