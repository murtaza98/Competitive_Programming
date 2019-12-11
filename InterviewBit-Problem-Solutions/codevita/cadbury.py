class cpairs:
    def __init__(self, l, w): 
        self.l = l
        self.w = w

    def __eq__(self, other): 
        if not isinstance(other, cpairs):
            return NotImplemented

        return (self.l == other.l and self.w == other.w) or (self.l == other.w and self.w == other.l)

    def __hash__(self):
        return hash((self.l, self.w))

    def __ne__(self, other):
        # Not strictly necessary, but to avoid having both x==y and x!=y
        # True at the same time	
        return not(self == other)


cache = dict()


def getTotal(l,w):
	global cache
	if(l==w):
		return 1
	obj = cpairs(l,w)
	if obj in cache :
		return cache[obj] 

	if(l>w):
		total = getTotal(l-w, w) + getTotal(w,w)
		cache[obj] = total
		return total
	else:
		total = getTotal(l, w-l) + getTotal(l,l)
		cache[obj] = total
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

