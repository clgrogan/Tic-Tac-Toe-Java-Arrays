import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    // Task 1: Create an array with three rows of '_' characters.
    String board[][] = {
        { "_", "_", "_" },
        { "_", "_", "_" },
        { "_", "_", "_" }
    };
    String gameResults = "The game was a tie!!";

    // Task 2: Call the function printBoard();
    printBoard(board);

    /*
     * { Task 3: Loop through turns.
     * 
     * if (X) turn {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value.
     * } else {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value. Then, print it.
     * 
     * }
     * 
     * Task 6 - Call the checkWin function.
     * if return value == 3 {
     * print: X wins and break the loop
     * } else if return value == -3 {
     * print: O wins and break the loop
     * }
     * 
     * }
     */
    for (int turnNumber = 1; turnNumber < 10; turnNumber++) {
      System.out.println();

      int[] selection = askUser(Arrays.copyOf(board, board.length));
      if (turnNumber % 2 == 0)
        board[selection[0]][selection[1]] = "O";
      else
        board[selection[0]][selection[1]] = "X";
      printBoard(Arrays.copyOf(board, board.length));
      int winner = checkWin(Arrays.copyOf(board, board.length));
      if (winner == 3) {
        gameResults = "X wins the game!";
        break;
      } else if (winner == -3) {
        gameResults = "O wins the game!";
        break;
      }

    }
    System.out.println("\n   " + gameResults + "\n");
    scanner.close();
  }

  /**
   * Task 2 - Write a function that prints the board.
   * Function name - printBoard()
   * 
   * @param board (char[][])
   * 
   *              Inside the function:
   *              1. print a new line.
   *              2. print the board.
   *              • separate each row by two lines.
   *              • each row precedes a tab of space
   *              • each character in the grid has one space from the other
   *              character
   */
  private static void printBoard(String[][] board) {
    for (int i = 0; i < board.length; i++) {
      System.out.print("\n\n\t");
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + "\s");
      }
    }
    System.out.println("\n");
  }

  /**
   * Function name – askUser
   * 
   * @param board (char[][] board)
   * @return spot (int[])
   * 
   *         Inside the function
   *         1. Asks the user: - pick a row and column number:
   *         2. Check if the spot is taken. If so, let the user choose again.
   *         3. Return the row and column in an int[] array.
   * 
   */
  private static int[] askUser(String[][] pBoard) {
    int[] userSelection = new int[2];
    boolean validSelection = false;
    while (validSelection == false) {
      userSelection[0] = scanner.nextInt();
      userSelection[1] = scanner.nextInt();
      scanner.nextLine();
      if (pBoard[userSelection[0]][userSelection[1]].equals("_")) {
        validSelection = true;
      } else
        System.out.print("\n Space " + userSelection[0] + " " + userSelection[1]
            + " is tacken already. Pick another row and column:");
    }
    return userSelection;
  }

  /**
   * Task 6 - Write a function that determines the winner
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   * 
   *         Inside the function:
   *         1. Make a count variable that starts at 0.
   *         2. Check every row for a straight X or straight O (Task 7).
   *         3. Check every column for a straight X or straight O (Task 8).
   *         4. Check the left diagonal for a straight X or straight O (Task 9).
   *         5. Check the right diagonal for a straight X or straight O (Task 10).
   */
  private static int checkWin(String[][] pBoard) {
    String x = "X";
    String o = "O";
    for (int i = 0; i < pBoard.length; i++) {
      if (pBoard[i][0].equals(x) && pBoard[i][1].equals(x) && pBoard[i][2].equals(x))
        return 3;
      if (pBoard[0][i].equals(x) && pBoard[1][i].equals(x) && pBoard[2][i].equals(x))
        return 3;
      if (pBoard[i][0].equals(o) && pBoard[i][1].equals(o) && pBoard[i][2].equals(o))
        return -3;
      if (pBoard[0][i].equals(o) && pBoard[1][i].equals(o) && pBoard[2][i].equals(o))
        return 3;
    }
    if ((pBoard[0][0].equals(x) && pBoard[1][1].equals(x) && pBoard[2][2].equals(x))
        || (pBoard[0][2].equals(x) && pBoard[1][1].equals(x) && pBoard[2][0].equals(x)))
      return 3;
    if ((pBoard[0][0].equals(o) && pBoard[1][1].equals(o) && pBoard[2][2].equals(o))
        || (pBoard[0][2].equals(o) && pBoard[1][1].equals(o) && pBoard[2][0].equals(o)))
      return 3;
    return 0;
  }

}
