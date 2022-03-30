#!/bin/bash

# intro messages
echo "Welcome to the Casino! Are you ready to play? [y/n]"

# read user input
read A

# compile and run java class for selected game
while [[ "A" == "y" ]];
do
	echo "Are you ready to play?"
	read A
done

echo "Good luck!"

cd ./src
javac ./main/MainMenu.java
java main.MainMenu
