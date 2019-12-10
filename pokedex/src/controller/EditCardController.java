package controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.*;
import view.*;

import javax.swing.*;

public class EditCardController implements ActionListener{
    private MainMenu menu;
    private Card card;
    private Frame frame;
    private EditCard editCard;
    private AddCard addCard;


    public EditCardController(Frame frame, Card card, EditCard editCard) {

        this.frame = frame;
        this.card = card;
        this.editCard = editCard;
    }

    public EditCardController(Frame frame, AddCard addCard) {
        this.frame = frame;
        this.addCard = addCard;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        HashMap<String, String> fields = editCard.getFields();
        // Back to menu
        if ("back".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new SeeCards(frame));
            frame.revalidate();
        } else if ("save".equals(actionCommand)) {

            try {
                card.setId(Integer.parseInt(fields.get("id")));
                card.setName(fields.get("name"));
                card.setName(fields.get("description"));
                if(card.getType().equals(fields.get("typePokemon"))){
                    int hp = Integer.parseInt(fields.get("hp"));
                    String typePokemon = fields.get("typePokemon");
                    String attackName = fields.get("attackName");
                    String attackDescription = fields.get("attackDescription");
                    String attackPower = fields.get("attackPower");

                    ArrayList<Attack> attacks = new ArrayList<Attack>();

                    attacks.add(new Attack(attackName, attackDescription, Integer.parseInt(attackPower)));

                }
                frame.getContentPane().removeAll();
                frame.setContentPane(new SeeCards(frame));
                frame.revalidate();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Oops, il ya un problème");
            }
        } else if ("delete".equals(actionCommand)) {
            Deck.getCard(fields.get("id")).remove(card);
            frame.getContentPane().removeAll();
            frame.setContentPane(new SeeCards(frame));
            frame.revalidate();
        }
    }
}
