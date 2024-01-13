# https://www.acmicpc.net/problem/1490

# 자리 수로 다 나누지 않고 최소공배수를 이용하여 연산량을 줄이는게 핵심 


def gcd(a,b):
  while b > 0:
    a, b = b, a % b
  return a
  

def lcm(a,b):
  return a*b // gcd(a,b)

n = input()

input_nums = [i for i in set(n) if i != '0']

a = int(input_nums.pop())

for i in input_nums:
  a = lcm(a,int(i))

from itertools import product

radix = 0
numbers = [str(i) for i in range(0,10)]

while 1:
  
  for i in product(numbers, repeat=radix):
    
    answer = int(n + ''.join(i))
    if answer % a == 0:
      print(answer)
      exit(0)
      
  radix += 1