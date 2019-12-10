package view;
import controller.SeeCardsController;
import model.Card;
import model.Deck;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class SeeCards extends JPanel {

    public SeeCards(Frame frame) {
        GridLayout layout = new GridLayout(5, 5);
        layout.setHgap(30);
        layout.setVgap(30);
        setLayout(layout);

        ArrayList<Card> deck = Deck.getCards();

        for (Card card : deck) {
            oneCard c = new oneCard(card);
            c.addActionListener(new SeeCardsController(frame, card));
            add(c);
        }

        SeeCardsController seeCardsController = new SeeCardsController(frame);
        // Back to menu button
        JButton backBtn = new JButton("back");
        backBtn.setActionCommand("back");
        backBtn.addActionListener(seeCardsController);

        add(backBtn);

    }
}
