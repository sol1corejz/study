package com.company;

public class Main {

    public static void main(String[] args) {
        ChessboardPositions x = new ChessboardPositions();
        ChessboardPositions y = new ChessboardPositions();
        try{
            x = new ChessboardPositions(1, 1);
            System.out.println(x.toString());

            x.setX(7);
            System.out.println(x.toString());

        }catch (Exception e){
            System.out.println(e);
        }

        try{
            y = new ChessboardPositions(9, 8);
            System.out.println(y.toString());
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
