package Shape;

import java.util.ArrayList;

// Example code for GitHub CI (see workflow file in .github/workflow directory)
public class Application {

    /** Compute the sum of the area of the figures stored in a container.
     *
     * @param list container containing Shapes
     * @return summed area
     */
    public static double sumArea(Iterable<? extends Shape> iterator)
    {
        //  - sumArea is a generic method
        //  - by taking an Iterable instead of an ArrayList the method can be used on
        //    a larger set of containers
        //  - using the following signature would not compile
        //      double sumArea(Iterable<Shape> list)
        //    because the line with '#1' would not compile (Iterable<Square> does not derive from Iterable<Shape>)
        //  - using the following signature would not compile
        //      double sumArea(Iterable<?> list)
        //    because the line with '#2' require the knowledge of the interface shape
        //  - in the present case we could have used the following signature
        //      <T extends Shape> double sumArea(Iterable<T> iterator)
        //    prefer wildcar ? usage if there is no dependency between parameters type (or return type)

        double res = 0.0;
        for(Shape s : iterator) { // #1
            res += s.area(); // #2
        }
        return res;
    }

    public static < T extends Shape > int countAreaGreaterThan(T[] tab, double limArea) {
        int count = 0;
        for (Shape fig : tab) {
            if (fig.area() > limArea) {
                ++count;
            }
        }
        return count;
    }


    public static void producer(ArrayList<? extends Shape> container)
    {
        // ? -> can be either Figure or Circle or Square, in our case Circle, so OK

        for (Shape f : container) { // here the container is used to “produce/access” elements
            System.out.println(f.area());  // OK as we known the the type is either Figure and Circle
            // both accepting the move function defined in Figure
        }

        // container.add(new Figure()); // compilation error
        // container.add(new Circle()); // compilation error
        // we don’t know which type was used to initialise the variable in practice (think about what
        // happen if you take this type as the input of a method), it could as well be an ArrayList of
        // Square, so insertion is forbidden !
    }

    public static void consumer(ArrayList<? super Circle> container)
    {
        // ? -> can be either Circle, Figure or Object, in our case Circle, so OK

        // here the container is used to “consume/store” elements
        container.add(new Circle(2)); // OK, we can insert a Circle in an ArrayList<Circle>,
        // an ArrayList<Figure> and an ArrayList<Object>
        // because Circle derive from Figure and Object
        //container.add(new Smiley()); // same here

        // container.add(new Figure()); // compilation error, Figure does not derive from Circle,
        // so there is one possible case of initialization of the variable container that is
        // problematic (the one we use above)... Once again since we don’t know which one was used
        // in practice (think about the parameter of a function), there is a compilation error !

        // for (Figure f : container) { // compilation error
        //     f.move(); // compilation error
        // }
        // variable container could have been initialized with an ArrayList<Object> (authorized
        // by “super” bound), which explain why it is forbidden
    }

    public static void main(String[] args)
    {
        ArrayList<Shape> shapeList = new ArrayList<Shape>(5);
        // warning : parameter of constructor is the capacity in term of memory,
        //           not the initial number of elements

        Circle c = new Circle(1);
        shapeList.add(c);             // add a reference to c in the list
        shapeList.add(new Circle(c)); // add duplicate of c (does not reference the same object)
        shapeList.add(new Circle(2));
        Shape s = new Square(1);
        shapeList.add(s);
        shapeList.add(new Square(2));

        System.out.println("Sum of the Figure's area is : " + sumArea(shapeList));
        Shape test[] = new Shape[5];
        shapeList.toArray(test);
        System.out.println("Num greater : " + countAreaGreaterThan(test, 2.0));

        ArrayList<Square> squareList = new ArrayList<>(); // <> automatically deduce the type based on type on the left of '='
        squareList.add(new Square(3));
        squareList.add(new Square(2));

        System.out.println("Sum of the Square's area is : " + sumArea(squareList));
        Square test2[] = new Square[2];
        squareList.toArray(test2);
        System.out.println("Num greater : " + countAreaGreaterThan(test2, 2.0));

        // Exemple Container Producer
        ArrayList<Circle> circles1 = new ArrayList<Circle>();
        circles1.add(new Circle(5));
        producer(circles1); // take a ArrayList<? extend Shape>

        // Exemple Container Consumer
        ArrayList<Circle> circles2 = new ArrayList<Circle>();
        circles2.add(new Circle(4));
        consumer(circles2); // take a ArrayList<? super Circle>
    }
}
