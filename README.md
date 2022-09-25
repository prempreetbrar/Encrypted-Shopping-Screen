# Shopping-Screen

The program opens a login dialog which prompts the user for a password. The password entered by the user is then compared to an encrypted password.
Upon entering the correct password, a shopping screen pops up. The user can then enter their info, and the "order" is written to a .txt file.

## Demo of the Program:

![](auction_demo.gif)

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

### If you are on Linux

1. Check if Java is installed by running ```java -version``` in the terminal. If it is, proceed to step . If it isn't, you'll get the following output: 
<img width="471" alt="image" src="https://user-images.githubusercontent.com/89614923/192161129-526927d3-4be7-4b67-af30-3d13a832008d.png">

2. Run 
```
sudo apt install default-jre
sudo apt install default-jdk

``` 
in the terminal; type in Y when prompted.

3. Now, we need to configure the environment variables; 

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
**If you have Java installed, skip to step 11! If you don't have Java installed, continue reading.**
If you don't have java installed, click [here](https://www.oracle.com/java/technologies/downloads/#jdk19-windows) and install the latest JDK version.
Click ```x64 Installer``` as your installation option. 
<img width="1265" alt="image" src="https://user-images.githubusercontent.com/89614923/192158881-060bb46f-54ce-4625-9db2-5c58ba8f4d34.png">

2. Go to your downloads folder and open the file you just installed; go through the entire installation process (you don't need to change any options). 
<img width="523" alt="image" src="https://user-images.githubusercontent.com/89614923/192158903-97244102-d562-4124-bc00-c602cdc84e48.png">

3. Open up the start menu and type in *environment variables*. Select *edit the system environment variables*. 
<img width="710" alt="image" src="https://user-images.githubusercontent.com/89614923/192158928-e36ebf82-9088-4988-b20d-2fc92916a449.png">

4. In the *System Properties Window*, under the *Advanced* tab, click *Environment Variables...* 
<img width="413" alt="image" src="https://user-images.githubusercontent.com/89614923/192158943-ed26a764-44a6-4815-95b5-a21c1e65fdde.png">

5. Under the *System variables* category, select the *Path* variable and click *Edit* 
<img width="619" alt="image" src="https://user-images.githubusercontent.com/89614923/192159024-29f19e40-a506-490e-876f-98638e322914.png">

6. Click the New button and enter the path to the Java bin directory (will be ```C:\Program Files\Java\jdk-<version number>\bin```. For example, if you installed JDK 19.0.1, it would be ```C:\Program Files\Java\jdk-19.0.1\bin```. Click ok to save the changes. 
<img width="529" alt="image" src="https://user-images.githubusercontent.com/89614923/192159043-264ece6e-8e1b-47f0-ab55-ab702987a5c5.png">

7. In the _Environment Variables_ window, under the _System variables_ category, click the **New…** button to create a new variable.
<img width="618" alt="image" src="https://user-images.githubusercontent.com/89614923/192159062-c9b1cca6-043f-4335-9352-153c65fecf1a.png">

8. Name the variable as **_JAVA_HOME_**, and in the variable value field, paste the path to your Java jdk directory (like you did in step 6) and click **OK**. 
<img width="654" alt="image" src="https://user-images.githubusercontent.com/89614923/192159074-8eb543d8-cbe6-4872-9283-3db59241785d.png">

9. Confirm the changes by clicking **OK** in the _Environment Variables_ and _System properties_windows_.

10. Test the installation by opening up your command prompt and writing ```java -version```. If the installation was successful, you should see something similar to the following (with a potentially different version number): 
<img width="710" alt="image" src="https://user-images.githubusercontent.com/89614923/192159086-e81ad28a-3405-447f-a3cf-60266e805400.png">


11. Open up your command prompt (if it isn't already), and execute the following commands:
```
cd ~/Downloads/Shopping-Screen-main
javac *.java
java Driver
```
The following codeblock above first puts you in the directory containing the shopping screen, then compiles all java files, and then executes the program.

