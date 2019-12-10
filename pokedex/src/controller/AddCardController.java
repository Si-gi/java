package controller;

import model.Card;
import view.AddCard;
import view.EditCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import model.*;
import view.Home;

public class AddCardController implements ActionListener {

    private Card card;
    private Frame frame;
    private AddCard addCard;

    public AddCardController(Frame frame, AddCard addCard) {
        this.frame = frame;
        this.addCard = addCard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        // Back to menu
        if ("back".equals(actionCommand)) {
            frame.getContentPane().removeAll();
            frame.setContentPane(new Home(frame));
            frame.revalidate();
        }

        // Add new card in cards
        else if ("create".equals(actionCommand)) {
            Map<String, String> fields = addCard.getFields();
            try {
                int id = Integer.parseInt(fields.get("id"));
                String name = fields.get("name");
                String description = fields.get("description");
                String img = fields.get("img");
                int hp = Integer.parseInt(fields.get("hp"));
                String typePokemon = fields.get("typePokemon");
                String attackName = fields.get("attackName");
                String attackDescription = fields.get("attackDescription");
                String attackPower = fields.get("attackPower");

                ArrayList<Attack> attacks = new ArrayList<Attack>();

                attacks.add(new Attack(attackName, attackDescription, Integer.parseInt(attackPower)));
                Pokemon pokemon = new Pokemon(name, typePokemon, description, img, id, hp, attacks);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
            }
        }
    }
}
