
for tc in range(1, int(input()) + 1):

    n, m = map(int, input().split())

    A = sorted(list(map(int, input().split())))
    B = list(map(int, input().split()))
    cnt = 0

    for target in B:
        left = 0
        right = n - 1
        answer = -1
        check = set()
        before = ''
        while left <= right:
            mid = (left + right) // 2
            if A[mid] == target:
                answer = mid
                break

            elif A[mid] > target:
                if before == 'left':
                    break
                before = 'left'
                right = mid - 1

            elif A[mid] < target:
                if before == 'right':
                    break
                before = 'right'
                left = mid + 1

        if answer != -1:
            cnt += 1

    print(f'#{tc} {cnt}')

