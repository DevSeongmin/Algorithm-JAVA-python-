# 작성자 : 황성민
# 작성일자 : 24.01.17
# 문제 접근, 풀이 : https://blog.naver.com/steadydeveloper/223325788368

N = int(input())

nums = list(map(int, input().split()))

arr = [""] * 1000001

for i in nums:
    arr[i] = 0

for i in range(1, 1000001):
    if arr[i] != "":
        
        for j in range(i+i, 1000001, i):
            if arr[j] != "":
                arr[i] += 1
                arr[j] -= 1
                
for i in nums:
    print(arr[i], end = ' ')