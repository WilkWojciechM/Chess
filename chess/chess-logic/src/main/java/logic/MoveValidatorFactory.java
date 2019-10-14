package logic;

import domain.Piece;

public class MoveValidatorFactory {
    public static MoveValidator validatorForPiece(Piece piece){
        switch(piece.getType()){
            case PAWN: return new PawnMoveValidator();
            case KING: return new KingMoveValidator();
            case ROOK: return new RookMoveValidator();
            case QUEEN: return new QueenMoveValidator();
            case BISHOP: return new BishopMoveValidator();
            case KNIGHT: return new KingMoveValidator();
            default: throw new RuntimeException("no Validator found");
        }
    }
}
