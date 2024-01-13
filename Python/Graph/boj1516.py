# https://www.acmicpc.net/problem/1516
# 위상 정렬 활용 

import sys
sys.setrecursionlimit(10**6)
input=  sys.stdin.readline



building = int(input())
build_time = [0] * (building + 1)
indeg = [0] * (building + 1)
answer = [0] * (building+1)
graph = [[] for _ in range(building + 1)]


for i in range(1, building+1):
    a, *b = map(int, input().split())
    build_time[i] = a
    for j in range(len(b) - 1):
        graph[b[j]].append(i)
        indeg[i] += 1
        
def dfs(n):
    
    for v in graph[n]:
        indeg[v] -= 1
        answer[v] = max(answer[v], build_time[n] + answer[n])
        if indeg[v] == 0:
            dfs(v)

s = [] 
for i in range(1,building+1):
      if indeg[i] == 0 :
          s.append(i)

for i in s:
    dfs(i)   

for i in range(1, building+1):
    print(answer[i] + build_time[i])