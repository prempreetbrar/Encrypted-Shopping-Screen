import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

/*
  Author: Prempreet Brar
  ---------------------------------------------------------------------------------------
  Purpose of the class: Asks the user to login.
 
  Features:
  - Decrypts an encrypted password by reversing a caesar cipher.
  - Stores the user's entered password, compares it to the decrypted password.
  - Shuts down if the user enters unsuccessful attempts.
  - If the user is successful, brings up a prompt to the order screen.
  - Reacts to the user hitting the login button and hitting enter.
   
  Limitations:
   - JPasswordField can easily be breached, not a secure password system.
   - Dialog looks dull and boring, not an industry-standard GUI.
   - Cannot decrypt passwords that use an encryption method other than the caesar cipher.
*/

public class LoginDialog extends JDialog
{
    // Initialize the constants needed for password handling.
    public static final int MATCH = 0;
    public static final int MAX_INCORRECT_ATTEMPTS = 3;
    public static final int PASSWORD_FIELD_LENGTH = 12;

    public static final int CAESAR_SHIFT = 1;
    public static final int ASCII_INDEX_SHIFT = 97;
    public static final int SIZE_OF_ALPHABET = 26;

    // Initialize the constants for the LoginDialog components.
    public static final int DIALOG_WIDTH = 400;
    public static final int DIALOG_HEIGHT = 300;
    public static final int SHUTDOWN_TIMER = 5000;
    public static final int MAX_ATTEMPT_MESSAGE_TIMER = 2750;

    public static final int LABEL_X_COOR = 1;
    public static final int LABEL_Y_COOR = 0;
    public static final int FIELD_X_COOR = 1;
    public static final int FIELD_Y_COOR = 1;

    public static final int BUTTON_X_COOR = 1;
    public static final int BUTTON_Y_COOR = 2;
    public static final int BUTTON_PADDING = 20;

    private JPasswordField passwordField;
    private JLabel fieldLabel;
    private JButton loginButton;
    private GridBagLayout dialogLayout;
    private GridBagConstraints layoutConstraint;

    private int numOfIncorrectAttempts;
    private String actualPassword;
    private FileHandler passwordReader;

    /* LoginDialog method. 
        Features: Creates an instance of a LoginDialog.
        Limitations/Assumptions: Ability to obtain password depends
          on the success of file IO.
    */
    public LoginDialog()
    {
        // Get the actual password.
        passwordReader = new FileHandler();
        String encryptedPassword = passwordReader.readPassword();
        actualPassword = decryptPassword(encryptedPassword);
        numOfIncorrectAttempts = 0;

        // Set up the components of the Login Dialog.
        passwordField = new JPasswordField(PASSWORD_FIELD_LENGTH);
        passwordField.addActionListener(new LoginListener());

        fieldLabel = new JLabel("Enter password: ");
        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginListener());

        dialogLayout = new GridBagLayout();
        layoutConstraint = new GridBagConstraints();
        setLayout(dialogLayout);

        // Set up the bounds of the dialog, center it on screen.
        setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
        setTitle("Login Screen");
        setLocationRelativeTo(null);
        addAllComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /* decryptPassword method. 
        Features: Reverses the caesar cipher and obtains the actual password.
        Limitations/Assumptions: encryptedPassword is of type String.
          Can only decode a caesar cipher of a specific, hard-coded shift.
    */
    public String decryptPassword(String encryptedPassword)
    {   
        // Convert the encrypted password to lowercase characters.
        encryptedPassword = encryptedPassword.toLowerCase();
        char[] encryptedCharacters = encryptedPassword.toCharArray();
        String decryptedPassword = "";
        char currentCharacter = ' ';

        // The following code was obtained from Stack Overflow.
        // Decrypt each non-space character.
        for (int i = 0; i < encryptedCharacters.length; i++)
        {
            if (Character.isLetter(encryptedCharacters[i]))
            {
                // Convert the character to its ASCII value, shift it forward, move it to index 0,
                // obtain its index in the alphabet, move it back to its ASCII index, and then
                // use that new ASCII index and convert it back to a character.
                currentCharacter = (char) ((((int) encryptedCharacters[i]) + CAESAR_SHIFT 
                    - ASCII_INDEX_SHIFT + SIZE_OF_ALPHABET) % SIZE_OF_ALPHABET + ASCII_INDEX_SHIFT);
                decryptedPassword += currentCharacter;
            }
            else if (encryptedCharacters[i] == ' ')
                decryptedPassword += encryptedCharacters[i];
        }
        
        return decryptedPassword;
    }

    /* addAllComponents method. 
        Features: Add every component to the LoginDialog.
        Limitations/Assumptions: Doesn't check if components are of type Component.
    */
    public void addAllComponents()
    {
        addComponent(fieldLabel, LABEL_X_COOR, LABEL_Y_COOR);
        addComponent(passwordField, FIELD_X_COOR, FIELD_Y_COOR);

        // Add spacing between the top of the button and the password field.
        layoutConstraint.insets = new Insets(BUTTON_PADDING, 0, 0, 0);
        addComponent(loginButton, BUTTON_X_COOR, BUTTON_Y_COOR);
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
        dialogLayout.setConstraints(component, layoutConstraint);
        add(component);
    }

    /* checkNumOfIncorrectAttempts method. 
        Features: Checks if all attempts have been used.
        Limitations/Assumptions: Can only close program if thread.sleep() operation is not interrupted.
        Method Signature: checkNumOfIncorrectAttempts()
    */
    public void checkNumOfIncorrectAttempts()
    {
        if (numOfIncorrectAttempts >= MAX_INCORRECT_ATTEMPTS)
        {
            try
            {   
                // Let the user see that all login attemtps have been used, then swap to an exit
                // message, give the user time to see the exit message, and close the dialog.
                Thread.sleep(MAX_ATTEMPT_MESSAGE_TIMER);
                setTitle("Max attempts exceeded, exiting...");
                Thread.sleep(SHUTDOWN_TIMER);
                setVisible(false);
                dispose();
            }
            catch (InterruptedException interruption)
            {
                System.out.println("There was an interruption in the suspension "
                    + "of the current thread.");
            }
        }
    }

    /* getPasswordField method. 
        Features: Returns the LoginDialog's password field.
        Limitations/Assumptions: None
    */
    public JPasswordField getPasswordField()
    {
        return passwordField;
    }

    // Purpose of the class: Responds to actions on the login dialog.
    private class LoginListener implements ActionListener
    {

        /* actionPerformed method.
           Features: Responds to an action on the LoginDialog.
           Limitations/Assumptions: Action was performed on either a password
              field or a button.
        */
        public void actionPerformed(ActionEvent event)
        {
            Component sourceOfEvent = (Component) event.getSource();
            String enteredPassword = null;

            // If the event happened in a password field, obtain the password.
            if (sourceOfEvent instanceof JPasswordField)
            {
                JPasswordField fieldOfInterest = (JPasswordField) sourceOfEvent;
                enteredPassword = new String(fieldOfInterest.getPassword());
            }

            // If a button was pressed, obtain the login dialog to which the button is
            // attached, and then obtain the password from that dialog.
            if (sourceOfEvent instanceof JButton)
            {
                JButton pressedButton = (JButton) sourceOfEvent;
                LoginDialog dialogOfInterest = (LoginDialog) pressedButton.getRootPane().getParent();
                enteredPassword = new String(dialogOfInterest.getPasswordField().getPassword());
            }

            checkPassword(enteredPassword);
            checkNumOfIncorrectAttempts();
        }

        /* checkPassword method.
           Features: Checks to see if a password matches the correct password.
           Limitations/Assumptions: enteredPassword is of type String.
        */
        public void checkPassword(String enteredPassword)
        {   
            // If the entered password isn't a match, let the user know.
            if (enteredPassword.compareTo(actualPassword) != MATCH)
            {
                numOfIncorrectAttempts++;
                setTitle("Number of Incorrect Login Attempts (Max = 3): " + numOfIncorrectAttempts);
            }

            // If the entered password is a match, open up the shopping screen.
            if (enteredPassword.compareTo(actualPassword) == MATCH)
            {
                setVisible(false);
                dispose();
                ShoppingScreen shoppingScreen = new ShoppingScreen();
            }
        }
    }
}
