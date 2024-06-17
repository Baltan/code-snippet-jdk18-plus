package collection_test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * Description:
 *
 * @author baltan
 * @date 2024/6/17 17:09
 */
public class SequencedSetTest {
    /**
     * @param args
     * @see <a href="https://javaguide.cn/java/new-features/java21.html#jep431-%E5%BA%8F%E5%88%97%E5%8C%96%E9%9B%86%E5%90%88"></a>
     */
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(List.of(1, 2, 3, 4));
        System.out.println(linkedHashSet);
        linkedHashSet.addFirst(4);
        linkedHashSet.addLast(1);
        System.out.println(linkedHashSet);
        System.out.println(linkedHashSet.reversed());

        System.out.println("---------------------------------------");

        TreeSet<Integer> treeSet = new TreeSet<>(List.of(1, 2, 3, 4));
        System.out.println(treeSet);
//        treeSet.addFirst(4); // java.lang.UnsupportedOperationException
//        treeSet.addLast(1); // java.lang.UnsupportedOperationException
        System.out.println(treeSet);
        System.out.println(treeSet.reversed());
    }
}
