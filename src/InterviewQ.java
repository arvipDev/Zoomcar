import java.util.*;

public class InterviewQ {

    //Zoom interview questions

    public static void main(String[] args) {
        System.out.println(isBalanced("[{]}()"));
        System.out.println(isBalanced("(())({}){"));
        System.out.println(isBalanced("}(){[()}]{"));
        System.out.println(isBalanced("[{}()]"));
        System.out.println(isBalanced("(())({})"));

        int[] arr = new int[] {16, 1, -6, 7, -9, 12};
        getSolution(arr);

    }

    // Check if the given string of brackets are balanced.
    //[{]}() 
    //(())({}){
    //}(){[()}]{

    public static boolean isBalanced (String input){
        Stack<String> openBrackets = new Stack<>();
        List<String> oBrackets = new ArrayList<>();
        oBrackets.add("{");
        oBrackets.add("(");
        oBrackets.add("[");
        String currentBracket;
        Map<String, String> bracketPairs = new HashMap<>();
        bracketPairs.put("}", "{");
        bracketPairs.put(")", "(");
        bracketPairs.put("]", "[");

        for (int i = 0; i < input.length(); i++){
            currentBracket = String.valueOf(input.charAt(i));
            if (oBrackets.contains(currentBracket)){
                openBrackets.push(currentBracket);
            } else if (i > 0 && openBrackets.peek().equals(bracketPairs.get(currentBracket))){
                openBrackets.pop();
            } else return false;
        }
        return (openBrackets.size() == 0);
    }

    // Get the 2 integers from the given array, whose sum is closest to 0.
    //[-12, -4, -2, 6, 15, 20]
    //[16, 1, -5, 7, -9, 12]

    public static void getSolution (int[] values){
        Arrays.sort(values);
        // would use merge sort with O(NlogN) time complexity
        System.out.println(Arrays.toString(values));
        int tailPointer = values.length - 1;
        int smallestSum = 0;
        int headPointer = 0;

        smallestSum = values[headPointer] + values[tailPointer];
        tailPointer--;
        while (!(tailPointer == headPointer)){
            if (smallestSum > values[headPointer] + values[tailPointer] ){
                smallestSum = values[headPointer] + values[tailPointer];
                headPointer++;
            } else {
                tailPointer--;
            }
        }
        System.out.println(smallestSum);
    }

}
