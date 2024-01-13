n = int(input())

graph = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            graph[i][j] = True
        else:
            graph[i][j] = False


for k in range(n):
    for s in range(n):
        for e in range(n):
            graph[s][e] = graph[s][e] or graph[s][k] and graph[k][e]
            

for i in range(n):
    for j in range(n):
        print(int(graph[i][j]), end = ' ')
    print()