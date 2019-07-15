package company.Apple;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by zhang on 2018/2/8.
 * A quadtree is a tree data structure in which each internal node has exactly four children. Quadtrees are most often used to
 partition a two-dimensional space by recursively subdividing it into four quadrants or regions. The regions may be square or
 rectangular, or may have arbitrary shapes.
 */
/*
 *  			N
 *  		W		E
 *  			S
 */
class Node {
    int x, y, value;

    Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value; /* some data*/
    }
}
/* Using two points of Rectangular (Top,Left) & (Bottom , Right)*/
class Boundry {
    public int getxMin() {
        return xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public Boundry(int xMin, int yMin, int xMax, int yMax) {
        super();
		/*
		 *  Storing two diagonal points
		 */
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean inRange(int x, int y) {
        return (x >= this.getxMin() && x <= this.getxMax()
                && y >= this.getyMin() && y <= this.getyMax());
    }

    int xMin, yMin, xMax, yMax;

}

public class QuadTree {
    final int MAX_CAPACITY =4;
    int level = 0;
    List<Node> nodes;
    QuadTree northWest = null;
    QuadTree northEast = null;
    QuadTree southWest = null;
    QuadTree southEast = null;
    Boundry boundry;

    QuadTree(int level, Boundry boundry) {
        this.level = level;
        nodes = new ArrayList<Node>();
        this.boundry = boundry;
    }

    /* Traveling the DataStructure.Graph using Depth First Search*/
    static void dfs(QuadTree tree) {
        if (tree == null)
            return;

        System.out.printf("\nLevel = %d [X1=%d Y1=%d] \t[X2=%d Y2=%d] ",
                tree.level, tree.boundry.getxMin(), tree.boundry.getyMin(),
                tree.boundry.getxMax(), tree.boundry.getyMax());

        for (Node node : tree.nodes) {
            System.out.printf(" \n\t  x=%d y=%d", node.x, node.y);
        }
        if (tree.nodes.size() == 0) {
            System.out.printf(" \n\t  Leaf Node.");
        }
        dfs(tree.northWest);
        dfs(tree.northEast);
        dfs(tree.southWest);
        dfs(tree.southEast);

    }

    void split() {
        int xOffset = this.boundry.getxMin()
                + (this.boundry.getxMax() - this.boundry.getxMin()) / 2;
        int yOffset = this.boundry.getyMin()
                + (this.boundry.getyMax() - this.boundry.getyMin()) / 2;

        northWest = new QuadTree(this.level + 1, new Boundry(
                this.boundry.getxMin(), this.boundry.getyMin(), xOffset,
                yOffset));
        northEast = new QuadTree(this.level + 1, new Boundry(xOffset,
                this.boundry.getyMin(), xOffset, yOffset));
        southWest = new QuadTree(this.level + 1, new Boundry(
                this.boundry.getxMin(), xOffset, xOffset,
                this.boundry.getyMax()));
        southEast = new QuadTree(this.level + 1, new Boundry(xOffset, yOffset,
                this.boundry.getxMax(), this.boundry.getyMax()));

    }

    void insert(int x, int y, int value) {
        if (!this.boundry.inRange(x, y)) {
            return;
        }

        Node node = new Node(x, y, value);
        if (nodes.size() < MAX_CAPACITY) {
            nodes.add(node);
            return;
        }
        // Exceeded the capacity so split it in FOUR
        if (northWest == null) {
            split();
        }

        // Check coordinates belongs to which partition
        if (this.northWest.boundry.inRange(x, y))
            this.northWest.insert(x, y, value);
        else if (this.northEast.boundry.inRange(x, y))
            this.northEast.insert(x, y, value);
        else if (this.southWest.boundry.inRange(x, y))
            this.southWest.insert(x, y, value);
        else if (this.southEast.boundry.inRange(x, y))
            this.southEast.insert(x, y, value);
        else
            System.out.printf("ERROR : Unhandled partition %d %d", x, y);
    }

    public static void main(String args[]) {
        QuadTree anySpace = new QuadTree(1, new Boundry(0, 0, 1000, 1000));
        anySpace.insert(100, 100, 1);
        anySpace.insert(500, 500, 1);
        anySpace.insert(600, 600, 1);
        anySpace.insert(700, 600, 1);
        anySpace.insert(800, 600, 1);
        anySpace.insert(900, 600, 1);
        anySpace.insert(510, 610, 1);
        anySpace.insert(520, 620, 1);
        anySpace.insert(530, 630, 1);
        anySpace.insert(540, 640, 1);
        anySpace.insert(550, 650, 1);
        anySpace.insert(555, 655, 1);
        anySpace.insert(560, 660, 1);
        //Traveling the graph
        QuadTree.dfs(anySpace);
    }
}
