public class Mymap {

  Entry[] arr = new Entry[1000];
  int size = 0;

  int indexOf(String key) {

    for (int i = 0; i < size; i++) {
      if (arr[i].key.equals(key)) {
        return i;
      }
    }
    return -1;

  }

  String get(String key) {
    int idx = indexOf(key);
    return idx != -1 ? arr[idx].value : null;
  }

  void set(String key, String value) {
    int idx = indexOf(key);
    if ((idx == -1)) {
      arr[size++] = new Entry(key, value);

    } else {

      arr[idx].value = value;
    }
  }

  void unset(String key) {
    int idx = indexOf(key);
    if (idx == -1)
      return;
    arr[idx] = arr[size - 1];
    size--;
  }

  int countValue(String value) {

    int c = 0;
    for (int i = 0; i < size; i++) {
      if (arr[i].value.equals(value)) {
        c++;
      }
    }
    return c;
  }
}
