# 빽 트래킹 순열 문제

def dfs(depth, value):
    global answer
    if depth == n:
        answer = min(answer, value)
        return
    if value > answer:
        return

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            dfs(depth + 1, value + arr[depth][i])
            visited[i] = False

for tc in range(1, int(input())+1):

    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    visited = [False]  * n
    answer = float('inf')

    dfs(0,0)

    print(f'#{tc} {answer}')
