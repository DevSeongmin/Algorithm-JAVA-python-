
def search(arr, s):
    global answer
    # 같은 교환 횟수와 같은 수열은 플러닝 하기위한 visited set
    visited.add(tuple(arr + [s]))

    # swap 만큼 바꾼 카드의 모든 경우에 수에서
    # 가장 큰 수를 정답에 넣는다.
    if s == swap:
        answer = max(answer, int(''.join(arr)))
        return

    for i in range(l-1):
        for j in range(i+1,l):
            tmp = arr[:i] + [arr[j]] + arr[i+1:j] + [arr[i]] + arr[j+1:]

            if tuple(tmp + [s+1]) not in visited:
                # 방문한 적이 없다면 재귀적으로 교환
                search(tmp, s + 1)



for tc in range(1, int(input()) + 1):

    arr, swap = input().split()
    arr = list(arr)
    swap = int(swap)
    l = len(arr)
    check = 0
    visited = set()
    answer = 0
    search(arr, 0)

    print(f'#{tc} {int(answer)}')


