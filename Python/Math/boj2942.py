import sys
input = sys.stdin.readline

def gcd(a, b):
    if (b == 0): return a
    
    return gcd(b, a % b)

a, b = map(int, input().split())

gcd_value = gcd(a, b)

for i in range(1, gcd_value + 1):
    if (a % i == 0 and b % i == 0):
        print(f"{i} {a // i} {b // i}")