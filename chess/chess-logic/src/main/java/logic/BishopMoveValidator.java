package logic;

import domain.ChessBoard;
import domain.Move;

public class BishopMoveValidator implements  MoveValidator {

    FriendlyFireValidator friendlyFireValidator = new FriendlyFireValidator();
    DiagonalMoveValidator diagonalMoveValidator = new DiagonalMoveValidator();
    ClearPathValidator clearPathValidator = new ClearPathValidator();

    @Override
    public boolean isValid(Move move, ChessBoard chessBoard){
        if(!friendlyFireValidator.isValid(move,chessBoard)) return false;
        if(!clearPathValidator.isValid(move, chessBoard)) return false;
        if(!diagonalMoveValidator.isValid(move, chessBoard)) return false;
        return true;
    }
}
