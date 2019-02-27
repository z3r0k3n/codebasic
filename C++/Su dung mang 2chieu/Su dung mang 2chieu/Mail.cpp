 //doan code trong bai nay noi ve cac thao tac su dung mang 2 chieu
#include<iostream>
#include<cmath>
using namespace std;
//Nhap mang
void input(int a[][4], int n,int m)
{
	a[0][0] = 1;
	a[0][1] = 2;
	a[0][2] = 0;
	a[0][3] = -3;
	a[1][0] = 0;
	a[1][1] = -5;
	a[1][2] = 3;
	a[1][3] = 4;
	a[2][0] = 0;
	a[2][1] = -1;
	a[2][2] = 1;
	a[2][3] = 13;
	a[3][0] = 0;
	a[3][1] = -7;
	a[3][2] = 2;
	a[3][3] = 11;
}
//xuat mang
void output(int a[][4], int n, int m) {
	int i, j;
	for ( i = 0; i < n; i++)
	{
		for ( j = 0; j < m; j++)
		{
			printf("%3d", a[i][j]);
		}
		cout << endl;
	}
}
//chep dong k len dong h 
void chepdong(int a[][4], int n,int m, int k,int h)
{
	input(a, 4, 4);
	int i;
	for (i = 0;i < n;i++)
	{
		a[h][i] = a[k][i];
	}
	cout << "chep dong k len dong h :\n";
	output(a, n, 4);
}
//chep cot k len cot h
void chepcot(int a[][4],int n, int m, int k, int h)
{
	input(a, 4, 4);
	int i;
	for (i = 0;i < m;i++)
	{
		a[i][h] = a[i][k];
	}
	cout << "chep cot k len dong h :\n";
	output(a, 4, m);
}
//hoan doi 2 dong k-->h
void hoandoi2dong(int a[][4], int n, int m, int k, int h)
{
	input(a, 4, 4);
	int i;
	for (i = 0;i < m;i++)
	{
		a[k][i] += a[h][i];
		a[h][i] = a[k][i] - a[h][i];
		a[k][i] = a[k][i] - a[h][i];
	}
	cout << "hoan doi dong k vs dong h:\n";
	output(a, n, m);
}
//hoan doi 2 cot k--h.
void hoandoi2cot(int a[][4], int n, int m, int k, int h)
{
	input(a, 4, 4);
	int i;
	for (i = 0;i < n;i++)
	{

		a[i][k] += a[i][h];
		a[i][h] = a[i][k] - a[i][h];
		a[i][k] = a[i][k] - a[i][h];
	}
	cout << "hoan doi cot k vs cot h:\n";
	output(a, n, m);
}
//xoa di 1 dong khong quan tam thu tu
void xoa1dongkhongthutu(int a[][4], int &n, int m, int x)
{
	input(a, n, m);
	int i;
	for (i = 0;i < m;i++)
	{
		a[x][i] = a[n-1][i];
	}
	n--;
	cout << "xoa 1 dong khong quan tam thu tu ban dau:\n";
	output(a, n, m);
}
//xoa di 1 dong quan tam thu tu
void xoa1dongcothutu(int a[][4], int &n, int m, int x)
{
	n = 4;
	input(a, n, m);
	int i,j;
	for (i = x;i < n;i++)
	{
		for (j = 0;j < m;j++) 
		{
			a[i][j] = a[i+1][j];
		}
	}
	n--;
	cout << "xoa 1 dong quan tam thu tu ban dau:\n";
	output(a, n, m);
}
//Xoa di 1 cot khong quan tam thu tu
void xoa1cotkhongthutu(int a[][4], int &n, int &m, int x)
{
	n = 4;
	input(a, n, m);
	int i;
	for (i = 0;i < n;i++)
	{
		a[i][x] = a[i][m-1];
	}
	m--;
	cout << "xoa 1 cot khong quan tam thu tu ban dau:\n";
	output(a, n, m);
}
//Xoa di 1 cot quan tam thu tu
void xoa1cotcothutu(int a[][4], int n, int &m, int x)
{
	m = 4;
	input(a, n, m);
	int i, j;
	for (i = x;i < m;i++)
	{
		for (j = 0;j < n;j++)
		{
			a[j][i] = a[j][i+1];
		}
	}
	m--;
	cout << "xoa 1 cot quan tam thu tu ban dau:\n";
	output(a, n, m);
}
void main()
{
	int a[4][4],m = 4,n = 4;
	input(a, n, m);
	cout << "mang goc: \n";
	output(a, n, m);
	chepdong(a, n, m, 1, 3);
	chepcot(a, n, m, 1, 3);
	hoandoi2dong(a, n, m, 1, 3);
	hoandoi2cot(a, n, m, 1, 3);
	xoa1dongkhongthutu(a, n, m, 1);
	xoa1dongcothutu(a, n, m, 1);
	xoa1cotkhongthutu(a, n, m, 1);
	xoa1cotcothutu(a, n, m, 1);
}