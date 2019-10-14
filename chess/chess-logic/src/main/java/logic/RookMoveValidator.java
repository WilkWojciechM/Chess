package logic;

import domain.ChessBoard;
import domain.Move;

public class RookMoveValidator implements MoveValidator{

    FriendlyFireValidator friendlyFireValidator = new FriendlyFireValidator();
    OrthogonalValidator orthogonalValidator = new OrthogonalValidator();
    DiagonalMoveValidator diagonalMoveValidator = new DiagonalMoveValidator();
    ClearPathValidator clearPathValidator = new ClearPathValidator();

    @Override
    public boolean isValid(Move move, ChessBoard chessBoard){
        return clearPathValidator.isValid(move, chessBoard)&&
        orthogonalValidator.isValid(move, chessBoard)&&
        friendlyFireValidator.isValid(move, chessBoard)&&
        !diagonalMoveValidator.isValid(move, chessBoard);

    }
}
