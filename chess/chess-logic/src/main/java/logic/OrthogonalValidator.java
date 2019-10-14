package logic;

import domain.ChessBoard;
import domain.Move;

public class OrthogonalValidator implements MoveValidator {

    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {
        DiagonalMoveValidator diagonalMoveValidator = new DiagonalMoveValidator();

        if ((move.verticalShift() == 0 && move.horizontalShift() != 0) || (move.verticalShift() != 0 && move.horizontalShift() == 0)) {
            if (noMovement(move)) {
                return false;
            }
            return !diagonalMoveValidator.isValid(move, chessBoard);
        }
        return true;
    }

    private boolean noMovement(Move move) {
        return move.verticalShift() == 0 && move.horizontalShift() == 0;
    }

}
