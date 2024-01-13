# https://www.acmicpc.net/problem/1339

# 핵심 ! 
# 알파벳의 각 자리수를 기준으로 점수를 매긴 후 
# 점수가 높은 알파벳부터 9~1값 부여 
# 마지막으로 알파벳을 숫자로 변환 후 값 출력

import sys
input = sys.stdin.readline

n = int(input())
arr = [input().rstrip() for _ in range(n)]
d = {}

for i in arr:
    mul = 1
    for j in range(len(i)-1,-1,-1):
        if not i[j] in d:
            d[i[j]] = 0   
        d[i[j]] += mul
        mul *= 10
        
tmp = 9
for i in sorted(d.items(), key=lambda x: x[1], reverse=True):
    d[i[0]] = tmp
    tmp -= 1

solve = []
for i in arr:
    tmp = ''
    for j in i:
        tmp += str(d[j])
    solve.append(tmp)
    
print(sum(map(int, solve)))       