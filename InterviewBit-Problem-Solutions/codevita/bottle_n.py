def allZeros(occ):
	for key,val in occ.items():
		if(val > 0):
			return False
	return True


n=int(input())
radius = list(map(long,input().split(' ')))

occ = dict()

for i in range(n):
	if radius[i] in occ:
		occ[i] += 1
	else:
		occ[i] = 1

total = 0

while(not allZeros(occ)):
	# decreament all occ by one
	for key,cnt in occ.items():
		occ[key] = cnt-1

	total+=1

print(total)
