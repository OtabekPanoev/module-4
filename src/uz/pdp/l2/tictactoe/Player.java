package uz.pdp.l2.tictactoe;

import java.util.Random;

public class Player extends Thread {

    private final TicTacToe ticTacToe;
    private final char mark;

    public Player(TicTacToe ticTacToe, char mark, String name) {
        super(name);
        this.ticTacToe = ticTacToe;
        this.mark = mark;
    }


    @Override
    public void run() {
        int row = -1;
        int col = -1;
        Random random = new Random();
        while (true) {
            try {

                row = random.nextInt(0, 3);
                col = random.nextInt(0, 3);

                ticTacToe.setRuntimeMark(col, row, mark);

                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }


        }

    }


}