/*
Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.

Your task is to complete the function tour() which returns an integer denoting the first point from where a truck will be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity).

Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.

Example (To be used only for expected output)
Input:
1
4
4 6 6 5 7 3 4 5
Output:
1

Explanation:
Testcase 1: there are 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where truck can make a circular tour is 2nd petrol pump. Output in this case is 1 (index of 2nd petrol pump).

*/

class GfG
{
    int tour(int petrol[], int distance[])
    {
	    int n=petrol.length;
	    int deficit = 0;
	    int start=0;
	    int sum=0;
	    for(int i=0;i<n;i++){
	        sum+=petrol[i]-distance[i];
	        if(sum<0){
	            start=i+1;
	            deficit += sum;
	            sum=0;
	        }
	    }
	    return (sum+deficit)>=0?start:-1;
    }
}