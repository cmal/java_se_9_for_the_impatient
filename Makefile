#
# define compiler and compiler flag variables
#

JFLAGS = -g
JC = javac
JAVA = java


#
# Clear any default targets for building .class files from .java files; we
# will provide our own target entry to do this in this makefile.
# make has a set of default targets for different suffixes (like .c.o)
# Currently, clearing the default for .java.class is not necessary since
# make does not have a definition for this target, but later versions of
# make may, so it doesn't hurt to make sure that we clear any default
# definitions for these
#

.SUFFIXES: .java .class


#
# Here is our target entry for creating .class files from .java files
# This is a target entry that uses the suffix rule syntax:
#	DSTS:
#		rule
#  'TS' is the suffix of the target file, 'DS' is the suffix of the dependency
#  file, and 'rule'  is the rule for building a target
# '$*' is a built-in macro that gets the basename of the current target
# Remember that there must be a < tab > before the command line ('rule')
#

.java.class:
	$(JC) $(JFLAGS) $*.java


#
# CLASSES is a macro consisting of 4 words (one for each java source file)
#

CLASSES = \
	ch01/sec01/HelloWorld.java \
	ch01/sec01/MethodDemo.java \
	ch01/ex/ReadInteger.java \
	ch01/ex/ReadIntegerAngle.java \
	ch01/ex/PrintMax.java \
	ch01/ex/PrintMaxMath.java \
	ch01/ex/PrintPosDoubleRange.java \
	ch01/ex/Factorial.java \
	ch01/ex/ComputeUnsign.java \
	ch01/ex/PrintSubs.java \
	ch01/ex/EqualStr.java \
	ch01/ex/RandLong.java \
	ch01/ex/RemoveASCII.java \
	ch01/ex/Lottery.java \
	ch01/ex/PascalTriangle.java \
	ch01/ex/MagicSquare.java \
	ch02/ex/ChangeCalendar.java \
	ch02/ex/NextInt.java \
	ch02/ex/NonVoidMutator.java \
	ch02/ex/SwapInt.java \
	ch02/ex/Point.java \
	ch02/ex/PointMut.java \
	ch02/ex/Car.java \
	ch02/ex/RandomNumber.java \
	ch02/ex/ChangeCalendarStatic.java \
	ch02/ex/Network.java \
	ch02/ex/Invoice.java \
	ch02/ex/Queue.java \
	ch03/ex/Employee.java \
	ch03/ex/IntegerSequence.java \
	ch03/ex/SquareSequence.java \
	ch03/ex/DigitSequence.java \
	ch03/ex/Lucky.java \
	ch03/ex/Greeter.java \
	ch03/ex/ListSubdirs.java \
	ch03/ex/ListGivenExtension.java \
	ch03/ex/SortFiles.java \
	ch03/ex/RandomSequence.java \
	ch04/ex/LabeledPoint.java \
	ch04/ex/Circle.java \
	ch04/ex/Rectangle.java \
	ch04/ex/Line.java \
	ch04/ex/DiscountedItem.java \
	ch04/ex/EnumColor.java \
	ch04/ex/ClassMethods.java \
	ch04/ex/UniversalToString.java \
	ch04/ex/MethodPrinter.java \
	ch04/ex/HelloWorld.java \
	ch04/ex/PrintStaticDoubleMethods.java \
	ch05/ex/ReadFloatPoint.java \
	ch05/ex/CatchScanner.java \
	ch05/ex/FinallyClause.java \
	ch05/ex/Factorial.java \
	ch05/ex/CompareAssert.java \
	ch05/ex/AssertMin.java \
	ch05/ex/ReentrantAutoCloseLock.java \
	ch05/ex/TestLogger.java \
	ch06/ex/StackArrayList.java \
	ch06/ex/StackArray.java \
	ch06/ex/Table.java \
	ch06/ex/TableNested.java \
	ch06/ex/Arrays.java \
	ch06/ex/AppendToAnother.java \
	ch06/ex/Pair.java \
	ch06/ex/MinMax.java \
	ch06/ex/ImprovedCloseAll.java \
	ch06/ex/Map.java \
	ch06/ex/Employee.java \
	ch06/ex/FundamentalFail.java \
	ch06/ex/ExtendsThrowable.java \
	ch07/ex/SieveErathostenes.java \
	ch07/ex/UpperString.java \
	ch07/ex/SetOps.java \
	ch07/ex/ConCurrentMod.java \
	ch07/ex/EfficientSwap.java \
	ch07/ex/WhatHappens.java \
	ch07/ex/ReadWords.java \
	ch07/ex/Merge.java \
	ch07/ex/Shuffle.java \
	ch07/ex/ShuffleSentence.java \
	ch07/ex/Cache.java \
	ch07/ex/ImmutableListView.java \
	ch07/ex/ImmutableListViewIntFunc.java \
	ch08/ex/Filter.java \
	ch08/ex/Parallel.java \
	ch08/ex/StreamInteger.java \
	ch08/ex/CodePoints.java \
	ch09/ex/CopyInputToOutput.java \
	ch09/ex/Toc.java \
	ch09/ex/WhichCharset.java \
	ch09/ex/BufferedReaderVsScanner.java \
	ch10/ex/FindFile.java \
	ch10/ex/HowLargeFaster.java \
	ch10/ex/FindWord.java \
	ch10/ex/ParallelPrefix.java \
	ch10/ex/EscapingThis.java \
	ch10/ex/ReadAllWords.java \
	ch10/ex/MaxKey.java \
	ch10/ex/AtomicLongVsLongAddr.java \
	ch10/ex/LongAccumulatorMax.java \
	ch10/ex/BlockingQueueSearchFile.java \
	ch10/ex/ThreadedCountWord.java \
	ch10/ex/WrongStack.java \
	ch10/ex/RepeatUntil.java \
	geeksforgeeks/Cov.java

#
# the default make target entry
#

default: classes


#
# This target entry uses Suffix Replacement within a macro:
# $(name:string1=string2)
# 	In the words in the macro named 'name' replace 'string1' with 'string2'
# Below we are replacing the suffix .java of all words in the macro CLASSES
# with the .class suffix
#

classes: $(CLASSES:.java=.class)


#
# RM is a predefined macro in make (RM = rm -f)
#

clean:
	$(RM) $(CLASSES:.java=.class)


dot:=.
slash:=/

.PHONY: runs
runs: $(subst .java,,$(subst $(slash),$(dot),$(CLASSES)))

$(subst .java,,$(subst $(slash),$(dot),$(CLASSES))):
	java $@

