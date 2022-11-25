t = int(input())

for i in range(t):
    n = int(input())
    weardict = {}
    for j in range(n):
        wear, kind = input().split()
        if kind in weardict:
            weardict[kind].append(wear)
        else:
            weardict[kind] = [wear]

    result = 1

    for kind in weardict:
        result *= (len(weardict[kind])+1)
    print(result-1)