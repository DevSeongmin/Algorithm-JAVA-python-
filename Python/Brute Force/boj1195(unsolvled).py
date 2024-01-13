# https://www.acmicpc.net/problem/1195


long = int(input())
short =  int(input())

if long < short:
    long, short = short, long


while 1:    
    if '4' not in str(long + short):
        break
    
    if '4' in str(long + short):
        short *= 10


print(len(str(max(short, long))))