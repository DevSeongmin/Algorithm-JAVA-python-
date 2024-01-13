#https://www.acmicpc.net/problem/2468

# 문제에서 시간 or 메모리 초과가 났던이유 
# copy로 확인했기때문
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(x,y):
    if not visited[y][x]:
        visited[y][x] = True
        
        for x_move,y_move in move:
            if 0 <= x+x_move < N and 0 <= y+y_move < N and not visited[y+y_move][x+x_move]:
                dfs(x+x_move, y+y_move)
            
move = [[0,1], [1,0], [-1,0], [0,-1]]   

N = int(input())

maps = [list(map(int, input().split())) for i in range(N)]

max_height = max([max(i) for i in maps])

solve = 0
for height in range(0,max_height):
    count = 0
    
    visited = [[False] * N for i in range(N)]
    
    for i in range(N):
        for j in range(N):
            if maps[i][j] <= height:
                visited[i][j] = True
                
    for i in range(N):
        for j in range(N):
            
            #문제가 됐던 부분
            #tmp = copy.deepcopy(visited)
            #dfs(i,j)
            #if tmp != visited: count += 1
            
            if not visited[j][i]:
                count += 1
                dfs(i,j)
                
    if count > solve: solve = count
    
print(solve)          
                
     
    
            

    