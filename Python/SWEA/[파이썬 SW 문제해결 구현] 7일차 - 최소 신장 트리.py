# 크루스 알고리즘으로 최소신장 트리의 비용 계산

def find(n):
    if n == set_chceck[n]:
        return n

    set_chceck[n] = find(set_chceck[n])
    return set_chceck[n]


def union(a,b):
    a, b = find(a), find(b)
    if a <= b:
        set_chceck[b] = a
    else:
        set_chceck[a] = b

for tc in range(1, int(input()) + 1):

    node, edge = map(int, input().split())
    set_chceck = [i for i in range(node+1)]
    graph = []

    for _ in range(edge):
        s,e,value = map(int, input().split())
        graph.append([s,e,value])

    graph.sort(key = lambda x: -(x[-1]))

    answer = 0

    while graph:
        v1, v2, value = graph.pop()
        if find(v1) != find(v2):
            union(v1,v2)
            answer += value

    print(f'#{tc} {answer}')