# Gambling Tools and Techniques
A Java-based collection of casino games. Final group project for WUSTL CSE237 (Spring '22). 

## Overview
This is a simple Java program accessible by the command line. Users begin by compiling and running a single "Main" class that functions as a text interface from which they can select a playable casino game. 

## Getting Started (for us, for now)
I created the project in Eclipse—it's the environment I'd planned to use for the semester, but if y'all have arguments for IntelliJ IDEA or something we can do that. Should be pre-configured with sensical settings but lmk if things show up in weird places after you clone. 

1. Clone the repo
```
git clone https://github.com/freret/casino-237.git
```
2. Navigate (cd) to `casino-237/src`
3. Make sure I didn't screw something up:
    1. Compile the `HelloWorld` class
    ```
    javac ./init/HelloWorld.java
    ```
    2. Run the `HelloWorld` class
    ```
    java init.HelloWorld
    ```
    3. Repeat steps 3 and 4 with the `InputOutput` class, ensuring that both run smoothly. 
4. Start editing in Eclipse
    1. Open Eclipse with whichever workspace you use
    2. Select `File > Import` from the main menu
    3. Navigate to the root repo directory (`casino-237`)
    4. Select `Casino` from the lower window
    5. Click `Finish`
5. Hmu if you have questions!


## Usage (for actual users when the time comes)
1. Run MainMenu.sh in the command line: ./MainMenu.sh
2. Type "y" when you are ready to being playing.
3. Select a game...

## Questions for Iteration 1
In this iteration, we created a MainMenu shell script for the initial user experience from the command line. This file welcomes the user to the casino, compiles and runs the MainMenu Java class that allows the user to choose and play a game. 
We also implemented the Slots game in a Java class. The game works and passes all written tests. 
Next iteration, we are planning to add Java classes for War and Blackjack along with tests for each. In the MainMenu Java class, we will ensure the user can begin playing a game and switch to a new game. 
Our shell script has been implemented as we intended, but there is a class path issue that we are working through, so it does not work completly yet. UPDATE: classpath issue partially resolved; run per instructions above and please let us know if you have questions.  
In our MainMenu.sh script, we use the javac and java commands to compile and run MainMenu.java that contains options for the three games in our casino. We also used a while loop in the shell script to continuously ask the user if they are ready to play until they respond with "y". 

## Questions for Iteration 2
In the second iteration, we added two more games to the Casino: war and blackjack as independent Java classes. We also created tests for the methods in each class to ensure the game is still functional for various outcomes and game scenarios. 
Another new aspect of our iteration is that the user can purchase chips and place wagers on the game they are playing. 
The MainMenu Java class now allows the user to switch between games??? 
The final iteration will likely consist of adding more tests for each of the games and implementing clean code rules to ensure our methods are concise and easy to follow. 
