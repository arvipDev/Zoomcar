import java.util.*;

public class InterviewQ {

    //Zoom interview questions

    public static void main(String[] args) {
        System.out.println(isBalanced("[{]}()"));
        System.out.println(isBalanced("(())({}){"));
        System.out.println(isBalanced("}(){[()}]{"));
        System.out.println(isBalanced("[{}()]"));
        System.out.println(isBalanced("(())({})"));

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

}
