package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

public class SeeCardsController implements ActionListener {

    private Frame frame;
    private Card card;

    public SeeCardsController(Frame frame, Card card) {
        this.frame = frame;
        this.card = card;
    }

    public SeeCardsController(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        // Back to menu
        if ("back".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new Menu(frame));
            frame.revalidate();
        } else {
            frame.getContentPane().removeAll();
            frame.setContentPane(new EditCard(frame,(Pokemon) card));
            frame.revalidate();
        }
    }
}
