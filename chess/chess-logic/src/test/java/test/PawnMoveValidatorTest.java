package test;

import domain.ChessBoard;
import domain.Move;
import domain.Piece;
import domain.Position;
import logic.MoveValidator;
import logic.PawnMoveValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static domain.PieceColor.BLACK;
import static domain.PieceColor.WHITE;
import static domain.PieceType.PAWN;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
@Category(ValidatorTests.class)
public class PawnMoveValidatorTest {
    private ChessBoard chessBoard;
    private MoveValidator moveValidator;
    private static Piece whitePawn = new Piece(PAWN, WHITE);
    private static Piece blackKPawn = new Piece(PAWN, BLACK);

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
                {"C2", "C4", "C4", whitePawn, null, true,"move up without opponent first move"},
                {"B7", "B5", "B5", blackKPawn, null, true,"move straight without opponent first move"},
                {"B7","A6","A6",blackKPawn,whitePawn,true,"move beating"},
                {"E2","F3","F3", blackKPawn,blackKPawn,false,"move beating ally"},
        });
    }

    @Before
    public void initializeBoard() {
        chessBoard = ChessBoard.getEmptyBoard();
        moveValidator = new PawnMoveValidator();
    }

    @Test
    public void isValid_test() {
        chessBoard.setPiece(srcPiece, new Position(srcPos));
        chessBoard.setPiece(opponentPiece, new Position(opponentPos));
        Move moveHorizontal = new Move(new Position(srcPos), new Position(dstPos));
        assertEquals(moveValidator.isValid(moveHorizontal, chessBoard), expectedResult);
    }
}
