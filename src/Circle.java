package Shape;

public class Circle implements Shape
{

    public Circle(double r)
    {
        if(r<0.0) {
            // WARNING : you should not throw an exception without cleaning acquired ressources
            // such as files...
            throw new IllegalArgumentException();
        }
        this.radius = r;
    }

    public Circle(Circle c)
    { // this is a copy constructor can be used to duplicate an object with ' new Circle(circle) '
        this.radius = c.radius;
    }

    public double area()
    {
        return Math.PI*this.radius*this.radius;
    }


    // Members

    private double radius;

    // member could be public only if they do not impact the class invariant
}
