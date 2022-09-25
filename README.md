
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

1. **Note: java installation on Windows is cumbersome.** Check if you have java installed by writing ```java -version``` in the command prompt. 
<img width="710" alt="image" src="https://user-images.githubusercontent.com/89614923/192158251-cf1afe71-901f-473a-a3ff-6642cb6f7faf.png">
If you don't have java installed, click [here](https://www.oracle.com/java/technologies/downloads/#jdk19-windows) and install the latest JDK version. Click ```x64 Installer``` as your installation option. 
![image](https://user-images.githubusercontent.com/89614923/192158288-37ea6af0-5702-45d0-8b9b-564d0dbf5929.png)



2. Go to your downloads folder and open the file you just installed; go through the entire installation process (you don't need to change any options). 
https://mail.google.com/mail/u/0?ui=2&ik=3a2ce7e191&attid=0.0.1&permmsgid=msg-a:r3292524296436141998&th=18375bcb68ad1939&view=fimg&fur=ip&sz=s0-l75-ft&attbid=ANGjdJ_yYLAK5hrjfWafn8UWspZbS3nDMP1XOnS9Ba_NoQ1dLfXvtC_StKSbNtiJNgtuHGpHNad35_68kZdUUAUSSCd7rldjZI4pgThJATBy9slRU4MIinA0BMW28HU&disp=emb&realattid=ii_l8hmgc2w1![image](https://user-images.githubusercontent.com/89614923/192158310-86497045-4972-4d2c-a07d-e6747c416e67.png)

3. Open up the start menu and type in *environment variables*. Select *edit the system environment variables*. 
https://phoenixnap.com/kb/wp-content/uploads/2021/12/edit-system-environment-variables.png![image](https://user-images.githubusercontent.com/89614923/192158336-737ac4bc-8fad-44fe-a2cd-b43032b210e4.png)


4. In the *System Properties Window*, under the *Advanced* tab, click *Environment Variables...* 
https://phoenixnap.com/kb/wp-content/uploads/2021/12/environment-variables-in-system-properties.png![image](https://user-images.githubusercontent.com/89614923/192158345-21d8274f-9234-4909-9dbd-7768b51d1f38.png)

5. Under the *System variables* category, select the *Path* variable and click *Edit* 
https://phoenixnap.com/kb/wp-content/uploads/2021/12/environment-variables-in-windows.png![image](https://user-images.githubusercontent.com/89614923/192158353-6d1ebedf-a504-4aa1-a478-edd06958e8cf.png)

6. Click the New button and enter the path to the Java bin directory (will be ```C:\Program Files\Java\jdk-<version number>\bin```. For example, if you installed JDK 19.0.1, it would be ```C:\Program Files\Java\jdk-19.0.1\bin```. Click ok to save the changes. 
https://phoenixnap.com/kb/wp-content/uploads/2021/12/add-java-environment-variable.png![image](https://user-images.githubusercontent.com/89614923/192158363-890ce0b2-1492-4589-9319-e93fa0e75003.png)

7. In the _Environment Variables_ window, under the _System variables_ category, click the **New…** button to create a new variable.
https://phoenixnap.com/kb/wp-content/uploads/2022/02/create-new-java-home-environment-variable.png![image](https://user-images.githubusercontent.com/89614923/192158392-7aa05041-a4bc-4a20-a7e6-f1b2b36f5e72.png)

8. Name the variable as **_JAVA_HOME_**, and in the variable value field, paste the path to your Java jdk directory (like you did in step 6) and click **OK**. 
https://phoenixnap.com/kb/wp-content/uploads/2022/02/add-java-home-environment-variable.png![image](https://user-images.githubusercontent.com/89614923/192158399-782d44ee-4512-4a38-9d47-0e22d3978bbd.png)

9. Confirm the changes by clicking **OK** in the _Environment Variables_ and _System properties_windows_.

10. Test the installation by opening up your command prompt and writing ```java -version```. If the installation was successful, you should see something similar to the following (with a potentially different version number): 
https://phoenixnap.com/kb/wp-content/uploads/2021/12/java-installed-on-windows.png![image](https://user-images.githubusercontent.com/89614923/192158425-1a9223d8-67e3-45f8-9edf-d4349f84f6eb.png)


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
