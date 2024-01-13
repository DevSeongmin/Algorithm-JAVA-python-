# m-coloring 문제

# color_check = [-1] * (node + 1)
# 위 색깔 체크 리스트에 대해 칠할 수 있는 모든 경우의 상태 공간트리를 탐색하며
# 인접한 노드와 색이 겹치는경우 Plunning시켜서 해결
# 만약 모두 색칠이 된경우 answer = 1


def coloring(depth, color_check):
    global answer
    if depth == Node + 1:
        answer = 1
        return

    for i in range(Color):
        color_check[depth] = i

        flag = True
        for v in graph[depth]:
            if i == color_check[v]:
                flag = False
        if flag:
            coloring(depth + 1, color_check)


for tc in range(1, int(input()) + 1):

    Node, Edge, Color = map(int, input().split())

    graph = [[] for _ in range(Node + 1)]
    visited = [False] * (Node + 1)

    for _ in range(Edge):
        s,e = map(int, input().split())
        graph[s].append(e)
        graph[e].append(s)



    answer = 0
    coloring(1, [-1] * (Node+1))
    print(f'#{tc} {answer}')


