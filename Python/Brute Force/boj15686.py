#https://www.acmicpc.net/problem/15686

import sys
from itertools import combinations

input = sys.stdin.readline

N, bhc_num = map(int, input().split())

maps = [list(map(int, input().split())) for _ in range(N)]
hous = []
bhc = []
solve = float('INF')
for i in range(N):
    for j in range(N):
        if maps[i][j] == 1:
            hous.append([i,j])
        elif maps[i][j] == 2:
            bhc.append([i,j])
           
        
for i in combinations(bhc, bhc_num):
    tmp = 0
    for h in hous:
        min_val = float('INF')
        for k in i:
            min_val = min(min_val, (abs(h[0] - k[0]) + abs(h[1] - k[1])))
        tmp += min_val
    solve = min(solve,tmp)
print(solve)