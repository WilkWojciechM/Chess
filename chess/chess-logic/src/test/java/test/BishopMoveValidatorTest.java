package test;

import domain.ChessBoard;
import domain.Move;
import domain.Piece;
import domain.Position;
import logic.BishopMoveValidator;
import logic.MoveValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static domain.PieceColor.BLACK;
import static domain.PieceColor.WHITE;
import static domain.PieceType.BISHOP;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
@Category(ValidatorTests.class)
public class BishopMoveValidatorTest {
    private ChessBoard chessBoard;
    private MoveValidator moveValidator;
    private static Piece whiteBishop = new Piece(BISHOP, WHITE);
    private static Piece blackBishop = new Piece(BISHOP, BLACK);

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
                {"E5","F6","H8",whiteBishop,null,true,"move diagonally vertical+/horizontal+ with no opponents"},
                {"E5","F4","G3",blackBishop,whiteBishop,false,"move diagonally vertical-/horizontal+ with opponent on path"},
                {"E5","D4","C3",blackBishop,null,true, "move diagonally vertical-/horizontal-  with no opponents"},
                {"E5","D6","D6",whiteBishop,blackBishop,true,"move diagonally horizontal+/vertical- with opponent on final position"},
                {"E5","D6","D6",whiteBishop,whiteBishop,false,"move diagonally with horizontal+/vertical- ally on final position"}
        });
    }

    @Before
    public void initializeBoard() {
        chessBoard = ChessBoard.getEmptyBoard();
        moveValidator = new BishopMoveValidator();
    }

    @Test
    public void isValid_test() {
        chessBoard.setPiece(srcPiece, new Position(srcPos));
        chessBoard.setPiece(opponentPiece, new Position(opponentPos));
        Move moveHorizontal = new Move(new Position(srcPos), new Position(dstPos));
        assertEquals(moveValidator.isValid(moveHorizontal, chessBoard), expectedResult);
    }
}

