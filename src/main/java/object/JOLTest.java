package object;

import org.openjdk.jol.info.ClassLayout;

/**
 * @classname: JOLTest 查看对象内存信息
 * @description:
 * @author: sunxinbo
 * @time: 2020/10/31、16:18
 */
public class JOLTest {

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        long instanceSize = ClassLayout.parseClass(InnerClass.class).instanceSize();
        int headerSize = ClassLayout.parseClass(InnerClass.class).headerSize();
        String printable = ClassLayout.parseClass(InnerClass.class).toPrintable();
        System.out.println("innerClass instanceSize: " + instanceSize);
        System.out.println("innerClass headerSize: " + headerSize);
        System.out.println("innerClass printable: " + printable);

        long instanceSize2 = ClassLayout.parseClass(InnerClass2.class).instanceSize();
        int headerSize2 = ClassLayout.parseClass(InnerClass2.class).headerSize();
        String printable2 = ClassLayout.parseClass(InnerClass2.class).toPrintable();
        System.out.println("innerClass2 instanceSize: " + instanceSize2);
        System.out.println("innerClass2 headerSize: " + headerSize2);
        System.out.println("innerClass2 printable2: " + printable2);

        String printable3 = ClassLayout.parseClass(InnerClass3.class).toPrintable();
        System.out.println("innerClass3 printable2: " + printable3);

        ClassLayout classLayout = ClassLayout.parseInstance(innerClass);
        System.out.println("innerClass instance instanceSize：" + classLayout.instanceSize());
    }

    private static class InnerClass {
        private int[][] arr = new int[128][2];

        InnerClass() {
            for (int i = 0; i < 128; i++) {
                for (int i1 = 0; i1 < 2; i1++) {
                    arr[i][i1] = 1;
                }
            }
        }

    }

    private static class InnerClass2 {
        private int a; // 4
        private byte b; // 1
        private Long l; // 4
        private Byte aByte; // 4
        private Long l2 = new Long(2L); // 4
        private Integer c = new Integer(1); // 4
    }

    // 33 + 7 = 40
    private static class InnerClass3 {
        private int a; // 4
        private byte b; // 1
        private InnerClass[] innerClassesArr = new InnerClass[2]; // 4 引用
    }
}
