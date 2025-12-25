public class Transaction {
  Change[] changes = new Change[1000];
  int size = 0;

  void add(Change change) {
    changes[size] = change;
    size++;
  }
}
