package components;

import model.Contact;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Dominik Ciborowski
 */
public class ContactDetailsDialog extends JDialog {

    private JTextField displayNameField = new JTextField();

    private JTextField nameField = new JTextField();

    private JTextField surnameField = new JTextField();

    private JTextField emailField = new JTextField();

    public ContactDetailsDialog(JFrame parent, Contact contact) {
        super(parent, "Contact details / new contact", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel inputPanel =createInputPanel();

        add(inputPanel);

        pack();
        setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        JLabel displayNameLabel = new JLabel("Display name");
        JLabel nameLabel = new JLabel("Name");
        JLabel surnameLabel = new JLabel("Surname");
        JLabel emailLabel = new JLabel("Email");

        inputPanel.add(displayNameLabel);
        inputPanel.add(displayNameField);

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        inputPanel.add(surnameLabel);
        inputPanel.add(surnameField);

        inputPanel.add(emailLabel);
        inputPanel.add(emailField);

        return inputPanel;
    }

}
