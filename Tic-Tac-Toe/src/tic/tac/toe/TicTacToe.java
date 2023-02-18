/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tic.tac.toe;

//import java.awt.Canvas;
/**
 *
 * @author Shino
 */
public class TicTacToe {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board newGame = new Board();
        System.out.println(newGame.getEmpties());
        //newGame.setBlock(1, 0, 0);newGame.setBlock(1, 1, 0);newGame.setBlock(1, 0, 2);
        //newGame.setBlock(-1, 1, 1);newGame.setBlock(-1, 0, 1);newGame.setBlock(-1, 2, 1);
        //newGame.findNearestEmpty();
        //System.out.println(newGame.getEmptyX()+" "+newGame.getEmptyY());
        //newGame.printBoard();
        //newGame.findWinner();
        //System.out.println(newGame.getEmpties());
        //newGame.isEmpty();  
        cpuDitto(newGame);
    }
    public static int[] randomX(Board game){
        int x = (int)(Math.random()*3);
        int y = (int)(Math.random()*3);
        int [] randx = new int[2];
        if(game.getBlockVal(x, y) != 0){ 
            game.findNearestEmpty();
            randx = game.getLE();
            return randx;    
        }
        return randx;
    }
    public static int[] randomO(Board game){
        int x = (int)Math.random()*3;
        int y = (int)Math.random()*3;
        int [] randO = new int[2];
        if(game.getBlockVal(x, y) != 0){ 
            game.findNearestEmpty();
            randO = game.getLE();
            return randO;    
        }
        return randO;
    }
    public static void cpuDitto(Board game){
        int [] current = new int[2];
        while(!game.findWinner()||game.getEmpties() != 0){
            current = randomX(game);
            System.out.println("X's turn");
            game.setBlock(1, current[0], current[1]);
            game.printBoard();
            System.out.println("-------------");
            if(game.findWinner()||game.getEmpties() == 0)
                break;
            System.out.println("\n\nO's turn");
            current = randomO(game);
            game.setBlock(-1,current[0],current[1]);
            game.printBoard();
        }
    }
}
