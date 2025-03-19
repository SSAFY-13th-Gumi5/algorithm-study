'''
 # @ Author: Jinwoo Choi
 # @ Create Time: 2022-11-08 00:53:47
 # @ Modified by: Jinwoo Choi
 # @ Modified time: 2022-11-08 00:53:49
 # @ Problem name: AC
 # @ Solution: 단순 구현
 # @ result: success
 '''

import sys
from collections import deque

t = int(input())

for i in range(t):
    P = sys.stdin.readline().rstrip()
    N = int(input())
    arr = sys.stdin.readline().rstrip()[1:-1].split(",")
    queue = deque(arr)

    rev, front, back = 0, 0, len(queue)-1
    flag = 0
    if N == 0:
        queue = []
        front = 0
        back = 0

    for j in P:
        if j == 'R':
            rev += 1
        elif j == 'D':
            if len(queue) < 1:
                flag = 1
                print("error")
                break
            else:
                if rev % 2 == 0:
                    queue.popleft()
                else:
                    queue.pop()
    if flag == 0:
        if rev % 2 == 0:
            print("[" + ",".join(queue) + "]")
        else:
            queue.reverse()
            print("[" + ",".join(queue) + "]")