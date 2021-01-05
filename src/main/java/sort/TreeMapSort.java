package sort;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @program: algorithm
 * @description: 实现TreeMap排序
 * @author: heruihao
 * @create: 2020-12-28 11:32
 **/
public class TreeMapSort {
    public static void main(String[] args) {
        Map<Integer,String> map = new TreeMap<>(new MyComparator());
        map.put(1,"rfgh");
        map.put(3,"zfg");
        map.put(2,"dfgh");
        map.put(4,"gddf");
        map.forEach((k,v)-> System.out.println(k));
    }
    static class MyComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if ((int)o1-(int)o2>0) return -1;
            if ((int)o1-(int)o2<0) return 1;
            return 0;
        }
    }
}
