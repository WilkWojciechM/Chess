package test;

import logic.MoveValidator;
import logic.RookMoveValidator;
import domain.ChessBoard;
import domain.Move;
import domain.Piece;
import domain.Position;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static domain.PieceColor.*;
import static domain.PieceType.ROOK;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
@Category(ValidatorTests.class)
public class RookMoveValidatorTest {

    private static Piece whiteRook = new Piece(ROOK, WHITE);
    private static Piece blackRook = new Piece(ROOK, BLACK);
    private ChessBoard board;
    private MoveValidator moveValidator;

    @Parameterized.Parameter(0)
    public String srcPos;
    @Parameterized.Parameter(1)
    public String opponentPos;
    @Parameterized.Parameter(2)
    public String dstPos;
    @Parameterized.Parameter(3)
    public Piece srcPiece;
    @Parameterized.Parameter(4)
    public Piece opponentPiece;
    @Parameterized.Parameter(5)
    public boolean expectedResult;
    @Parameterized.Parameter(6)
    public String testName;


    @Parameterized.Parameters(name = "{index}: {6}")
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"H1","G1","E1",whiteRook,null,true,"move orthogonally left with no opponents"},
                {"A8","B8","C8",blackRook,null,true,"move orthogonally right with no opponents"},
                {"A8","A5","A3",blackRook,null,true, "move orthogonally down with no opponents"},
                {"H1","H2","H3",whiteRook,blackRook,false,"move orthogonally up with opponent"},
                {"A2","A5","A5",whiteRook,blackRook,true, "move orthogonally with opponent on final position"},
                {"G3","D3","D3",whiteRook,whiteRook,false, "move orthogonally with ally on final position"}
        });
    }

    @Before
    public void initializeBoard() {
        board = ChessBoard.getEmptyBoard();
        moveValidator = new RookMoveValidator();
    }

    @Test
    public void isValid_moveOrthogonalWithAndWithoutPieces(){
        board.setPiece(srcPiece, new Position(srcPos));
        board.setPiece(opponentPiece, new Position(opponentPos));
        Move move = new Move(new Position(srcPos), new Position(dstPos));
        assertEquals(moveValidator.isValid(move, board), expectedResult);
    }
}
