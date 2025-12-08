# Equality and Hashing:

### In this section we used equality and hashing as a way to quickly and easily search through/ compare data, this was for several functions in our code: assigning IDs to entries, looking and displaying duplicates, letting the player know which entries were duplicates by displaying their IDs, letting the user find specific entries using their ID, displaying their hashcodes, etc.



### The reason we used hash code is because it is a simple and easy way to set up code to allow for user to easily find what they need or for the program to find or match code in a way to help it know if data matches or not.

## For example HashMap allows the code to assign an ID to each entry, which will allow the program or the user to easily find a specific entry using that ID.



### Another reason for using this is the equality, this means the code uses hash version of data in order to compare it to other data, whether this is data stored in an array, file etc, or inputted data such as a name inputted by a user to find data.

### Hashset takes in data and prevents duplicates from happening, meaning that the program can feed in string from entries and hashset will prevent they're from being any duplicate sound found within it. An example for how this can be useful is for the program to print out all games in the data without their being duplicates created by multiple runners playing that game.





# Testing:

### Matthew: The tests I did were for the hashing, this meant taking the functions I had created and running a Junit test on them but creating a test input, setting what it is expected to be and then running the function for the actual and comparing the two.

### Matthew: For hashing this meant setting up test data to input, inputting a number to function as a ID for the test, setting a string for what the output should be and letting the function calculate what data should appear with the given ID, and seeing if the expected result and the actual result are the same.

### Garyowen: For Sorting, I similarly had to create test data for inputting. I then had to manually sort the test data into an arrayList twice. The first time holds the incorrect, random order, and the second one holds it in the corrected order. This process was repeated for each different type of sort, requiring a decent bit of thought to get the order correct each time. For this function to be properly tested, I also had to make a temporary file for the method to read. This temporary file uses the arrayList to write itself out. 

### Garyowen: I also handled the testing of the findBetween method. This involved making two small tests, checking that the same test data as before can be properly broken up, returning only the list of things within the range. Though there is no option for the user to do so in the main, this method is wrote such that a self-inputted date could be accepted. 

# Defensive Coding

### Garyowen: Defensive coding was implemented in a couple of places throughout the program. Primarily, I wanted to focus on areas where I could see there being the most issues if erroneous data was inputted.

### Starting off, we have the setName and setGame functions. These double check that there is not an empty String submitted as an option. In the event that there is an empty string given, the currently saved String is kept.

### Next is inside the setRuns function. As this is a linearly increasing number, negatives are not allowed. One cannot do a negative run.

### Afterwards I worked on setJoinDate. Logically speaking, one would not be able to set their join date to 0 or any other extreme value in that same vein. My solution to this was to create a start date to compare to. This date was chosen as my birthday to make it easy to reuse later in the program. 

### Following that, I worked on the setLastSubmission. This one uses similar logic to the previous bit of defensive coding, but this time it makes use of the Runner's Join Date. One cannot submit a run prior to joining the database. 

### Moving over to the RunnerFileUtilities java file, a key thing I included here was a line to ensure that even if an entry is inputted wrongly in the file, the reading function will still successfully output a list containing every valid entry. Without this, the program would simply break at the entry and refuse to resume. 


# Reflection:

### Matthew: Overall I would say there was many things I learned over the course of this assignment. I learned a lot about hashing I did not know about before I began this assignment.

### I also learned more about working on the same code file with another person using github and more about using GitHub itself, such as committing code and pulling code from the github in order to work off what my teammate had done.

### However, one issue with the assignment was feeling like I did not know enough going into it or like I had enough time to fully learn and make enough code to meet the full requirements needed for the assignment.

### Garyowen: Similar to my teammate, I did find that there was not enough time or extensive enough explanation for what was needed. A large chunk of my time on this project was spent learning what was needed more than actually doing the programming. The very short turnaround on this assignment was similarly stress inducing. 

### Above all else, what I learnt most was better, more efficient ways to program. I am now far more adept at creating flexible, reusable bits of code that can fit a variety of purposes. 



# Commit:

### Over the course of the project we used GitHub to align our work together and make sure our code was one cohesive whole. GitHub also allowed us to easily send our code to each other without having to constantly send pieces of code via message and tell the other person where it goes, this was done via the commit, push and pull function of GitHub where it would see what differences was made to the code, push that to the code found within the repository online and allow us to take that and pull it into our code meaning we would have the exact same code throughout the project.

# References:

## Matthew:

### Baeldung.Mohamed Helmy(2024).HashSet toArray() Method in Java[online].Available from https://www.baeldung.com/java-hashset-toarray#:~:text=In%20conclusion%2C%20it%20is%20easy,components%20in%20our%20Java%20apps. [Accessed 7th December 2025]

### Coding with John.(2021). Map and HashMap in Java - Full Tutorial  [video online]. Available from https://www.youtube.com/watch?v=H62Jfv1DJlU&t=386s [Accessed 7th December 2025]

### Coding with John.(2022). Set and HashSet in Java - Full Tutorial [video online]. Available from https://www.youtube.com/watch?v=QvHBHuuddYk&t=1031s [Accessed 7th December 2025]

### Do Some Dev.(2024). Java HashSet [video online]. Available from https://www.youtube.com/watch?v=ZQ8ona2q6Fc&t=113s [Accessed 7th December 2025]



## Garyowen:


### Colin Koenig, CK. (2014). Exporting to a CSV File in Java. StackOverflow [ online ], 23 April, Available from: https://stackoverflow.com/questions/23257369/exporting-to-a-csv-file-in-java.

### Mike Sickler, MS. (2009). How do I check if a date is within a certain range?. StackOverflow [ online ], 30 January, Available from: https://stackoverflow.com/questions/494180/how-do-i-check-if-a-date-is-within-a-certain-range.

### Rajeev Ranjan, RR. (2021). How to get the top 5 max values from a list using java stream. StackOverflow [ online ], 2 Febuary, Available from: https://stackoverflow.com/questions/66008858/how-to-get-the-top-5-max-values-from-a-list-using-java-stream.

### TutorOcean. (2025). Encapsulation in Java [ Online ]. Available from: https://www.tutorocean.com/questions-answers/encapsulation-in-java#:~:text=Encapsulation%20in%20Java%20is%20a%20powerful%20concept%20that%20helps%20to,the%20data%20is%20not%20corrupted. [2nd December 2025 - 7th December 2025].

### W3Schools. (2025). Java Exceptions [ Online ]. Available from: https://www.w3schools.com/java/java_try_catch.asp [2nd December 2025 - 7th December 2025].
