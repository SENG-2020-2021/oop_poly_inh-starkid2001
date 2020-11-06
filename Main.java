import java.util.Scanner;
//Complete this program that the user will be able to choose the quadilateral it wants to calculate its perimeter and area

class Main {
    public static void main(String[] args) {
        //Declare a char to store the chosen quadilateral
        char choice = ' ';
        float top_side, right_side, bottom_side, left_side, height;
        Scanner scan = new Scanner(System.in);
        Quadilateral q;
        System.out.println("Note : \nt - Trapezoid \nr - Rhombus \np - parallelogram \nR - Rectangle \ns - Square");
        System.out.print("Enter your choice :");
        choice = scan.next().charAt(0);
        //using a switch check what the user selected and use it to calculate the perimeter and area of the desired quadilateral
        switch (choice) {

            case 'p':
                //this should be in the parallelogram case
                System.out.println("This program calculates the area and perimeter of the parallelogram.");

                System.out.print("Input the base of your Parallelogram :");
                bottom_side = scan.nextFloat();
                System.out.print("Input the height of your Parallelogram :");
                height = scan.nextFloat();
                System.out.print("Input the length of your Parallelogram :");
                left_side = scan.nextFloat();
                scan.close();

                q = new Parallelogram(left_side, bottom_side, height);

                if (q.check()) {
                    System.out.println("Invalid input");
                    return;
                }
                System.out.println("\n");
                System.out.printf("The perimeter of the parallelogram with base %.2f and height %.2f is %.2f", bottom_side, height, q.calculatePerimeter());
                System.out.printf("The area of the parallelogram is %.2f", q.Area());
                break;

            case 't':

                //this should be in the Trapezoid case
                System.out.println("This program calculates the area and perimeter of the Trapezoid.");

                System.out.print("Input the top side: ");
                top_side = scan.nextFloat();
                System.out.print("Input bottom side: ");
                bottom_side = scan.nextFloat();
                System.out.print("Input left side: ");
                left_side = scan.nextFloat();
                System.out.print("Input right side: ");
                right_side = scan.nextFloat();
                System.out.print("Input height: ");
                height = scan.nextFloat();
                scan.close();

                q = new Trapezoid(top_side, right_side, bottom_side, right_side, height);
                if (q.check()) {
                    System.out.println("Invalid input");
                    return;
                }
                System.out.println("\n");
                System.out.printf("The perimeter of the Trapezoid with First Side: %.2f, Second Side: %.2f, Third Side: %.2f, and Fourth Side: %.2f is %.2f\n", top_side, right_side, bottom_side, left_side, q.calculatePerimeter());
                System.out.printf("The area of the Trapezoid is %.2f\n\n", q.Area());
                break;

            case 'r':

                //this should be in the Trapezoid case
                System.out.println("This program calculates the area and perimeter of the Rhombus.");

                System.out.print("Input the first diagonal :");
                float d1 = scan.nextFloat();
                System.out.print("Input the second diagonal :");
                float d2 = scan.nextFloat();
                System.out.print("Input the value of a side :");
                top_side = scan.nextFloat();
                scan.close();

                q = new Rhombus(d1, d2, top_side);
                if (q.check()) {
                    System.out.println("Invalid input");
                    return;
                }
                System.out.println("\n");
                System.out.printf("The perimeter of the Rhombus is %.2f with side of %.2f and diagonals %.2f and %.2f\n", q.calculatePerimeter(), top_side, d1, d2);
                System.out.printf("The area of the Rhombus is %.2f\n\n", q.Area());
                break;

            case 's':

                System.out.println("This program calculates the area and perimeter of the Square.");

                System.out.print("Input value of a side :");
                top_side = scan.nextFloat();
                scan.close();

                q = new Square(top_side);
                if (q.check()) {
                    System.out.println("Invalid input");
                    return;
                }
                System.out.println("\n");
                System.out.printf("The perimeter of the square is %.2f and side of %.2f\n", q.calculatePerimeter(), top_side);
                System.out.printf("The area of the square is %.2f\n\n", q.Area());
                break;

            case 'R':

                System.out.println("This program calculates the area and perimeter of the Rectangle.");

                System.out.print("Input side of a Rectangle :");
                left_side = scan.nextFloat();
                System.out.print("Input base of a Rectangle :");
                top_side = scan.nextFloat();
                scan.close();

                q = new Rectangle(top_side, left_side);
                if (q.check()) {
                    System.out.println("Invalid input");
                    return;
                }
                System.out.println("\n");
                System.out.printf("The parameter of the Rectangle is %.2f of length %.2f and base %.2f\n", q.calculatePerimeter(), left_side, top_side);
                System.out.printf("The area of the Rectangle is %.2f\n\n", q.Area());
                break;

            default:
                System.out.println("Invalid option Entered");
                scan.close();
                return;

        }
        }
    }

    //Create class for Rhombus
    class Rhombus extends Quadilateral {

        //d1 - first diagonal
        //d2 - second diagonal
        float d1 = 1f, d2 = 1f;

        public Rhombus(float d1, float d2, float a) {

            this.d1 = d1;
            this.d2 = d2;
            ts = a;
        }

        public float Area() {

            return (d1 * d2) / 2;
        }

        public float calculatePerimeter() {

            return 4 * ts;
        }

        public boolean check() {

            return ((ts <= 0) || (d1 <= 0) || (d2 <= 0));
        }
    }

    //Create class for square
    class Square extends Quadilateral {

        public Square(float a) {
            ts = a;
        }

        public float Area() {
            return ts * ts;
        }

        public float calculatePerimeter() {
            return 4 * ts;
        }

    }


    //create class for Rectangle
    class Rectangle extends Quadilateral {

        public Rectangle(float a, float b) {
            ts = a;
            ls = b;
        }

        public float Area() {
            return ts * ls;
        }

        public float calculatePerimeter() {
            return (ts + ls) * 2;
        }

    }

    class Trapezoid extends Quadilateral {

        public Trapezoid(float a, float b, float c, float d, float h) {
            ts = a;
            rs = b;
            bs = c;
            ls = d;
            height = h;
        }

        public float calculatePerimeter() {
            return ts + rs + bs + ls;
        }

        public float Area() {
            return ((ts + bs) / 2) * height;

        }

    }

    class Parallelogram extends Quadilateral {

        public Parallelogram(float l, float b, float h) {
            height = h;
            bs = b;
            ls = l;
        }

        public float Area() {
            return height * bs;
        }

        public float calculatePerimeter() {
            return (bs + ls) * 2;
        }

    }

    class Quadilateral {

        protected float ts = 1;
        protected float bs = 1;
        protected float ls = 1;
        protected float rs = 1;
        protected float height = 1f;

        public void setLength(float b) {
            ls = b;
        }

        public float calculatePerimeter() {

            return 2 * (ls + bs);
        }

        public float Area() {
            return bs * ls;
        }

        public boolean check() {

            return ((ts <= 0f) || (bs <= 0f) || (rs <= 0f) || (ls <= 0f));


        }


    }

