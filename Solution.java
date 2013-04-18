import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
/* Head ends here */
static void nextMove(String player, int[] pos, String [] board){
   //logic here
	int x, y;
    
    if(player.charAt(0) =='r') {
        x = pos[0];
	    y = pos[1];
    }
   
    else {
        x = pos[2];
	    y = pos[3];
    }
     
	if (board[x].charAt(y+1) == '-') 
		System.out.println("RIGHT");
		
    else {
    	if (board[x].charAt(y-1) == '-')
    		System.out.println("LEFT");
    	
    	else {
    		if (board[x-1].charAt(y) == '-')
    			System.out.println("UP");
            else 
            	if (board[x+1].charAt(y) == '-')
            		System.out.println("DOWN");
       }
    }

  }
/* Tail starts here */
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String player = in.next();
        String pos = in.next();
        String[] str_pos = pos.split(" ");
        int[] position = new int[4];
        int[] sizes = new int[2];

        for(int i=0;i<4;i++) {
            position[i] = Integer.parseInt(str_pos[i]);
        }
        pos = in.next();
        str_pos = pos.split(" ");
        for(int i=0;i<2;i++) {
            sizes[i] = Integer.parseInt(str_pos[i]);
        }

        String board[] = new String[sizes[ 0 ]];

        for(int i = 0; i < sizes[ 0 ]; i++) {
            board[i] = in.next();
        }

    nextMove(player,position,board);
    }
}