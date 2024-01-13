# https://www.acmicpc.net/problem/11509
# 공간을 사용해서 시간을 버는것이 핵심

n = int(input())
balloons = list(map(int, input().split()))

check = [0] * 1000001
answer = 0


for i in range(n):
    if check[balloons[i]] == 0:
        answer += 1
        check[balloons[i]-1] += 1
        
    else:
        check[balloons[i]] -= 1
        check[balloons[i]-1] += 1
print(answer)
            
