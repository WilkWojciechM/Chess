package logic;

import domain.*;

public class PawnMoveValidator implements MoveValidator {

    @Override
    public boolean isValid(Move move, ChessBoard chessBoard){
        Piece pieceToMove = chessBoard.getPiece(move.getFromPosition());
        PieceColor pieceColorToMove = pieceToMove.getColor();
        int verticalModifier = calculateVerticalModifier(pieceColorToMove);
        FriendlyFireValidator friendlyFireValidator = new FriendlyFireValidator();
        if(friendlyFireValidator.isValid(move,chessBoard) && moveIsLegal(move, verticalModifier,pieceToMove, move.getFromPosition()))
            return true;
        return false;
    }

    private boolean moveIsLegal(Move move, int verticalModifier, Piece piece, Position position){
        if(firstMove(piece,position)){
            if(movedMoreThan2StepsVertically(move) || movedMoreThan1StepHorizontally(move) || noVerticalMovement(move) || movedBackwords(move, verticalModifier))
                return true;
            else if(!firstMove(piece,position))
                if (!(movedMoreThan2StepsVertically(move) || movedMoreThan1StepHorizontally(move) || noVerticalMovement(move) || movedBackwords(move, verticalModifier)))
                    return true;
        }return false;
    }

    private int calculateVerticalModifier(PieceColor pieceColor) {
        return pieceColor.equals(PieceColor.BLACK) ? 1 : -1;
    }

    private boolean firstMove(Piece piece, Position position){
        if(piece.getColor().equals(PieceColor.BLACK) && (position.getRow() == 6)) return true;
        else return piece.getColor().equals(PieceColor.WHITE) && (position.getRow() == 1);
    }

    private boolean movedBackwords(Move move, int verticalModifier) {
        return move.verticalShift() * verticalModifier < 0;
    }

    private boolean noVerticalMovement(Move move) {
        return move.verticalShift() == 0;
    }

    private boolean movedMoreThan2StepsVertically(Move move) {
        return Math.abs(move.verticalShift()) > 2;
    }

    private boolean movedMoreThan1StepHorizontally(Move move) {
        return Math.abs(move.horizontalShift()) > 1;
    }
}
