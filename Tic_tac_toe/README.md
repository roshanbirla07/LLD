# Tic-Tac-Toe Game

A console-based implementation of the classic Tic-Tac-Toe game in Java, designed using Object-Oriented Programming principles.

##  Game Overview

This is a two-player Tic-Tac-Toe game where players take turns placing their pieces (X and O) on a 3x3 grid. The first player to get three of their pieces in a row (horizontally, vertically, or diagonally) wins the game.

##  Project Structure

`
Tic_tac_toe/
 Main.java                    # Entry point of the application
 Game/
    Game.java               # Main game logic and flow control
 GameBoard/
    GameBoard.java          # Game board representation and operations
 Player/
    Player.java             # Player entity with name and playing piece
 PalyingPiece/
     PlayingPiece.java       # Abstract base class for playing pieces
     PlayingPieceType.java   # Enum defining piece types (X, O)
     PlayingPieceX.java      # X piece implementation
     PlayingPieceO.java      # O piece implementation
`

##  Features

- **Two-player gameplay**: Players take alternating turns
- **Win detection**: Checks for horizontal, vertical, and diagonal wins
- **Draw detection**: Identifies when the game ends in a draw
- **Visual board display**: Shows the current state of the game board
- **Input validation**: Handles user input for row and column selection
- **Extensible design**: Easy to modify board size or add new features

##  How to Run

1. **Compile the project**:
   `ash
   javac -d . *.java */*.java
   `

2. **Run the game**:
   `ash
   java Tic_tac_toe.Main
   `

3. **Play the game**:
   - Enter row and column numbers (0-2) when prompted
   - Players alternate turns automatically
   - Game ends when someone wins or the board is full

##  How to Play

1. The game starts with an empty 3x3 board
2. Player 1 (X) goes first, followed by Player 2 (O)
3. When prompted, enter the row and column where you want to place your piece
4. The board is displayed after each move
5. Win by getting three of your pieces in a row:
   - **Horizontal**: Same row
   - **Vertical**: Same column  
   - **Diagonal**: Top-left to bottom-right or top-right to bottom-left
6. If all cells are filled without a winner, the game is a draw

##  Architecture & Design Patterns

### Class Hierarchy

- **PlayingPiece**: Abstract base class for game pieces
- **PlayingPieceX/PlayingPieceO**: Concrete implementations for X and O pieces
- **Player**: Contains player information and their playing piece
- **GameBoard**: Manages the game board state and piece placement
- **Game**: Orchestrates the entire game flow and logic

### Key Design Principles

1. **Single Responsibility**: Each class has a specific purpose
2. **Open/Closed**: Easy to extend with new piece types or board sizes
3. **Composition**: Players contain playing pieces rather than inheriting
4. **Encapsulation**: Game logic is properly encapsulated within classes

##  Game Flow

1. **Initialization**: Create game board, players, and initialize game state
2. **Game Loop**: 
   - Display current board
   - Check for draw condition
   - Get player move
   - Place piece on board
   - Check for win condition
   - Switch player turn
3. **Game End**: Display final board and announce winner or draw

##  Technical Details

- **Language**: Java
- **Input**: Console-based user input
- **Board Size**: Configurable (currently set to 3x3)
- **Memory**: Efficient 2D array representation
- **Error Handling**: Basic null pointer protection in board display

##  Sample Output

`
  |  |  
---------
  |  |
---------
  |  |

Player 1 make your move
Enter the row and column
0 0
X |  |  
---------
  |  |
---------
  |  |

Player 2 make your move
Enter the row and column
1 1
X |  |  
---------
  |O |
---------
  |  |
`

##  Future Enhancements

- [ ] GUI implementation using Swing/JavaFX
- [ ] AI player with different difficulty levels
- [ ] Score tracking across multiple games
- [ ] Customizable board sizes (4x4, 5x5, etc.)
- [ ] Network multiplayer support
- [ ] Game history and replay functionality
- [ ] Input validation for invalid moves
- [ ] Sound effects and animations

##  Contributing

Feel free to fork this project and submit pull requests for any improvements or new features!

##  License

This project is open source and available under the MIT License.

##  Class Diagram
Main
│
│ creates
└─── Game
     │
     │ uses
     ├─── GameBoard
     │    │
     │    │ contains
     │    └─── PlayingPiece[][]
     │
     │ manages
     └─── Player[]
          │
          │ has
          └─── PlayingPiece
               │
               │ inheritance
               ├─── PlayingPieceX
               └─── PlayingPieceO
                    │
                    │ uses
                    └─── PlayingPieceType (enum: X, O)
`


##  Game Flow Diagram

`
Start
│
├─── Initialize Game
│
├─── Print Board
│
├─── Check Draw? ──── YES ──── Game Draw
│     │
│     NO
│     │
├─── Get Player Move
│
├─── Place Piece
│
├─── Check Win? ──── YES ──── Player Wins
│     │
│     NO
│     │
├─── Switch Player
│
└─── Loop back to Print Board

##  Key Relationships

1. **Main** creates and controls the **Game** instance
2. **Game** manages the **GameBoard** and **Player** array
3. **Player** contains a **PlayingPiece** (composition)
4. **PlayingPieceX** and **PlayingPieceO** inherit from **PlayingPiece**
5. **PlayingPiece** uses **PlayingPieceType** enum
6. **GameBoard** contains a 2D array of **PlayingPiece** objects

##  Design Patterns Used

- **Template Method**: Game flow follows a consistent pattern
- **Strategy Pattern**: Different piece types (X, O) with same interface
- **Composition**: Player contains PlayingPiece rather than inheritance
- **Factory Pattern**: PlayingPiece subclasses for different piece types
