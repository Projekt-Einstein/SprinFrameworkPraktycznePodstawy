package persistence.service;

import model.Contact;

import java.util.List;

/**
 * @author Dominik C.
 */
public interface ContactsService {

    List<Contact> getAllContacts();

    void saveOrUpdateContact(Contact contact);

    void deleteContact(Contact contact);

}
