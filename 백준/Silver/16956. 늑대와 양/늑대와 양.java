import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        sc.nextLine();

        int[] di={-1,0,1,0};
        int[] dj={0,1,0,-1};

        char[][] box=new char[r][c];

        for(int i=0; i<r;i++){
            String line=sc.nextLine();
            for(int j=0; j<c; j++) {
                box[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<r;i++){
            for(int j=0; j<c;j++){
                if(box[i][j]=='W'){
                    for(int k=0; k<4; k++){
                        int x=i+di[k];
                        int y=j+dj[k];
                        if(x>=0&&y>=0&&x<r&&y<c){
                            if(box[x][y]=='.'){
                                box[x][y]='D';
                            }else if(box[x][y]=='S'){
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(1);
        for(int i=0; i<r;i++){
            for(int j=0; j<c;j++){
                System.out.print(box[i][j]);
            }
            System.out.println();
        }
    }
}
