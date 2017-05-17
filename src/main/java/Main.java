import components.ContactsFrame;
import config.SwingConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

/**
 * Created by domino on 5/15/17.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwingConfig.class);

        new ContactsFrame();
    }

}
