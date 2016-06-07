#include <iostream>
#include <vector>
#include <math.h>
#include <stdlib.h>

using namespace std;

class assignment
{
public:
	double time = 0;
	double days = 0;
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

		if (userIn == 1){
			cout << "Time: ";
			cin >> time1;
			cout << "Days: ";
			cin >> days1;
			main1.time = time1;
			main1.days = days1;
			listMain.push_back(main1);
		}

		if (listMain.size() > 0) {
			cout << ceil(listMain[counter1].time / listMain[counter1].days);
			counter1++;
		}

		cout << endl;
	}

}