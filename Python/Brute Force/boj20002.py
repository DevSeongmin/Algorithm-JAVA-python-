# https://www.acmicpc.net/problem/20002

import sys

input = sys.stdin.readline


n = int(input())

trees = [[0] * (n+1)] + [[0] + list(map(int, input().split())) for _ in range(n)]


answer = -float('inf')

for y in range(1,n+1):
    for x in range(1, n+1):
        
        answer = max(trees[y][x], answer)
        
        trees[y][x] += trees[y-1][x] + trees[y][x-1] - trees[y-1][x-1]


for i in range(2,n+1):
    
    for y in range(i,n+1):
        
        for x in range(i, n+1):
            
            answer = max(answer, trees[y][x] - trees[y-i][x] - trees[y][x-i] + trees[y-i][x-i])

        
print(answer)