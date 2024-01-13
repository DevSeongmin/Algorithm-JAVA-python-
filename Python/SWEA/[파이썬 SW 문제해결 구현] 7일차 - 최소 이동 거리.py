
for tc in range(1, int(input()) + 1):

    node ,edge = map(int, input().split())

    distance = [0] + [float('inf')] * (node)
    visited = [False] * (node + 1)
    graph = [[] for _ in range(node + 1)]


    for _ in range(edge):
        s,e,d = map(int, input().split())
        graph[s].append((e,d))



    # 다익스트라 알고리즘은 노드의 개수 만큼 선택을 반복하면 된다.
    for _ in range(node):
        minst = float('inf')
        u = -1

        # 현재 상태에서 거리가 가장 작은 노드를 선택함
        for i in range(node + 1):
            if not visited[i] and distance[i] < minst:
                minst = distance[i]
                u = i
        visited[u] = True

        # 선택한 노드와 연결된 노드들의 거리 업데이트
        for e,d in graph[u]:
            distance[e] = min(distance[e], distance[u] + d)




    print(f'#{tc} {distance[-1]}')