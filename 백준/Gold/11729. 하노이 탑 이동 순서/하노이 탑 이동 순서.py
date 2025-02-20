import sys
input = sys.stdin.readline
answer = 0
s = []
e = []
def hanoi(N, start, end, sub):
    global answer, s, e
    if N==1:
        s.append(start)
        e.append(end)
        answer+=1
    else:
        hanoi(N-1, start, sub, end)
        s.append(start)
        e.append(end)
        answer+=1
        hanoi(N-1, sub, end, start)



N = int(input())

hanoi(N, 1, 3, 2)
print(answer)
for i in range(len(s)):
    print(s[i], e[i])