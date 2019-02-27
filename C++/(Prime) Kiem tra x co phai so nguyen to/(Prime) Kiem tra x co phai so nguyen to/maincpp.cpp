//viet cuongtrinh kiem tra xem x co phai la so nguyen to
#include <iostream>
#include <cmath>
using namespace std;

bool snt(long x)
{
	bool test;
	double sqrtx;
	int i=2;
	if (x < 0) x = -x;
	sqrtx = sqrt(x);
	if (x == 0) test = true;
	else if (x == 1) test = false;
	else
	{
		test = true;
		while (i<= sqrtx)
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
	long x=4;
	bool y;
	y= snt(x);
	if (y==true)
	{
		cout << x << " La so nguyen to.";
	}
	else
	{
		cout << x << " Khong la so nguyen to.";
	}
}