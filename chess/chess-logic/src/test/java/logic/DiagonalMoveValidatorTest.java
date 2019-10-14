package logic;

import domain.ChessBoard;
import domain.Move;
import domain.Piece;
import domain.Position;
import org.junit.Before;
import org.junit.Test;

import static domain.PieceColor.WHITE;
import static domain.PieceType.QUEEN;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiagonalMoveValidatorTest {

    private ChessBoard chessBoard;

    @Before
    public void buildBoard() {
        chessBoard = ChessBoard.getEmptyBoard();
    }

    @Test
    public void isValid_PerformKnightMove_returnsFalse() {
        MoveValidator moveValidator = new DiagonalMoveValidator();
        chessBoard.setPiece(new Piece(QUEEN, WHITE), new Position("A1"));
        Move move = new Move(new Position("A1"), new Position("B3"));
        assertFalse(moveValidator.isValid(move, chessBoard));
    }

    @Test
    public void isValid_PerformOrthogonalMove_returnsFalse() {
        MoveValidator moveValidator = new DiagonalMoveValidator();
        chessBoard.setPiece(new Piece(QUEEN, WHITE), new Position("A1"));
        Move move = new Move(new Position("A1"), new Position("A2"));
        assertFalse(moveValidator.isValid(move, chessBoard));
    }

    @Test
    public void isValid_PerformDiagonalMove_returnsFalse() {
        MoveValidator moveValidator = new DiagonalMoveValidator();
        chessBoard.setPiece(new Piece(QUEEN, WHITE), new Position("A1"));
        Move move = new Move(new Position("A1"), new Position("C3"));
        assertTrue(moveValidator.isValid(move, chessBoard));
    }
}