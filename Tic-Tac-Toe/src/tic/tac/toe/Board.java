/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic.tac.toe;

/**
 *
 * @author Shino
 */
public class Board extends Block{
    private Block [][] game = new Block[3][3];
    private int empties  = 9;
    private int[] le = {0,0};
    private boolean full = false;
    //private int emptyX;
    //private int emptyY;
    
    Board(){//row,coulumn
        for(int x = 0;x<game.length;x++){
            for(int y =0;y<game[x].length;y++){
                game[x][y] = new Block();
                game[x][y].setBlock(0);
            }
        }
    }
    public void printBoard(){
        for(int x = 0;x<game.length;x++){
            System.out.print("|");
            for(int y =0;y<game[x].length;y++){
                //System.out.print(x+" "+ y+" | ");
                System.out.print(game[x][y].getBlock()+"|");
            }
            System.out.println("");
        }
    }
    public boolean isEmpty(){
        for(int x = 0;x< game.length;x++){
            for(int y = 0; y< game[x].length;y++){
                if(game[x][y].getBlockVal() != 0){
                    System.out.println("Is not Empty");
                    return true;
                }
            }
        }
        System.out.println("is empty");
        return false;
    }
    public int[] findNearestEmpty(){
        if(empties > 0){
            for(int x = 0;x< game.length;x++){
                for(int y = 0; y< game[x].length;y++){ 
                    if(game[x][y].getBlockVal() == 0){
                        le[0]=x;
                        le[1]=y;
                        return(le);
                    } 
                }
            }
        }
        else if(empties == 0){
            full = true;
            System.out.println("Board Full");
            return(le);
        }
        return(null);
    }
    public boolean getWinner(){
        String winner = " is the winner.";
        /*
        find the winner
        can we loop it
        maybe 
        if we look for each area from a point we can determine the winner
        000
        000
        000
        think we have this 
        how do we find this
        X00
        0X0
        00X
        recursion?
        find a point if that point findwinner(coordinate)
        coordinate same find winner coordinate must 
        X->
        
        return -1 if O wins
        return 0 if there is no winner 
        return 1 if X wins
        */
        for(int i =0;i<game.length;i++){
            if(game[i][0].getBlockVal() ==(game[i][1].getBlockVal())&&(game[i][0].getBlockVal() == (game[i][2].getBlockVal()))){
                if(game[i][0].getBlockVal() != 0){
                    //System.out.println(game[i][0].getBlock()+winner);
                    return true;
                }  
            }
        }
        for(int i =0;i<game[0].length;i++){
            if(game[0][i].getBlockVal() == (game[1][i].getBlockVal())&&(game[0][i].getBlockVal() == (game[2][i]).getBlockVal())){//logic error when th for loop starts all i willbe zero it is basically comparing itself
                if(game[0][i].getBlockVal() != 0){
                    //System.out.println(game[0][i].getBlock()+winner);
                    return true;
                }
            }
        }
        if(game[0][0].getBlockVal() == (game[1][1].getBlockVal())&&(game[0][0].getBlockVal() == (game[2][2]).getBlockVal())){
            if(game[1][1].getBlockVal() != 0){
                //System.out.println(game[0][0].getBlock()+winner);
                return true;
            }
        }
        if(game[1][1].getBlockVal() == (game[0][2].getBlockVal())&&(game[1][1].getBlockVal() == (game[2][0].getBlockVal()))){
            if(game[1][1].getBlockVal() != 0){
                //System.out.println(game[1][1].getBlock()+winner);
                return true;
            }
        }
        //System.out.println("There is no winner.");
        return false;
        
    }
    public boolean findWinner(){
        String winner = " is the winner.";
        for(int i =0;i<game.length;i++){
            if(game[i][0].getBlockVal() ==(game[i][1].getBlockVal())&&(game[i][0].getBlockVal() == (game[i][2].getBlockVal()))){
                if(game[i][0].getBlockVal() != 0){
                    System.out.println(game[i][0].getBlock()+winner);
                    return true;
                }  
            }
        }
        for(int i =0;i<game[0].length;i++){
            if(game[0][i].getBlockVal() == (game[1][i].getBlockVal())&&(game[0][i].getBlockVal() == (game[2][i]).getBlockVal())){//logic error when th for loop starts all i willbe zero it is basically comparing itself
                if(game[0][i].getBlockVal() != 0){
                    System.out.println(game[0][i].getBlock()+winner);
                    return true;
                }
            }
        }
        if(game[0][0].getBlockVal() == (game[1][1].getBlockVal())&&(game[0][0].getBlockVal() == (game[2][2]).getBlockVal())){
            if(game[1][1].getBlockVal() != 0){
                System.out.println(game[0][0].getBlock()+winner);
                return true;
            }
        }
        if(game[1][1].getBlockVal() == (game[0][2].getBlockVal())&&(game[1][1].getBlockVal() == (game[2][0].getBlockVal()))){
            if(game[1][1].getBlockVal() != 0){
                System.out.println(game[1][1].getBlock()+winner);
                return true;
            }
        }
        System.out.println("There is no winner.");
        return false;
        
    }
    public void setBlock(int val,int x, int y){
        game[x][y].setBlock(val);
        empties--;
        //System.out.printf("%c goes at %2d, %d \n",game[x][y].getBlock(),x,y);
    }
    public char getBlock(int x,int y){
        return game[x][y].getBlock();
    }
    public int getBlockVal(int x,int y){
        return game[x][y].getBlockVal();
    }
    public int getEmpties(){
        return empties;
    }
    public int[] getLE(){   
        return le;
    }
    public boolean isFull(){
        if(full == true){
            System.out.println("Board Full");
        }
        return full;
    }
    public void printLe(){
        System.out.printf("Last Empty at %d, %d\n",le[0],le[1]);
    }
}
