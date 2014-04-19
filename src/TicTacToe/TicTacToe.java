package TicTacToe;
import java.util.Scanner;
public class TicTacToe {
    public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		String border[] = {"   |   |   ","---+---+---","   |   |   ","---+---+---","   |   |   "};
		char gameData[][] = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
		char [][] display = new char[5][11];
		char player = 'O';
		boolean win = false;
		int pos;
		for (int i=0;i<=display.length-1;i++){
			display[i] = border[i].toCharArray();
		}
		updateDisplay(gameData,display);
		printDisplay(display);
		for (int loop=1;loop<=9 && !win;loop++){
			player = (player == 'O') ? 'X' : 'O';
			do{
				System.out.print("Player " + player +" input the position (1-9): ");
				pos = input.nextInt();
			}while(!valAdd(pos,gameData,player,display));
			if (loop>=5) win = checkWin(gameData);
			printDisplay(display);
		}
		if (win){
            System.out.println("The winner is " + player + "!");
        }else{
            System.out.println("The game is drawn !");
        }
	}
	public static void printDisplay(char[][] output){
		for (int i=0;i<=output.length-1;i++){
			System.out.println(output[i]);
		}
	}
	public static void updateDisplay(char[][] dataArray, char[][] output){
		for (int i=0;i<=dataArray.length-1;i++){
			for(int j=0;j<=dataArray[i].length-1;j++){
				output[2*i][4*j+1] = dataArray[i][j];
			}
		}
	}
	public static boolean checkWin(char [][] dataArray){
		for (int row=0;row<=dataArray.length-1;row++){
			if(dataArray[row][0] == dataArray[row][1] && dataArray[row][0] == dataArray[row][2]) return true;
		}
		for (int col=0;col<=dataArray.length-1;col++){
			if(dataArray[0][col] == dataArray[1][col] && dataArray[0][col] == dataArray[2][col]) return true;
		}
		if ((dataArray[0][0] == dataArray[1][1] && dataArray[0][0] == dataArray[2][2]) || (dataArray[0][2] == dataArray[1][1] && dataArray[0][2] == dataArray[2][0])) return true;
		return false;
	}
    public static boolean valAdd(int position, char[][] dataArray, char playerSign, char[][] output){
		int row = (position-1)/3 , col = (position+2)%3;
		if (position >= 1 && position <= 9){
			if (dataArray[row][col] > '9'){
				System.out.println("The position is occupied !");
				return false;
			} else {
				dataArray[row][col] = playerSign;
				updateDisplay(dataArray,output);
				return true;
			}
		}else{
			System.out.println("The input range is 1-9 !");
			return false;
		}	
	}
}
