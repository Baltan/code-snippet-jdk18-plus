package switch_test;

/**
 * Description:
 *
 * @author baltan
 * @date 2024/6/17 17:52
 */
public class Test3 {
    public static void main(String[] args) {
        print(1);
        print(2L);
        print(3f);
        print(4d);
        print("恰烂钱");
        print(Boolean.TRUE);
        print('c');
        print(Byte.valueOf("5"));
    }

    /**
     * @param o
     * @see <a href="https://javaguide.cn/java/new-features/java20.html#jep-433-switch-%E6%A8%A1%E5%BC%8F%E5%8C%B9%E9%85%8D-%E7%AC%AC%E5%9B%9B%E6%AC%A1%E9%A2%84%E8%A7%88"></a>
     */
    private static void print(Object o) {
        Object text = switch (o) {
            case Integer i -> String.format("Integer %d", i);
            case Long l -> String.format("Long %d", l);
            case Float f -> String.format("Float %f", f);
            case Double d -> String.format("Double %f", d);
            case String s -> String.format("String %s", s);
            case Boolean b -> String.format("Boolean %b", b);
            case Character c -> String.format("Character %s", c);
            case Byte bt -> String.format("Byte %s", bt);
            default -> o.toString();
        };
        System.out.println(text);
    }
}
