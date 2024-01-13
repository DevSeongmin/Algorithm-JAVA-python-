# 정점과 간선이 주어졌을 때
# 몇 개의 그래프로 구성 되어있는지 구하는 문제

def dfs(v):
    visited[v] = True

    for n in graph[v]:
        if not visited[n]:
            dfs(n)


for tc in range(1, int(input()) + 1):

    node, edge = map(int, input().split())

    arr = list(map(int, input().split()))

    graph = [[] for _ in range(node+1)]
    visited = [False] * (node + 1)

    for i in range(0,edge*2,2):

        graph[arr[i]].append(arr[i+1])
        graph[arr[i+1]].append(arr[i])


    answer = 0

    for i in range(1,node+1):
        if not visited[i]:
            answer += 1
            dfs(i)

    print(f'#{tc} {answer}')