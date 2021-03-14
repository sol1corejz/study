package com.company;

import java.util.Objects;

public class ChessboardPositions {

    private int x;
    private int y;

    public ChessboardPositions(int x, int y) throws IllegalArgumentException {

            if (x >= 0 && x < 8 && y >= 0 && y < 8){
                this.x = x;
                this.y = y;
            }
            else {
                throw new IllegalArgumentException("Введеные некорректыне данные! Диапазон координат от 0 до 7!");
            }
    }

    public ChessboardPositions(){
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) throws IllegalArgumentException{
            if (x >= 0 && x < 8) {
                this.x = x;
            }
            else{
                throw new IllegalArgumentException("Введеные некорректыне данные! Диапазон координат от 0 до 7!");
            }
    }

    public void setY(int y) throws IllegalArgumentException{
            if (y >= 0 && y < 8){
                this.y = y;
            }
            else {
                throw new IllegalArgumentException("Введеные некорректыне данные! Диапазон координат от 0 до 7!");
            }
    }

    @Override
    public String toString() {
        return (char)(x+97)+""+(Number)(y+1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPositions that = (ChessboardPositions) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
