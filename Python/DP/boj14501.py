#https://www.acmicpc.net/problem/14501

import sys
input = sys.stdin.readline

N = int(input())
T = [0] * N
P = [0] * N
D = [0] * (N+1)
for i in range(N):
    a,b = map(int, input().split())
    T[i] = a
    P[i] = b


# N 일의 거꾸로 반복을 진행 
# i 일 부터 퇴사일 까지의 최대수익을 기록 
# 만약 퇴사일 안에 상담이 끝나지 않는 다면 D[i] = D[i+1]
# 만약 퇴사일 안에 상담이 끝난다면 D[i] = max(D[i+1], P[i] + D[i+T[i]]
for i in range(N-1,-1,-1):
    if T[i] > N - i:
        D[i] = D[i+1]
    else:
        D[i] = max(D[i+1], P[i]+D[i+T[i]]) 
    
    
print(D[0])