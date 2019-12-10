package view;

import javax.swing.*;
import controller.*;
import model.Card;

import java.awt.*;
import java.util.HashMap;

public class AddCard extends JPanel  {

    private JTextField name;
    private JTextField type;
    private JTextField desc;
    private JTextField id;
    private JTextField hp;
    private JTextField attackName;
    private JTextField attackDescription;
    private JTextField attackPower;

    public AddCard(Frame frame) {
        GridLayout gridlayout = new GridLayout(0,1);

        JLabel nameLabel = new JLabel("Enter name:");
        name = new JTextField();

        JLabel typeLabel = new JLabel("Enter type:");
        type = new JTextField();

        JLabel descriptionLabel = new JLabel("Enter description:");
        desc = new JTextField();
        /** TO DO auto-increment **/
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
        add(typeLabel);
        add(type);
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

        AddCardController listen = new AddCardController(frame,this);
        JButton AddButton = new JButton("Create a new Pokemon");
        add(AddButton);
        AddButton.addActionListener(listen);
        AddButton.setActionCommand("add");
        JButton GoBack = new JButton("Go Back !");
        GoBack.addActionListener(listen);
        GoBack.setActionCommand("goback");
        add(GoBack);

    }

    public HashMap<String, String> getFields() {
        HashMap<String, String> fields = new HashMap<String, String>();
        fields.put("id", id.getText());
        fields.put("name", name.getText());
        fields.put("description", name.getText());
        fields.put("hp", hp.getText());
        fields.put("typePokemon", type.getText());
        fields.put("attackName", attackName.getText());
        fields.put("attackDescription", attackDescription.getText());
        fields.put("attackPower", attackPower.getText());

        return fields;
    }
}
