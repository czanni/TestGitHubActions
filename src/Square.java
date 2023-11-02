package Shape;

public class Square implements Shape
{
    public Square(double size)
    {
        if(size<0.0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    public Square(Square c)
    {
        this.size = c.size;
    }

    public double area()
    {
        return size*size;
    }


    private double size;
}
