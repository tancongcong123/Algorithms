package com.example.algorithms.array2;

import com.example.algorithms.PrintUtils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 有效的数独
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 */
public class Suduko {

    private static HashMap<Integer, Boolean> hashMap = new HashMap<>();
    private static char[][] chars = new char[][]{{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

    public static void main(String[] args){
        System.out.println(PrintUtils.toString(chars));
        System.out.println(isValidSudoku(chars));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board==null)
            return false;
        for (int i=0;i<9;i++){
            if (!isValidSmall(board, i)){
                return false;
            }
        }
        int row = 0;
        int column = 0;
        while (row<board.length && column<board.length){
            for (int i=column+1;i<board.length;i++){
                if (board[row][column]=='.'){
                    continue;
                }
                if (board[row][column]==board[row][i]){
                    return false;
                }
            }
            for (int i=row+1;i<board.length;i++){
                if (board[row][column]=='.'){
                    continue;
                }
                if (board[row][column]==board[i][column]){
                    return false;
                }
            }
            column++;
            if (column==board.length){
                row++;
                column=0;
            }
        }
        return true;
    }

    private static boolean isValidSmall(char[][] board, int index){
        if (hashMap.containsKey(index)){
            return hashMap.get(index);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        int rowStart = (index/3)*3;
        int columnStart = (index%3)*3;
        int row=rowStart;
        int column=columnStart;
        while (row<(rowStart+3)||column<(columnStart+3)){
            if (column==columnStart+3){
                row++;
                if (row==rowStart+3){
                    return true;
                }
                column=columnStart;
            }
            if (board[row][column]=='.'){
                column++;
                continue;
            }
            if (!hashSet.add(Integer.valueOf(board[row][column]))){
                hashMap.put(index, false);
                return false;
            }
            column++;
            System.out.println("row=="+row+"  column=="+column);
        }
        hashMap.put(index, true);
        return true;
    }
}
