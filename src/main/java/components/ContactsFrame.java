package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Okno glowne kontaktow
 *
 * @author Dominik C.
 */
@Component
public class ContactsFrame extends JFrame {

    @Autowired
    private JScrollPane contactScrollPane;

    @Autowired
    ContactDetailsDialog contactDetailsDialog;

    public ContactsFrame() {
        super("My contacts");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setPreferredSize(new Dimension(300, 300));
    }

    @PostConstruct
    public void init() {
        JButton addButton = new JButton("Add contact");
        addButton.addActionListener((e) -> contactDetailsDialog.showDialog(null));

        add(contactScrollPane);
        add(addButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

}
