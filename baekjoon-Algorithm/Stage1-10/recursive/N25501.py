num = 0

def recursion(s, l, r):
    if l >= r: return 1
    elif s[l] != s[r]: return 0
    else: 
        global num
        num += 1
        return recursion(s, l+1, r-1)

def isPalindrome(s):
    global num
    num += 1
    return recursion(s, 0, len(s)-1)

n = int(input())
for i in range(n):
    num = 0
    target = input()
    result = isPalindrome(target)
    print(result, num, sep=" ")