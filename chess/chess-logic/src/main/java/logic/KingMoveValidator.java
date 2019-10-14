package logic;

import domain.ChessBoard;
import domain.Move;

public class KingMoveValidator implements MoveValidator {

    FriendlyFireValidator friendlyFireValidator = new FriendlyFireValidator();
    OrthogonalValidator orthogonalValidator = new OrthogonalValidator();
    DiagonalMoveValidator diagonalMoveValidator = new DiagonalMoveValidator();


    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {
        return friendlyFireValidator.isValid(move, chessBoard) && moveWithinRadius(move) && (orthogonalValidator.isValid(move, chessBoard) || diagonalMoveValidator.isValid(move, chessBoard));
    }

    public boolean moveWithinRadius(Move move) {
        return !(Math.abs(move.verticalShift()) > 1 || Math.abs(move.horizontalShift()) > 1);
    }
}
