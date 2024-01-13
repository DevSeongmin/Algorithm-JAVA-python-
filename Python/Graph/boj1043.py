#https://www.acmicpc.net/problem/1043

#유니온 파인드
def find(n):
    if check[n] == n:
        return n 
    check[n] = find(check[n])
    return check[n]

def union(a,b):
    a = find(a)
    b = find(b)
    
    if a != b:
        
        if a > b:
            check[a] = b
        else:
            check[b] = a
            
            
population, party = map(int, input().split())
check = [i for i in range(population + 1)]
fact = list(map(int, input().split()))

if fact == [0]:
    print(party)
    exit()

fact = fact[1:]
    
    
for i in range(1, len(fact)):
    union(fact[0], fact[i])


partys = []


for _ in range(party):
    a, *b = list(map(int, input().split()))
    partys.append(b)
    if a > 1:
        for i in range(1, len(b)):
            union(b[0], b[i])
        

answer = 0
for party in partys:
    for p in party:
        if find(fact[0]) == find(p):
            break
    else:
        answer += 1
        
print(answer)