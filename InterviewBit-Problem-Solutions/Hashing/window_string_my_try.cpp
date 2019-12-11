void print_map(map<char, int> a){
    for(auto it = a.cbegin(); it != a.cend(); ++it)
    {
        cout << it->first << " -> " << it->second << "\n";
    }
    cout << "\n" <<endl;
}

bool compare_2_maps(map<char, int> a, map<char, int> b){
    if(a.size() != b.size()){
        return false;
    }
    // cout << "same len \n";
    for(auto a_ptr = a.begin(); a_ptr!= a.end(); a_ptr++){
        if(b.find(a_ptr->first) == b.end()){
            // not found
            return false;
        }else{
            // found, so check value
            if(b[a_ptr->first] > a_ptr->second){
                // cout << b[a_ptr->first] << " , " << a_ptr->second << endl;
                return  false;
            }
        }
    }
    return true;
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
    
    map<char, int> B_map;
    for(int i=0;i<B.length();i++){
        char curr_char = B.at(i);
        if(B_map.find(curr_char) == B_map.end()){
            // not found
            B_map.insert({curr_char, 1});
        }else{
            // already present
            B_map[curr_char] += 1;
        }
    }
    
    int left_ptr = 0;
    int right_ptr = 0;
    
    int min_length = INT_MAX;
    string min_len_str = "";
    
    // left ptr lies between 0 and A.size()-2
    // right_ptr = left_ptr + 1;
    
    map<char, int> A_map;
    // if(B_map.find(A.at(left_ptr)))
    // A_map.insert({A.at(left_ptr),1});
    
    
    // cout << B_map.size() << endl;
    // print_map(B_map);
    
    while(right_ptr<A.length()){
        char curr_char = A.at(right_ptr);
        if(B_map.find(curr_char) == B_map.end()){
            // not found in B_map, so ignore this
        }else{
            A_map[curr_char]++;
        }
        
        // if(A_map['h'] == 3){
        //     cout << "success\t" << right_ptr<< " "<< A_map.size()<<endl;
        //     print_map(A_map);
        // }
        
        if(compare_2_maps(A_map, B_map)){
            // cout << "minimum" << endl;
            if(right_ptr-left_ptr+1 < min_length){
                min_length = right_ptr-left_ptr+1;
                // cout << "min " << min_length <<endl;
            }
            
            while(left_ptr < right_ptr){
                if(A_map.find(A.at(left_ptr)) == A_map.end()){
                    left_ptr++;
                }else if(A_map[A.at(left_ptr)] > B_map[A.at(left_ptr)]){
                    A_map[A.at(left_ptr)]--;
                    left_ptr++;
                }else{
                    break;
                }
            }
            // left_ptr++;
            // cout << "same comparison" << endl;
        }

        // cout << left_ptr << " " << right_ptr << endl;
        // cout << "A_map "<< curr_char << endl;
        // print_map(A_map);
        right_ptr ++;
        
    }
    while(left_ptr < right_ptr){
        if(A_map.find(A.at(left_ptr)) == A_map.end()){
            left_ptr++;
        }else if(A_map[A.at(left_ptr)] > B_map[A.at(left_ptr)]){
            A_map[A.at(left_ptr)]--;
            left_ptr++;
        }else{
            break;
        }
    }
    cout << "end before " << left_ptr << " " << right_ptr << " " << A.length() << endl;
    if(min_length == INT_MAX){
        string result = "";
        return result;
    }else{
        return A.substr(left_ptr, right_ptr);
    }
}
