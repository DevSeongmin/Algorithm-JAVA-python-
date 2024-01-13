#플로이드 워셜 알고리즘

import sys
input = sys.stdin.readline

node = int(input())
edge = int(input())

inf = float('inf')

# node수 * node수 사이즈의 인접행렬 
graph = [[inf] * node for _ in range(node)]

# 해당 문제에서는 노드의 시작이 1부터임으로 시작과 끝 노드에 -1식 하여 인접행렬 업데이트 해줍니다. 
for _ in range(edge):
    s,e,w = map(int, input().split())
    s -= 1
    e -= 1
    # 같은 버스노선이 여러개가 주어질 수도 있음 가장 작은값으로 할당 
    graph[s][e] = min(w,graph[s][e])
    

# 자기 자신으로 가는 경로는 0으로 초기화
for i in range(node):
    graph[i][i] = 0
    
for t in range(node):
    for s in range(node):
        for e in range(node):
            graph[s][e] = min(graph[s][e], graph[s][t] + graph[t][e])
                

    
for gr in graph:
    for g in gr:
        if g == inf:
            g = 0
        print(g, end = ' ')
    print()