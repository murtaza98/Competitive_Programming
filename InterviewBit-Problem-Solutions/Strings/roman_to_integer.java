
// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

// Example :

// Input : "XIV"
// Return : 14
// Input : "XX"
// Output : 20


public class Solution {
    
    //  MAIN LOGIN HERE
    public static int process_char(int decimal, int last_no, int total){
        if(decimal < last_no){
            return total - decimal;
        }else{
            return total + decimal;
        }
    }
    
    public int romanToInt(String A) {
        
        int total = 0;
        int last_number = 0;
        
        
        for(int i=A.length()-1;i >= 0; i--){
            char curr_char = A.charAt(i);
            switch(curr_char){
                case 'I':
                    total = Solution.process_char(1, last_number, total);
                    last_number = 1;
                    break;
                case 'V':
                    total = Solution.process_char(5, last_number, total);
                    last_number = 5;
                    break;
                case 'X':
                    total = Solution.process_char(10, last_number, total);
                    last_number = 10;
                    break;
                case 'L':
                    total = Solution.process_char(50, last_number, total);
                    last_number = 50;
                    break;
                case 'C':
                    total = Solution.process_char(100, last_number, total);
                    last_number = 100;
                    break;
                case 'D':
                    total = Solution.process_char(500, last_number, total);
                    last_number = 500;
                    break;
                case 'M':
                    total = Solution.process_char(1000, last_number, total);
                    last_number = 1000;
                    break;
            }
        }
        return total;
    }
}
