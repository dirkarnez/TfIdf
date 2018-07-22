# TfIdf - Term Frequency and Inverse Document Frequency
TF IDF (to show the important words from documents by grading, common words have very low grade)

### Steps
1. Given `N` text files, make a dictionary/hashset storing all the unique words from these files

TF-IDF = term frequency * inverse document frequency
term frequency = number of occurrence in that text file / number of unique words in that file) 
inverse document frequency = log * (number of text files `N` / number of occurrence among these files)
