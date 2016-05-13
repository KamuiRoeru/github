#文字N-gram
#文字コード順でソートするプログラム

import sys,glob,string,copy,time
from os.path import basename

from collections import defaultdict
dicTF = defaultdict(int)
dicIDF = defaultdict(int)
dicTemp = defaultdict(int)
dicIndex = defaultdict(list)
doc_total = 0
word_total = 0

ngram = ""
n = int(sys.argv[1])
if n == 1:
    ngram = "Unigram"
elif n == 2:
    ngram = "Bigram"
elif n == 3:
    ngram = "Trigram"
elif n == 4:
    ngram = "4-gram"
elif n == 5:
    ngram = "5-gram"

label = []
documents = []
start_MeCab = time.time()
for loop in glob.glob("*.txt"):
    doc_total += 1
    sentence = ""
    lists = []
    with open(loop, encoding = "utf-8") as a_file:
            lists = [ arg1.strip() for arg1 in a_file]
    print(loop)

    dic_eachTF = defaultdict(int)
    dicTemp = copy.deepcopy(dicTF)
    i = 0
    for str2 in lists:
        word_total += max(0, len(str2) - n + 1)
        for i in range(len(str2) - n + 1):
            dicTF[str2[i:i+n]] += 1
            dic_eachTF[str2[i:i+n]] += 1

    for i,j in dicTF.items():
        if dicTemp[i] != j:
            dicIDF[i] += 1
            dicIndex[i].append(loop)

    label.append(str(loop.strip(".txt")))
    documents.append(dic_eachTF)
end_MeCab = time.time()

from math import log2
print("dicTF= " + str(len(dicTF)))
print("dicIDF=" + str(len(dicIDF)))

print("〜ファイル書き出し中〜")
start = time.time()
for loop in range(0, doc_total):
    with open("../moji_out/" + str(label[loop]) + "_" + ngram + ".txt", "w") as f:
        seikika = 0.0
        w = 0.0
        for i,j in sorted(documents[loop].items()):
            w = j/word_total * (log2(doc_total/dicIDF[i]) + 1)
            f.write("{:20}\t{}\t{}\t{}\n".format(i,j,dicIDF[i],w))

with open("../moji_out/mt_index_" + ngram + ".txt", "w") as f1:
    for i,j in sorted(dicIndex.items()):
        f1.write(i + "\t:" + str(", ".join(j)) + "\n")
print("処理時間" + "{0}".format((end_MeCab - start_MeCab)/60) + "[min]")
print("書込時間" + "{0}".format((time.time() - start)/60) + "[min]")
print("〜完了〜")
