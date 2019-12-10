package view;

import model.Card;

import javax.swing.*;
import java.awt.*;

public class oneCard  extends JButton {

    public oneCard(Card card) {
        super(card.getName());
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2,true));
        setOpaque(true);
    }
}