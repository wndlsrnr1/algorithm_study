package algorithm.study.level1;
import java.util.*;
public class CrainDoll {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/64061
     */

    //이중 반복 인덱스 생각하기
    //문제 조건 잘 알아보기 터진 횟수 x 터진 인형 개수 o
    class Buffer{
        final Stack<Integer> intStack = new Stack<>();
        int count;

        void push(int number){


            if (intStack.isEmpty()){
                intStack.push(number);
                return;
            }

            if (intStack.peek() == number){
                intStack.pop();
                this.count += 2;
            }else {
                intStack.push(number);
            }
        }

        int getCount(){
            return this.count;
        }
    }

    int getResult(int[][] board, int[] moves){
        Buffer buffer = new Buffer();
        int[] index = moves.clone();

        for (int i = 0; i < moves.length; i++) {
            index[i] -= 1;
        }



        for (int j = 0; j < index.length; j++) {
            int widthIndex = index[j];
            for (int i = 0; i < board.length; i++) {
                if (board[i][widthIndex] != 0){
                    buffer.push(board[i][widthIndex]);
                    board[i][widthIndex] = 0;
                    break;
                }
            }

        }

        return buffer.getCount();
    }





    public int solution(int[][] board, int[] moves) {
        int result = getResult(board, moves);
        int answer = 0;
        return result;
    }
}
