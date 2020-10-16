#include <bits/stdc++.h> 
using namespace std; 
using namespace std::chrono;
void factorize(long long n) 
{ 
	int count = 0; 
 
	while (!(n % 2)) { 
		count++; 
	} 
	if (count) 
		cout << 2 << " " << count << endl; 

	for (long long i = 3; i <= sqrt(n); i += 2) { 
		count = 0; 
		while (n % i == 0) { 
			count++; 
			n = n / i; 
		} 
		if (count) 
			cout << i << " " << count << endl; 
	} 

	if (n > 2) 
		cout << n << " " << 1 << endl; 
} 

int main() 
{   long long n;
    cout<<"\nEnter the no.";
    cin>>n;
	auto start = high_resolution_clock::now();
	factorize(n); 
	auto stop = high_resolution_clock::now();
	
    auto duration = duration_cast<microseconds>(stop - start); 
  
    cout << "Time required for factorization: "
         << duration.count() << " ms" << endl;
	return 0; }
