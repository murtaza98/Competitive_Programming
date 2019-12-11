import numpy as np
from pprint import pprint
import copy

def check_complete(a,b,n,m):
	y = np.multiply(a,b)
	count_of_1 = np.count_nonzero(y)
	if count_of_1 == 0:
		return True
	else:
		return False

def recurse(status, accessible, i, j, n, m, tmp_combn, combn):
	if status[i][j] == 0 or money[i][j] == 0:
		if j == m-1:
			if i < n-1:
				recurse(status, accessible, i+1, 0, n, m, tmp_combn, combn)
		else:
			recurse(status, accessible, i, j+1, n, m, tmp_combn, combn)
		return

	# don't include
	new_combn = copy.deepcopy(combn)
	new_status = copy.deepcopy(status)

	# include it
	found = False
	curr_cost = money[i][j]
	# up
	if i > 0:
		for k in range(i,max(i-curr_cost-1,0),-1):
			status[k][j] = 0
	# down
	if i < n-1:
		for k in range(i,min(i+curr_cost+1,n)):
			status[k][j] = 0
	#  right
	if j < m-1:
		for k in range(j,min(j+curr_cost+1,m)):
			status[i][k] = 0
	# left
	if j > 0:
		for k in range(j,max(j-curr_cost-1,0),-1):
			status[i][k] = 0

	check = check_complete(np.array(accessible), np.array(status), n, m)
	print(i,j)
	pprint(status)
	if check:
		found = True
		if len(tmp_combn) > 0 and len(tmp_combn) < len(combn):
			combn = copy.deepcopy(tmp_combn)
			print("FOUND")
			print(tmp_combn)
		return
	else:
		tmp_combn.append([i,j])
	if j == m-1:
		if i < n-1:
			recurse(status, accessible, i+1, 0, n, m, tmp_combn, combn)
		else:
			recurse(status, accessible. i, j+1, n, m, tmp_combn, combn)

	# dont include contd..
	if j == m-1:
		if i < n-1:
			recurse(new_status, accessible, i+1, 0, n, m, new_combn, combn)
		else:
			recurse(new_status, accessible. i, j+1, n, m, new_combn, combn)


t = int(input())

for _ in range(t):
	n,m = list(map(int, input().split(' ')))

	accessible = []
	for _ in range(n):
		accessible.append(list(map(int, input().split(' '))))
	
	money = []
	for _ in range(n):
		money.append(list(map(int, input().split(' '))))

	# status = np.full((n,m), 1, dtype=int)

	status = [[1 for x in range(m)] for y in range(n)]

	combn = []
	tmp_combn = []

	recurse(status, accessible, 0, 0, n, m, tmp_combn, combn)

	# found = False
	# for i in range(n):
	# 	for j in range(m):
	# 		if status[i][j] != 0 and money[i][j] != 0:
	# 			curr_cost = money[i][j]
	# 			# up
	# 			if i > 0:
	# 				for k in range(i,max(i-curr_cost-1,0),-1):
	# 					status[k][j] = 0
	# 			# down
	# 			if i < n-1:
	# 				for k in range(i,min(i+curr_cost+1,n)):
	# 					status[k][j] = 0
	# 			#  right
	# 			if j < m-1:
	# 				for k in range(j,min(j+curr_cost+1,m)):
	# 					status[i][k] = 0
	# 			# left
	# 			if j > 0:
	# 				for k in range(j,max(j-curr_cost-1,0),-1):
	# 					status[i][k] = 0

	# 			check = check_complete(np.array(accessible), np.array(status), n, m)
	# 			# print(i,j)
	# 			# pprint(status)
	# 			if check:
	# 				found = True
	# 				# pprint('FOUND')
	# 				break
	# 			else:
	# 				combn.append([i,j])

	# 	if found:
	# 		break

	print(len(combn))
	for i in range(len(combn)):
		print("{} {}".format(combn[i][0], combn[i][1]))
