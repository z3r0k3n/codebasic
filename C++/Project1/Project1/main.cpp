#include <iostream>
#include <cmath>
using namespace std;

bool snt(long x)
{
	bool test;
	double sqrtx;
	int i = 2;
	if (x < 0) x = -x;
	sqrtx = sqrt(x);
	if (x == 0) test = true;
	else if (x == 1) test = false;
	else
	{
		test = true;
		while (i <= sqrtx)
		{
			if (x%i == 0)
			{
				test = false;
				break;
			}
			i++;
		}
	}
	return test;
}

void main()
{
	int i=2,n=10;
	bool y;
	cout << "Ket qua: \n";
	while (i < n)
	{
		y = snt(i);
		if (y == true)	cout << i<<endl;
		i++;
	}
}