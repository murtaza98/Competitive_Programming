// A Dynamic Programming solution for subset sum problem 
#include <stdio.h> 
#include <bits/stdc++.h>
#include <vector>

using namespace std;

void printCVector(vector<int> v){
	for (vector<int>::iterator i = v.begin(); i != v.end(); ++i)
	{
		cout << *i << " ";
	}
	cout << endl;
}

void getSubsetPairs(vector<vector<bool>> subset, int set[], int row, int sum, vector<int> &curr_subset, vector<vector<int>> &all_pairs){
	// if sum is zero
	if(sum == 0){
		// printCVector(curr_subset);
		all_pairs.push_back(curr_subset);
		return;
	}

	if(row == 0){
		return;
	}

	if(subset[row-1][sum] == true){
		// exclude this, since it will be considered in future
		vector<int> new_curr_subset = curr_subset;
		getSubsetPairs(subset, set, row-1, sum, new_curr_subset, all_pairs);
	}

	if(sum >= set[row-1] && subset[row-1][sum-set[row-1]] == true){
		// include this pair
		curr_subset.push_back(set[row-1]);
		// printCVector(curr_subset);
		getSubsetPairs(subset, set, row-1, sum-set[row-1], curr_subset, all_pairs);
	}
}

// Returns true if there is a subset of set[] with sun equal to given sum 
bool isSubsetSum(int set[], int n, int sum) 
{ 
	// The value of subset[i][j] will be true if there is a 
	// subset of set[0..j-1] with sum equal to i 
	// subset is of dimension n+1 x sum+1
	vector<vector<bool>> subset(n+1, vector<bool>(sum+1));

	// set all col with sum 0
	for(int i=0;i<=n;i++){
		subset[i][0] = true;
	}

	// set 0th row to false, except the subset[0][0]
	for(int i=1;i<=sum;i++){
		subset[0][i] = false;
	}

	// fill the rest of matrix as per the condition
	for(int i=1; i<=n; i++){
		for(int j=1; j<=sum; j++){
			if(j < set[i-1]){
				subset[i][j] = subset[i-1][j];
			}else if(j >= set[i-1]){
				subset[i][j] = subset[i-1][j] || subset[i-1][j-set[i-1]];
			}
		}
	}

	// print matrix
	// for(int i=0;i<=n;i++){
	// 	for(int j=0;j<=sum;j++){
	// 		cout << subset[i][j] << " ";
	// 		// printf("%4d", subset[i][j]);
	// 	}
	// 	printf("\n");
	// }

	// get the elements of subset
	vector<vector<int>> all_pairs; 
	vector<int> curr_subset;
	getSubsetPairs(subset, set, n, sum, curr_subset, all_pairs);

	printf("Subsets Found\n");
	for(int i=0;i<all_pairs.size();i++){
		printCVector(all_pairs[i]);
	}

	return subset[n][sum];
}

// Driver program to test above function 
int main() 
{ 
int set[] = {1,2,3,4,5}; 
int sum = 10; 
int n = sizeof(set)/sizeof(set[0]); 
// for(int i=0;i<n;i++)
// 	printf("%4d", set[i]);
// cout << endl;
if (isSubsetSum(set, n, sum) == true) 
	printf("Found a subset with given sum\n"); 
else
	printf("No subset with given sum\n"); 
return 0; 
} 