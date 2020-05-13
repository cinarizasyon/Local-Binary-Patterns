
public class Array {

	private int[] array;
	public Array(int length) {
		array = new int[length];
	}
	
	public Array(int[] firstValues) {
		array = new int[firstValues.length];
		for (int i = 0; i < firstValues.length; i++) {
			array[i] = firstValues[i];
		}
	}

	public int getValue(int index){
		return array[index];
	}
	
	public void setValue(int index,int value){
		array[index] = value;
	}
	
	public int getLength(){
		return array.length;
	}
	
	@Override
	public String toString(){
		String result = "";
		for (int i = 0; i < getLength(); i++) {
			result += getValue(i) + " ";
		}
		return result;
	}
}
