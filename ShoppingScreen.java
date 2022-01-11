import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.text.Document;
import javax.swing.text.BadLocationException;

/*
  Author: Prempreet Brar
  ---------------------------------------------------------------------------------------
  Purpose of the class: Allows the user to enter their order information.
 
  Features:
  - Can save information by writing it to a file, can clear the text in the interface.
  - Responds to the user pressing save or clear buttons.
  - Text area has scroll pane for instances where the user has a long address.
   
  Limitations:
   - Writes to a hardcoded file order.txt, overwrites the order info currently in the file.
   - Dialog looks dull and boring, not an industry-standard GUI.
   - No option for user to wipe one of the two input fields, user is forced to wipe both
     input fields.
   - No clear indication of the format the address should be in.
*/

public class ShoppingScreen extends JFrame
{
    // Initialize the constants for the ShoppingScreen components.
    public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 500;
    public static final int FONT_SIZE = 18;
    public static final int ORDER_TIMER = 2750;
    public static final int CLEAR_TIMER = 2750;

    public static final int LOGO_X_COOR = 0;
    public static final int LOGO_Y_COOR = 0;
    public static final int LOGO_WIDTH = 2;
    
    public static final int NAME_LABEL_X_COOR = 0;
    public static final int NAME_LABEL_Y_COOR = 1;
    public static final int NAME_LABEL_LEFT_PADDING = 20;

    public static final int ADDRESS_LABEL_X_COOR = 1;
    public static final int ADDRESS_LABEL_Y_COOR = 1;
    public static final int ADDRESS_LABEL_LEFT_PADDING = 50;

    public static final int LABEL_TOP_PADDING = 25;
    public static final int LABEL_GRID_WIDTH = 1;

    public static final int NAME_FIELD_LENGTH = 20;
    public static final int NAME_FIELD_X_COOR = 0;
    public static final int NAME_FIELD_Y_COOR = 2;
    public static final int NAME_FIELD_TOP_PADDING = 10;
    public static final int NAME_FIELD_LEFT_PADDING = 20;

    public static final int ADDRESS_PANE_X_COOR = 1;
    public static final int ADDRESS_PANE_Y_COOR = 2;
    public static final int ADDRESS_PANE_TOP_PADDING = 10;
    public static final int ADDRESS_PANE_LEFT_PADDING = 20;

    public static final int ADDRESS_AREA_ROWS = 5;
    public static final int ADDRESS_AREA_COLUMNS = 17;

    public static final int SAVE_BUTTON_X_COOR = 0;
    public static final int SAVE_BUTTON_Y_COOR = 3;
    public static final int SAVE_BUTTON_RIGHT_PADDING = 33;
    public static final int CLEAR_BUTTON_X_COOR = 1;
    public static final int CLEAR_BUTTON_Y_COOR = 3;
    public static final int BUTTON_TOP_PADDING = 10;

    // Declare references to the instance attributes.
    private JLabel companyLogo;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JTextField nameField;
    private JScrollPane addressPane;
    private JTextArea addressArea;
    private JButton saveButton;
    private JButton clearButton;

    private GridBagLayout screenLayout;
    private GridBagConstraints layoutConstraint;
    private FileHandler fileHandler;

    /* LoginDialog method. 
        Features: Creates an instance of a ShoppingScreen, instantiates attributes.
        Limitations/Assumptions: Goat.jpg, Save.jpg, Clear.jpg are in the same directory
          as ShoppingScreen.java
    */
    public ShoppingScreen()
    {   
        // Get all the labels in.
        // NOTE: The "Goat.jpg" image was constructed by me using clipart provided
        // by Microsoft and an image found at the following link:
        // https://www.jing.fm/iclip/iRRoiiJ_clipart-of-animal-cartoon-the-and-goat-of/
        companyLogo = new JLabel(new ImageIcon("Goat.jpg"));
        nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
        addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));

        // Create the areas where text can be entered and add the appropriate listeners.
        nameField = new JTextField(NAME_FIELD_LENGTH);
        nameField.addActionListener(new ShoppingListener());

        addressArea = new JTextArea(ADDRESS_AREA_ROWS, ADDRESS_AREA_COLUMNS);
        addressPane = new JScrollPane(addressArea);

        // Create the two buttons, adding listeners.
        // NOTE: Both images were taken from https://icon-library.com/
        // The save button image was taken by searching for "floppy disk"
        // The clear button image was taken by searching for "garbage can"
        saveButton = new JButton("Save", new ImageIcon("Save.png"));
        saveButton.setFont(new Font("Dialog", Font.BOLD, FONT_SIZE));
        saveButton.addActionListener(new ShoppingListener());

        clearButton = new JButton("Clear", new ImageIcon("Clear.png"));
        clearButton.setFont(new Font("Dialog", Font.BOLD, FONT_SIZE));
        clearButton.addActionListener(new ShoppingListener());

        screenLayout = new GridBagLayout();
        layoutConstraint = new GridBagConstraints();
        fileHandler = new FileHandler();
        setLayout(screenLayout);

        // Set up the bounds of the screen, center it on the user's screen.
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setTitle("Order Information");
        setLocationRelativeTo(null);
        addAllComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /* addAllComponents method. 
        Features: Add every component to the LoginDialog.
        Limitations/Assumptions: Doesn't check if components are of type Component.
    */
    public void addAllComponents()
    {
        // Add all components, changing their position within their cell (center, start, end)
        // as well as their position relative to other components (x-coordinate, y-coordinate).
        // Add padding around the component when necessary.
        layoutConstraint.anchor = GridBagConstraints.CENTER;
        addComponent(companyLogo, LOGO_X_COOR, LOGO_Y_COOR, LOGO_WIDTH);

        layoutConstraint.anchor = GridBagConstraints.LINE_START;
        layoutConstraint.insets = new Insets(LABEL_TOP_PADDING, NAME_LABEL_LEFT_PADDING, 0, 0);
        addComponent(nameLabel, NAME_LABEL_X_COOR, NAME_LABEL_Y_COOR, LABEL_GRID_WIDTH);

        layoutConstraint.insets = new Insets(LABEL_TOP_PADDING, ADDRESS_LABEL_LEFT_PADDING, 0, 0);
        addComponent(addressLabel, ADDRESS_LABEL_X_COOR, ADDRESS_LABEL_Y_COOR, LABEL_GRID_WIDTH);

        layoutConstraint.anchor = GridBagConstraints.PAGE_START;
        layoutConstraint.insets = new Insets(NAME_FIELD_TOP_PADDING, NAME_FIELD_LEFT_PADDING, 0, 0);
        addComponent(nameField, NAME_FIELD_X_COOR, NAME_FIELD_Y_COOR);

        layoutConstraint.anchor = GridBagConstraints.PAGE_END;
        layoutConstraint.insets = new Insets(ADDRESS_PANE_TOP_PADDING, ADDRESS_PANE_LEFT_PADDING, 0, 0);
        addComponent(addressPane, ADDRESS_PANE_X_COOR, ADDRESS_PANE_Y_COOR);

        layoutConstraint.insets = new Insets(BUTTON_TOP_PADDING, 0, 0, SAVE_BUTTON_RIGHT_PADDING);
        addComponent(saveButton, SAVE_BUTTON_X_COOR, SAVE_BUTTON_Y_COOR);
        layoutConstraint.insets = new Insets(BUTTON_TOP_PADDING, 0, 0, 0);
        addComponent(clearButton, CLEAR_BUTTON_X_COOR, CLEAR_BUTTON_Y_COOR);
    }

    /* addComponent method. 
        Features: Add a single component to the LoginDialog.
        Limitations/Assumptions: Doesn't typecheck the parameters.
    */
    public void addComponent(Component component, int xCoordinate, int yCoordinate)
    {
        // Change the attributes of the GridBagConstraint and add the component.
        layoutConstraint.gridx = xCoordinate;
        layoutConstraint.gridy = yCoordinate;
        screenLayout.setConstraints(component, layoutConstraint);
        add(component);
    }

    /* addComponent method. 
        Features: Add a single component to the LoginDialog, first changing its gridwidth.
        Limitations/Assumptions: Doesn't typecheck the parameters.
    */
    public void addComponent(Component component, int xCoordinate, int yCoordinate, int width)
    {
        layoutConstraint.gridwidth = width;
        addComponent(component, xCoordinate, yCoordinate);
    }

    // Purpose of the class: Responds to actions on the order screen.
    private class ShoppingListener implements ActionListener
    {

        /* actionPerformed method.
           Features: Responds to an action on the ShoppingScreen.
           Limitations/Assumptions: Only two buttons: saveButton and clearButton.
        */
        public void actionPerformed(ActionEvent event)
        {   
            // If the action was not a button press, don't perform any further operations.
            Component sourceOfEvent = (Component) event.getSource();
            if (!(sourceOfEvent instanceof JButton))
                return;

            JButton pressedButton = (JButton) sourceOfEvent;

            // If the save button was pressed, get its corresponding ShoppingScreen, as well as the name 
            // and address, and place the order.
            if (pressedButton == saveButton)
            {
                String name = nameField.getText();
                Document addressDocument = addressArea.getDocument();
                order(name, addressDocument);
            }
            
            // If the clear button was pressed, get its corresponding ShoppingScreen, as well as the name 
            // field and address area, and clear them.
            if (pressedButton == clearButton)
                clear();
        }

        /* order method.
           Features: Saves the name and address information to the file.
           Limitations/Assumptions: Doesn't typecheck the parameters.
        */
        public void order(String name, Document addressDocument)
        {   
            // Try getting the text from the document, checking for errors.
            try
            {
                int endOfDocument = addressDocument.getLength();
                int startOfDocument = 0;
                String addressContent = addressDocument.getText(startOfDocument, endOfDocument);

                // Display an appropriate status message, suspend execution, put the info in a file.
                setTitle("Saving Information...");
                Thread.sleep(ORDER_TIMER);
                fileHandler.writeToFile(name, addressContent);
                setTitle("Order Information");
            }
            catch (BadLocationException rangeError)
            {
                System.out.println("The specified range is not a valid part of the address document.");
            }
            catch (InterruptedException interruption)
            {
                System.out.println("There was an interruption in the suspension "
                    + "of the current thread.");
            }
        }

        /* clear method.
           Features: Wipes the name field and address area.
           Limitations/Assumptions: Doesn't typecheck the parameters.
        */
        public void clear()
        {
            try
            {
                // Display a status message, suspend execution, clear the text areas,
                // and then reset the title.
                setTitle("Clearing Information...");
                Thread.sleep(CLEAR_TIMER);
                nameField.setText(null);
                addressArea.setText(null);
                setTitle("Order Information");
            }
            catch (InterruptedException interruption)
            {
                System.out.println("There was an interruption in the suspension "
                    + "of the current thread.");
            }
        }

    }

}
