# Python Data Structures (https://www.coursera.org/learn/python-data)

########################################################################
# 6.5 Write code using find() and string slicing (see section 6.10) to  
# extract the number at the end of the line below. Convert the extracted 
# value to a floating point number and print it out.
########################################################################
text = "X-DSPAM-Confidence:    0.8475";
pos = text.find(":");
str_num = text[pos+1:].strip();
print float(str_num);


########################################################################
# 7.1 Write a program that prompts for a file name, then opens that file
# and reads through the file, and print the contents of the file in upper
# case. Use the file words.txt to produce the output below. Use words.txt
# as the file name
########################################################################
fname = raw_input("Enter file name: ")
fh = open(fname)
out = ''
for line in fh:
    if line != '':
    	out += line.upper().strip() + '\n'
print out

########################################################################
# 7.2 Write a program that prompts for a file name, then opens that file 
# and reads through the file, looking for lines of the form:
#                 X-DSPAM-Confidence:    0.8475
# Count these lines and extract the floating point values from each of 
# the lines and compute the average of those values and produce an output
# as shown below. Do not use the sum() function or a variable named sum 
# in your solution. You can download the sample data at
# http://www.pythonlearn.com/code/mbox-short.txt when you are testing 
# below enter mbox-short.txt as the file name.
########################################################################
fname = raw_input("Enter file name: ")
fh = open(fname)
total = 0.0
count = 0.0
for line in fh:
    if line.startswith("X-DSPAM-Confidence:") : 
        total += float(line[line.find(":")+1:])
        count += 1        
    else: continue
        
print "Average spam confidence:", total/count


########################################################################
# 8.4 Open the file romeo.txt and read it line by line. For each line, 
# split the line into a list of words using the split() method. The 
# program should build a list of words. For each word on each line check 
# to see if the word is already in the list and if not append it to the 
# list. When the program completes, sort and print the resulting words 
# in alphabetical order.
# You can download the sample data at http://www.pythonlearn.com/code/romeo.txt
########################################################################
fname = raw_input("Enter file name: ")
fh = open(fname)
lst = list()
for line in fh:
    for word in line.strip().split():
        if word not in lst:
            lst.append(word)
            
lst.sort()
print lst



########################################################################
# 8.5 Open the file mbox-short.txt and read it line by line. When you 
# find a line that starts with 'From ' like the following line:
#       From stephen.marquard@uct.ac.za Sat Jan  5 09:14:16 2008
# You will parse the From line using split() and print out the second 
# word in the line (i.e. the entire address of the person who sent the 
# message). Then print out a count at the end.
# Hint: make sure not to include the lines that start with 'From:'.
########################################################################

You can download the sample data at http://www.pythonlearn.com/code/mbox-short.txt

fname = raw_input("Enter file name: ")
if len(fname) < 1 : fname = "mbox-short.txt"
fh = open(fname)
count = 0
mlist = list()
for line in fh:
	if line.startswith("From") and not line.startswith("From:"):
		print line.split()[1]
		count += 1
print "There were", count, "lines in the file with From as the first word"


########################################################################
# 9.4 Write a program to read through the mbox-short.txt and figure out 
# who has the sent the greatest number of mail messages. The program 
# looks for 'From ' lines and takes the second word of those lines as 
# the person who sent the mail. The program creates a Python dictionary 
# that maps the sender's mail address to a count of the number of times 
# they appear in the file. After the dictionary is produced, the program
# reads through the dictionary using a maximum loop to find the most 
# prolific committer.
########################################################################
name = raw_input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)
wordCount = dict()
maxCount = 0
key = ''
for line in handle:
    if line.startswith('From') and not line.startswith('From:'):
        cKey = line.split()[1]
        wordCount[cKey] = wordCount.get(cKey, 0) + 1
        if (wordCount.get(cKey) > maxCount):
			key = cKey        
    else:
		continue
		
print key, wordCount.get(key)


########################################################################
# 10.2 Write a program to read through the mbox-short.txt and figure out 
# the distribution by hour of the day for each of the messages. You can 
# pull the hour out from the 'From ' line by finding the time and then
# splitting the string a second time using a colon.
#            From stephen.marquard@uct.ac.za Sat Jan  5 09:14:16 2008
# Once you have accumulated the counts for each hour, print out the 
# counts, sorted by hour as shown below.
########################################################################

# The description is a litle ambiguous, see online test:
# https://pr4e.dr-chuck.com/tsugi/mod/pythonauto/index.php?PHPSESSID=669851efb76f2236de32bd8aabd01548

name = raw_input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)

counter = dict()

for line in handle:
	if line.startswith('From ') :
		h = line.split()[5].split(':')[0]
		counter[h] = counter.get(h, 0) + 1
		
lst = sorted([(k,v) for k, v in counter.items()])
for k, v in lst:
    print k, v
