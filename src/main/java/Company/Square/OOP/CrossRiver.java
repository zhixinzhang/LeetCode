package Company.Square.OOP;

import java.util.ArrayList;

public class CrossRiver {
    static class ObjState {
        public int man;
        public int wolf ;
        public int sheep;
        public int vegetable;
    }
    
    static class Vertex {
        ObjState objState = new ObjState();     // 对象状态信息
        String outputMessage;                   // 输出时要显示的信息
        public Vertex(int manState, int wolfState, int sheepState,
                      int vegetableState, String outputMessage){
            // 初始化工作
            objState.man = manState;
            objState.wolf = wolfState;
            objState.sheep = sheepState;
            objState.vegetable = vegetableState;
            this.outputMessage = outputMessage;
        }
    }

    public static int[][] arr = new int[10][10];    // 保存了相邻矩阵信息
    public static ArrayList<Vertex> arrayList = new ArrayList<>();  // 顶点集
    public static int[] visited = new int[10];      // 用来保存是否遍历

    public static void main(String[] args) {
        arrayList.add(new Vertex(0, 0, 0, 0, "初始状态"));
        arrayList.add(new Vertex(0, 1, 0, 0, "农夫羊菜 | 狼"));
        arrayList.add(new Vertex(0, 0, 1, 0, "农夫狼菜 | 羊"));
        arrayList.add(new Vertex(0, 0, 0, 1, "农夫狼羊 | 菜"));
        arrayList.add(new Vertex(1, 0, 1, 0, "狼菜 | 农夫羊"));
        arrayList.add(new Vertex(0, 1, 0, 1, "农夫羊 | 狼菜"));
        arrayList.add(new Vertex(1, 0, 1, 1, "狼 | 农夫羊菜"));
        arrayList.add(new Vertex(1, 1, 0, 1, "羊 | 农夫狼菜"));
        arrayList.add(new Vertex(1, 1, 1, 0, "菜 | 农夫狼羊"));
        arrayList.add(new Vertex(1, 1, 1, 1, "已经全部过河"));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = 0;
            }
        }   // for循环结束初始化数组

        for (int i = 0; i < 10; i++) {
            int temp_i_Man = arrayList.get(i).objState.man;
            int temp_i_Wolf = arrayList.get(i).objState.wolf;
            int temp_i_Sheep = arrayList.get(i).objState.sheep;
            int temp_i_Vegetable = arrayList.get(i).objState.vegetable;
            for (int j = 0; j < 10; j++) {
                int temp_j_Man = arrayList.get(j).objState.man;
                int temp_j_Wolf = arrayList.get(j).objState.wolf;
                int temp_j_Sheep = arrayList.get(j).objState.sheep;
                int temp_j_Vegetable = arrayList.get(j).objState.vegetable;
                if (temp_i_Man != temp_j_Man && (Math.abs(temp_i_Wolf - temp_j_Wolf) +
                        Math.abs(temp_i_Sheep - temp_j_Sheep) +
                        Math.abs(temp_i_Vegetable - temp_j_Vegetable) <= 1)) {
                    // 满足两个条件：①man的状态不一样②有且仅有最多一个狼羊菜中的一个对象状态不一样
                    arr[i][j] = 1;          // 满足以上条件则满足连通性，置为1
                }
            }
        }


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%2d", arr[i][j]);
            }
            System.out.println();   // 换行操作
        }

        visited[0] = 1;
        dfs(1, 10);         // 从第一个点找最后一个点
    }

    public static void dfs(int start, int end) {
        if (start == end) {
            print(end);    // 调用print()方法输出结果
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            if (arr[start-1][i] > 0 && visited[i] == 0) {
                // 有边且没有被访问
                visited[i] = start;
                dfs(i+1, end);
                visited[i] = 0; // 回溯时置为0
            }
        }
    }

    public static void print(int end) {
        // 从最后往前遍历，然后正序输出
        int[] temp = new int[10]; // 保存了倒叙输出的顺序
        int num = 0;    // num表示要输出的个数
        int i = end;    // i表示当前是第几个数
        while (i != 1) {
            // 当i不是第一个数字时，则继续往前找
            temp[num] = visited[i - 1];
            i = temp[num];
            num++;      // num加1
        }
        for (int j = num - 1; j > 0; j--) {
            System.out.println(arrayList.get(temp[j] - 1).outputMessage);
        }
        // 输出最终状态
        System.out.println(arrayList.get(9).outputMessage);
    }
}
