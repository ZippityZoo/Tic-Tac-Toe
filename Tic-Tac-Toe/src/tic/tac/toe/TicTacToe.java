/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tic.tac.toe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
        cpuDitto(newGame);
    }
    public static int[] randomX(Board game){
        int x = (int)(Math.random()*3);
        int y = (int)(Math.random()*3);
        int [] randx = new int[2];
        if(game.getBlockVal(x, y) != 0){ 
            //game.printLe();
            randx = game.findNearestEmpty();
            return randx;    
        }
        randx[0]=x;randx[1] =y;
        return randx;
    }
    public static int[] randomO(Board game){
        int x = (int)Math.random()*3;
        int y = (int)Math.random()*3;
        int [] rando = new int[2];
        if(game.getBlockVal(x, y) != 0){
            rando = game.findNearestEmpty();
            return rando;    
        }
        rando[0] = x;rando[1] = y;
        return rando;
    }
    public static void cpuDitto(Board game){
        int turn = 0;
        int [] current = new int[2];
        while(!game.getWinner()||game.getEmpties() != 0){
            
            current = randomX(game);
            System.out.println("Turn "+turn + "\nX's turn\n");
            game.setBlock(1, current[0], current[1]);
            //System.out.println(game.getEmpties());
            game.printBoard();
            if(game.findWinner()||game.getEmpties() == 0){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
            System.out.println("\n\nO's turn\n");
            current = randomO(game);
            game.setBlock(-1,current[0],current[1]);
            //System.out.println(game.getEmpties());
            game.printBoard();
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(game.findWinner()||game.getEmpties() == 0){
                break;
            }
            turn++;
        }
    }
}
