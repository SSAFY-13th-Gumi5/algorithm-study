//
//  main.cpp
//  4485
//
//  Created by 최진우 on 2/15/24.
//

#include <iostream>
#include<climits>
int N;
int map[125][125];
int dp[125][125];
int dx[4] = { 1, 0, 0, -1 };
int dy[4] = { 0, 1, -1, 0 };

using namespace std;
pair<int, int> findMin(bool(&visited)[125][125])
{
    int min = INT_MAX;
    pair<int, int> p;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (!visited[i][j] && dp[i][j] < min)
            {
                min = dp[i][j];
                p.first = i;
                p.second = j;
            }
        }
    }
    return p;
}
void dijkstra(bool (&visited)[125][125])
{
    for (int i = 0; i < N * N; i++)
    {

        auto p = findMin(visited);
        visited[p.first][p.second] = true;

        for (int dir = 0; dir < 4; dir++)
        {
            int nx = p.second + dx[dir];
            int ny = p.first + dy[dir];
            if (nx > -1 && nx < N && ny > -1 && ny < N)
            {
                dp[ny][nx] = min(dp[ny][nx], dp[p.first][p.second] + map[ny][nx]);
            }
        }
    }
}
int main() {


    cin >> N;
    int cnt = 0;
    while (true)
    {
        bool visited[125][125] = { false , };
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            {
                cin >> map[i][j];
                dp[i][j] = INT_MAX;
            }
        dp[0][0] = map[0][0];

        dijkstra(visited);

        cout << "Problem " << ++cnt << ": " << dp[N - 1][N - 1] << "\n";
        cin >> N;
        if (N == 0)
            break;
    }
    return 0;
}
