import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        char currentPlayer = 'X';

        initializeBoard(board);

        while (true) {
            displayBoard(board);

            int[] move = getMove(scanner);
            int row = move[0];
            int col = move[1];

            if (isValidMove(board, row, col)) {
                board[row][col] = currentPlayer;

                if (isGameOver(board, currentPlayer)) {
                    displayBoard(board);
                    System.out.println(currentPlayer + " wins!");
                    break;
                }

                if (isBoardFull(board)) {
                    displayBoard(board);
                    System.out.println("It's a tie!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void displayBoard(char[][] board) {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static int[] getMove(Scanner scanner) {
        int[] move = new int[2];

        System.out.print("Enter row (0-2): ");
        move[0] = scanner.nextInt();

        System.out.print("Enter column (0-2): ");
        move[1] = scanner.nextInt();

        return move;
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    public static boolean isGameOver(char[][] board, char currentPlayer) {
        if (board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer) {
            return true;
        } else if (board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer) {
            return true;
        } else if (board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        } else if (board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        } else if (board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer) {
            return true;
        } else if (board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }
}