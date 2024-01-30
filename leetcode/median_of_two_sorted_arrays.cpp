#median_of_two_sorted_arrays.cpp

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std


bool isEven(int n) {
	
	int half = n/2;
	
	if ( (half*2)==n ) {
		return true;
	}	
	else {
		return false;
	}
	
	
}

int compute_median(vector<int> arr) {
	
	bool even = isEven(arr.size());
	
	int mid = binary_search( arr );
	
	if (even) return arr[mid];
	
	//ellse
	int second = 0;
	if (mid+1 > ( arr.size() /2) ) {
		second = arr[mid - 1];
	}
	else {
		second = arr[mid + 1];
	}
	
	return (arr[mid] + arr[second] ) / 2;
	
}

void find_median(vector<int> nums1, vector<int> nums2) {

	int m1 = compute_median(nums1);
	int m2 = compute_median(nums2);
	
	return (m1 + m2) / 2;



}

