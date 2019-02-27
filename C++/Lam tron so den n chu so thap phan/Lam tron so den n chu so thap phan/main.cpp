#include <iostream>
using namespace std;

double round(double x, int n)
{
	double y;
	x *= pow(10, n);
	if (x >= 0) y = floor(x + 0.5)/ pow(10, n);
	else y = -floor(-x + 0.5)/ pow(10, n);
	return y;
}
void main()
{
	double x;
	int n;
	cout << "x: ";
	cin >> x;
	cout << "n: ";
	cin >> n;
	x = round(x, n);
	cout << x;
}