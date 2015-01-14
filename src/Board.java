import java.util.*;


public class Board {
	private ArrayList<ArrayList<Piece>> columns;
	private ArrayList<ArrayList<Piece>> rows;
	private ArrayList<ArrayList<Piece>> squares;
	
	public Board(){
		columns = new ArrayList<ArrayList<Piece>>(9);
		rows = new ArrayList<ArrayList<Piece>>(9);
		squares = new ArrayList<ArrayList<Piece>>(9);
		
		//Init all inner arraylists of pieces.
		for(int i = 0; i < 9; i++){
			ArrayList<Piece> array = new ArrayList<Piece>(9);
			columns.add(array);
		}
		
		for(int i = 0; i < 9; i++){
			ArrayList<Piece> array = new ArrayList<Piece>(9);
			rows.add(array);
		}
		
		for(int i = 0; i < 9; i++){
			ArrayList<Piece> array = new ArrayList<Piece>(9);
			squares.add(array);
		}
		
		for(int y = 0; y < 9; y++){
			for(int x = 0; x < 9; x++){
				Piece temp = new Piece();
				columns.get(x).add(y,temp);
				rows.get(y).add(x,temp);
				int squarefinder = (int)(3*Math.floor(y/3) + Math.floor(x/3));
				int withinX = x%3;
				int withinY = y%3;
				int elementfinder = (int)(3*Math.floor(withinY/3) + Math.floor(withinX/3));
				squares.get(squarefinder).add(elementfinder,temp);
			}
		}
		//System.out.println(columns.get(0));
	}
	
	//Takes in predetermined (x,y) coordinates for certain clues nums and makes pieces for board
	public Board(ArrayList<Integer> posX, ArrayList<Integer> posY, ArrayList<Integer> nums){
		columns = new ArrayList<ArrayList<Piece>>();
		rows = new ArrayList<ArrayList<Piece>>();
		squares = new ArrayList<ArrayList<Piece>>();
		
		Piece temp = new Piece();
		for(int i = 0; i < 9; i++){
			ArrayList<Piece> array = new ArrayList<Piece>();
			for(int j = 0; j < 9; j++){
				array.add(temp);
			}
			columns.add(array);
			rows.add(array);
			squares.add(array);
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
	
	public void print(){
		for(int i = 0; i < columns.size(); i++){
			System.out.println(columns.get(i));
		}
	}
	
	public void changePiece(int x, int y, int val){
		columns.get(x).get(y).setValue(val);
	}
}
