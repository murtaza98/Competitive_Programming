/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **
ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.
**/


public class Solution {
    public String convert(String A, int B) {
        if(A.length() < 3 || B == 1){
            return A;
        }
        int[] upper = new int[B];
        int[] lower = new int[B];
        
        for(int i = 0; i < B;i++){
            int upper_rows = i;
            int lower_rows = B - i - 1;
            
            if(i != 0){
                upper[i] = upper_rows * 2 - 1;   
            }
            if(i != B-1){
                lower[i] = lower_rows * 2 - 1;
            }
        }
        
        // System.out.println(Arrays.toString(upper));
        // System.out.println(Arrays.toString(lower));
        
        String zigzag = "";
        
        for(int i = 0;i < B;i++){
            int j = i;
            boolean down = true;
            // check if its last row, n if yes then set direction to up
            if(i == B-1){
                down = false;
            }
            while(j < A.length()){
                zigzag += A.charAt(j);
                // System.out.println(A.charAt(j));
                if(down){
                    if(lower[i] != 0){
                        j += lower[i]+1;
                    }
                    if(upper[i] != 0){
                        down = false;    
                    }
                }else{
                    if(upper[i] != 0){
                        j += upper[i]+1;
                    }
                    if(lower[i] != 0){
                        down = true;    
                    }
                }    
            }
        }
        return zigzag;
    }
}
