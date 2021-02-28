package org.example.ch2;

public class LLDemo {
    public static void main(String[] args) {
        LinearList<String> LLS = new LinearList<>();
        LLS.initiate(20);
        LLS.insert("a");
        LLS.insert("n");
        LLS.insert("c");
        System.out.println(LLS.getLength());
        System.out.println(LLS.get(2));
        System.out.println(LLS.getPrior(1));
        System.out.println(LLS.getNext(1));
        System.out.println(LLS.locate("n"));
        LLS.insert(1, "b");
        System.out.println(LLS);
        LLS.delete(1);
        System.out.println(LLS);
        System.out.println(LLS.isEmpty());
        LLS.clear();;
        System.out.println(LLS);


        LinearList<String> a = new LinearList<>("a", "b", "c", "e", "g");
        LinearList<String> b = new LinearList<>("a", "d", "f", "h");

        //有序线性表的聚合
        LinearList<String> c = new LinearList<>();
        c.initiate(a.length + b.length);
        int i=0,j=0;
        while(i<a.length && j<b.length) {
            String e1 = a.get(i);
            String e2 = b.get(j);
            if (e1.equals(e2)) {
                c.insert(e1);
                i++;
                j++;
            } else if (e1.compareTo(e2) < 0) {
                c.insert(e1);
                i++;
            } else {
                c.insert(e2);
                j++;
            }
        }

        for (;i< a.length;i++) {
            c.insert(a.get(i));
        }

        for (;j<b.length;j++) {
            c.insert(b.get(j));
        }

        System.out.println(c);
        System.out.println(a.union(b));
    }

}
