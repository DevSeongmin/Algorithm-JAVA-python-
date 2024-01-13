from itertools import permutations

for tc in range(1, int(input()) + 1):

    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    answer = float('inf')

    for i in tuple(permutations(([i for i in range(1,n)]))):
        tmp_arr = [0] + list(i) + [0]
        tmp = 0
        for i in range(n):
            tmp += arr[tmp_arr[i]][tmp_arr[i+1]]

        answer = min(tmp, answer)

    print(f'#{tc} {answer}')