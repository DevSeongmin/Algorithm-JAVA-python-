n, m = map(int, input().split())    # 세로 크기 n, 가로 크기 m    #
arr = list(set([input() for _ in range(n)]))    # 중복제거
print(arr)
arr = sorted(arr)[1:]   # 0만 있는 배열 제거

print(arr)