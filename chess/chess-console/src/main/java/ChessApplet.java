import sun.swing.SwingUtilities2;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

public class ChessApplet extends Applet {

    static int N = 8;//ChessBoard size
    private char[][] chessBoard = new char[N][N];

    public char[][] getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(char[][] chessBoard) {
        this.chessBoard = chessBoard;
    }


    public void paint(Graphics graphics) {
        int x, y;
        char[] pion = new char[1];

        for (int row = 0; row < N; row++)
            for (int col = 0; col < N; col++) {
                x = row * 75;
                y = col * 75;
                if ((row + col) % 2 == 0) graphics.setColor(Color.GRAY);
                else graphics.setColor(Color.LIGHT_GRAY);
                graphics.fillRect(x, y, 75, 75);
                pion[0] = chessBoard[col][row];
                graphics.setColor(Color.BLACK);
                Font font = new Font("Arial",1,30);
                graphics.setFont(font);
                graphics.drawChars(pion, 0, 1, x + 25, y + 45);
            }
    }

    public void initializeChessBoard() {

        chessBoard[0][0] = '\u265C';
        chessBoard[0][1] = '\u265E';
        chessBoard[0][2] = '\u265D';
        chessBoard[0][3] = '\u265B';
        chessBoard[0][4] = '\u265A';
        chessBoard[0][5] = '\u265D';
        chessBoard[0][6] = '\u265E';
        chessBoard[0][7] = '\u265C';
        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[1][i] = '\u265F';
            chessBoard[6][i] = '\u2659';
        }
        chessBoard[7][0] = '\u2656';
        chessBoard[7][1] = '\u2658';
        chessBoard[7][2] = '\u2657';
        chessBoard[7][3] = '\u2655';
        chessBoard[7][4] = '\u2654';
        chessBoard[7][5] = '\u2657';
        chessBoard[7][6] = '\u2658';
        chessBoard[7][7] = '\u2656';
    }
        public static void main (String[]args){

            JFrame jp = new JFrame();
            ChessApplet chessApplet = new ChessApplet();
            chessApplet.initializeChessBoard();
            jp.getContentPane().add(chessApplet, BorderLayout.CENTER);
            jp.setSize(new Dimension(600, 630));
            jp.setVisible(true);

        }

    }
