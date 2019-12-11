n = int(input())

pat = [list() for _ in range(n)]

# fill stars
for i in range(n):
	for j in range(0,2*i):
		pat[i].append("*")

no = 10

# add nos in from top to bottom
for i in range(n):
	for j in range(n-i):
		pat[i].append(no)
		no+=10

# add nos from bottom to top
for i in range(n-1,-1,-1):
	for j in range(n-i):
		pat[i].append(no)
		no+=10

for i in range(len(pat)):
	line = ""
	for j in range(len(pat[i])):
		line += str(pat[i][j])
	print(line[:-1])

