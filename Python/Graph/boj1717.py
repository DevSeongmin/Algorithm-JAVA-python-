import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


# 파인드 연산 
def find(a):
    if a == union_find_set[a]:
        return a
    # 재귀적으로 돌아오며 각 인덱스 값들을 대표 노드로 업데이트     
    union_find_set[a] = find(union_find_set[a])
    return union_find_set[a]

# 유니온 연산 
def union(a,b):
    # 대표노드 연결 
    a,b = find(a), find(b)
    
    #편의상 더 작은 노드가 대표 노드가 되도록 구현 
    if a <= b:
        union_find_set[b] = a
    else:
        union_find_set[a] = b
        

n, q = map(int, input().split())
union_find_set = [i for i in range(n+1)]




for _ in range(q):
    a,b,c = map(int, input().split())
    if a == 1:
        if find(b) == find(c):
            print('YES')
        else:
            print('NO')
        
    else:
        union(b,c)