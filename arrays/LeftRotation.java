import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
    //naturally what makes sense: i --> i-d
    //need to wrap around for it to make sense (modulus)
    //modulus makes sure that the number is in the range of whatever you are dividng it by
    //if i modulus by 5, itll be some number between 0 and 4 no matter what
    //makes a perfect usage for staying in range
    //since we are modulusing by n, adding n doesnt actually do anything to the value for positive numbers, but makes sure that negative numbers are positive 
    //think about it -1 % 5 = -1 --> 4 % 5 = 4
    // 3 % 5 = 3 --> 8 % 5 = 3 (same thing)
    // d = 2
    //1 2 3 4 5 --> 3 4 5 1 2 
    //0 --> 3 2 --> 0
    // d = 4
    //1 2 3 4 5 --> 5 1 2 3 4 
    int[] gyat = new int[a.size()];
    for(int i = 0; i < a.size(); i++){
        int increment = ( i + a.size() - d ) % a.size();// ADDING n wraps the value AROUND the array for neg #, doesnt change for pos # cause the nature of modulus
        if(increment >= a.size()){
            increment = 0;
        }
        gyat[increment] = a.get(i);E
    }
    List<Integer> rotatedList = new ArrayList<>();
    for (int num : gyat) {
        rotatedList.add(num);
    }
    
    return rotatedList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.rotLeft(a, d);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
