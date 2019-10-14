package logic;

import domain.ChessBoard;
import domain.Move;

public class DiagonalMoveValidator implements MoveValidator {

    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {
        if (move.verticalShift() != 0 && move.horizontalShift() != 0 && Math.abs(move.verticalShift()) == Math.abs(move.horizontalShift())) {
            return true;
        } else return false;
    }
}
