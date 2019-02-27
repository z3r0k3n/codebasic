//Lam tron so (round)
#include <iostream>
using namespace std;

double round(double x)
{
	double y;
	if (x >= 0) y = floor(x + 0.5);
	else y = -floor(-x + 0.5);
	return y;
}
void main()
{
	double x;
	cout << "x:";
	cin >> x;
	x = round(x);
	cout << x;
}