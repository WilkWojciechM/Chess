package logic;

import domain.ChessBoard;
import domain.Move;

public class QueenMoveValidator implements MoveValidator {

    FriendlyFireValidator friendlyFireValidator = new FriendlyFireValidator();
    OrthogonalValidator orthogonalValidator = new OrthogonalValidator();
    DiagonalMoveValidator diagonalMoveValidator = new DiagonalMoveValidator();
    ClearPathValidator clearPathValidator = new ClearPathValidator();

    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {
        if (clearPathValidator.isValid(move, chessBoard) && friendlyFireValidator.isValid(move, chessBoard)) {
            if (orthogonalValidator.isValid(move, chessBoard) && !diagonalMoveValidator.isValid(move, chessBoard))
                return true;
            else if (!orthogonalValidator.isValid(move, chessBoard) && diagonalMoveValidator.isValid(move, chessBoard))
                return true;
        }
        return false;
    }
}
