package persistence.service;

import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.repo.ContactsRepository;

import javax.swing.*;
import java.util.List;

/**
 * @author Dominik C.
 */
@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private DefaultListModel<Contact> listModel;

    @Override
    public List<Contact> getAllContacts() {
        return contactsRepository.getAllContacts();
    }

    @Override
    public void saveOrUpdateContact(Contact contact) {
        int index = listModel.indexOf(contact);

        if (index == -1) {
            contactsRepository.saveContact(contact);
            listModel.addElement(contact);
        } else {
            contactsRepository.updateContact(contact);
            listModel.set(index, contact);
        }
    }

    @Override
    public void deleteContact(Contact contact) {
        contactsRepository.deleteContact(contact);
        listModel.remove(listModel.indexOf(contact));
    }
}
