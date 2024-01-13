
T = int(input())

for tc in range(1,T+1):
    n = int(input())
    arr = list(map(int, input().split()))

    answer = {0}

    for i in arr:
        for j in tuple(answer):
            answer.add(i+j)

    print(f'#{tc} {len(answer)}')