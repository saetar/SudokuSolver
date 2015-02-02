import java.util.*;

public class Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
		ArrayList<int[]> clues = new ArrayList<int[]>();
		int[] clue1 = {0,0,3};
		int[] clue2 = {3,0,5};
		int[] clue3 = {4,0,1};
		int[] clue4 = {8,0,7};
		int[] clue5 = {0,1,5};
		int[] clue6 = {4,1,7};
		int[] clue7 = {1,2,8};
		int[] clue8 = {2,2,9};
		int[] clue9 = {3,2,4};
		int[] clue10 = {4,2,6};
		int[] clue11 = {5,2,3};
		int[] clue12 = {0,3,1};
		int[] clue13 = {1,3,3};
		int[] clue14 = {2,3,5};
		int[] clue15 = {6,3,7};
		int[] clue16 = {1,4,2};
		int[] clue17 = {3,4,1};
		int[] clue18 = {4,4,8};
		int[] clue19 = {5,4,7};
		int[] clue20 = {7,4,5};
		int[] clue21 = {2,5,8};
		int[] clue22 = {6,5,4};
		int[] clue23 = {7,5,2};
		int[] clue24 = {8,5,1};
		int[] clue25 = {3,6,7};
		int[] clue26 = {4,6,9};
		int[] clue27 = {5,6,4};
		int[] clue28 = {6,6,2};
		int[] clue29 = {7,6,3};
		int[] clue30 = {4,7,5};
		int[] clue31 = {8,7,6};
		int[] clue32 = {0,8,4};
		int[] clue33 = {4,8,2};
		int[] clue34 = {5,8,1};
		int[] clue35 = {8,8,9};
		clues.add(clue1);
		clues.add(clue2);
		clues.add(clue3);
		clues.add(clue4);
		clues.add(clue5);
		clues.add(clue6);
		clues.add(clue7);
		clues.add(clue8);
		clues.add(clue9);
		clues.add(clue10);
		clues.add(clue11);
		clues.add(clue12);
		clues.add(clue13);
		clues.add(clue14);
		clues.add(clue15);
		clues.add(clue16);
		clues.add(clue17);
		clues.add(clue18);
		clues.add(clue19);
		clues.add(clue20);
		clues.add(clue21);
		clues.add(clue22);
		clues.add(clue23);
		clues.add(clue24);
		clues.add(clue25);
		clues.add(clue26);
		clues.add(clue27);
		clues.add(clue28);
		clues.add(clue29);
		clues.add(clue30);
		clues.add(clue31);
		clues.add(clue32);
		clues.add(clue33);
		clues.add(clue34);
		clues.add(clue35);
		
		ArrayList<Integer> xCord = new ArrayList<Integer>();
		ArrayList<Integer> yCord = new ArrayList<Integer>();
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for(int i = 0; i < clues.size(); i++){
			xCord.add(clues.get(i)[1]);
			yCord.add(clues.get(i)[0]);
			vals.add(clues.get(i)[2]);
		}
		Board testBoard = new Board(xCord,yCord,vals);
		testBoard.print();
		System.out.println(testBoard.getColumnPiece(0,2).getPoss());
		//testBoard.solve();
		//board.print();
		//board.changePiece(0, 1, 1);
		//board.print();
		testBoard.print();
		
	}

}
