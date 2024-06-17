package collection_test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description:
 *
 * @author baltan
 * @date 2024/6/17 17:02
 */
public class SequencedCollectionTest {
    /**
     * @param args
     * @see <a href="https://javaguide.cn/java/new-features/java21.html#jep431-%E5%BA%8F%E5%88%97%E5%8C%96%E9%9B%86%E5%90%88"></a>
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        list.addFirst(0);
        list.addLast(4);
        System.out.println(list);
        System.out.println(list.reversed());

        System.out.println("---------------------------------------");

        Deque<Integer> deque = new ArrayDeque<>(List.of(1, 2, 3));
        deque.addFirst(0);
        deque.addLast(4);
        System.out.println(deque);
        System.out.println(deque.reversed());

        System.out.println("---------------------------------------");

        Deque<Integer> deque1 = new ArrayDeque<>(List.of(1, 2, 3));
        deque1.offerFirst(0);
        deque1.offerLast(4);
        System.out.println(deque1);
        System.out.println(deque1.reversed());
    }
}
