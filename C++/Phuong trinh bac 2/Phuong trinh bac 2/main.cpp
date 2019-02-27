//Phương trình bậc 2
#include <iostream>
#include <cmath>
using namespace std;

double ptb1(double a, double b)
{
	double x;
	if (a == 0)
	{
		if (b == 0) cout << "phuong trinh vo so nghiem.";
		else cout << "Phuong trinh vo nghiem.";
	}
	else
	{
		if (b == 0) return x = 0;
		else return x = -b / a;
	}
}
void ptb2(double a, double b, double c)
{
	double x1,x2,detal;
	if (a == 0)
	{
		x1 = ptb1(b, c);
		cout << "ket qua: x=" << x1;
	}
	else
	{
		if (b == 0)
		{
			if (c == 0) //a!=0;b=0;c=0
			{
				cout << "Ket qua: x=" << 0;
			}
			else//a!=0;b=0;c!=0 phuong trinh chi co nghiem khi c/a >0
			{
				if (c/a > 0)
				{
					x1 = sqrt(c / a); 
					x2 = -sqrt(c / a);
					cout << "Ket qua: /n x1=" << x1 << "/n x2=" << x2;
				}
				else
				{
					cout << "Phuong trinh khong co nghiem.";
				}

			}
		}
		else
		{
			if (c == 0) //a!=0;b!=0;c=0
			{
				x1 = 0;
				x2 = ptb1(a, b);
				cout << "Ket qua: /n x1=" << x1 << "/n x2=" << x2;
			}
			else //a!=0;b!=0;c!=0
			{
				detal = pow(b, 2) - 4 * a*c;
				cout << "detal=" << detal<<endl;
				if (detal < 0) cout << "Phuong trinh vo nghiem.";
				else if (detal = 0)
				{
					x1 = -b / (2 * a);
					cout << "Phuong trinh co nghiem kep: x1=x2=" << x1;
				}
				else
				{
					x1 = (-b + sqrt(detal)) / (2 * a);
					x2 = (-b - sqrt(detal)) / (2 * a);
					cout << "Ket qua: /n x1=" << x1 << "/n x2=" << x2;
				}
			}
		}
	}
}
void main()
{
	double a, b, c;
	cout << "a=";
	cin >> a;
	cout << "b=";
	cin >> b;
	cout << "c=";
	cin >> c;
	ptb2(a, b, c);
}