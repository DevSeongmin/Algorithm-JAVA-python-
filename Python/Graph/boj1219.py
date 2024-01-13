import sys
input = sys.stdin.readline

n,start,end,e = map(int, input().split())

edge = []

for _ in range(e):
    edge.append(list(map(int, input().split())))
    
distance = [-float('inf')] * n
money = list(map(int, input().split()))

distance[start] = money[start]

for i in range(n + 101):
    for s, e, w in edge:
        if distance[s] != -float('inf'):
            
            if distance[s] == float('inf'):
                distance[e] = float('inf')
            
            elif distance[e] < distance[s] - w + money[e]:
                distance[e] = distance[s] - w + money[e]
                if i >= n-1:
                    distance[end] = float('inf')


if distance[end] == float('inf'):
    print('Gee')

elif distance[end] == -float('inf'):
    print('gg')
else:
    print(distance[end])
    
