n = int(input())
result = [ int(input()) for _ in range(n)]
stack = []
result.reverse()
presult = ""

for i in range(1, n+1):
    if result[-1] == i:
        stack.append(i)
        stack.pop()
        result.pop()
        presult += "+"
        presult += "-"
        #print(result)
        #print(stack)

        while len(stack) != 0 and result[-1] == stack[-1]:
            stack.pop()
            result.pop()
            presult += "-"
            #print(result)
            #print(stack)
    
    else:
        stack.append(i)
        presult += "+"
        #print(result)
        #print(stack)

if len(result) != 0:
    print("NO")
else:
    for t in presult:
        print(t)