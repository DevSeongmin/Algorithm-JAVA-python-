# https://www.acmicpc.net/problem/25633


N = int(input())

arr =  [0] + list(map(int, input().split()))



dp = [0] + [1] * N


for i in range(1, N+1):
    tmp = 0
    tmp_idx = i
    for j in range(i-1,0,-1):
        if arr[j] >= arr[i] and dp[j] > tmp:
            tmp = dp[j]
            tmp_idx = j

    if tmp != 0:
        arr[i] += arr[tmp_idx]
        dp[i] = tmp + 1

print(max(dp))