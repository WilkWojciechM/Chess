package logic;

import domain.ChessBoard;
import domain.Move;

public interface MoveValidator {
    boolean isValid(Move move, ChessBoard chessBoard);
}
