#!/usr/bin/env python
# -*- coding: utf-8 -*-

from glob import glob
files = glob("*.txt")

from MeCab import Tagger
mecab = Tagger("-F%f[6]\\t%m\\n -E\ ")

def get_first(s):
    s = s.split("\t")
    if len(s) < 2:
        return ''
    return s[0] or s[1]

for filename in files:
	with open(filename) as f:
	    lines = [list(filter(lambda s: s, [get_first(s) for s in mecab.parse(line).split('\n')])) for line in f]

	for word_n in range(1, 4):
		from collections import defaultdict
		d = defaultdict(int)
		tokens = 0

		for line in lines:
			tokens += max(0, len(line) - word_n + 1)
			for i in range(0, len(line) - word_n + 1):
				d["".join(line[i:i+word_n])] += 1

		with open(filename + "." + str(word_n) + "word", mode="w") as f_nword:
			sum = 0
			for k, v in sorted(d.items()):
				f_nword.write(k + "\t" + str(v/tokens) + "\n")
