word = input()
result = set()

for i in range(0, len(word)):
    for j in range(i, len(word)):
        temp = word[i:j+1]
        result.add(temp)

print(len(result))