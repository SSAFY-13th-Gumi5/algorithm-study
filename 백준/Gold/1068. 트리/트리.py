def dfs(x, visited):
    global graph
    global answer
    visited[x] = True
    if len(graph[x]) == 0:
        answer+=1
        return
    else:
        for next in graph[x]:
            if not visited[next]:
                dfs(next, visited)
   


N = int(input())
graph = []
visited = [False for _ in range(N)]
for _ in range(N):
    graph.append([])
line = list(map(int, input().split()))
root_idx = -1

X = int(input())


for i in range(len(line)):
   
    if line[i] == -1:
        root_idx = i
        continue
    if i ==X:
        continue
    graph[line[i]].append(i)
answer = 0

if X != root_idx:
    visited[X] = True
    dfs(root_idx, visited)

print(answer)


