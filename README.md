# Goose Game
The Goose Game Kata is a command-line interface adaptation of a multiplayer board game where players move along a board by rolling x2 6-sided dice, in an attempt to reach the end and win.

This a solution to a coding challenge found [here](https://github.com/xpeppers/goose-game-kata)

## Requirements
- scala 3.2.0
- sbt 1.7.1

## Build, Run and Test
Using `sbt` you can build and run the game with:
```
cd ./goosegame
sbt run
```
To run the unit tests, use `sbt test` inside the scala project.

## Usage
Once the game has successfully compiled and is running, you will be prompted to input a command with `ScalaGooseGame$> `
### Add a Player
Input the command `add Player` followed by the player name you would like to add.\
The game will respond with the names of the existing players plus the added player.\
Example:
```
ScalaGooseGame$> add Player NewPlayer
players: NewPlayer
```
If a player already exists, the game will not add the new player:
```
ScalaGooseGame$> add Player NewPlayer
NewPlayer: already existing player
```
### Move a Player
Input the command `move` followed by the player name to move.
The game will roll, move the player and respond with the new place.\
Example:
```
ScalaGooseGame$> move Blue
Blue rolls 6, 2. Blue moves from 0 to 8
```
If you have your own dice and choose to input the results, you can do so by inputing the 2 values with the player's name.\
Example:
```
ScalaGooseGame$> move Green 5, 2
Green rolls 5, 2. Green moves from 0 to 7
```
Place 6 is a 'Bridge' that moves a player to place 12 instead:
```
ScalaGooseGame$> move Yellow 4, 2
Yellow rolls 4, 2. Yellow moves from 0 to The Bridge. Yellow jumps to 12
```
Places 5, 9, 14, 18, 23, 27 contain a 'Goose' that moves the player forward again by the same amount of places:
```
ScalaGooseGame$> move Red 2, 2
Red rolls 2, 2. Red moves from 5 to 9, The Goose. Red moves again and goes to 13
```
If a player rolls past place 63, they will have to bounce back the extra places:
```
ScalaGooseGame$> move Green 6, 6
Green rolls 6, 6. Green moves from 56 to 63. Green bounces! Green returns to 58
```
The first player to reach the place 63, wins the game, ending the game:
```
ScalaGooseGame$> move Blue
Blue rolls 2, 3. Blue moves from 58 to 63. Blue Wins!!
```