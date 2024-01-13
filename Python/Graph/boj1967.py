#https://www.acmicpc.net/problem/1967


#문제의 핵심 ! 
#입력 받은 가중치를 가지는 트리에서 처음 루트 노드에서 탐색을해 가장 먼 노드를 구한다.
#다시 방문 리스트를 초기화 해준 후 가장 먼 노드에서 다시한번 탐색 후 
#방문 리스트에서 가장 큰 값을 출력해주면 트리의 지름이 된다.

import sys
limit_number = 15000
sys.setrecursionlimit(limit_number)
input = sys.stdin.readline

N = int(input())
visited = [-1] * (N+1)
graph = [[] for _ in range(N+1)]

for i in range(N-1):
    n1,n2,weight = map(int, input().split())
    graph[n1].append([n2,weight])
    graph[n2].append([n1, weight])
    
    
def dfs(n,weight):
    if visited[n] == -1:
        visited[n] = weight
        
    for v, w in graph[n]:
        if visited[v] == -1:    
            dfs(v,weight + w)
    
dfs(1,0)
start_node = visited.index(max(visited))
visited = [-1] * (N+1)
dfs(start_node,0)

print(max(visited))