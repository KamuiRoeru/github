#文字コード順でソートするプログラム
import sys,glob
from os.path import basename

lists = []
com_insuu = sys.argv[1]
for source in glob.glob("./*.txt"):
#	print(basename(source))
	with open(basename(source), encoding = "utf-8") as a_file:
		lists.append([arg1.strip() for arg1 in a_file])

n = int(com_insuu)
i = 0
gram_total = 0
from collections import defaultdict
dic = defaultdict(int)
for arg2 in lists:
	lis_len = len("".join(arg2))
	for i in range(lis_len - n + 1):
		gram_total += 1
		dic["".join(arg2)[i:i+n]] +=1

seikika = 0.0
for i,j in sorted(dic.items()):
	print("{}\t{}".format(i,j/gram_total))
	seikika = j / gram_total + seikika
print("グラムの総要素数=",gram_total," 正規化値合計=",seikika)
