# Java-BrainFuck
A brainfuck interpreter in one java class. I was bored and decided to make an easy program to interpret BrainFuck.

## Build Instruction
Firstly, you must have a JDK installed on your system. If you don't you can download the latest JDK from [this link.](https://www.oracle.com/java/technologies/downloads/)

Next, run the following commands in your terminal:
```console
git clone https://github.com/aarush-murari/Java-BrainFuck/
cd  Java-BrainFuck
javac BrainFuck.java
```
You should get a `BrainFuck.class` file which can be exectued by typing:
```
java BrainFuck
```

## How to use?

You can use it like any BrainFuck Interpreter, just note that if you ever type a ',' then your input stream is read in the next line. To exit the interpreter, you may type `exit()` or `quit().` All other characters are ignored.
