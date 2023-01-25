stack = []

while True:
    sentence = input()
    stack.clear()

    if sentence == '.':
        break
    else:
        for s in sentence:
            if s == '(' or s == '[':
                stack.append(s)
            elif s == ')':
                if len(stack) == 0 or stack[-1] != '(':
                    print("no")
                    break
                else:
                    stack.pop()
            elif s == ']':
                if len(stack) == 0 or stack[-1] != '[':
                    print("no")
                    break
                else:
                    stack.pop()
            elif s == '.':
                if len(stack) != 0:
                    print("no")
                else:
                    print("yes")