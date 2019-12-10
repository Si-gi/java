package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Card;
import model.Deck;
import view.*;

public class ListenerController implements ActionListener {

    private Frame frame;

    public ListenerController(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if ("show".equals(actionCommand)) {
            Deck.saveDeck();
            System.exit(0);
        } else if ("create".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new AddCard(frame));
            frame.revalidate();
        } else if ("show".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new SeeCards(frame));
            frame.revalidate();
        }
    }
}