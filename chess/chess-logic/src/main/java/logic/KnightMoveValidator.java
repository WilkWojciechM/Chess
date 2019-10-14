package logic;

import domain.ChessBoard;
import domain.Move;

public class KnightMoveValidator implements MoveValidator{

    @Override
    public boolean isValid(Move move, ChessBoard chessBoard){

        int sumShift = Math.abs(move.verticalShift()) + Math.abs(move.horizontalShift());
        FriendlyFireValidator fireValidator = new FriendlyFireValidator();
        OrthogonalValidator orthogonalValidator = new OrthogonalValidator();


        if(fireValidator.isValid(move,chessBoard)){
        return true;
        }
        if(orthogonalValidator.isValid(move,chessBoard)){
            return false;
        }
        if(sumShift == 3){
            return true;
        }
        return true;
    }
}
