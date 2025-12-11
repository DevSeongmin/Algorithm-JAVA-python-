import sys
import heapq
from typing import List, Tuple

input = sys.stdin.readline

def is_in(idx : int, N : int) -> bool :
    return 0 <= idx < N

def make_graph(N : int, A: List[int], B: List[int]) -> List[List[Tuple[int]]]:
    
    graph = [[] for i in range(N+1)]
    
    for i in range(N):
        time = B[i]
        
        if (is_in(i + A[i], N)):
            graph[i + A[i]].append((i, time))
        if (is_in(i - A[i], N)):
            graph[i - A[i]].append((i, time))
        
        if (not is_in(i + A[i], N) or not is_in(i - A[i], N)):
            graph[N].append((i, time))

    return graph

def find_short_paths(N: int, graph: List[List[Tuple[int]]]) -> List[int]:
    dist = [float('inf') for i in range(N+1)]
    dist[N] = 0
    
    pq = []
    heapq.heappush(pq, (0, N))
    
    while(pq):
        time, node = heapq.heappop(pq)
        
        for next_node, weight in graph[node]:
            if (dist[next_node] > time + weight):
                dist[next_node] = time + weight
                heapq.heappush(pq, (time+weight, next_node))
    
    return dist

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

graph = make_graph(N, A, B)

answers = find_short_paths(N, graph)

print(*answers[:-1])

