INSERT INTO users
VALUES (1,'name','pass');


INSERT INTO questions
VALUES (1,'What are enums and why are they useful?','Today I was browsing through some questions on this site and I found a mention of an enum being used in singleton pattern about purported thread-safety benefits to such solution.
I have never used enums and I have been programming in Java for more than a couple of years now. And apparently, they changed a lot. Now they even do full-blown support of OOP within themselves. Now why and what should I use enum in day to day programming?', 1);

INSERT INTO questions
VALUES (2,'Static Classes In Java', 'Is there anything like static class in Java?
What is the meaning of such a class? Do all the methods of the static class need to be static too?
Is it required the other way round as well? That if a class contains only static methods, the class shall be static too?
What are static classes good for?', 1);

INSERT INTO answers
VALUES (1, 'Enumerations offer an easy way to work with sets of related constants. An enumeration, or Enum , is a symbolic name for a set of values. Enumerations are treated as data types, and you can use them to create sets of constants for use with variables and properties.', 1, 1);

