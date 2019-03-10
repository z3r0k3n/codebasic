#include<iostream>
#include<cmath>
#include<string>
using namespace std;

//Tinh tong cac so tu 1 den n
int tinhtongcacsov1(int n)
{
	cout << "\nTinh tong cac so tu 1 den n: ";
	int i = 0,y=0;
	while (i<=n)
	{
		y += i;
		i++;
	}
	return y;
}
//tinh tich cac so tu 1 den n.
int tinhtichcacsov1(int n)
{
	cout << "\nTinh tich cac so tu 1 den n: ";
	int i = 1,y = 1;
	while (i<=n)
	{
		y *= i;
		i++;
	}
	return y;
}
//Tinh tong cac so co dieu kien
int tinhtongcacsov2(int n)
{
	cout << "\nTinh tong cac so co dieu kien: ";
	int i = 0, y = 0;
	while (i<=n)
	{
		if (i % 4 == 1)
		{
			y += (i / (1 + pow(i, 2)));
		}
	}
	return y;
}
//Tinh tich cac so co dieu kien
int tinhtichcacsov2(int n)
{
	cout << "\nTinh tich cac so co dieu kien: ";
	int i = 0, y = 1;
	while (i <= n)
	{
		if (i % 2 != 1 && i % 3 == 1)
		{
			y *= i;
		}
	}
	return y;
}
//Tinh tong cac so tu x/1 den x^n/n
double tinhtongcacsov3(int n,double x)
{
	cout << "\nTinh tong cac so tu x/1 den x^n/n: ";
	int i = 1;
	double y = 0;
	while (i <= n)
	{
		y += (pow(x, i) / i);
	}
	return y;
}
//Tinh tong cac so tu x/1 den ((-1)^(n-1))*(x^n/n)
double tinhtongcacsov4(int n, double x)
{
	cout << "\nTinh tong cac so tu x/1 den ((-1)^(n-1))*(x^n/n): ";
	int i = 1;
	double y = 0;
	while (i <= n)
	{
		y += pow(-1, i - 1)*(pow(x, i)) / i;
	}
	return y;
}
//Tinh tong cac so tu x/1 den (x^n/n!)
double tinhtongcacsov5(int n, double x)
{
	cout << "\nTinh tong cac so tu x/1 den (x^n/n!): ";
	int i = 0;
	double y = 0;
	while (i <= n)
	{
		y += pow(-x, i) / tinhtichcacsov1(i);
	}
	return y;
}
//tinh can bac hai cua n
int canbacn(int n)
{
	cout << "\nTinh can bac hai cua n: ";
	int x = 1, i = 1, y;
	while (x < n)
	{
		i += 2;
		x += i;
	}
	if (x > n)
	{
		i -= 2;
	}
	y = (i + 1) / 2;
	cout<< y;
	return y;
}
//kiem tra so hoan chinh: neu n la mot so hoan chinh thi neu cong tat ca cac uoc lai se bang chinh no
int sohoanchinh(int n)
{
	cout << "\nkiem tra so hoan chinh: ";
	int i = 1, y = 0;
	while (i < n)
	{
		if (n%i == 0)
		{
			y += i;
		}
		i++;
	}
	if (y == n) cout << n << " la so hoan chinh.";
	else cout << n << " khong la so hoan chinh.";
	return y;
}
//Đếm và phân loại ký tự
void phanloaikytu(char* a)
{
	int i = 0, n,chu,so,khac;
	chu = so = khac = 0;
	n = strlen(a);//strlen dung để tính số phần tử trong một chuỗi.
	while (i < n)
	{
		if (a[i] >= 'a' && a[i] <= 'z') chu++;
		else if (a[i] >= 'A' && a[i] <= 'z') chu++;
		else if (a[i] >= '0'&& a[i] <= '9') so++;
		else khac++;
		i++;
	}
	cout << "\nchu: " << chu;
	cout << "\nso: " << so;
	cout << "\nkhac: " << khac;
}
//đếm phân loại các số âm, số dương, số bằng 0 trong một chuỗi số nguyên
void demphanloaiso(int* a, int n)
{
	int i, soam, soduong, sobang0;
	i = soam = soduong = sobang0 = 0;
	while (i < n)
	{
		if (a[i] == 0)	sobang0++;
		else if (a[i] < 0)	soam++;
		else soduong++;
		i++;
	}
	cout << "so duong: " << soduong << endl;
	cout << "so am: " << soam << endl;
	cout << "so bang 0: " << sobang0 << endl;
}
//tra loi cac cau hoi sau bang chuong trinh:
void xetsox(int* a, int n, int x)
{
	int i, bangx, solonx, nhohonx;
	i = bangx = solonx = nhohonx = 0;
	while(i<n)
	{
		if (a[i] == x)	bangx++;
		else if (a[i] < x)	nhohonx++;
		else solonx++;
		i++;
	}
	if (bangx == 0)	cout << x << " khong xuat hien trong mang" << endl;
	else	cout << x << " co xuat hien trong mang." << endl;
	if (solonx == 0) cout << x << " nho hon moi so trong mang" << endl;
	if (nhohonx == 0) cout << x << " lon hon moi so trong mang";
	cout << "So " << x << "xuat hien: " << bangx << endl;
	cout << "Co " << solonx << " so lon hon so " << x << endl;
	cout << "co" << nhohonx << " so nho hon so" << x << endl;
	// so x co xuat hien trong mang hay ko.
	// so x lon hon moi so trong mang hay ko.
	// so x có nhỏ hơn moi so trong mảng hay ko.
	// tât cả mọi so trong mang co âm hay ko.
	// có bao nhieu so trong mang bằng số x.
	// có bao nhiêu số trong mảng bé hơn số x.
	// có bao nhiêu số trong mảng lớn hơn so x.
}
// Tìm số nhỏ nhất trong mảng gom n so thuc;
int timsonhonhan(int *a, int n)
{
	int i = 0, min=a[0];
	while (i < n)
	{
		if (a[i] < min) min = a[i];
		i++;
	}
	return min;
}
//tim hai so ma chung tru cho nhau ra so nho nhat trong mang;
void hieunhonhat(int* a,int n)
{
	int i = 0, j,g=0, min1[10], min2[10], min=a[0]-a[1];//min2-min1=min
	while (i < n)
	{
		j = i;
		while (j < n)
		{
			if ((a[i] - a[j])<=min)
			{
				min = a[i] - a[j];
				min1[g] = a[i];
				min2[g] = a[j];
				g++;
			}
		}
		i++;
	}
	cout << "hai so tru cho nhau ra so be nhat la: " << min1[g] << " " << min2[g] << "ket qua: " << min << endl;
}

void main()
{
	char a[100] = "abc123   ";
	int b[100];
	b[0] = 1;
	b[1] = 2;
	b[2] = 3;
	b[3] = 6;
	b[4] = 3;
	b[5] = 8;
	b[6] = 4;
	b[7] = 3;
	b[8] = 2;
	canbacn(2);
	sohoanchinh(6);
	phanloaikytu(a);
	demphanloaiso(b,9);
}