
public class MiniDataBase {
  Mymap db = new Mymap();
  Transaction[] stack = new Transaction[100];
  int top = -1;

  void begin() {
    stack[++top] = new Transaction();
  }

  void recordChanges(String key) {
    if (top == -1) {
      return;
    }
    String oldvalue = db.get(key);
    stack[top].add(new Change(key, oldvalue));
  }

  void rollback() {

    if (top == -1) {
      return;
    }
    Transaction t = stack[top--];
    for (int i = t.size - 1; i >= 0; i--) {
      Change c = t.changes[i];
      if (c.oldvalue == null) {
        db.unset(c.key);
      } else {
        db.set(c.key, c.oldvalue);
      }
    }
  }

  void commit() {

    if (top == -1) {
      return;
    }
    top = -1;
  }

  void set(String key, String value) {

    recordChanges(key);
    db.set(key, value);
  }

  void unset(String key) {
    recordChanges(key);
    db.unset(key);
  }

  String get(String key) {
    return db.get(key);
  }

  int count(String value) {
    return db.countValue(value);
  }
}
