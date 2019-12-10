package view;

import java.awt.*;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.*;
import model.*;

public class EditCard extends JPanel{

    private JTextField name;
    private JTextField desc;
    private JTextField id;
    private JTextField hp;
    private JTextField attackName;
    private JTextField attackDescription;
    private JTextField attackPower;

    public EditCard(Frame frame, Card card) {
        GridLayout gridlayout = new GridLayout(0,1);

        JLabel nameLabel = new JLabel("Enter name:");
        name = new JTextField();

        JLabel descriptionLabel = new JLabel("Enter description:");
        desc = new JTextField();
        /** TO DO ** /
            AUto-increment (based on the last id+1)
         **/
        JLabel numberLabel = new JLabel("Enter an id:");
        id = new JTextField();

        JLabel hpLabel = new JLabel("Enter hp :");
        hp = new JTextField();

        JLabel attackNameLabel = new JLabel("Enter an attack name:");
        attackName = new JTextField();
        JLabel attackDescriptionLabel = new JLabel("Enter an attack description:");
        attackDescription = new JTextField();
        JLabel attackPowerLabel = new JLabel("Enter an attack power:");
        attackPower = new JTextField();

        setLayout(gridlayout);
        add(nameLabel);
        add(name);
        add(descriptionLabel);
        add(desc);
        add(numberLabel);
        add(id);
        add(hpLabel);
        add(hp);
        add(attackNameLabel);
        add(attackName);
        add(attackDescriptionLabel);
        add(attackDescription);
        add(attackPowerLabel);
        add(attackPower);

        EditCardController cardctrl = new EditCardController(frame, card, this);
        JButton AddButton = new JButton("Edit Card");
        add(AddButton);
        AddButton.addActionListener(cardctrl);
        AddButton.setActionCommand("edit");
        JButton DeleteButton = new JButton("Delete Card");
        add(DeleteButton);
        DeleteButton.addActionListener(cardctrl);
        DeleteButton.setActionCommand("delete");
        JButton GoBack = new JButton("Go Back !");
        GoBack.addActionListener(cardctrl);
        GoBack.setActionCommand("goback");
        add(GoBack);
        }

    public HashMap<String, String> getFields() {
        HashMap<String, String> fields = new HashMap<String, String>();
        fields.put("id", id.getText());
        fields.put("name", name.getText());
        fields.put("description", name.getText());
        fields.put("hp", hp.getText());
        fields.put("attackName", attackName.getText());
        fields.put("attackDescription", attackDescription.getText());
        fields.put("attackPower", attackPower.getText());

        return fields;
    }
}
