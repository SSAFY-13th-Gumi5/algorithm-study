#include<iostream>
using namespace std;
int main(void) {

    int N;
    int dp[31] = {0, };
    dp[0] = 1;
    cin >> N;

    for (int i = 2; i <= N; i += 2) {
        dp[i] += 3 * dp[i - 2];
        for (int j = 4; j <= i; j += 2) {
            dp[i] += 2 * dp[i - j];
        }
    }

    cout<<dp[N]<<endl;

    return 0;
}
//299303201
