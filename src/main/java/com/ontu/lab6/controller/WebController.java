package com.ontu.lab6.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.ontu.lab6.tictactoe.*;;

@Controller
public class WebController  
{
    @RequestMapping(value = "/index")
    public String index(Model model) 
    {
        TicTacToe game = new TicTacToe();
        game.Grid.SetO(2, 1);
        game.Grid.SetX(0, 0);
        game.Grid.SetO(1, 2);
        game.Grid.SetX(0,2);
        int[][] grid = game.Grid.GetGrid();
        for(int i = 0;i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[i][j] != 0){
                    model.addAttribute("cell" + i + j, grid[i][j] == 1 ? "X" : "O");
                }
                else{
                    model.addAttribute("cell" + i + j, "");
                }
            }
        }
        
        return "index";
    }

}