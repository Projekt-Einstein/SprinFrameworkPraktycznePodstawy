package components;

import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by domino on 5/16/17.
 */
@Component
public class ContactList extends JList<Contact> {

    @Autowired
    private DefaultListModel<Contact> listModel;

    @Autowired
    private ContactDetailsDialog contactDetailsDialog;

    public ContactList() {
        super();
        setPreferredSize(new Dimension(200, 100));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setToolTipText("Double click on element to show details");
        addMouseListener(new ListMouseListener());
    }

    @PostConstruct
    public void init() {
        setModel(listModel);
    }

    private class ListMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                Contact contact = ContactList.this.getSelectedValue();

                contactDetailsDialog.showDialog(contact);
            }
        }
    }

}
