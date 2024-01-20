# 작성자 : 황성민
# 작성일자 : 24.01.20
# 문제 접근 및 풀이 : https://blog.naver.com/steadydeveloper/223328467811


def find(a):
    if a == parents[a]:
        return a 

    parents[a] = find(parents[a])
    return parents[a]


def union(a,b):
    a = find(a)
    b = find(b)
    parents[a] = b


import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

NODE, N = map(int, input().split())

parents = list(range(NODE))



flag = False
for idx in range(N):
    a,b = map(int, input().split())
    
    if find(a) == find(b):
        print(idx+1)
        flag = True
        break
    else:
        union(a,b)

if not flag:
    print(0)
    
