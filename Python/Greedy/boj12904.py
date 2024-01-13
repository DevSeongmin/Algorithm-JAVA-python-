# https://www.acmicpc.net/problem/12904

#문제 풀이법
# S <-- T 로 역으로 변환 


s = list(input())
t = list(input())

slen = len(s)

while slen != len(t):
    if t[-1] == "A":
        t.pop()
    elif t[-1] == "B":
        t.pop()
        t.reverse()
        
  
if s == t:
    print(1)
else:
    print(0)