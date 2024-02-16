import java.util.Scanner;


/*      c=0          c=1         c=2
 * l=0 [0][0]   |   [0][1]  |   [0][2]
 * l=1 [1][0]   |   [1][1]  |   [1][2]
 * l=2 [2][0]   |   [2][1]  |   [2][2]
 */


public class JogoDaVelha {

    Scanner tec = new Scanner(System.in);

    private int jogada = 0;

    public JogoDaVelha(){

        char jogarNov = 'S';

        char mapa[][] = new char[3][3];
        
        do{
            jogarPartida(tec, mapa);
            if (terminou(mapa) == true){
                do{
                    System.out.println("Deseja jogar novamente?(s/n)");
                    jogarNov = tec.next().toUpperCase().charAt(0);
                } while (jogarNov != 'S' && jogarNov != 'N');
                jogada = 0;
            }
        } while (jogarNov == 'S');

        

        if (jogarNov == 'S'){
        }
    }


    private void jogarPartida(Scanner tec, char[][] mapa){

        limpaMapa(mapa);

        desenha(mapa);

        int turno = (int)(Math.random()*2);
        

        System.out.println(turno);

        while (terminou(mapa) == false){
            
            switch(turno){
            case 0:
                turnoJogador(mapa);
                turno++;
                jogada++;
                break;

            case 1:
                turnoPC(mapa);
                turno--;
                jogada++;
                break;
            }
        }
    }


    private void limpaMapa(char[][] mapa){

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                mapa[i][j] = ' ';
            }
        }

    } 


    private void desenha(char[][] mapa){
        System.out.println("------------- .. jogada: " + jogada);
        System.out.println("| " + mapa[0][0] + " | " + mapa[0][1] + " | " + mapa[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + mapa[1][0] + " | " + mapa[1][1] + " | " + mapa[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + mapa[2][0] + " | " + mapa[2][1] + " | " + mapa[2][2] + " |");

    }


    private void turnoJogador(char[][] mapa){
        System.out.println("Turno do Jogador");
        System.out.print("Linha: ");
        int l = tec.nextInt();
        System.out.print("Coluna: ");
        int c = tec.nextInt();

        if (l < 3 && c < 3){
            if (mapa[l][c] == ' '){

                mapa[l][c] = 'X';

            } else{

                do{
                    System.out.println("Jogada Inválida.");
                    System.out.print("Linha: ");
                    l = tec.nextInt();
                    System.out.print("Coluna: ");
                    c = tec.nextInt();
                }while (mapa[l][c] != ' ');
                
                mapa[l][c] = 'X';
            }
        }

        System.out.println();
        desenha(mapa);
    }


    private void turnoPC(char[][] mapa){
        System.out.println("Turno do PC");
        int l = (int)(Math.random()*3);
        int c = (int)(Math.random()*3);

        if (mapa[l][c] == ' '){

            mapa[l][c] = 'O';

        } else{

            do{
                l = (int)(Math.random()*3);
                c = (int)(Math.random()*3);
            }while (mapa[l][c] != ' ');
            
            mapa[l][c] = 'O';
        }
        
        System.out.println("PC: [" + l + "]" + "[" + c + "]");
        System.out.println();
        desenha(mapa);
    }


    private boolean terminou(char[][] mapa){
        if (((mapa[0][0] == mapa[0][1] && mapa[0][0] == mapa[0][2]) && mapa[0][0] != ' ') || 
            ((mapa[1][0] == mapa[1][1] && mapa[1][0] == mapa[1][2]) && mapa[1][0] != ' ') || 
            ((mapa[2][0] == mapa[2][1] && mapa[2][0] == mapa[2][2]) && mapa[2][0] != ' ') || 

            ((mapa[0][0] == mapa[1][0] && mapa[0][0] == mapa[2][0]) && mapa[0][0] != ' ') || 
            ((mapa[0][1] == mapa[1][1] && mapa[0][1] == mapa[2][1]) && mapa[0][1] != ' ') || 
            ((mapa[0][2] == mapa[1][2] && mapa[0][2] == mapa[2][2]) && mapa[0][2] != ' ') || 

            ((mapa[0][0] == mapa[1][1] && mapa[0][0] == mapa[2][2]) && mapa[0][0] != ' ') || 
            ((mapa[0][2] == mapa[1][1] && mapa[0][2] == mapa[2][0]) && mapa[0][2] != ' ')){

                if(
                   (mapa[0][0] == 'O' && mapa[0][1] == 'O' && mapa[0][2] == 'O') || 
                   (mapa[1][0] == 'O' && mapa[1][1] == 'O' && mapa[1][2] == 'O') || 
                   (mapa[2][0] == 'O' && mapa[2][1] == 'O' && mapa[2][2] == 'O') || 

                   (mapa[0][0] == 'O' && mapa[1][0] == 'O' && mapa[2][0] == 'O') ||
                   (mapa[0][1] == 'O' && mapa[1][1] == 'O' && mapa[2][1] == 'O') || 
                   (mapa[0][2] == 'O' && mapa[1][2] == 'O' && mapa[2][2] == 'O') || 

                   (mapa[0][0] == 'O' && mapa[1][1] == 'O' && mapa[2][2] == 'O') ||
                   (mapa[2][0] == 'O' && mapa[1][1] == 'O' && mapa[0][2] == 'O')){
                    System.out.println("PC GANHOU!");

                   } else if(
                    (mapa[0][0] == 'X' && mapa[0][1] == 'X' && mapa[0][2] == 'X') || 
                    (mapa[1][0] == 'X' && mapa[1][1] == 'X' && mapa[1][2] == 'X') || 
                    (mapa[2][0] == 'X' && mapa[2][1] == 'X' && mapa[2][2] == 'X') || 
 
                    (mapa[0][0] == 'X' && mapa[1][0] == 'X' && mapa[2][0] == 'X') ||
                    (mapa[0][1] == 'X' && mapa[1][1] == 'X' && mapa[2][1] == 'X') || 
                    (mapa[0][2] == 'X' && mapa[1][2] == 'X' && mapa[2][2] == 'X') || 
 
                    (mapa[0][0] == 'X' && mapa[1][1] == 'X' && mapa[2][2] == 'X') ||
                    (mapa[2][0] == 'X' && mapa[1][1] == 'X' && mapa[0][2] == 'X')){
                     System.out.println("JOGADOR GANHOU!");
                     
                 }

                

            return true;

            
            
        } else if((mapa[0][0] != ' ' && mapa[0][1] != ' ' && mapa[0][2] != ' ' &&
                   mapa[1][0] != ' ' && mapa[1][1] != ' ' && mapa[1][2] != ' ' &&
                   mapa[2][0] != ' ' && mapa[2][1] != ' ' && mapa[2][2] != ' ')){
                    
            System.out.println("Deu velha!");
            return true;

        } else{
            return false;
        }
        
    }


    public void run(){

    }


}
