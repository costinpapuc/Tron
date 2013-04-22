import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
	/* Head ends here */
	static int directie = 2;

	static void nextMove(String player, int[] pos, String [] board) {
		//logic here
		int x, y, s, ss;
		if(player.charAt(0) =='r') {
			x = pos[0];
			y = pos[1];
			s = pos[2];
			ss = pos[3]; 
		}

		else {
			x = pos[2];
			y = pos[3];
			s = pos[0];
			ss = pos[1];
		}

		int p = cauta(x, y, x, y, s, ss, board);

		switch(directie) {
		case 0: System.out.println("UP"); break;
		case 1: System.out.println("RIGHT"); break;
		case 2: System.out.println("DOWN"); break;
		case 3: System.out.println("LEFT"); break;
		}

	}


	static String[] copie(String[] board) {
		String[] aux = new String[board.length];

		for (int i = 0; i < board.length; i++) {
			aux[i] = board[i];
		}

		return aux;
	}

	//o functie
	static int cauta(int x, int y, int p, int q, int s, int ss, String [] board) {
		int max = 0;
		String[] boardAux;
		char[] boardAuxChars;
		int xx, yy, aux;

		for (int i = 0; i < 4; i++) {
			xx = x; 
			yy = y;

			switch(i) {
			case 0: xx--; break;
			case 1: yy++; break;
			case 2: xx++; break;
			case 3: yy--; break;
			}

			if (!((xx+2 == s && yy == ss) || (xx-2 == s && yy == ss) || (xx == s && yy+2 == ss) || (xx == s && yy-2 == ss))) {
				if (board[xx].charAt(yy) == '-') {
					boardAux = board;
					boardAuxChars = boardAux[xx].toCharArray();
					boardAuxChars[yy] = '#';
					boardAux[xx] = String.valueOf(boardAuxChars);
					aux = 1 + cauta(xx,yy,p,q,s,ss,boardAux);

					if (max < aux) {
						max = aux;
						if (x == p && y == q)
							directie = i;

					}
				} 
			}
		}

		return max;
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