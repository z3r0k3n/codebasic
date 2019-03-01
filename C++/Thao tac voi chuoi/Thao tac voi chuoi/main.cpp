//Thao tac vs chuoi
#include <iostream>
#include <string.h>
using namespace std;

void output(char a[])
{
	int i=0;
	cout << endl;
	while (a[i] != NULL)
	{
		cout << a[i];
		i++;
	}
}
int main()
{
	char a[100] = "Z3R0", b[100] = "K3N";
	int number,i=0;
//dem so ky tu trong chuoi
	number = strlen(a);
	cout << number;
//chep chuoi
	strcat_s(a, b);//su dung strcat_s thay cho strcat
	output(a);
//ghi de chuoi
	strcpy_s(a, "ZEROKEN");
	output(a);
//so sanh chuoi
	number = strcmp(a, b);
	cout << endl << number;
//tim ky tu trong chuoi
	strchr(a,number);
//xac dinh chuoi con
	strstr(a, "ZERO");
//doi tat cac ky tu trong chuoi thanh ky tu thuong
	_strlwr_s(a);
	output(a);
//doi tat ca cac ky tu trong chuoi thanh ky tu in hoa
	_strupr_s   (a);
	output(a);
}