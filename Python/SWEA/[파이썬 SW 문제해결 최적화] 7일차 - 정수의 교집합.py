

for tc in range(1, int(input()) + 1):
    a, b = map(int ,input().split())

    a_set = set(map(int, input().split()))
    b_set = set(map(int, input().split()))

    a_l = len(a_set)
    after_l = len(a_set - b_set)

    print(f'#{tc} {a_l - after_l}')