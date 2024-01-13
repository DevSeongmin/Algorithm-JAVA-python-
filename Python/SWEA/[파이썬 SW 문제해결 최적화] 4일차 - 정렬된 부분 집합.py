# 최장 증가 수열 -- DP
for tc in range(1, int(input()) + 1):

    arr = list(map(int, input().split()))

    l = len(arr)
    dp = [0] * l


    for i in range(1,l):
        dp[i] = 1
        for j in range(1,i):
            if arr[j] < arr[i]:
                dp[i] = max(dp[i], dp[j] + 1)

    print(f'#{tc} {max(dp)}')
