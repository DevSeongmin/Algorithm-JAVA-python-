for tc in range(1, int(input()) + 1):
    container, truck = map(int, input().split())
    containers = sorted(list(map(int, input().split())))
    trucks = sorted(list(map(int, input().split())))

    answer = 0
    while containers and trucks:

        if trucks[-1] >= containers[-1]:
            answer += containers[-1]
            trucks.pop()
            containers.pop()
        else:
            containers.pop()

    print(f'#{tc} {answer}')