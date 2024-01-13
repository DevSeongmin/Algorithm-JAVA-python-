# https://www.acmicpc.net/problem/13398

# DP 점화식
# LtoR 왼쪽에서 오른쪽으로 진행하며 D[i] = max(D[i], D[i]+D[i-1]
# RtoL 오른쪽에서 왼쪽으로 진행하며 D[i] = max(D[i], D[i]+D[i+1])
# 이 두 리스트의 최댓값을 구하면 하나의 원소를 제거하지 않았을 때 연속합의 최댓값을 구할 수 있다.
# LtoR[i] + RtoL[i+2] 가 하나의 원소를 제거했을 때 최댓값이므로 이 중 가장 큰 값을 출력하여 문제를 해결할 수 있다.
# 왜 이렇게 하면 되는지는 손으로 써가며 생각해보면 알 수 있음

import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().rstrip().split()))


LtoR = arr[:]
RtoL = arr[:]

for i in range(1,N):
    LtoR[i] = max(LtoR[i], LtoR[i]+LtoR[i-1])
    
for i in range(N-2,-1,-1):
    RtoL[i] = max(RtoL[i],RtoL[i] + RtoL[i+1])    
solve = max(LtoR+RtoL)


for i in range(N-2):
    solve = max(solve, LtoR[i] + RtoL[i+2])
    
print(solve)

