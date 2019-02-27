#include<iostream>
using namespace std;

void input_array(int a[], int n)
{
	a[0] = 9;
	a[1] = 6;
	a[2] = 3;
	a[3] = 5;
	a[4] = 8;
	a[5] = 2;
	a[6] = 1;
	a[7] = 4;
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
//Them một phần từ x trong mảng tại vị trí k
void themmotphantuvaomang(int a[], int &n, int x, int k)
{
	int i;
	if (k - 1 < 0 || k - 1 > n)
	{
		cout << "khong co vi tri trong mang: \n";
	}
	else
	{
		for (i = n - 1;i >= k;i--)
		{
			a[i + 1] = a[i];
		}
		a[k - 1] = x;
		n++;
	}
	cout << "Them mot phan tu vao trong mang: \n";
	output_array(a, n);
}
void lapvitritrongmang(int a[], int n, int k)
{
	int i;
	for (i = k;i < n;i++)
	{
		a[i] = a[i + 1];
	}
}
void xoaphantutrongmang(int a[], int &n, int x)
{
	int i;
	for (i = 0;i < n;i++)
	{
		while (a[i] == x)
		{
			lapvitritrongmang(a, n, i);
			n--;
		}
	}
	cout << "Xoa phan tu trong mang: \n";
	output_array(a, n);
}

void tachmangchanle(int a[], int n, int c[], int &h, int l[],int &k)
{
	h = k = 0;
	int i;
	for (i = 0;i < n;i++)
	{
		if (a[i] % 2 == 0)
		{
			c[h++] = a[i];
		}
		else
		{
			l[k++] = a[i];
		}
	}
	cout << "mang goc:\n";
	output_array(a, n);
	cout << "mang chan:\n";
	output_array(c, h);
	cout << "mang le:\n";
	output_array(l, k);
}
void goptungmangvsnhau(int a[], int &n, int c[], int h, int l[], int k)
{
	n = 0;
	int i=0;
	for (i = 0;i < h;i++)
	{
		a[n++] = c[i];
	}
	for (i = 0;i < k;i++)
	{
		a[n++] = l[i];
	}
	cout << "Gop tung mang vs nhau: \n";
	output_array(a, n);
}
void gopmangsenke(int a[], int &n, int c[], int h, int l[], int k)
{
	n = 0;
	int i=0, j=0;
	while (i < h && j < k)
	{
		if (n % 2 == 0)
			a[n++] = l[j++];
		else
		{
			a[n++] = c[i++];
		}
	}
	while (i < h)
	{
		a[n++] = c[i++];
	}
	while (j < h)
	{
		a[n++] = l[j++];
	}
	cout << "Gop mang xen ke nhau: \n";
	output_array(a, n);
}
int main()
{
	int n = 8, h, k, a[8], c[100], l[100];
	input_array(a, n);
	themmotphantuvaomang(a, n, 2, 3);
	xoaphantutrongmang(a, n, 2);
	tachmangchanle(a, n, c, h, l, k);
	goptungmangvsnhau(a, n, c, h, l, k);
	gopmangsenke(a, n, c, h, l, k);
}