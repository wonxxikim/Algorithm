def f(b):
    c = 1
    for i in range(1,b+1):
        c = c*i
    return c

a = int(input())
g = 0
for i in range(a):
    n, m = map(int,input().split())
    g = f(m)//(f(n)*f(m-n))
    print(g)