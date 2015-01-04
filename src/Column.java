import java.util.*;


public class Column {
	
	ArrayList<Integer> nums;
	ArrayList<Integer> possibilities;
	
	public Column(){
		nums = new ArrayList<Integer>();
		for(int i = 1; i < 10; i++){
			nums.add(0);
			possibilities.add(i);
		}
	}
	
	public Column(ArrayList<Integer> indexes, ArrayList<Integer> numbers){
		nums = new ArrayList<Integer>();
		for(int i = 1; i < 10; i++){
			nums.add(0);
			possibilities.add(i);
		}
		for(int i = 0; i < indexes.size(); i++){
			insertNum(indexes.get(i), numbers.get(i));
		}
	}
	
	public boolean insertNum(int index, int num){
		if(possibilities.contains(num)){
			possibilities.remove(num);
			if(nums.get(index)==0){
				nums.add(index,num);
				return true;
			}
		}
		return false;
		
	}
}
