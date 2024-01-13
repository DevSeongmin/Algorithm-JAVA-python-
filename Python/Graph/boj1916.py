import sys
input = sys.stdin.readline

node = int(input())
edge = int(input())



graph = [[] for _ in range(node+1)]
distance = [float('inf')] * (node + 1)
visited = [False] * (node + 1)




for _ in range(edge):
    n1, n2, w = map(int, input().split())
    graph[n1].append((n2, w))
    
    
start, end  = map(int, input().split())

distance[start] = 0

for _ in range(node):
    
    min_val = float('inf')
    u = -1 
    for i in range(node + 1):
        if not visited[i] and distance[i] < min_val:
            min_val = distance[i]
            u = i
            
    visited[u] = True
    
    for e, d in graph[u]:
        distance[e] = min(distance[e], distance[u] + d)
        
    
print(distance[end])