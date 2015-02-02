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
				int elementfinder = 3*withinY + withinX;
				squares.get(squarefinder).add(elementfinder, temp);
				//System.out.println(squares.get(squarefinder));
			}
		}
		
		//Sets values up
		for(int i = 0; i < posX.size(); i++){
			int x = posX.get(i);
			int y = posY.get(i);
			int num = nums.get(i);
			columns.get(x).get(y).setValue(num);
		}
		
		eliminate();
	}
	
	//TO ADD: If there is only one piece with a possibility, then that has to be the value.
	//Takes in arrayList of pieces and eliminates possibilities if there is a Piece with value
	public void eliminate(){
		for(int c = 0; c < 9; c++){
			ArrayList<Integer> setValues = new ArrayList<Integer>();
			ArrayList<Piece> list = columns.get(c);
			for(int i = 0; i < list.size(); i++){
				int val = list.get(i).value();
				if(val!=0){
					setValues.add(val);
				}
			}
			
			System.out.println(setValues);
			
			for(int i = 0; i < list.size(); i++){
				list.get(i).eliminatePossibility(setValues);
			}
			
			checkPoss(list);
			
			list = rows.get(c);
			for(int i = 0; i < list.size(); i++){
				int val = list.get(i).value();
				if(val!=0){
					setValues.add(val);
				}
			}
			
			System.out.println(setValues);
			
			for(int i = 0; i < list.size(); i++){
				list.get(i).eliminatePossibility(setValues);
			}
			
			checkPoss(list);
			
			list = squares.get(c);
			for(int i = 0; i < list.size(); i++){
				int val = list.get(i).value();
				if(val!=0){
					setValues.add(val);
				}
			}
			
			System.out.println(setValues);
			
			for(int i = 0; i < list.size(); i++){
				list.get(i).eliminatePossibility(setValues);
			}
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
		int elementfinder = 3*withinY + withinX;
		return squares.get(squarefinder).get(elementfinder);
	}
	
	public void print(){
		for(int x = 0; x < squares.size(); x++){
			for(int y = 0; y < squares.get(0).size(); y++){
				System.out.print("(" + getSquarePiece(x,y) + "," + getColumnPiece(x,y) + "," + getRowPiece(x,y) +  "),");
			}System.out.print("\n");
		}
		
	}
	
	public void changePiece(int x, int y, int val){
		columns.get(x).get(y).setValue(val);
	}
	
	public void checkPoss(ArrayList<Piece> question){
		for(int j = 1; j < 10; j++){
			ArrayList<Piece> satisfy = new ArrayList<Piece>();
			for(int i = 0; i < 9; i++){
				if(question.get(i).getPoss().contains(j)){
					satisfy.add(question.get(i));
				}
			}
			if(satisfy.size() == 1){
				System.out.println("Found one of size 1");
				satisfy.get(0).setValue(j);
			}
		}
	}
	
	public void solve(){
		eliminate();
		
		//If any piece's value is still 0, then try solving again.  
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(columns.get(i).get(j).value() == 0){
					solve();
				}
			}
		}
	}
}
