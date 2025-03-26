#include<stdio.h>
long long pinaryNum(int n);
long long memo[90];

int main(void){
    int N;
    scanf("%d",&N);

    printf("%lu\n", pinaryNum(N));

    return 0;
}

long long pinaryNum(int n){
    if(n==0){
        return 0;
    } else if(n==1){
        return 1;
    } else {
        if(memo[n]) return memo[n];
        return memo[n]=pinaryNum(n-1)+pinaryNum(n-2);
    }
}
