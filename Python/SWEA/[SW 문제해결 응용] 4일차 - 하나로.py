# MST를 구하는 최소 신장 트리 문제!
# 크루스칼 알고리즘 사용

# 같은 집합인지 확인하기 위해 유니온-파인드 함수 구현

def find(a):
    if union_check[a] == a:
        return a
    else:
        union_check[a] = find(union_check[a])
        return union_check[a]

def union(a, b):
    a = find(a)
    b = find(b)
    if a <= b:
        union_check[b] = a
    else:
        union_check[a] = b


for tc in range(1,int(input())+1):

    n = int(input())
    x = list(map(int, input().split()))
    y = list(map(int, input().split()))
    E = float(input())


    # 같은 집합인지 체크하는 리스트
    union_check = [i for i in range(n)]


    g  = [[i[0],i[1]] for idx,i in enumerate(zip(x,y))]
    graph = {i : [] for i in range(n)}

    for i in range(n):
        for j in range(i+1,n):
            if i in graph:
                graph[i].append([j, ((g[i][0] - g[j][0]) ** 2 + (g[i][1] - g[j][1]) ** 2) * E])

    arr = []

    for i in graph:
        for j in graph[i]:
            arr.append([i] + j)

    # 2차원 리스트 [시작 점, 도착 점, 거리] 에서 거리 기준으로 내림차 순 정렬
    arr = sorted(arr, key = lambda x : -x[-1])

    answer= 0
    while arr:
        tmp = arr.pop()

        # 거리가 짧은 간선 부터 순차 적으로 뽑아 같은 집합이 아니라면 연결하고
        # 거리 길이 없데이트
        if find(tmp[0]) != find(tmp[1]):
            union(tmp[0], tmp[1])
            answer += tmp[2]

    # 소숫점 첫 째 자리에서 반올림
    if answer - int(answer) >= 0.5:
        answer = int(answer) + 1
    else:
        answer = int(answer)

    print(f'#{tc} {answer}')