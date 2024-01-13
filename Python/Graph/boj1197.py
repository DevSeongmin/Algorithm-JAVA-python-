# MST(최소 신장 트리) 알고리즘 

import sys
from heapq import heappush, heappop
input = sys.stdin.readline

# 유니온 파인드 
def find(a):
    if check_set[a] == a:
        return a
    
    check_set[a] = find(check_set[a])
    return check_set[a]

def union(a,b):
    a = find(a)
    b = find(b)
    if a <= b:
        check_set[b] = a
    else:
        check_set[a] = b
        

v,e = map(int, input().split())

check_set = [i for i in range(v+1)]
hq = []

#힙큐에 가중치를 기준으로 push
for _ in range(e):
    n1,n2,w = map(int, input().split())
    heappush(hq, (w,n1,n2))
    
    
answer = 0
# 노드 개수 -1 번의 엣지 연결을 하면 최소 신장 트리가 완성 됩니다. 
for _ in range(v-1):
    while 1:
        w,n1,n2  = heappop(hq)
        # 연결할 두 노드가 다른 집합이라면 연결 
        if find(n1) != find(n2):
            break
    union(n1,n2)
    # 최소 신장 트리의 가중치의 합 갱신 
    answer += w
    
print(answer)
    
    