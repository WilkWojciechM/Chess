package logic;

import domain.ChessBoard;
import domain.Move;
import domain.Position;

public class ClearPathValidator implements MoveValidator {
    @Override
    public boolean isValid(Move move, ChessBoard chessBoard) {
        Position checkingPosition = new Position(move.getFromPosition().getRow(),move.getFromPosition().getColumn());
        int rowMovement = 0;
        int columnMovement = 0;

        if (move.horizontalShift() > 0) {
            columnMovement = 1;
        } else if (move.horizontalShift() < 0) {
            columnMovement = -1;
        }

        if (move.verticalShift() > 0) {
            rowMovement = 1;
        } else if (move.verticalShift() < 0) {
            rowMovement = -1;
        }

        checkingPosition.setRow(checkingPosition.getRow() + rowMovement);
        checkingPosition.setColumn(checkingPosition.getColumn() + columnMovement);

        while (move.getToPosition().getRow() != checkingPosition.getRow() || move.getToPosition().getColumn() != checkingPosition.getColumn()) {

            if (chessBoard.getPiece(checkingPosition) != null) {
                return false;
            }
            checkingPosition.setRow(checkingPosition.getRow() + rowMovement);
            checkingPosition.setColumn(checkingPosition.getColumn() + columnMovement);
        }
        return true;
    }
}
//
//        if (move.horizontalShift() == 0) {
//            if (move.verticalShift() > 0) {
//                for (int j = move.getFromPosition().getRow() + 1; j < move.getToPosition().getRow(); j++) {
//                    checkingPosition.setColumn(move.getFromPosition().getColumn());
//                    checkingPosition.setRow(j);
//
//                }
//            }
//            if (move.verticalShift() < 0) {
//                for (int j = move.getFromPosition().getRow() - 1; j > move.getToPosition().getRow(); j--) {
//                    checkingPosition.setColumn(move.getFromPosition().getColumn());
//                    checkingPosition.setRow(j);
//                    if (chessBoard.getPiece(checkingPosition) != null) {
//                        return false;
//                    }
//                }
//            }
//        }
//        if (move.verticalShift() == 0) {
//            if (move.horizontalShift() < 0) {
//                for (int i = move.getFromPosition().getColumn() - 1; i > move.getToPosition().getColumn(); i--) {
//                    checkingPosition.setColumn(i);
//                    checkingPosition.setRow(move.getFromPosition().getRow());
//                    if (chessBoard.getPiece(checkingPosition) != null) {
//                        return false;
//                    }
//                }
//            }
//            if (move.horizontalShift() > 0) {
//                for (int i = move.getFromPosition().getColumn() + 1; i < move.getToPosition().getColumn(); i++) {
//                    checkingPosition.setColumn(i);
//                    checkingPosition.setRow(move.getFromPosition().getRow());
//                    if (chessBoard.getPiece(checkingPosition) != null) {
//                        return false;
//                    }
//
//                }
//            }
//        }
//        return true;
//    }
//
//    public boolean clearPath(Move move, ChessBoard chessBoard) {
//        Position positionTemp = move.getFromPosition();
//        int j = move.getFromPosition().getRow();
//
//        if (move.horizontalShift() > 0) {
//            if (move.verticalShift() > 0) {
//                for (int i = move.getFromPosition().getColumn() + 1; i < move.getToPosition().getColumn(); i++) {
//                    positionTemp.setColumn(i);
//                    positionTemp.setRow(i);
//                    if (chessBoard.getPiece(positionTemp) != null) {
//                        return false;
//                    }
//                }
//            }
//            if (move.verticalShift() < 0) {
//
//                for (int i = move.getFromPosition().getColumn() + 1; i < move.getToPosition().getColumn(); i++) {
//                    j--;
//                    positionTemp.setColumn(i);
//                    positionTemp.setRow(j);
//                    if (chessBoard.getPiece(positionTemp) != null) {
//                        return false;
//                    }
//                }
//            }
//        }
//        if (move.horizontalShift() < 0) {
//            if (move.verticalShift() > 0) {
//                for (int i = move.getFromPosition().getColumn() - 1; i > move.getToPosition().getColumn(); i--) {
//                    j++;
//                    positionTemp.setColumn(i);
//                    positionTemp.setRow(j);
//                    if (chessBoard.getPiece(positionTemp) != null) {
//                        return false;
//                    }
//
//                }
//            }
//            if (move.verticalShift() < 0) {
//                for (int i = move.getFromPosition().getColumn() - 1; i > move.getToPosition().getColumn(); i--) {
//                    positionTemp.setColumn(i);
//                    positionTemp.setRow(i);
//                    if (chessBoard.getPiece(positionTemp) != null) {
//                        return false;
//                    }
//
//                }
//            }
//        }


