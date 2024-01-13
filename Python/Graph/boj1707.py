#https://www.acmicpc.net/problem/1707


#이분 그래프의 개념 https://ko.wikipedia.org/wiki/%EC%9D%B4%EB%B6%84_%EA%B7%B8%EB%9E%98%ED%94%84

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def dfs(start):
    global solve
    visited[start] = True
    
    for v in graph[start]:
        if not visited[v]:
            check[v] = (check[start]+1) % 2
            dfs(v)
            
        # 이 부분이 핵심 
        # 인접한데 같은 그룹이라면
        elif check[start] == check[v]:
            solve = False
            return 
            
    
for _ in range(int(input())):
    
    solve = True
    v,e = map(int, input().split())
    visited = [False] * (v+1)
    check = [0] * (v+1)
    graph = [[] for _ in range(v+1)]


    for _ in range(e):
        v_1, v_2 = map(int, input().split())
        graph[v_1].append(v_2)
        graph[v_2].append(v_1)
        
        
    for i in range(1,v+1):
        if solve:
            dfs(i)
        else:
            break

    if solve: print("YES")
    else: print("NO")
        
        