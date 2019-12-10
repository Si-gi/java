package view;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import controller.*;

public class Home extends JPanel{
    private JButton addCard;
    private JButton editCard;
    private JButton viewCollection;
    private JButton searchCard;
    private JButton quitt;

    public Home (Frame frame) {

        addCard = new JButton("Add card");
        editCard = new JButton("Edit card");
        viewCollection = new JButton("View cards");
        searchCard = new JButton("Search card");
        quitt = new JButton("quitt");

        ListenerController listen = new ListenerController(frame);

        addCard.addActionListener(listen);
        editCard.addActionListener(listen);
        viewCollection.addActionListener(listen);
        searchCard.addActionListener(listen);
        quitt.addActionListener(listen);

        addCard.setActionCommand("add");
        editCard.setActionCommand("edit");
        viewCollection.setActionCommand("view");
        searchCard.setActionCommand("search");
        quitt.setActionCommand("quitt");

        GridLayout gridlayout = new GridLayout(5,0);

        setLayout(gridlayout);
        add(addCard);
        add(editCard);
        add(viewCollection);
        add(searchCard);
        add(quitt);

    }
}
