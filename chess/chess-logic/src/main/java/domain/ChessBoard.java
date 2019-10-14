package domain;

import static domain.PieceColor.BLACK;
import static domain.PieceColor.WHITE;
import static domain.PieceType.*;

public class ChessBoard {

    private Piece[][] board;

    private ChessBoard(Piece[][] board) {this.board = board;}

    public ChessBoard boardWithPieces() {
        Piece[][] board = new Piece[8][8];
        board[0][0] = board[0][7] = new Piece(ROOK, WHITE);
        board[0][1] = board[0][6] = new Piece(KNIGHT, WHITE);
        board[0][2] = board[0][5] = new Piece(BISHOP, WHITE);
        board[0][3] = new Piece(KING, WHITE);
        board[0][4] = new Piece(QUEEN, WHITE);

        for (int i = 0; i < board[1].length; i++) {
            board[1][i] = new Piece(PAWN, WHITE);
        }

        board[7][0] = board[7][7] = new Piece(ROOK, BLACK);
        board[7][1] = board[7][6] = new Piece(KNIGHT, BLACK);
        board[7][2] = board[7][5] = new Piece(BISHOP, BLACK);
        board[7][3] = new Piece(KING, BLACK);
        board[7][4] = new Piece(QUEEN, BLACK);

        for (int i = 0; i < board[6].length; i++) {
            board[6][i] = new Piece(PAWN, BLACK);
        }
        return new ChessBoard(board);
    }

    public static ChessBoard getEmptyBoard() {return new ChessBoard(new Piece[8][8]); }

    public void performMove(Move move){
        Position currentPosition = move.getFromPosition();
        Position futurePosition = move.getToPosition();

        board[futurePosition.getRow()][futurePosition.getColumn()]= getPiece(currentPosition);
        board[currentPosition.getRow()][currentPosition.getColumn()] = null;
    }
    public Piece getPiece(Position position){return board[position.getRow()][position.getColumn()];}
    public void setPiece(Piece piece, Position position){board[position.getRow()][position.getColumn()]= piece;}
}
