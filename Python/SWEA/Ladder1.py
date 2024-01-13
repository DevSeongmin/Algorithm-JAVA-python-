def dfs(x, y):
    global solve
    visited[y][x] = True
    if y == 0:
        solve = x
        return

    if 0 <= x-1 < 100 and arr[y][x - 1] == 1 and not visited[y][x-1]:
        dfs(x - 1, y)

    elif 0 <= x+1 < 100 and arr[y][x + 1] == 1 and not visited[y][x+1]:
        dfs(x + 1, y)

    else:
        dfs(x, y - 1)

import sys
sys.stdin = open("input.txt", "r")

t = int(input())
arr = [list(map(int, input().split())) for _ in range(100)]

visited = [[False]* 100 for _ in range(100)]

x = arr[-1].index(2)
y = 99

solve = 0
dfs(x,y)
print(f'#{t} {solve}')




