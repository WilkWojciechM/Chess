package logic;

import domain.*;

public class FriendlyFireValidator implements MoveValidator{
    @Override
    public boolean isValid(Move move, ChessBoard chessBoard){
        if (chessBoard.getPiece(move.getToPosition()) != null) {
            return  chessBoard.getPiece(move.getFromPosition()).getColor() != chessBoard.getPiece(move.getToPosition()).getColor();
        } else {
            return true;
        }
    }
}
