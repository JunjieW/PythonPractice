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
