package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created by domino on 5/15/17.
 */
@Component
public class ContactsFrame extends JFrame {

    @Autowired
    private JScrollPane contactScrollPane;

    public ContactsFrame() {
        super("My contacts");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @PostConstruct
    public void init() {
        JButton addButton = new JButton("Add contact");
        addButton.addActionListener((e) -> new ContactDetailsDialog(this, null));


        add(contactScrollPane);
        add(addButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

}
