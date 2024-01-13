# DFS 탐색문제

def dfs(n):
    global solve
    if n == 99:
        solve = 1
        return

    if not visited[n]:
        visited[n] = True
        if n in graph:
            for v in graph[n]:
                dfs(v)


for tc in range(1,11):

    tc, n = map(int, input().split())

    arr = list(map(int, input().split()))
    graph = {}

    for i in range(0, n*2, 2):
        if arr[i] in graph:
            graph[arr[i]].append(arr[i+1])
        else:
            graph[arr[i]] = [arr[i+1]]

    visited = [False] * 100

    solve = 0

    dfs(0)

    print(f'#{tc} {solve}')

