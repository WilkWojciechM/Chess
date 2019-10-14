package domain;

import java.util.Objects;

public class Piece {
    Integer pieceId;
    PieceType type;
    PieceColor color;

    public Integer getPieceId() {
        return pieceId;
    }

    public void setPieceId(Integer pieceId) {
        this.pieceId = pieceId;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public Piece(PieceType type, PieceColor color){
        this.type = type;
        this.color = color;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece)o;
        return color == piece.color &&
                type == piece.type;
    }

    @Override
    public int hashCode() { return  Objects.hash(pieceId, type, color);}


}
