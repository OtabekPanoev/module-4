package uz.pdp.l2.tictactoe;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final TicTacToe ticTacToe = new TicTacToe();

        Player player1 = new Player(ticTacToe, 'X', "X");
        Player player2 = new Player(ticTacToe, 'O', "O");

        player2.start();
        player1.start();

        player1.join();
        player2.join();

//        System.out.println(ticTacToe);
    }
}
