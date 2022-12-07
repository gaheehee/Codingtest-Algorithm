n, k = map(int, input().split())
nlist = list(map(int, input().split()))

psum = sum(nlist[0:k])
slist = [psum]

for i in range(0, len(nlist)-k):
    psum = psum - nlist[i] + nlist[i+k]
    slist.append(psum)

print(max(slist))