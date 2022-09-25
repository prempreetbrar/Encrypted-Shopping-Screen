
# Shopping-Screen

The program opens a login dialog which prompts the user for a password. The password entered by the user is then compared to an encrypted password.
Upon entering the correct password, a shopping screen pops up. The user can then enter their info, and the "order" is written to a .txt file.

## Demo of the Program:

![](auction_demo.gif)

&nbsp;
&nbsp;
&nbsp;



### If you are on MacOS

1. Java comes installed with OSX. So, click on the green button in the top right that says ```Code```, click ```Download ZIP```, and then execute the following commands in your terminal:

```
cd ~/Downloads/Shopping-Screen-main
javac *.java
java Driver
```
The following codeblock above first puts you in the directory containing the shopping screen, then compiles all java files, and then executes the program.

&nbsp;

### If you are on Windows

1. **Note: java installation on Windows is cumbersome.** Check if you have java installed by writing ```java -version``` in the command prompt. If you don't have java installed, click [here](https://www.oracle.com/java/technologies/downloads/#jdk19-windows) and install the latest JDK version. Click ```x64 Installer``` as your installation option.

2. Go to your downloads folder and open the file you just installed; go through the entire installation process (you don't need to change any options).

3. Open up the start menu and type in *environment variables*. Select *edit the system environment variables*.

4. In the *System Properties Window*, under the *Advanced* tab, click *Environment Variables...*

5. Under the *System variables* category, select the *Path* variable and click *Edit*

6. Click the New button and enter the path to the Java bin directory (will be ```C:\Program Files\Java\jdk-<version number>\bin```. For example, if you installed JDK 19.0.1, it would be ```C:\Program Files\Java\jdk-19.0.1\bin```. Click ok to save the changes.

7. In the _Environment Variables_ window, under the _System variables_ category, click the **New…** button to create a new variable.

8. Name the variable as **_JAVA_HOME_**, and in the variable value field, paste the path to your Java jdk directory and click **OK**.

9. Confirm the changes by clicking **OK** in the _Environment Variables_ and _System properties_windows_.

10. Test the installation by opening up your command prompt and writing ```java -version```. If the installation was successful, you should see something similar to the following:

11. Open up your command prompt (if it isn't already), and execute the following commands:
```
cd ~/Downloads/Shopping-Screen-main
javac *.java
java Driver
```
The following codeblock above first puts you in the directory containing the shopping screen, then compiles all java files, and then executes the program.

&nbsp;
&nbsp;
&nbsp;




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
