import java.util.*;

class FindCombination
{
  static long count = 0;

  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    final String num = sc.next();
    calculatePossibleCombinations(num);
    System.out.println(count);
  }

private static void calculatePossibleCombinations(String number){
  char[] input = number.toCharArray();
  char[] output = new char[1000];
  getCombinations(input, 0, output, 0);
}

private static void getCombinations(char[] input,
							int index,
							char[] output,
							int outLength)
{
	// no more digits left in input string
	if (input.length == index)
	{
		// print output string & return
		System.out.println(String.valueOf(output));
    if(checkValidString(String.valueOf(output)))
      count++;
		return;
	}

	// place current digit in input string
	output[outLength] = input[index];

	// separate next digit with a space
	output[outLength + 1] = ' ';

	getCombinations(input, index + 1, output,
								outLength + 2);

	// if next digit exists make a
	// call without including space
	if(input.length!=index + 1)
	getCombinations(input, index + 1, output,
								outLength + 1);
}

//checks if the string is a valid combination of numbers:
//-numbers are in range of alphabet
//-removes trailing whitespaces
private static boolean checkValidString(String inp){
  inp= inp.trim();
  String[] arr = inp.split("\\s+");

  //only one digit in string
  if(arr.length == 1){
    long currNum = Long.parseLong(arr[0]);
    if(currNum> 0 && currNum<27)
      return true;
  } else if(arr.length>1){
    for(String str : arr){
      long currNum = Long.parseLong(str);
      if(currNum<0 || currNum>26)
        return false;
    }
    return true;
  }
  return false;
}

}