class Element {
    int value;
    Element next;
  
    public boolean isEmpty() {
      return next == null;
    }
  
    public void add(int x) {
      // Wenn die Liste leer ist, dann hängen wir ein Element an.
      if (isEmpty()) {
        value = x;
        next = new Element();
        return;
      }
      // Sonst fügen wir x in next ein.
      next.add(x);
    }
  
    public void print() {
      // Wenn die Liste leer ist, haben wir nichts zu tun.
      if (isEmpty()) {
        return;
      }
      // Sonst geben wir das erste Element aus, gefolgt vom Rest der Liste.
      System.out.println(value);
      next.print();
    }
  }
  
  class Main {
    public static void main(String[] args) {
      Element l1 = new Element();
      l1.add(3);
      l1.add(5);
  
      l1.print();
    }
  }