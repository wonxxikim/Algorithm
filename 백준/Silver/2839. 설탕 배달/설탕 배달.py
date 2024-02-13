N = int(input())
p = 0

while N >=0:
    if N%5==0:
        p += N //5
        print(p)
        break
    N-=3
    p+=1
else:
    print(-1)
    
#5로 나누어 떨어질 때까지 3을 계속뺀다
