#!/bin/bash

# intro messages
echo "Welcome to the Casino, please select a game: Slots, War, or Blackjack"

# read user input
read G

# compile and run java class for selected game
while ! [[ -f "$G.java" ]];
do
	echo "Please select a game: Slots, War, or Blackjack"
	read G
done

javac $G.java
java $G

echo "Goodluck!"	
