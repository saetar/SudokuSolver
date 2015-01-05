import java.util.ArrayList;

public class Piece {
	
	int value;
	ArrayList<Integer> possibilities;
	
	public Piece(){
		value = 0;
		possibilities = new ArrayList<Integer>();
		for(int i = 1; i <= 9; i++){
			possibilities.add(i);
		}
	}
	
	public ArrayList<Integer> getPoss(){
		return possibilities;
	}
	
	public void setValue(int val){
		value = val;
		possibilities.clear();
	}
	
	public void eliminatePossibility(ArrayList<Integer> pos){
		possibilities.remove(pos);
	}
	
	public int value(){
		return value;
	}
	
	public void syncPiece(Piece p){
		possibilities.remove(p.getPoss());
	}
	
}
