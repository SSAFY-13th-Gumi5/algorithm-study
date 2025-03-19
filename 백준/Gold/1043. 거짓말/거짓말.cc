#include<iostream>
#include<vector>
using namespace std;

int N, M, answer;
bool know[51] = { false, };
bool party[51][51] = { false, };
void dfs(int person)
{
	if (know[person])
	{
		for (int i = 1; i <= M; i++)
		{
			if (party[i][person])
			{
				for (int j = 1; j <= N; j++)
				{
					if (party[i][j] && !know[j])
					{
						know[j] = true;
						dfs(j);
					}
				}
			}
		}
	}
}
int main()
{
	cin >> N >> M;
	int num;
	cin >> num;
	while (num--)
	{
		int person;
		cin >> person;
		know[person] = true;
	}
	for (int i = 1; i <= M; i++)
	{
		int person;
		cin >> person;

		for (int j = 0; j < person; j++)
		{
			int id;
			cin >> id;
			party[i][id] = true;
		}
	}

	for (int i = 1; i <= N; i++)
	{
		if(know[i])
			dfs(i);
	}
	for (int i = 1; i <= M; i++)
	{
		bool isAnswer = true;
		for (int j = 1; j <= N; j++)
		{
			if (party[i][j] && know[j])
				isAnswer = false;
		}
		if (isAnswer)
			answer++;
	}
	cout << answer << endl;


}