def dfs(depth, value):
    global answer
    if depth == n:
        if value == target:
            answer += 1
        return

    dfs(depth + 1, value)
    dfs(depth + 1, value + arr[depth])

for tc in range(1, int(input()) + 1):

    n, target = map(int, input().split())
    arr = list(map(int, input().split()))


    answer = 0
    dfs(0,0)
    print(f'#{tc} {answer}')