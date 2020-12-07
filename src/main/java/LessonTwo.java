public class LessonTwo {
    public static void main(String[] args) {
        int a = 20;
        int b = 5;

        int c = 8;
        int d = --c;

        int e = 8;
        int f = e--;

        int x = 10 / 5 * 2;

        String text = "hello";
        String text2 = "hello";

        String text3 = new String("hello");
        String text4 = new String("hello");


        boolean bool = a == b;
        boolean bool2 = a != b;
        boolean bool3 = a < b;
        boolean bool4 = a > b;
        boolean bool5 = a <= b;
        boolean bool6 = a >= b;

        boolean bool7 = (5 > 6) || (4 < 6);
        boolean bool8 = (5 < 6) && (4 < 6);


        if (a == 5) {
            System.out.println("Hello Worlds if");
        } else {
            System.out.println("Hello Worlds else");
        }


        if (a == 5) {
            System.out.println("Hello Worlds " + a);
        } else if (a == 6) {
            System.out.println("Hello Worlds " + a);
        } else if (a == 7) {
            System.out.println("Hello Worlds " + a);
        }

        switch (a) {
            case 5:
                System.out.println("first case");
                a++;
                break;
            case 6:
                System.out.println("second case");
                break;
            case 15:
                System.out.println("third case");
                break;
            default:
                System.out.println("default");
        }
        int z = a > b ? 10 : 5;
        
        if (a > b) {
            z = 10;
        } else {
            z = 5;
        }
    }
}
