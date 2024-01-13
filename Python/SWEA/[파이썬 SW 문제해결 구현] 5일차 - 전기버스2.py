# 빽 트래킹

def dfs(x, depth):
    global solve

    # 이미 구한 최소 베터리 교체 횟수보다 크다면 탐색종료 (Pruning)
    if x >= (n-1):
        solve = min(solve, depth)
        return

    if depth < solve:
        for i in range(x+1, x+arr[x] + 1):
            dfs(i,depth + 1)


for tc in range(1, int(input()) + 1):

    n, *arr = map(int, input().split())
    solve = float('inf')
    dfs(0,0)

    print(f'#{tc} {solve-1}')