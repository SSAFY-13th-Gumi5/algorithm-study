#include <iostream>
#include <vector>
#include <set>
using namespace std;

int N;         // 1 <= N <= 100
vector<int> v; // graph

set<int> answer;
set<int> index_set;
set<int> value_set;

void dfs(int i, bool *visited)
{
    visited[i] = true;

    index_set.insert(i);
    value_set.insert(v[i]);
    if (index_set == value_set)
    {
        set<int>::iterator iter;

        for (iter = value_set.begin(); iter != value_set.end(); iter++)
        {
            answer.insert(*iter);
        }
        return;
    }
    if (!visited[v[i]])
        dfs(v[i], visited);
}
int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int down;
        cin >> down;
        v.push_back(down - 1);
    }
    for (int i = 0; i < v.size(); i++)
    {
        index_set.clear();
        value_set.clear();
        bool visited[101] = {false};
        dfs(i, visited);
    }
    cout << answer.size() << endl;
    set<int>::iterator iter;

    for (iter = answer.begin(); iter != answer.end(); iter++)
    {
        cout << *iter + 1 << endl;
    }
}