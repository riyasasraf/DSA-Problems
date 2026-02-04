import java.util.Stack;

public class ImplementUNDOREDO {
  Stack<Character> doc = new Stack<>();
  Stack<Character> redo = new Stack<>();

  public void append(char x) {
    doc.add(x);
    redo.clear();
  }

  public void undo() {
    if (!doc.isEmpty()) {
      redo.push(doc.pop());
    }
  }

  public void redo() {
    if (!redo.isEmpty()) {
      doc.push(redo.pop());
    }
  }

  public String read() {

    StringBuilder ans = new StringBuilder();

    for (Character character : doc) {
      ans.append(character);
    }
    return ans.toString();
  }
}