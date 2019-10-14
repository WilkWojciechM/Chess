package test;

import domain.ChessBoard;
import domain.Move;
import domain.Piece;
import domain.Position;
import logic.KingMoveValidator;
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
import static domain.PieceType.KING;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
@Category(ValidatorTests.class)
public class KingMoveValidatorTest {
    private ChessBoard chessBoard;
    private MoveValidator moveValidator;
    private static Piece whiteKing = new Piece(KING, WHITE);
    private static Piece blackKing = new Piece(KING, BLACK);

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
                {"C1", "C2", "C2", whiteKing, null, true,"move up without opponent"},
                {"B1", "C2", "C2", blackKing, null, true,"move orto without opponent"},
                {"E2","D2","D2",blackKing,whiteKing,true,"move with opponent on end location"},
                {"E2","D2","D2", blackKing,blackKing,false,"move l-shape when ally on end location"},
        });
    }

    @Before
    public void initializeBoard() {
        chessBoard = ChessBoard.getEmptyBoard();
        moveValidator = new KingMoveValidator();
    }

    @Test
    public void isValid_test() {
        chessBoard.setPiece(srcPiece, new Position(srcPos));
        chessBoard.setPiece(opponentPiece, new Position(opponentPos));
        Move moveHorizontal = new Move(new Position(srcPos), new Position(dstPos));
        assertEquals(moveValidator.isValid(moveHorizontal, chessBoard), expectedResult);
    }
}
