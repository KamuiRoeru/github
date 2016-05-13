#!/usr/bin/env python
# -*- coding: utf-8 -*-

from glob import glob
filenames = [f for f in glob("*")]
files = len(set([fn.split(".")[0] for fn in filenames]))

from collections import defaultdict
d = defaultdict(int)

for filename in filenames:
    with open(filename) as f:
        for line in f:
            d[line.split("\t")[0]] += 1

from math import log
for key in d:
    d[key] = log(files/d[key], 2) + 1

for filename in filenames:
    with open(filename, "r+") as f:
        lines = list(f) #処理が完了したらインデックスは一番下でとまる
        f.seek(0) #インデックスを一番上まで持ってくる
        for line in lines:
            t_w = line.split('\t')
            t_w[1] = str(float(t_w[1]) * d[t_w[0]])
            f.write("\t".join(t_w)+"\n")
        f.truncate() #現在インデックス以下のゴミを削除する
