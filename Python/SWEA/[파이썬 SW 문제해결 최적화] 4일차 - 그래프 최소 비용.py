# 플로이드 워샬 알고리즘

for tc in range(1, int(input()) + 1):

    N = int(input())

    graph = [list(map(int, input().split())) for _ in range(N)]
    dist = [[float("inf")] * N for _ in range(N)]


    for y in range(N):
        for x in range(N):
            if graph[y][x] != 0:
                dist[y][x] = graph[y][x]


    for k in range(N):
        for i in range(N):
            if i!=k :
                for j in range(N):
                    if j!=k and j!=i :
                        dist[i][j] = min( dist[i][j],dist[i][k]+dist[k][j] )

    answer = -float('inf')

    for i in range(N):
        for j in range(N):
            if dist[i][j] != float('inf'):
                answer = max(answer, dist[i][j])


    print(f'#{tc} {answer}')