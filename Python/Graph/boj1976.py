#https://www.acmicpc.net/problem/1976

#유니온 파인드
# 문제의 핵심 해당 문제에서 여행의 경로가 모두 하나의 집합에 속해 있다면 계획대로 여행이 가능하다!!
import sys
input = sys.stdin.readline


def find(a):
    if a == parent_list[a]:
        return a
    else:
        parent_list[a] = find(parent_list[a])
        return parent_list[a]
    
def union(a,b):
    a = find(a)
    b = find(b)
    if a > b: parent_list[b] = a
    else: parent_list[a] = b


CITY = int(input())
_ = int(input())
parent_list = list(range(CITY))
maps = [list(map(int, input().split())) for _ in range(CITY)]
route = list(map(int, input().split()))
route = [i - 1 for i in route]

for i in range(CITY):
    for j in range(CITY):
        if maps[j][i] == 1:
            union(j,i)
            
answer_set = set()


# 루트의 모든 원소가 하나의 집합으로 이루어 져있는지 확인 
for i in route:
    answer_set.add(find(i))
    

if answer_set.__len__() == 1: print("YES")
else: print("NO")