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
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class ClearPathValidatorTest {
    private static Piece whiteQueen = new Piece(QUEEN,WHITE);
    private static Piece blackQueen = new Piece(QUEEN, BLACK);
    private ChessBoard chessBoard;

    @Before
    public void initializeBoard(){
        chessBoard = ChessBoard.getEmptyBoard();
    }

    @Test
    public void isValid_moveVerticalBy2WhenAnotherPieceOnPath_returnFalse() {
        chessBoard.setPiece(whiteQueen,new Position("C1"));
        chessBoard.setPiece(blackQueen, new Position("C2"));
        Move moveVertical = new Move(new Position("C1"),new Position("C3"));
        MoveValidator moveValidator = new ClearPathValidator();
        assertFalse(moveValidator.isValid(moveVertical,chessBoard));
    }
    @Test
    public void isValid_moveHorizontalyBy2WhenAnotherPieceOnPath_returnFalse() {
        chessBoard.setPiece(whiteQueen,new Position("C1"));
        chessBoard.setPiece(blackQueen,new Position("E1"));
        Move moveHorizontal = new Move(new Position("C1"), new Position("F1"));
        MoveValidator moveValidator = new ClearPathValidator();
        assertFalse(moveValidator.isValid(moveHorizontal,chessBoard));
    }
    @Test
    public void isValid_moveVerticalBy2WhenNoPieceOnPath_returnTrue(){
        chessBoard.setPiece(whiteQueen,new Position("B2"));
        chessBoard.setPiece(null,new Position("B3"));
        Move moveVertical = new Move(new Position("B2"),new Position("B5"));
        MoveValidator moveValidator = new ClearPathValidator();
        assertTrue(moveValidator.isValid(moveVertical,chessBoard));
    }
    @Test
    public void isValid_moveHorizontalBy2WhenNoPieceOnPath_returnTrue(){
        chessBoard.setPiece(whiteQueen,new Position("B1"));
        chessBoard.setPiece(null,new Position("C1"));
        Move moveHorizontal = new Move(new Position("B1"),new Position("E1"));
        MoveValidator moveValidator = new ClearPathValidator();
        assertTrue(moveValidator.isValid(moveHorizontal,chessBoard));
    }
    }

