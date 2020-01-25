// https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1

class Triplet
{
    // Function to check if triplet is present 
    // arr[]: input array
    // n: size of the array
	public boolean findTriplets(int arr[] , int n)
    {
        for(int i=0;i<n-2;i++){
            int first = arr[i];
            HashSet<Integer> second = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third = arr[j];
                if(second.contains(-first-third)){
                    return true;
                }else{
                    second.add(arr[j]);
                }
            }
        }
        return false;
    }
}