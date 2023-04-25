package Company.Sony.ThreadAbstractInterface.Abstract;

public abstract class Shape {
        // Declare fields
        String objectName = " ";
 
        // Constructor of this class
        Shape(String name) { this.objectName = name; }
     
        // Method
        // Non-abstract methods
        // Having as default implementation
        public void moveTo(int x, int y)
        {
            System.out.println(this.objectName + " "
                               + "has been moved to"
                               + " x = " + x + " and y = " + y);
        }
     
        // Method 2
        // Abstract methods which will be
        // implemented by its subclass(es)
        abstract public double area();
        abstract public void draw();
}
