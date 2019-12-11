/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)
Sample Output :

2
You will be given 2 arrays X and Y. Each point is represented by (X[i], Y[i])
*/


/*
NOTE THAT instead of storing slope i.e (y2-y1)/(x2-x1),
we will store num & deno pair to avoid precision limitation
so ratio_pair->num will store (y2-y1)
and ratio_pair->deno will store (x2-x1)
*/
struct ratio_pair{
    int num;
    int deno;
    
    bool operator==(const ratio_pair &o) const{
        return num == o.num && deno == o.deno;
    }

    bool operator<(const ratio_pair &o) const{
        // LOGIC to determine which ratio is larger
        // self -- 3/4 into o -- 9/16 
        // Cross multiply 
        // =3into16= 4into9
        // = 48 =36
        // So 3/4is larger
        int sum1 = num * o.deno;
        int sum2 = o.num * deno;
        
        return sum1 < sum2 ? true : false;
    }
};

int gcd(int a, int b){
    if(a==0){
        return b;
    }
    gcd(b%a, a);
}

int Solution::maxPoints(vector<int> &A, vector<int> &B) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    
    if(A.size() == 0){
        return 0;
    }else if(A.size() == 1){
        return 1;
    }
    
    int max_points = INT_MIN;
    
    map<ratio_pair, int> slopeMap;
    
    for(int i=0;i<A.size();i++){
        int curr_max = 0, overlap_points = 0, vertical_points = 0;
        for(int j=i+1;j<A.size();j++){
            if(A[i] == A[j] && B[i] == B[j]){
                // overlap, same points
                overlap_points++;
            }else if(A[i] == A[j]){
                // vertical lines
                vertical_points++;
            }else{
                int diffX = A[j] - A[i];
                int diffY = B[j] - B[i];
                
                int gcd_no = gcd(diffY, diffX);
                
                diffX /= gcd_no;
                diffY /= gcd_no;
                
                ratio_pair key;
                key.num = diffY;
                key.deno = diffX;
                
                slopeMap[key] += 1;
                
                curr_max = max(curr_max, slopeMap[key]);
            }
            curr_max = max(curr_max, vertical_points);
        }
        max_points = max(max_points, curr_max + overlap_points+1);
        slopeMap.clear();
    }
    return max_points;
    
}
