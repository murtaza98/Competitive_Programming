def getTotal(l,w):
	global cache
	if(l==w):
		return 1

	if(l>w):
		total = getTotal(l-w, w) + getTotal(w,w)
		return total
	else:
		total = getTotal(l, w-l) + getTotal(l,l)
		return total


min_l = int(input())
max_l = int(input())
min_w = int(input())
max_w = int(input())

total = 0

for l in range(min_l, max_l+1):
	for w in range(min_w, max_w+1):
		# print("({}, {}) = {}".format(l, w, getTotal(l,w)))
		total += getTotal(l,w)

print(total)

