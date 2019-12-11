from copy import deepcopy
n=int(input())
radius = list(map(int,input().split(' ')))

radius.sort()
# print(radius)


result = []

while True:
	i=0
	curr = radius[i]
	curr_idx = 0
	i+=1
	left_out = []
	while i < len(radius):
		if radius[i] == curr:
			left_out.append(radius[i])
			del radius[i]
			# i++
		else:
			# radius[i] > curr
			del radius[curr_idx]
			# update curr_idx and curr
			curr = radius[i-1]
			curr_idx = i-1
			# i+=1

	result.append(radius[curr_idx])

	if len(left_out) == 0:
		break
	else:
		radius = deepcopy(left_out)

# print(left_out)
# print(result)

print(len(result))
