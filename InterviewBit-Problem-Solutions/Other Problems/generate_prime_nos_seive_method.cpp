#include <bits/stdc++.h>
// #include <algorithm>

using namespace std;

vector<int> getPrimeNumbers(int n){

	// if prime[i] is true, then i is prime  
	bool prime[n+1];
	// set all values in prime to true
	fill_n(prime, n+1, true);

	for(int p=2; p*p<=n; p++){
		// if prime[p] is true or not changed, then it is a prime
		if(prime[p] == true){
			// update all multiples of p, starting from p*p(included)
			for(int j=p*p; j<=n; j++){
				prime[j] = false;
			}
		}
	}

	vector<int> prime_result;

	for(int i=2; i<=n; i++){
		if(prime[i] == true){
			cout << i << " ";
			prime_result.push_back(i);
		}
	}
	cout << endl;

	return prime_result;
}


void printCVector(vector<int> v){
	for (vector<int>::iterator i = v.begin(); i != v.end(); ++i)
	{
		cout << *i << " ";
	}
	cout << endl;
}

int main(){
	vector<int> prime_no = getPrimeNumbers(10);
	printCVector(prime_no);
}

