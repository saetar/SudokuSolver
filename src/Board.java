import java.util.*;

public class Board {
	private ArrayList<ArrayList<Piece>> columns;
	private ArrayList<ArrayList<Piece>> rows;
	private ArrayList<ArrayList<Piece>> squares;
	
	public Board(){
		Piece temp = new Piece();
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				columns.get(i).add(temp);
				rows.get(i).add(temp);
				squares.get(i).add(temp);
			}
		}
		columns = new ArrayList<ArrayList<Piece>>();
		rows = new ArrayList<ArrayList<Piece>>();
		squares = new ArrayList<ArrayList<Piece>>();
	}
	
	//Takes in predetermined (x,y) coordinates for certain clue nums and makes pieces for board
	public Board(ArrayList<Integer> posX, ArrayList<Integer> posY, ArrayList<Integer> nums){
		columns = new ArrayList<ArrayList<Piece>>();
		rows = new ArrayList<ArrayList<Piece>>();
		squares = new ArrayList<ArrayList<Piece>>();
		
		Piece temp = new Piece();
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				columns.get(i).add(temp);
				rows.get(i).add(temp);
				squares.get(i).add(temp);
			}
		}
		
		//Sets values up and synchronizes all lists to match
		for(int i = 0; i < posX.size(); i++){
			columns.get(posX.get(i)).get(posY.get(i)).setValue(nums.get(i));
			rows.get(posY.get(i)).get(posX.get(i)).setValue(nums.get(i));
			int squarefinder = (int)(3*Math.floor(posY.get(i)/3) + Math.floor(posX.get(i)/3));
			int withinX = posX.get(i)%3;
			int withinY = posY.get(i)%3;
			int elementfinder = (int)(3*Math.floor(withinY/3) + Math.floor(withinX/3));
			squares.get(squarefinder).get(elementfinder).setValue(nums.get(i));
		}
		
	}
	
	//Takes in arrayList of pieces and eliminates possibilities if there is a Piece with value
	public void eliminate(ArrayList<Piece> list){
		ArrayList<Integer> setValues = new ArrayList<Integer>();
		
		for(int i = 0; i < list.size(); i++){
			int val = list.get(i).value();
			if(val!=0) setValues.add(val);
		}
		
		for(int i = 0; i < list.size(); i++){
			list.get(i).eliminatePossibility(setValues);
		}
	}
	
	public Piece getColumnPiece(int xCord, int yCord){
		return columns.get(xCord).get(yCord);
	}
	
	public Piece getRowPiece(int xCord, int yCord){
		return rows.get(yCord).get(xCord);
	}
	
	public Piece getSquarePiece(int xCord, int yCord){
		int squarefinder = (int)(3*Math.floor(yCord/3) + Math.floor(xCord/3));
		int withinX = xCord%3;
		int withinY = yCord%3;
		int elementfinder = (int)(3*Math.floor(withinY/3) + Math.floor(withinX/3));
		return squares.get(squarefinder).get(elementfinder);
	}
}
