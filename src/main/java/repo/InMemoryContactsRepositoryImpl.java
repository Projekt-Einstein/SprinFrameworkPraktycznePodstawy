package repo;

import model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by domino on 5/15/17.
 */
@Repository
public class InMemoryContactsRepositoryImpl implements ContactsRepository {

    private List<Contact> contactsList = new ArrayList<>();

    {
        Contact contact1 = new Contact();
        contact1.setDisplayName("Contact 1");
        contactsList.add(contact1);
    }

    @Override
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contactsList);
    }
}
