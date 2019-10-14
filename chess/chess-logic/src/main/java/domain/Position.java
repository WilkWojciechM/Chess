package domain;

import commons.InvalidPositionString;

public class Position {

    private int row, column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    public Position(String position){
        char[] coords = position.toUpperCase().toCharArray();
        column = coords[0] - 'A';
        row = coords[1]-'0'-1;
        if(column < 0 || column > 7 || row < 0 || row > 7){
            throw new InvalidPositionString();
        }


    }


}
