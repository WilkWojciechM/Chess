package domain;

public class Move {

    private Position fromPosition;
    private Position toPosition;

    public Position getFromPosition() {
        return fromPosition;
    }

    public void setFromPosition(Position fromPosition) {
        this.fromPosition = fromPosition;
    }

    public Position getToPosition() {
        return toPosition;
    }

    public void setToPosition(Position toPosition) {
        this.toPosition = toPosition;
    }

    public Move(Position fromPosition, Position toPosition) {
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
    }

    public int verticalShift() { return  toPosition.getRow() - fromPosition.getRow();}

    public int horizontalShift() {return toPosition.getColumn() - fromPosition.getColumn();}

    @Override
    public String toString() {
        return "Move{" +
                "fromPosition=" + fromPosition +
                ", toPosition=" + toPosition +
                '}';
    }
}
