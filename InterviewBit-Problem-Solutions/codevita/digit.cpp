#include <bits/stdc++.h>
#include <algorithm>
using namespace std;

int getMaxDigit(int n){
    int max_no = INT_MIN;

    while(n>0){
        max_no = max(max_no, n%10);
        n/=10;
    }
    return max_no;
}

int getMinDigit(int n){
    int min_no = INT_MAX;

    while(n>0){
        min_no = min(min_no, n%10);
        n/=10;
    }
    return min_no;
}

int main() {
    int n;

    // scanf("%d", &n);
    cin >> n;

    vector<int>nos(n);

    for(int i=0;i<n;i++){
        // scanf("%d", nos[i]);
        cin >> nos[i];
    }

    for(int i=0;i<n;i++){
        int max_digit = getMaxDigit(nos[i]);
        int min_digit = getMinDigit(nos[i]);

        // make the nos[i] 2 digit
        nos[i] = (max_digit*11 + min_digit*7) % 100;
    }

    // for(int i=0;i<n;i++){
    //     printf("%d ", nos[i]);
    // }

    unordered_map<int ,vector<int>>odd_pairs,even_pairs;

    for(int i=0;i<n;i=i+2){
        odd_pairs[nos[i]/10].push_back(i+1);
    }

    for(int i=1;i<n;i=i+2){
        even_pairs[nos[i]/10].push_back(i+1);
    }

    int tp=0; // total pairs


    for(int i=0;i<10;i++){
        int odd_s = odd_pairs[i].size();
        int even_s = even_pairs[i].size();
        if(odd_s==2){
            tp++;
        }
        if(even_s == 2){
            tp++;
        }
        if(odd_s>2 || even_s>2){
            tp += 2; 
        }
    }

    cout << tp;
}