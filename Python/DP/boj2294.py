# https://www.acmicpc.net/problem/2294

# 핵심!! DP 테이블 갱신 시 
# min(DP[i], DP[i - 동전 값] + 1)
import sys
input = sys.stdin.readline


n, target = map(int, input().split())
dp = [0] + [10001] * (target)



coin = [int(input()) for _ in range(n)]
coin.sort()


for i in coin:
    for j in range(i,target+1):
        dp[j] = min(dp[j], dp[j-i] + 1)
        
if dp[target] == 10001:print(-1)
else: print(dp[target])