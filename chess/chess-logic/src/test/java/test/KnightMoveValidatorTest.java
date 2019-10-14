package test;

import domain.ChessBoard;
import domain.Move;
import domain.Piece;
import domain.Position;
import logic.KnightMoveValidator;
import logic.MoveValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static domain.PieceType.KNIGHT;
import static domain.PieceColor.BLACK;
import static domain.PieceColor.WHITE;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
@Category(ValidatorTests.class)
public class KnightMoveValidatorTest {
    private ChessBoard chessBoard;
    private MoveValidator moveValidator;
    private static Piece whiteKnight = new Piece(KNIGHT, WHITE);
    private static Piece blackKnight = new Piece(KNIGHT, BLACK);

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
                {"C1", "C2", "B3", whiteKnight, null, true,"move l-shape without opponent"},
                {"G8", "G7", "F6", blackKnight, null, true,"move l-shape without opponent"},
                {"E1","F3","F3",blackKnight,whiteKnight,true,"move l-shape with opponent on end location"},
                {"E1","D3","D3", blackKnight,blackKnight,false,"move l-shape when ally on end location"},
        });
    }

    @Before
    public void initializeBoard() {
        chessBoard = ChessBoard.getEmptyBoard();
        moveValidator = new KnightMoveValidator();
    }

    @Test
    public void isValid_test() {
        chessBoard.setPiece(srcPiece, new Position(srcPos));
        chessBoard.setPiece(opponentPiece, new Position(opponentPos));
        Move moveHorizontal = new Move(new Position(srcPos), new Position(dstPos));
        assertEquals(moveValidator.isValid(moveHorizontal, chessBoard), expectedResult);
    }

}
