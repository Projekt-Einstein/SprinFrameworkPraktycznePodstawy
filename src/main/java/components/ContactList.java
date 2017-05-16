package components;

import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repo.ContactsRepository;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created by domino on 5/16/17.
 */
@Component
public class ContactList extends JList<Contact> {

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private DefaultListModel<Contact> listModel;

    public ContactList() {
        super();
        setPreferredSize(new Dimension(200, 100));

    }

    @PostConstruct
    public void init() {
        setModel(listModel);
    }

}
