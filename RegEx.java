//Coding Platform: Ubuntu 17.10 & Eclipse Oxygen
/*
 * @author mohammodalemran
 */

package assignment.three;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class RegEx {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
 
        System.out.print("Enter the line: ");
        int inputLine = 0;
        try{
        inputLine = kb.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Please enter a number");
             
        }
        System.out.println(" ");
 
        ArrayList<String> input = new ArrayList<String>();
        String inputString;
 
        for (int i = 0; i < inputLine; i++) {
            System.out.print("Enter the string: ");
            inputString = kb.next();
            input.add(inputString);
            System.out.println(" ");
        }
 
        String[] result;
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < inputLine; i++) {
            output = checkString(input.get(i));
 
            if (output.get(0).equals("NA")) {
                System.out.println(input.get(i) + " is Not Accepted ");
                System.out.println();
            } else {
                System.out.println(input.get(i) + " is Accepted by Regular Expression : ");
                for (int j = 0; j < output.size(); j++) {
                    System.out.println(output.get(j) + " ");
                }
                System.out.println();
            }
        }
 
    }
 
    private static ArrayList<String> checkString(String s) {
        String[] result = new String[6];
        ArrayList<String> output = new ArrayList<String>();
        result[0] = ZeroOrMore(s);
 
        result[1] = OneOrMore(s);
 
        result[2] = OneOrNotAtAll(s);
 
        result[3] = CharaterClasses(s);
 
        result[4] = NegationOfCharacterClasses(s);
 
        result[5] = ExactlyNTimes(s);
        int na = 0;
        for (int i = 0; i < result.length; i++) {
            if (!(result[i].equals("NA"))) {
                output.add(result[i]);
            } else {
                na++;
            }
 
        }
 
        if (na == 6) {
            // output.clear();
            output.add("NA");
        }
 
        return output;
    }
 
    private static String ZeroOrMore(String s) {
        String result;
        boolean bc = true;
        boolean de = false;
 
        if (s.charAt(0) == 'a') {
 
            for (int i = 1; i <= s.length() - 2; i++) {
                if (s.charAt(i) == 'b' && s.charAt(i + 1) != 'c') {
                    bc = false;
                    i++;
                } else {
                    if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'c') {
                        bc = true;
                        i++;
                    }
                }
            }
 
            if (s.length() > 2) {
 
                int d = s.length() - 2;
                int e = d + 1;
 
                if (s.charAt(d) == 'd' && s.charAt(e) == 'e') {
                    de = true;
                } else {
                    de = false;
                }
            }
        }
 
        if (bc == true && de == true) {
            result = "a(bc)*de";
        } else {
            result = "NA";
        }
        return result;
    }
 
    private static String OneOrMore(String s) {
        String result;
        boolean bc = false;
        boolean de = false;
 
        if (s.charAt(0) == 'a') {
 
            for (int i = 1; i <= s.length() - 2; i++) {
                if (s.charAt(i) == 'b' && s.charAt(i + 1) != 'c') {
                    bc = false;
                    i++;
                } else {
                    if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'c') {
                        bc = true;
                        i++;
                    }
                }
            }
 
            if (s.length() > 1) {
                int d = s.length() - 2;
                int e = d + 1;
 
                if (s.charAt(d) == 'd' && s.charAt(e) == 'e') {
                    de = true;
                } else {
                    de = false;
                }
            }
        }
 
        if (bc == true && de == true) {
            result = "a(bc)+de";
        } else {
            result = "NA";
        }
        return result;
    }
 
    private static String OneOrNotAtAll(String s) {
        String result;
        boolean bc = true;
        boolean de = false;
 
        if (s.charAt(0) == 'a') {
 
            for (int i = 1; i <= s.length() - 2; i++) {
                if (s.charAt(i) == 'b' && s.charAt(i + 1) != 'c') {
                    bc = false;
                    i++;
                } else {
                    if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'c') {
                        if (i > 1) {
                            bc = false;
                        }
                        i++;
                    }
                }
            }
 
            if (s.length() > 1) {
                int d = s.length() - 2;
                int e = d + 1;
 
                if (s.charAt(d) == 'd' && s.charAt(e) == 'e') {
                    de = true;
                } else {
                    de = false;
                }
            }
        }
 
        if (bc == true && de == true) {
            result = "a(bc)?de";
        } else {
            result = "NA";
        }
        return result;
    }
 
    private static String CharaterClasses(String s) {
        String result;
        boolean alphabet = false;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 109) {
                alphabet = true;
            } else {
                alphabet = false;
                break;
            }
        }
 
        if (alphabet == true) {
            result = "[a-m]*";
        } else {
            result = "NA";
        }
 
        return result;
    }
 
    private static String NegationOfCharacterClasses(String s) {
        String result;
        boolean alphabet = false;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) == 97 || (int) s.charAt(i) == 101 || (int) s.charAt(i) == 105
                    || (int) s.charAt(i) == 111 || (int) s.charAt(i) == 117) {
                alphabet = false;
                break;
            } else {
                alphabet = true;
 
            }
        }
 
        if (alphabet == true) {
            result = "[^aeiou]*";
        } else {
            result = "NA";
        }
 
        return result;
    }
 
    private static String ExactlyNTimes(String s) {
        String result;
        boolean alphabet = false;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) == 97 || (int) s.charAt(i) == 101 || (int) s.charAt(i) == 105
                    || (int) s.charAt(i) == 111 || (int) s.charAt(i) == 117) {
                alphabet = false;
                break;
            } else {
                alphabet = true;
 
            }
        }
 
        if (s.length() == 6) {
            if (alphabet == true) {
                result = "[^aeiou]{6}";
            } else {
                result = "NA";
            }
        } else {
            result = "NA";
        }
 
        return result;
    }
 
}