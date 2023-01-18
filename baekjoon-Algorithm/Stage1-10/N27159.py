n = int(input())
xList = list(map(int, input().split()))

result = xList[0]

for i in range(0, len(xList)):
    if i+1 < len(xList):
        if xList[i] != xList[i+1]-1:
            result += xList[i+1]

print(result)