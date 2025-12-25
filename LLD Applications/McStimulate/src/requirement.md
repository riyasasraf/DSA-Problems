This round is mainly based on data structure and oops concepts.
No inbuilt collections are allowed. You need to implement on your own.
Needs to discuss your approach before start solving the problem.
Design a system with following functionalities,

1. SET a variable
2. GET a variable
3. UNSET a variable
4. COUNT NUMBERS OF VARIABLE with given value
5. BEGIN — Begins a new transaction
6. ROLLBACK — Roll back all the commands in the open transaction
7. COMMIT — Commit the transaction
8. EXAMPLE 1:
9. SET a 20
   GET a 20
   SET b 30
   GET b 30
   SET a 10
   GET a 10
   UPDATE c 40 No variable named “c”
   SET c 30
   COUNT 30 2
   COUNT 40 null
   UNSET a
   GET a null
   10.EXAMPLE 2:
   11.GET a null
   SET a 30
   GET a 30
   12.EXAMPLE 3:
   13.SET a 30
   BEGIN
   GET a 30
   SET a 40
   GET a 40
   SET b 40
   GET b 40
   ROLLBACK
   GET b null
   GET a 30
   14.EXAMPLE 4:
   15.BEGIN
   SET a 40
   SET b 40
   SET c 50
   COUNT 40 2
   BEGIN
   COUNT 40 null
   COMMIT
   COUNT 40 2
   BEGIN
   SET c 10
   GET c 10
   ROLLBACK
   GET c 50
