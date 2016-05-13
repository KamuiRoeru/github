#文字コード順でソートするプログラム

import sys,glob,MeCab,string
from os.path import basename

from collections import defaultdict
dic = defaultdict(int)
word_total = 0

for loop in ["{0:02d}".format(num) for num in range(0,100)]:
    n = int(sys.argv[1])
    sentence = ""
    for source in glob.glob("./" + str(loop) + "*.txt"):
        with open(basename(source), encoding = "utf-8") as a_file:
            sentence += "".join([arg1.strip() for arg1 in a_file])
    print(str(loop) + "*.txt")

    t = MeCab.Tagger("-F %f[6]\\n")
    lists = []
    for words in t.parse(sentence).split("\n"):
        if (words == "" or words == "EOS"):
            continue
        lists.append(words)

    i = 0
    lis_len = len(lists)
    for i in range(lis_len - n + 1):
        dic["-".join(lists[i:i+n])] += 1
        word_total += 1


gram_total = len(dic)
print("〜ファイル書き出し中〜")
with open("../output.txt", "w") as f:
    seikika = 0.0
    for i,j in sorted(dic.items()):
        f.write("{:20}\t{}\t{}\n".format(i,j,j/word_total))
        seikika = j /word_total + seikika
    f.write("グラム総要素数=" + str(gram_total) + " 正規化値合計=" + str(seikika) + "\n")
print("〜完了〜")
