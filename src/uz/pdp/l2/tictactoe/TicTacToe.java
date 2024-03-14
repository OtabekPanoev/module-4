package uz.pdp.l2.tictactoe;

import java.util.Arrays;

public class TicTacToe {

    boolean isPrime = false;

    char[][] table = new char[3][3];

    char lastMark;

    public TicTacToe() {
        for (char[] chars : table) Arrays.fill(chars, 'q');
    }

    private boolean checkHasWonOrValid() {

        if (table[0][0] != 'q' && table[0][0] == table[0][1] && table[0][1] == table[0][2])
            return true;
        if (table[1][0] != 'q' && table[1][0] == table[1][1] && table[1][1] == table[1][2])
            return true;
        if (table[2][0] != 'q' && table[2][0] == table[2][1] && table[2][1] == table[2][2])
            return true;


        if (table[0][0] != 'q' && table[0][0] == table[1][0] && table[1][0] == table[2][0])
            return true;
        if (table[0][1] != 'q' && table[0][1] == table[1][1] && table[1][1] == table[2][1])
            return true;
        if (table[0][2] != 'q' && table[0][2] == table[1][2] && table[1][2] == table[2][2])
            return true;

        if (table[0][0] != 'q' && table[0][0] == table[1][1] && table[1][1] == table[2][2])
            return true;
        if (table[0][2] != 'q' && table[0][2] == table[1][1] && table[1][1] == table[2][0])
            return true;

        for (char[] chars : table) {
            for (char aChar : chars) {
                if (aChar == 'q') {
                    return false;
                }
            }
        }

        return true;
    }


    public synchronized void setRuntimeMark(int x, int y, char mark) throws InterruptedException {

        if (!isPrime && mark == 'O') {
            wait();
        }

        if (!isPrime && mark == 'X') {
            isPrime = true;
        }

        if (checkHasWonOrValid()) {
            Thread.currentThread().interrupt();
            return;
        }

        if (lastMark == mark)
            wait();

        if (table[x][y] != 'q') {
            return;
        }

//        System.out.println(Thread.currentThread().getName() + " thread moving");

        table[x][y] = mark;
        lastMark = mark;
        System.out.println(this);

        notifyAll();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                str.append(table[i][j]).append("\t");
            }
            str.append("\n");
        }
        return str.toString();
    }
}