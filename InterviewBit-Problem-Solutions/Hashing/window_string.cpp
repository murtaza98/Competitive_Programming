/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).

REFERENCE:- https://www.youtube.com/watch?v=eS6PZLjoaq8
*/

void print_map(map<char, int> a){
    for(auto it = a.cbegin(); it != a.cend(); ++it)
    {
        cout << it->first << " -> " << it->second << "\n";
    }
    cout << "\n" <<endl;
}

string Solution::minWindow(string A, string B) {
    if(B.size() > A.size()){
        return "";
    }
    
    if(A.size()==1){
        if(A.at(0) == B.at(0)){
            string result(1,A.at(0));
            return result;
        }else{
            return "";
        }
    }
    
    unordered_map<char,int> map_patt;
    unordered_map<char,int> map_str;
    
    for(int i=0;i<B.length();i++){
        map_patt[B.at(i)] += 1;
    }
    
    int min_window_size = INT_MAX;
    int global_start = -1;
    int left=0, right=0;
    int count = 0;
    for(right=0;right<A.length();right++){
        char curr_char = A.at(right);
        if(map_patt.find(curr_char) == map_patt.end()){
            continue;
        }
        map_str[curr_char] += 1;
        
        if(count != B.size() && map_str[curr_char] <= map_patt[curr_char]){
            count++;
        }
        
        if(count == B.size()){
            // shrink the window
            while(map_patt.find(A.at(left)) == map_patt.end() || 
            (map_patt.find(A.at(left)) != map_patt.end() && map_patt[A.at(left)] < map_str[A.at(left)])){
                if(map_patt.find(A.at(left)) != map_patt.end() && map_patt[A.at(left)] < map_str[A.at(left)]){
                    map_str[A.at(left)]--;
                }
                left++;
            }
            int curr_window_size = right-left+1;
            if(curr_window_size < min_window_size){
                min_window_size = curr_window_size;
                global_start = left;
            }
        }
    }
    if(global_start == -1){
        return "";
    }else{
        return A.substr(global_start, min_window_size);
    }
    
}
