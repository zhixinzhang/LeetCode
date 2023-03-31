package Company.Rippling;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/25/22
 * Time: 2:11 PM
 * Description:
 *
 * To avoid extra space we have to store a particular state of the position in a 
 * unique number so that later we can change that number back to 0 or 1 before returning.
 *
 * We will encounter 4 states while making changes to the given matrix.
 *
 * live cell -> live cell [we will store this state with number 2]
 * live cell -> dead cell [we will store this state with number 3]
 * dead-> dead cell [we will store this state with number 4]
 * dead -> live cell [we will store this state with number 5]
 * Thus while making changes to given matrix we have to follow original state. Live cell will be either 1( if a cell is not reached by any yet), 2 and 3. Dead cell will be given by 0(if a cell is not reached by any yet), 4 and 5. At last after all processing we will make 2 or 5 back to 1 as their current state is live and 3 or 4 to 0 as their current state is dead.
 * I used array a,b to avoid those 8 if cases to be written again & again :)
 */

public class _289_GameLife_Array {
    public void gameOfLife(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int a[]= new int[]{-1,-1,-1,0,0,1,1,1};
        int b[]= new int[]{-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int count=0;
                for(int p=0;p<8;p++)
                {
                    if(check(i+a[p],j+b[p],arr) && (arr[i+a[p]][j+b[p]]==1 || arr[i+a[p]][j+b[p]]==2 || arr[i+a[p]][j+b[p]]==3) )
                        count++;
                }
                if((arr[i][j]==0 || arr[i][j]==4 || arr[i][j]==5) && count==3)
                {
                    arr[i][j]=5;
                }
                else if(arr[i][j]==1 || arr[i][j]==2 || arr[i][j]==3)
                {
                    if(count<2)
                        arr[i][j]=3;
                    else if(count==2 || count==3)
                        arr[i][j]=2;
                    else if(count>3)
                        arr[i][j]=3;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==2 || arr[i][j]==5)
                    arr[i][j]=1;
                else if(arr[i][j]==3 || arr[i][j]==4)
                    arr[i][j]=0;
            }
        }

    }

    public boolean check(int i, int j,int arr[][])
    {
        int n=arr.length,m=arr[0].length;
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }


    // Extra space  
    public void gameOfLife_DFS(int[][] board)
    {
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        int m=board.length;
        int n=board[0].length;
        int[][] mat=new int[m][n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int temp=board[i][j];
                int one=0;
                for(int[] row:directions)
                {
                    int r=i+row[0];
                    int c=j+row[1];
                    
                    if(r<0 || r>=m || c<0 || c>=n)
                    {
                        continue;
                    }
                    
                    if(board[r][c]==1)
                    {
                        one++;
                    }
                    
                }
                
                if(temp==1 && (one==2 || one==3))
                {
                   mat[i][j]=1; 
                }
                
                if((temp==0) && (one==3))
                {
                    mat[i][j]=1;
                }
            }
        }
        int i=0;
        for(int[] row:mat)
        {
            board[i]=row;
            i++;
        }
    }
}
