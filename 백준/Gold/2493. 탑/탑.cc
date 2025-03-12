//
//  main.cpp
//  5557
//
//  Created by 최진우 on 1/26/24.
//

#include <iostream>
#include<stdio.h>
#include <stack>
using namespace std;

int main()
{
    int N;
    stack<pair<int, int>> s;
    cin >>N;
    int num1;
    cin>>num1;
    s.push({num1, 1});
    cout<<0<<" ";
    
    for(int i=2;i<=N;i++)
    {
        int num;
        scanf(" %d", &num);
        while(!s.empty() && s.top().first < num)
            s.pop();
        if(s.empty())
            cout<<0<<" ";
        else
            cout<<s.top().second<<" ";
        
        
        s.push({num, i});
    }
}
