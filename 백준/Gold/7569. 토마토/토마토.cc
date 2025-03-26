//
//  main.cpp
//  7569
//
//  Created by 최진우 on 2/14/24.
//

#include <iostream>
#include<queue>;
using namespace std;
typedef struct XYZ
{
    int z;
    int y;
    int x;
    int cnt;
}XYZ;
int X, Y, Z;
int box[101][101][101]={0, };
bool visited[101][101][101] = {false, };
queue<XYZ> q;
int dx[6] = {1, -1, 0, 0, 0, 0};
int dy[6] = {0, 0, 1, -1, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};
int main() {
    cin>>X>>Y>>Z;
    for(int i = 0; i<Z;i++)
    {
        for(int j=0;j<Y;j++)
        {
            for(int k=0;k<X;k++)
            {
                cin>>box[i][j][k];
                if(box[i][j][k] == 1)
                {
                    q.push({i, j, k, 0});
                    visited[i][j][k] = true;
                }
            }
        }
    }
    int answer = -1;
    while(!q.empty())
    {
        auto cur = q.front();
        q.pop();
        answer = max(answer, cur.cnt);
        for(int i=0;i<6;i++)
        {
            int nextX = cur.x + dx[i];
            int nextY = cur.y + dy[i];
            int nextZ = cur.z + dz[i];
            if(nextX >= 0 && nextX < X &&
               nextY >= 0 && nextY < Y &&
               nextZ >= 0 && nextZ < Z &&
               box[nextZ][nextY][nextX] == 0 && !visited[nextZ][nextY][nextX])
            {
                q.push({nextZ, nextY, nextX, cur.cnt+1});
                box[nextZ][nextY][nextX] = 1;
                visited[nextZ][nextY][nextX] = true;
            }
        }
    }
    int flag = false;
    for(int i = 0; i<Z;i++)
    {
        for(int j=0;j<Y;j++)
        {
            for(int k=0;k<X;k++)
            {
                if(box[i][j][k] == 0)
                {
                    flag = true;
                    break;
                }
            }
        }
    }
    if(flag)
        cout<<-1<<endl;
    else
        cout<<answer<<endl;
    return 0;
}
