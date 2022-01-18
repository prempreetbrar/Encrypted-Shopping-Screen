# Encrypted-Shopping-Screen

The program opens a login dialog which prompts the user for a password. The password entered by the user is then compared to an encrypted password.
Upon entering the correct password, a shopping screen pops up. The user can then enter their info, and the "order" is written to a .txt file.

## Features [LoginDialog.java]:
![image](https://user-images.githubusercontent.com/89614923/131058925-299baf5b-c8c8-4c5b-908c-7f0e66562397.png)

  - Decrypts an encrypted password by reversing a caesar cipher.
  - Stores the user's entered password, compares it to the decrypted password.
  - Displays a suitable error message if the user has 3 unsuccessful attempts, and then shuts down.
  - If the user is successful, brings up a prompt to the order screen.
  - Reacts to the user hitting the login button and hitting enter.

## Features [ShoppingScreen.java]:
![image](https://user-images.githubusercontent.com/89614923/131058987-059d649f-4573-4987-b983-4328e697b08c.png)

  - Can save information by writing it to a file called order.txt, displaying an appropriate message in the title bar.
  - Clears the entire interface of information when the user hits clear, displaying an appropriate message in the title bar.
  - Text area has scroll pane for instances where the user has a long address.

&nbsp;

## [order.txt]:
- The name sits by itself on the first line of the file, and each line of the address sits on a separate line following the name.

_An example order that I placed:_

![image](https://user-images.githubusercontent.com/89614923/148914778-8d137a21-679f-4b0c-abaf-a4e0542e9d86.png)

_The format of the order in the "order.txt" file:_

Prempreet Brar\
Calgary Tower\
101 9 Ave SW\
Calgary, AB\
T2P 1J9

&nbsp;

## How to Use?
1. Download and compile all files, and then execute java Driver.java.
2. This will bring up a login screen. To see how the GUI responds to incorrect attempts, enter in any word other than "password".
   If you'd like to progress to the shopping screen, enter "password".
3. At the shopping screen, enter in a name and address, and then press save to write the order to a .txt file, or clear if you want
   to write another order.
