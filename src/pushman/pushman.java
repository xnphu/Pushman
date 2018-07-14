package pushman;

import java.util.Scanner;
public class pushman {
    static int px,py,kx,ky,ex,ey,vx,vy;
    static int [][] a;
    static Scanner sc = new Scanner(System.in);
    static String move = "";


    public static void main(String[] args) {
        generate();
        while(true){
            draw();
            System.out.println("Your move? ");
            move = sc.next();
            action(move);
            if(kx==ex&&ky==ey){
                System.out.println("You win!");
                break;
            }
        }

    }

    private static void draw(){
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = 0;
            }
        }
        a[ex][ey] = 1;
        a[kx][ky] = 2;
        a[px][py] = 3;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                switch(a[i][j]){
                    case 0:System.out.print(" - ");break;
                    case 1:System.out.print(" E ");break;
                    case 2:System.out.print(" K ");break;
                    case 3:System.out.print(" P ");break;
                    default:break;
                }
            }
            System.out.println("");
        }
    }

    private static void generate() {
        System.out.println("Input n: ");
        int n;
        n = sc.nextInt();
        a = new int[n][n];
        px = 0;
        py = 0;
        ex = n-1;
        ey = n-1;
        kx = (int) (Math.random()*(n-2));
        ky = (int) (Math.random()*(n-2));
    }

    private static void action(String move) {
        switch(move){
            case "W": vx = -1; vy = 0; break;
            case "A": vx = 0; vy = -1; break;
            case "S": vx = 1; vy = 0; break;
            case "D": vx = 0; vy = 1; break;
            default: vx = 0; vy = 0; break;
        }
        if(px+vx>a.length-1||px+vx<0) return;
        if(py+vy>a.length-1||py+vy<0) return;
        if(px+vx==kx&&py+vy==ky){
            if(kx+vx>a.length-1||kx+vx<0) return;
            if(ky+vy>a.length-1||ky+vy<0) return;
            kx+=vx;
            ky+=vy;
            px+=vx;
            py+=vy;
            return;
        }
        px+=vx;
        py+=vy;

    }




}
