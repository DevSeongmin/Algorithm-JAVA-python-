# https://www.acmicpc.net/problem/2156

N = int(input())

if N == 1:
    print(int(input()))
    exit(0)

arr =[int(input()) for _ in range(N)] 
DP = [0] * N
DP[0] = arr[0]
DP[1] = arr[0] + arr[1]

for i in range(2,N):
    DP[i] = max(arr[i] + DP[i-2] , arr[i] + arr[i-1] + DP[i-3])
    
    # 3번 이상 건너뛸 경우를 생각해서 다음 식을 추가해야한다. 
    DP[i] = max(DP[i], DP[i-1])



print(max(DP))

