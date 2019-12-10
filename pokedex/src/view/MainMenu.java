package view;

import javax.swing.*;

import javax.swing.JFrame;
import java.awt.*;
import model.*;
import controller.*;

public class MainMenu extends JFrame {

    private Home home;
    private Image img;
    private JButton seeCardsBtn;
    private JButton createBtn;
    public MainMenu(Frame frame) {
        seeCardsBtn = new JButton("See my cards");
        createBtn = new JButton("Add a card");
        ListenerController listener = new ListenerController(frame);
        seeCardsBtn.addActionListener(listener);
        createBtn.addActionListener(listener);

        createBtn.setActionCommand("create");
        seeCardsBtn.setActionCommand("show");
        add(seeCardsBtn);
        add(createBtn);
    }


}