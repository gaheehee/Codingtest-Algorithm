def gcd(a, b):
    while b != 0:
        remain = a % b
        a = b
        b = remain
    
    return a

n = int(input())
rings = list(map(int, input().split()))

for i in range(1,n):
    denominator = gcd(rings[0], rings[i])
    print('{}/{}'.format(rings[0]//denominator, rings[i]//denominator))


# gcd: 최대공약수