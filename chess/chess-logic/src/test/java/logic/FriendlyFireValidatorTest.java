package logic;

import domain.ChessBoard;
import domain.Move;
import domain.Piece;
import domain.Position;
import org.junit.Before;
import org.junit.Test;

import static domain.PieceColor.BLACK;
import static domain.PieceColor.WHITE;
import static domain.PieceType.QUEEN;
import static domain.PieceType.ROOK;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FriendlyFireValidatorTest {
    private ChessBoard chessBoard;

    @Before
    public void buildBoard() {
        chessBoard = ChessBoard.getEmptyBoard();
    }

    @Test
    public void isValid_PerformBeatMove_returnsTrue() {
        MoveValidator moveValidator = new FriendlyFireValidator();
        chessBoard.setPiece(new Piece(ROOK, WHITE), new Position("A1"));
        chessBoard.setPiece(new Piece(ROOK, BLACK), new Position("A2"));
        Move move = new Move(new Position("A1"), new Position("A2"));
        assertTrue(moveValidator.isValid(move, chessBoard));
    }

    @Test
    public void isValid_PerformNotFriendlyFireMove_returnsFalse() {
        MoveValidator moveValidator = new FriendlyFireValidator();
        chessBoard.setPiece(new Piece(QUEEN, WHITE), new Position("A1"));
        chessBoard.setPiece(new Piece(QUEEN, WHITE), new Position("A2"));
        Move move = new Move(new Position("A1"), new Position("A2"));
        assertFalse(moveValidator.isValid(move, chessBoard));
    }

}