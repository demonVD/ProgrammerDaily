// Sorting Elements of an Array by Frequency 
class Solution{
	public void sortAccToFrequency(int[] arr){
		HashMap<Integer, Integer> frequencyValue = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(frequencyValue.containsKey(arr[i])){
				frequencyValue.put(arr[i], ++frequencyValue.get(arr[i])); 
			}
			else{
				frequencyValue.put(arr[i], 1);
			}
		}
		
	}
}
class Practice57{
	public static void main(String[] args) {
		
	}
}