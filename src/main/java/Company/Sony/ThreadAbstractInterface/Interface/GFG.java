package Company.Sony.ThreadAbstractInterface.Interface;

public class GFG {
        // Main driver method
        public static void main(String[] args)
        {
            // Creating the Object of Rectangle class
            // and using shape interface reference.
            Shape rect = new Rectangle(2, 3);
     
            System.out.println("Area of rectangle: "
                               + rect.area());
    
        }
}
