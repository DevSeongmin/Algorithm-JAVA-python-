#https://www.acmicpc.net/problem/1915


# DP 점화식 주어진 사각형을 모두 탐색하며 위, 왼쪽위, 왼쪽에의 최소값에 + 1 한 값을 대입해준다. 
# 위 과정을 거친 후 정사각형의 넓이를 구해야하기 때문에 **2 해서 출력해주면 끝
# 모든 값이 0 일 경우에는 예외처리 

import sys

input = sys.stdin.readline

n,m = map(int, input().split())

maps = [[int(i) for i in input().rstrip()] for _ in range(n)]


solve = 1
for i in range(1,n):
    for j in range(1,m):
        if maps[i][j] == 1:
            tmp = min(maps[i-1][j], maps[i-1][j-1], maps[i][j-1]) + 1
            maps[i][j] = tmp
            if solve < tmp:solve = tmp
      
      
if max(map(max, maps)) == 0:print(0)             
else:print(solve ** 2)
        
