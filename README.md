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


## Usage
1. Navigate to the gamblingtoolsandtechniques directory: cd project-gamblingtoolsandtechniques
2. Run MainMenu.sh in the command line: ./MainMenu.sh
3. Type "y" when you are ready to being playing.
4. Select a game by typing 1, 2, 3 or 4. 

## Questions for Iteration 1

In this iteration, we created a MainMenu shell script for the initial user experience from the command line. This file welcomes the user to the casino, compiles and runs the MainMenu Java class that allows the user to choose and play a game. 
We also implemented the Slots game in a Java class. The game works and passes all written tests. 
Next iteration, we are planning to add Java classes for War and Blackjack along with tests for each. In the MainMenu Java class, we will ensure the user can begin playing a game and switch to a new game. 
Our shell script has been implemented as we intended, but there is a class path issue that we are working through, so it does not work completly yet. UPDATE: classpath issue partially resolved; run per instructions above and please let us know if you have questions.  
In our MainMenu.sh script, we use the javac and java commands to compile and run MainMenu.java that contains options for the three games in our casino. We also used a while loop in the shell script to continuously ask the user if they are ready to play until they respond with "y". 

## Questions for Iteration 2

In the second iteration, we added blackjack to the casino as an independent Java class. We also created tests for the methods to ensure the game is still functional for various outcomes and game scenarios.
We also reduced the size of the slots methods "initiate" and "play" and added more tests to cover the functionality of the game.
Another new aspect of our iteration is that the user can place wagers on the game they are playing. 
The MainMenu Java class now allows the user to switch between games.

User stories completed:
- The user should be able to play blackjack.
- The user should be able to place wagers on the game they are playing.
- The user should be able to switch between games.

The final iteration will likely consist of adding War, more tests for each of the games and implementing clean code rules to ensure our methods are concise and easy to follow. We will also add the ability to buy more credits from the main menu as well as within each game. We will also include a "how to play" message at the beginning of each game.

User stories to complete for next iteration:
- The user should be able to play war.
- The user should be able to buy credits from the main menu.
- The user should be able to buy credits from within the game.
- The user should have a clear description of how to play.

## Questions for Iteration 3
User stories completed: 
- The user is able to play blackjack.
- The user is able to place wagers on all 3 games they are playing. 
- The user is able to 

We decided not to have the user buy credits from the main menu or within games becasue it did not add any value to the user experience of the casino. In reality, most people enter a casino with an predetermined amount of money they are willing to wager that night. Hopefully, they quit playing when they have won more credits than they lost, but if we're being honest here, most people stop playing when the lose all of their money. By beginning each game with a set amount of credits mirrors this experience many people have at a normal casino. 

In summary, our casino features 3 different games - Slots, War, and Blackjack - for a holistic that will excite any user. We began by developing a MainMenu script that welcomes the user and compiles and run the Java classes for each game. To begin developing code for each game, we created tests to test the funcitonality of our future code. These tests consisted of checking the values of instance variables throughout each game such as the number of rounds played, credits after playing, win state of a round, and if a user has enough credits to continue playing in Blackjack. Beyond the Java classes we have for each game, there is a Card object and a Deck object that are used in War to simplify our code. 

In each iteration of our project, we further implement clean code rules to make our code more intuitive and understandable for non-developers. We create more methods to partition the functionality of our code and extend the breadth of our tests so all of the cases for outcomes of our games are addressed. The user experience also improves by being able to move between games and play more games. 
