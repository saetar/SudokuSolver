import java.util.ArrayList;

public class Piece {
	
	private int value;
	private ArrayList<Integer> possibilities;
	
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
		//System.out.println("Eliminating possibilities");
		possibilities.remove(pos);
		if(possibilities.size()==1){
			//Setting value
			value = possibilities.get(0);
			System.out.println("Setting value: " + value );
		}
	}
	
	public int value(){
		return value;
	}
	
	public String toString(){
		return value + "";
	}
	
}
