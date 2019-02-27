#include <iostream>
#include <cmath>
using namespace std;

void input_array(int a[], int n)
{
	int i = 0;
	while (i < n)
	{
		cout << "Nhap gia tri thu " << i + 1 << ": ";
		cin >> a[i];
		i++;
	}
}
void output_array(int a[], int n)
{
	int i = 0;
	while (i < n)
	{
		cout << a[i] << endl;
		i++;
	}
}
void sapxepmangtanggian(int a[], int n)
{
	int i, j;
	for (i = 0;i < n;i++)
	{
		for (j = i + 1;j < n;j++)
		{
			if (a[i] > a[j])
			{
				a[i] = a[i] + a[j];
				a[j] = a[i] - a[j];
				a[i] = a[i] - a[j];
			}
		}
	}
}
void sapsepmanggiamgian(int a[], int n)
{
	int i, j;
	for (i = 0;i < n;i++)
	{
		for (j = i + 1;j < n;j++)
		{
			if (a[i] < a[j])
			{
				a[i] = a[i] + a[j];
				a[j] = a[i] - a[j];
				a[i] = a[i] - a[j];
			}
		}
	}
}
void main()
{
	int n = 8, a[8];
	a[0] = 9;
	a[1] = 6;
	a[2] = 3;
	a[3] = 5;
	a[4] = 8;
	a[5] = 2;
	a[6] = 1;
	a[7] = 4;
	sapxepmangtanggian(a, n);
	cout << "Mang theo chieu tang gian: \n";
	output_array(a, n);
	sapsepmanggiamgian(a, n);
	cout << "Mang theo chieu giam gian: \n";
	output_array(a, n);
}
