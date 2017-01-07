/*
3 0 4 0
0 1 0 3
2 3 0 0
1 0 0 2
*/
import java.util.*;
public class CadidateCode {
	//public static 
	public static void main(String[] args) {
		int[][] sudoku = new int[4][4];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				sudoku[i][j] = sc.nextInt();
			}
		}
		sc.close();
		if(isFull(sudoku))
			printSudoku(sudoku);
	}
	
	public static void checkPossibleValues(int[][] sud) {
		int x=0,y=0;
		outer:
		for(int i=0;i<sud.length;i++) {
			for(int j=0;j<sud.length;j++) {
				if(sud[i][j]==0) {
					//System.out.println("i: "+i+",j: "+j);
					x=i;
					y=j;
					break outer;
				}
			}
		}
		//System.out.println(x+" "+y);
		int[] possibleValues = new int[5];
		for(int i=1;i<possibleValues.length;i++)
			possibleValues[i]=0;
		//row validation
		for(int i=0;i<sud.length;i++) {
			if(sud[x][i]!=0)
				possibleValues[sud[x][i]] = 1;
		}
		//column validation
		for(int i=0;i<sud.length;i++) {
			if(sud[i][y]!=0)
				possibleValues[sud[i][y]] = 1;
		}
		/*System.out.println("Possible Values : ");
		for(int i=1;i<possibleValues.length;i++)
			System.out.print(possibleValues[i]+" ");*/
		System.out.println();
		for(int i=1;i<possibleValues.length;i++) {
			if(possibleValues[i]==0)
				sud[x][y] = i;
		}
		isFull(sud);
		
	}
	public static void printSudoku(int[][] x) {
		//print sudoku
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<4;j++) {
				if(j==3)
					System.out.print(x[i][j]);
				else System.out.print(x[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean isFull(int[][] sudoku) {
		for(int i=0;i<sudoku.length;i++) {
			for(int j=0;j<sudoku.length;j++) {
				if(sudoku[i][j]==0) {
					checkPossibleValues(sudoku);
				}
			}
		}
		return true;
	}

}
