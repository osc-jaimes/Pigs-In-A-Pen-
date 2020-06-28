# Pigs In A Pen
A Dots and Boxes type Game made in Android Studio to statisfy the requirements of a Software Engineering Class

## Quick Links

1. [Purpose](#purpose)
2. [Background](#background)
3. [Acknowledgements and Contributors](#acknowledgments-and-contributors)
4. [Gameplay Screenshots](#gameplay-screenshots)
5. [Notes](#notes)

## Purpose
This project was made to fullfill the requirements of a Software Engineering I class at the University of Alberta.
The class was divided into eight groups, of about four or five students, and we were all told to build the same thing: A mobile game for android devices that is based upon
the well known pen and paper game of 'dots and boxes' or 'pigs in a pen'. 

## Background
Dots and Boxes was originally made as a two person pencil-and-paper game  published by French mathematician, Édouard Lucas.
Here is the wikipedia link if you would like to learn more: [Dots and Boxes](https://en.wikipedia.org/wiki/Dots_and_Boxes)

In case of unfamiliarity with the core concept of dots and boxes, the rules are as follows:
* There are two players, playing against each other on an N x N grid of dots, where N is a positive integer greater than 1.
* Players take turns adding a single __vertical__ or __horizontal__ line between two _unjoined_ adjacent dots.
* The player who completes the fourth side of 1 x 1 box earns _one_ points, and gets another turn.
* The game continues like this until no more horizontal or vertical lines can be drawn between two unjoined adjacent dots.
* The player who closed off the most 1 x 1 boxes wins the game.


## Acknowledgments and Contributors
This project would have not been possible without the hard work of all of our team:

1. [Luke Rostad](https://github.com/redheadbros)
    * Luke was the mind behind the 'bot' that a user can play against. Luke built and tested the entirety of the backend algorithms that control computer moves.
    There are three levels of bots, each one way harder than the last. 
2. [Benjamin Wilson](https://github.com/bwilson1639)
    * Benjamin was responsible for building the data flow system between the front-end and back-end. He constructed classes that would turn user input into parsable
    data containing board status and user moves. 
3. [Jared Boonstra](https://github.com/jarrrrl)
    * Jared was a jack-of-all-trades when it came to this project. He worked on a variety of different aspects of the application, such as UI flow and general backend work. 
    He was responsible for writing classes that modelled users and their actions.
4. [Oscar Jaimes](https://github.com/osc-jaimes)
    * Oscar was the man behnid the entirety of the user interface. He designed and developed the flow of the interface, as well as set up connections to the backend 
    of the application. Oscar also assisted in writing backend code that controls the state of the game board.

## Gameplay Screenshots
![1](https://github.com/osc-jaimes/pigs-in-a-pen/blob/master/info/open.png)
![2](https://github.com/osc-jaimes/pigs-in-a-pen/blob/master/info/main.png)
![3](https://github.com/osc-jaimes/pigs-in-a-pen/blob/master/info/setup.png)
![4](https://github.com/osc-jaimes/pigs-in-a-pen/blob/master/info/gameplay.png)

## Notes

This was all of our first times using Android Studio, or even making a game for that matter.
The game was developed using the Google Pixel 2 Emulator in Android Studio, so it may not look 100% right if it is run on a different sized phone.
This project was a blast to make, and the whole group was glad we got placed with one another.
