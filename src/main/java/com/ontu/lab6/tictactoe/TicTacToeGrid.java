package com.ontu.lab6.tictactoe;

public class TicTacToeGrid{
    private int[][] Grid = new int[3][3];

    public int[][] GetGrid(){
        return Grid;
    }

    public void SetX(int x, int y){
        Grid[x][y] = 1;
    }

    public void SetO(int x, int y){
        Grid[x][y] = 2;
    }

    public void CheckWin(){
        int wonSign = 0;
        
        if  (Grid[0][0] == Grid[1][0] && Grid[1][0] == Grid[2][0])      wonSign = Grid[0][0];
        else if (Grid[0][1] == Grid[1][1] && Grid[1][1] == Grid[2][1])  wonSign = Grid[0][1];
        else if (Grid[0][2] == Grid[1][2] && Grid[1][2] == Grid[2][2])  wonSign = Grid[0][2];

        else if (Grid[0][0] == Grid[0][1] && Grid[0][1] == Grid[0][2])  wonSign = Grid[0][0];
        else if (Grid[1][0] == Grid[1][1] && Grid[1][1] == Grid[1][2])  wonSign = Grid[1][0];
        else if (Grid[2][0] == Grid[2][1] && Grid[2][1] == Grid[2][2])  wonSign = Grid[2][0];

        else if (Grid[0][0] == Grid[1][1] && Grid[1][1] == Grid[2][2])  wonSign = Grid[0][0];
        else if (Grid[0][2] == Grid[1][1] && Grid[1][1] == Grid[2][0])  wonSign = Grid[0][2];
        
        if(wonSign == 1)      WinX();
        else if(wonSign == 2) WinO();
    }

    public void WinX(){
        System.out.println("First Player Win");
    }

    public void WinO(){
        System.out.println("Second Player Win");
    }

}