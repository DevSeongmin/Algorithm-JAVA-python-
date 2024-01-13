import sys
sys.stdin = open("input.txt", "r")

for tc in range(1, 11):
    n = int(input())

    ground = list(map(int, input().split()))

    for i in range(n):
        maxg = max(ground)
        ming = min(ground)
        ground[ground.index(maxg)] -= 1
        ground[ground.index(ming)] += 1

    print(f'#{tc} {max(ground) - min(ground)}')
