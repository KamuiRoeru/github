#/usr/bin/env python
# -*- coding: utf-8 -*-
from time import time
from glob import glob
files = glob("*.txt")
#Gitテスト
start = time()
for filename in files:
    with open(filename) as f:
        lines = [line.strip() for line in f] #リストを作成

    for gram_n in range(1, 6):
        from collections import defaultdict
        d = defaultdict(int)
        tokens = 0

        for line in lines:
            tokens += max(0, len(line) - gram_n + 1)
            for i in range(0, len(line) - gram_n + 1):
                d[line[i:i+gram_n]] += 1

        with open(filename + "." + str(gram_n) + "gram", mode="w") as f_ngram:
            for k, v in sorted(d.items()):
                f_ngram.write(k + "\t" + str(v/tokens) + "\n")

    print(filename)

print("処理時間 = " + "".format((time() - start)/60) + "[min]")
