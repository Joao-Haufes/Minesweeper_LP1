# Minesweeper Game in Java

This repository contains an implementation of the classic Minesweeper game in Java, developed by João Victor Alves de Lima and João Pedro Haufes as part of their Info-126 class on October 21, 2019.

## Game Description

Minesweeper is a single-player puzzle game where the player's objective is to clear a grid without hitting any hidden mines. The grid is represented by a matrix, and the player selects cells one by one, trying to avoid the mines. When a cell is selected, it reveals the number of neighboring cells containing mines, which helps the player deduce the locations of the mines. The game ends if the player hits a mine or successfully clears all non-mine cells.

## How to Play

1. Run the Java program and follow the instructions on the console.
2. Input the coordinates of the cell you want to uncover, following the pattern (row, column), both being odd numbers from 1 to 9.
3. The game will reveal the selected cell and its neighboring cells' mine count. Avoid uncovering cells with mines.
4. Keep selecting cells until you clear the entire grid or uncover a cell with a mine.

## Features

- Randomly generated mines and mine-free cells on each game start.
- Interactive console-based gameplay.
- Smart grid display with mine counts for neighboring cells.

**Note**: This Minesweeper implementation is based on a console interface and does not include a graphical user interface (GUI).

Feel free to explore the code and play the game! Any feedback or contributions to enhance the game's features or user experience are highly appreciated.

## Get Started

1. Clone the repository.
2. Compile and run the `campoMinado12.java` file using Java.

**Have fun and enjoy Minesweeper in Java!**
