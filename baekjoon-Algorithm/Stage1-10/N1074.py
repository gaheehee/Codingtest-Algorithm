N, r, c = map(int, input().split())

def recursive(n, r, c):
    if n == 0:
        return 0
    
    return 2*(r%2)+(c%2) + 4*recursive(n-1, int(r/2), int(c/2))

print(recursive(N, r, c))