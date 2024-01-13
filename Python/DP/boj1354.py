# # https://www.acmicpc.net/problem/1351


#  이 문제는 메오이제이션으로 리스트를 사용해서 DP테이블을 만들면 메모리초과가 뜬다.
# 그렇기 때문에 목표값에서 Top-Down 방식으로 접근해야 한다.


import sys

n, p, q, x, y = map(int, sys.stdin.readline().split())

# 딕셔너리 선언
d = {0:1}

def dfs(n):
    if n in d:
        return d[n]
    
    else:
        if n // p - x <= 0:
            d[n // p - x] = 1
            
        if n // q - y <= 0:
            d[n // q - y ] = 1
            
        d[n] = dfs(n // p - x) + dfs(n // q - y)
        return d[n]
    
print(dfs(n))
