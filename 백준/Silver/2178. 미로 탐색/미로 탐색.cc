#include <iostream>
#include <algorithm>
#include<vector>
#include<queue>
using namespace std;

int arr[100][100];
queue<pair<int,int>> q;
int move1[4] = { 1,0,-1,0 };
int move2[4] = { 0,1,0,-1 };
int visited[100][100];
void bfs(int a, int b) {
    q.push({ 0, 0 });
    visited[0][0] = 1;
    while (!q.empty())
    {
        int y = q.front().first;
        int x = q.front().second;
        for (int i = 0; i < 4; i++)
        {
            int mx = x + move1[i];
            int my = y + move2[i];
            if (my < 0 || mx < 0 || my >= a || mx >= b) continue;
            if (arr[my][mx] == 0)continue;
            if (visited[my][mx] != 0)continue;
            visited[my][mx] = visited[y][x] + 1;
            q.push({my,mx});
        }
        q.pop();
    }
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n,m;
    cin >> n >> m;
    string temp = "";
    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        for (int j = 0; j < m; j++)
        {
            arr[i][j] = temp[j] - '0';
        }
        temp = "";
    }
    bfs(n,m);
    cout << visited[n-1][m-1];
    return 0;
}
