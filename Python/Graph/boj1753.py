# 힙큐를 이용한 다익스트라 

from heapq import heappop, heappush

import sys
input = sys.stdin.readline
node, edge = map(int, input().split())

start = int(input())

graph = [[] for _ in range(node+1)]
distance = [float('inf')] * (node + 1)
visited = [False] * (node + 1)


for _ in range(edge):
    n1, n2, w = map(int, input().split())
    graph[n1].append((n2, w))
    


hq = []
distance[start] = 0
heappush(hq, [0, start])


while hq:
    _, cv = heappop(hq)
    if not visited[cv]:
        visited[cv] = True
    
        for v, w in graph[cv]:
            distance[v] = min(distance[v], distance[cv] + w)
            if not visited[v]:
                heappush(hq, [distance[v], v])
            
for i in range(1, node + 1):
    if visited[i]:
        print(distance[i])
    else:
        print('INF')