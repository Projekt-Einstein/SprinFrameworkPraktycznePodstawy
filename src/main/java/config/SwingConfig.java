package config;

import components.ContactList;
import components.ToolButtonsActionListener;
import helper.GuiHelper;
import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import persistence.repo.ContactsRepository;

import javax.swing.*;
import java.awt.*;

/**
 * Created by domino on 5/15/17.
 */
@Configuration
@ComponentScan({"components", "persistence"})
public class SwingConfig {

    private static final int FORM_COMPONENTS_NUMBER = 4;

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private ContactList contactList;

    @Bean
    public DefaultListModel<Contact> contactListModel() {
        DefaultListModel<Contact> listModel = new DefaultListModel<>();

        for (Contact contact : contactsRepository.getAllContacts()) {
            listModel.addElement(contact);
        }

        return listModel;
    }

    @Bean
    public JScrollPane contactScrollPane() {
        JScrollPane scrollPane = new JScrollPane(contactList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        return scrollPane;
    }

    @Bean
    public JLabel[] formLabels() {
        JLabel[] formLabels = new JLabel[FORM_COMPONENTS_NUMBER];

        formLabels[0] = new JLabel("Display name");
        formLabels[1] =  new JLabel("Name");
        formLabels[2] =  new JLabel("Surname");
        formLabels[3] =  new JLabel("Email");

        return formLabels;
    }

    @Bean
    public JTextField[] textFields() {
        JTextField[] formFields = new JTextField[FORM_COMPONENTS_NUMBER];

        for (int i = 0; i < formFields.length; i++) {
            formFields[i] = GuiHelper.createFormField();
        }

        return formFields;
    }

    @Bean
    public JPanel toolPanel(ToolButtonsActionListener listener) {
        JPanel toolPanel = new JPanel(new GridLayout(1, 3));

        for (JButton btn : toolBtns(listener)) {
            toolPanel.add(btn);
        }

        return toolPanel;
    }

    @Bean
    public JButton[] toolBtns(ToolButtonsActionListener toolButtonsActionListener) {
        JButton[] btns = new JButton[3];
        btns[0] = GuiHelper.createBtn(GuiHelper.MODIFY, toolButtonsActionListener);
        btns[0].setEnabled(false);

        btns[1] = GuiHelper.createBtn(GuiHelper.DELETE, toolButtonsActionListener);
        btns[1].setEnabled(false);

        btns[2] = GuiHelper.createBtn(GuiHelper.SAVE, toolButtonsActionListener);

        return btns;
    }
}
