#include <iostream>
#include <vector>
#include <math.h>
#include <stdlib.h>
#include <string>

using namespace std;

class assignment
{
public:
	double time = 0;
	double days = 0;
	double timePerDay = 0;
	string name;
};

class day
{
	double dayOne;
	double time;
};

int main()
{
	vector <assignment> listMain;
	assignment main1;
	//    main1.time = 10;
	//    main1.days = 10;
	//    listMain.push_back(main1);

	//day listOne[7];

	int userIn = 0;
	int counter1 = 0;

	while (true){
		cout << "Enter what you want to do: ";
		cin >> userIn;
		double time1 = 0;
		double days1 = 0;
		string name1;

		if (userIn == 1){
			cout << "Time: ";
			cin >> time1;
			cout << "Days: ";
			cin >> days1;
			cout << "Name: ";
			cin >> name1;
			main1.time = time1;
			main1.days = days1;
			main1.name = name1;
			main1.timePerDay = ceil(time1 / days1);
			listMain.push_back(main1);

			if (listMain.size() > 0) {
				cout << name1 << "  " << time1 << "  " << days1;
				counter1++;
			}
			cout << endl;
		}

		if (userIn == 2){
			for (int a = 0; a < 7; a++){
				cout << a + 1 << ": " << endl;
				for (int b = 0; b < listMain.size(); b++){
					if (listMain[b].days > a)
					{
						cout << listMain[b].name << "  " << listMain[b].timePerDay << endl;
					}
				}
				cout << endl;
			}
		}


	}

}