# 벨만 포드 알고리즘  


import sys
input = sys.stdin.readline

n, e = map(int, input().split())

edge = []
distance = [float('inf')] * (n + 1)

# 벨만 포드 알고리즘은 모든 엣지를 확인하기에 엣지 리스트로 표현 
for _ in range(e):
    edge.append(list(map(int, input().split())))
    

# 시작 노드는 1번 
distance[1] = 0

# 매 반복마다 모든 간선 확인 
for _  in range(n):
    for s, e, w in edge:
        # 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 업데이트 
        distance[e] = min(distance[e], distance[s] + w)
    
check = True


# 모든 간선에 대해 한번 더 수행함으로 음수 사이클 확인 
for s, e, w in edge:
    if distance[e] > distance[s] + w:
        check = False
        

if check:
    for i in range(2, n+1):
        if distance[i] == float('inf'):
            print(-1)
        else:
            print(distance[i])
            
else:
    print(-1)