package components;

import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * @Author Dominik Ciborowski
 */
@org.springframework.stereotype.Component
public class ContactDetailsDialog extends JDialog {

    @Autowired
    private JLabel[] formLabels;

    @Autowired
    private JTextField[] formFields;

    @Autowired
    private JPanel toolPanel;

    @Autowired
    private JButton[] toolBtns;

    private Contact contact;

    private ContactDetailsDialog() {
        super((JFrame) null, "Contact details / new contact", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(250, 250));
    }

    @PostConstruct
    public void init() {
        add(createInputPanel());
        add(toolPanel, BorderLayout.SOUTH);
        pack();
    }

    public void showDialog(Contact contact) {
        this.contact = contact;
        if (contact != null) {
            initDialogWithContactObject();
        }

        this.setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        for (int i = 0; i < formLabels.length; i++) {
            inputPanel.add(formLabels[i]);
            inputPanel.add(formFields[i]);
        }

        return inputPanel;
    }

    private void initDialogWithContactObject() {
        formFields[0].setText(contact.getDisplayName());
        formFields[0].setEnabled(false);

        formFields[1].setText(contact.getName());
        formFields[1].setEnabled(false);

        formFields[2].setText(contact.getSurname());
        formFields[2].setEnabled(false);

        formFields[3].setText(contact.getEmail());
        formFields[3].setEnabled(false);

        enableButtons();
    }

    private void enableButtons() {
        for (JButton btn : toolBtns) {
            btn.setEnabled(true);
        }
    }

    public void disableBtns() {
        toolBtns[0].setEnabled(false);
        toolBtns[1].setEnabled(false);
    }

    public void enableFields() {
        for (JTextField field : formFields) {
            field.setEnabled(true);
        }
    }

    public Contact getContactFromForm() {
        if (contact == null) {
            contact = new Contact();
        }

        contact.setDisplayName(formFields[0].getText());
        contact.setName(formFields[1].getText());
        contact.setSurname(formFields[2].getText());
        contact.setEmail(formFields[3].getText());

        return contact;
    }

    public Contact getContact() {
        return contact;
    }
}
