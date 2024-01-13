# 플로이드 워셜 알고리즘

for tc in range(1, int(input()) + 1):
    node, *graph = map(int, input().split())

    graph = [list(map(lambda x: x if x != 0 else float('inf'), graph[i:i+node])) for i in range(0, node*node, node)]

    for i in range(node):
        graph[i][i] = 0

    for k in range(node):
        for i in range(node):
            for j in range(node):
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

    graph = [sum(i) for i in graph]
    print(f'#{tc} {min(graph)}')



