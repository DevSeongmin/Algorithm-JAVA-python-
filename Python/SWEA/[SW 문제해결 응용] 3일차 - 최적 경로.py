# DFS와 가지치기(pruning) 기법으로 해결


def dfs(depth, x, y, distance):
    global solve

    # dfs로 거리를 업데이트하다가 현재 구한 값(solve) 보다 클 경우 중단(pruning)
    if solve < distance:
        return

    # 모든 지점을 들렀고 구한 solve 값보다 작을경우 집까지의 거리를 더해준 다음 더 작으면 solve값 갱신
    if depth == n:
        solve = min(solve, distance + abs(home[0] - x) + abs(home[1] - y))
        return


    for i in range(n):
        if not visited[i]:
            # 재귀로 방문 안한 곳들을 방문하며 거리 값 갱신
            visited[i] = True
            dfs(depth + 1, arr[i][0], arr[i][1], distance + abs(x - arr[i][0]) + abs(y - arr[i][1]))

            # 재귀를 수행하다가 해당 가지를 빠져나오면 다시 방문 안한것으로 초기화
            visited[i] = False


for tc in range(1, int(input()) + 1):

    n = int(input())

    arr = list(map(int, input().split()))

    company = arr[:2]
    home = arr[2:4]

    # 회사와 집을 제외한 지점들을 2차원 리스트로 생성
    arr = [[arr[i], arr[i+1]] for i in range(4, n*2+4, 2)]

    # DFS탐색을 하며 같은 지점을 가는 것을 막기위한 방문 리스트
    visited = [False] * n
    solve = float('inf')

    dfs(0, company[0], company[1], 0)

    print(f'#{tc} {solve}')
