/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic.tac.toe;

/**
 *
 * @author Shino
 */
public class Block {
    private int val;
    private char stat;
    
    public Block(){
        val = 0;
    }
    public char getBlock(){
        return stat;
    }
    public int getBlockVal(){
        return val;
    }
    public void setBlock(int val){
        this .val = val;
        switch(val){
            case -1:
                stat = 'O';
                break;
            case 0:
                stat = '\u2205';
                break;
            case 1:
                stat = 'X';
                break;
        }
    }
    
}
