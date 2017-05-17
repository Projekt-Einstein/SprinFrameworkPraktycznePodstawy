package helper;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Dominik C.
 */
public abstract class GuiHelper {

    public static final String MODIFY = "Modify";
    public static final String DELETE = "Delete";
    public static final String SAVE = "Save";

    public static JTextField createFormField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        return textField;
    }

    public static JButton createBtn(String text, ActionListener listener) {
        JButton btn = new JButton(text);
        btn.setActionCommand(text);
        btn.addActionListener(listener);

        return btn;
    }
}
