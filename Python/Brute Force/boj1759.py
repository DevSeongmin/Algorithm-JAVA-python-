# https://www.acmicpc.net/submit/1759

from itertools import combinations

n, m = map(int ,input().split())
strings = list(input().replace(' ', ''))
solve = []

mo = ('a','e','i','o','u')
ja = set(strings) - set(mo)

for i in combinations(strings, n):
    for j in mo:
        if j in i:
            solve.append(''.join(sorted(i)))
            break

solve.sort()
for i in solve:
    if len(set(i) - set(mo)) >= 2:
        print(i)
