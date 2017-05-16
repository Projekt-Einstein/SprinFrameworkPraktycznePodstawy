package config;

import components.ContactList;
import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import repo.ContactsRepository;

import javax.swing.*;
import java.awt.*;

/**
 * Created by domino on 5/15/17.
 */
@Configuration
@ComponentScan({"components", "repo"})
public class SwingConfig {

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
}
