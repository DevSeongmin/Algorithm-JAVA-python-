# https://www.acmicpc.net/problem/1092 

#다음 풀 문제 

import sys

input = sys.stdin.readline

n = int(input())
crains = sorted(list(map(int, input().rstrip().split())), reverse=True)
m = int(input())
boxes = sorted(list(map(int, input().rstrip().split())), reverse=True)


if crains[0] < boxes[0]:
    print(-1)

else:
    t = 0
    while boxes:
        
        
        for crain in crains:
            for box in boxes:
                if crain >= box:
                    boxes.remove(box)
                    break
            
        t += 1
        
    print(t)
