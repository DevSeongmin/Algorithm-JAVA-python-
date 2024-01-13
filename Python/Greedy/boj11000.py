# https://www.acmicpc.net/problem/11000
# 문제 핵심
# 각 시작 시간과 끝나는 시간을 2차원 배열로 입력받고 
# lambda x : (x[0], x[1]) 기준으로 정렬 
# 시간 리스트의 첫 끝나는 시간을 힙에 넣고 
# 1번째 요소부터 순차 적으로 시작하는 시간을 돌려 
# 시작하는 시간이 힙에 있는 첫 번째 원소보다 작으면 끝나는 시간 힙 푸시
# 크거나 같으면 힙 팝 후 힙 푸시 
# 마지막으로 힙의 개수를 출력하면 최소 강의실의 개수가 나옴


import sys
input = sys.stdin.readline

from heapq import heappush, heappop

n = int(input())

t = []
h = []

for i in range(n):
    t.append(list(map(int,input().split())))
    
t.sort(key = lambda x : (x[0],x[1]))

heappush(h, t[0][1])

for i in range(1,n):
    if t[i][0] < h[0]:
        heappush(h,t[i][1])
    else:
        heappop(h)
        heappush(h, t[i][1])
        
print(len(h))