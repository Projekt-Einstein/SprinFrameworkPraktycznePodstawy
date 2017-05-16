package repo;

import model.Contact;

import java.util.List;

/**
 * Created by domino on 5/15/17.
 */
public interface ContactsRepository {

    List<Contact> getAllContacts();

//    Contact getContactByDisplayName(String displayName);

}
