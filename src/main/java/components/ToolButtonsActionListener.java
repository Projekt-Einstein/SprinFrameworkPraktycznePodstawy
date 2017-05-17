package components;

import helper.GuiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.service.ContactsService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dominik C.
 */
@Component
public class ToolButtonsActionListener implements ActionListener {

    @Autowired
    private ContactDetailsDialog contactDetailsDialog;

    @Autowired
    private ContactsService contactsService;

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case GuiHelper.MODIFY:
                contactDetailsDialog.enableFields();

                break;

            case GuiHelper.DELETE:
                contactsService.deleteContact(contactDetailsDialog.getContact());
                JOptionPane.showMessageDialog(contactDetailsDialog, "Succesfully deleted");
                contactDetailsDialog.dispose();
                break;

            case GuiHelper.SAVE:
                contactsService.saveOrUpdateContact(contactDetailsDialog.getContactFromForm());
                JOptionPane.showMessageDialog(contactDetailsDialog, "Contact saved");
                contactDetailsDialog.dispose();
                break;
        }
    }
}
