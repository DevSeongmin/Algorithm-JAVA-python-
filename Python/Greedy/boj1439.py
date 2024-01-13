# https://www.acmicpc.net/problem/1439

s = list(input())
solve = [s[i] for i in range(1,len(s)) if s[i] != s[i-1]]
solve.append(s[0])
print(min(solve.count('0'), solve.count('1')))