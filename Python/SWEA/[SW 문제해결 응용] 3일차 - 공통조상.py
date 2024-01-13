# 왜 D5지...?
# DFS, BFS 변형 문제


def dfs(node):
    if node in same_parent_check:
        global same_parent
        same_parent = node
        return

    same_parent_check.append(node)
    visited[node] = True

    for v in to_parent[node]:
        if not visited[v]:
            dfs(v)

def dfs2(node):
    global cnt
    cnt += 1
    visited[node] = True

    for v in graph[node]:
        if not visited[v]:
            dfs2(v)

for tc in range(1, int(input()) + 1):


    Node, Edge, a,b = map(int,input().split())

    graph = [[] for _ in range(Node + 1)]
    to_parent = [[] for _ in range(Node + 1)]

    visited = [False] * (Node + 1)

    tmp = list(map(int, input().split()))
    for i in range(0, len(tmp), 2):
        graph[tmp[i]].append(tmp[i+1])
        to_parent[tmp[i + 1]].append(tmp[i])

    same_parent_check = []
    same_parent = None


    dfs(a)
    visited = [False] * (Node + 1)
    dfs(b)
    visited = [False] * (Node + 1)


    cnt = 0
    dfs2(same_parent)

    print('#' + str(tc), end = ' ')
    print(same_parent, cnt)