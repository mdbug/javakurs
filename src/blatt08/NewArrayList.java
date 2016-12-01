package blatt08;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by micha on 01.12.2016.
 */
public class NewArrayList extends ArrayList {
    public void add (String x) {
        try {
            add(Integer.parseInt(x));
        } catch (NumberFormatException e) {
            try {
                add(Double.parseDouble(x));
            } catch (NumberFormatException f) {
                add((Object) x);
            }
        }
    }
    public void add (int x) {
        add(new Integer(x));
    }
    public void add (double x) {
        add(new Double(x));
    }

    public ArrayList<Integer> getIntegers() {
        ArrayList<Integer> list = new ArrayList<>();
        for(Object o : this) {
            if(o instanceof Integer) {
                list.add((Integer) o);
            }
        }
        return list;
    }

    public ArrayList<Double> getDoubles() {
        ArrayList<Double> list = new ArrayList<>();
        for(Object o : this) {
            if(o instanceof Double) {
                list.add((Double) o);
            }
        }
        return list;
    }

    public ArrayList<String> getStrings() {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < this.size(); ++i) {
            Object o = this.get(i);
            if(!(o instanceof String || o instanceof Integer || o instanceof Double))
                throw new WrongElementException(i);
            list.add(o.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        NewArrayList list = new NewArrayList();
        list.add(3);
        list.add(7.6);
        list.add(9);
        list.add(4.3);
        list.add("Hallo");
        //list.add(new Random());

        ArrayList<String> sl = list.getStrings();
        for(String s : sl) {
            System.out.println(s);
        }
    }
}
