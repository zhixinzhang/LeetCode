package Company.Sony.ThreadAbstractInterface.Abstract;

public class GFG {
        // Main driver method
        public static void main(String[] args)
        {
            // Creating the Object of Rectangle class
            // and using shape class reference.
            Shape rect = new Rectangle(2, 3, "Rectangle");
     
            System.out.println("Area of rectangle: "
                               + rect.area());
     
            rect.moveTo(1, 2);
        }
}
