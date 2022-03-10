import java.util.ArrayList;
import java.util.Arrays;

public class TwoDArrayEncryptor {

    private char[][] letterMatrix;
    private int rowShift;
    private int colShift;
    private int caesarShift;

    public TwoDArrayEncryptor(String message, int rowShift, int colShift, int caesarShift) {
        this.letterMatrix = strToCharTwoD(message);
        this.rowShift = rowShift;
        this.colShift = colShift;
        this.caesarShift = caesarShift;
    }

    public void encrypt() {
       shiftCharTwoDRight(letterMatrix,rowShift);
    }

    public static void shiftCharTwoDRight(char[][] matrix, int shift)
    {
        for (int r = 0; r < matrix.length; r++) {
            shiftCharTwoDRightModify(matrix[r],shift);
        }
    }

    public static char[][] strToCharTwoD(String str)
    {
        char[][] matrix;
        int length = str.length();
        int[] rowCols = squarestFactors(length);
        int row = rowCols[0];
        int col = rowCols[1];
        matrix = new char[row][col];

        int idx = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                matrix[r][c] = str.charAt(idx);
                idx++;
            }
        }
        return matrix;
    }

    public static int[] squarestFactors(int num)
    {
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i = 1;i<= num;i++)
        {
            if(num%i==0) factors.add(i);
            if(num/i==i) return new int[]{i,i};
        }
        int[] squarest = new int[2];
        squarest[0] = factors.get(factors.size()/2-1);
        squarest[1] = factors.get(factors.size()/2);
        return squarest;
    }

    public String toString()
    {
        String str = "";
        for(char[] c:letterMatrix)
        {
            str += Arrays.toString(c) + "\n";
        }
        return str;
    }



    public static char caesar(char c, int shift)
    {
        if(c<=90 && c>=65)
        {
            return (char)(((int)c - 65 + shift) % 26 + 65);
        }
        else if(c<=122&& c>=97)
        {
            return (char)(((int)c - 97 + shift) % 26 + 97);
        }
        else
        {
            return c;
        }
    }


    public static String caesar(String str, int shift)
    {
        String s = "";
        char[] arr = str.toCharArray();
        for (char c: arr)
        {
            if(c<=90 && c>=65)
            {
                s += (char)(((int)c - 65 + shift) % 26 + 65);
            }
            else if(c<=122&& c>=97)
            {
                s += (char)(((int)c - 97 + shift) % 26 + 97);
            }
            else
            {
                s += c;
            }
        }
        return s;
    }

    public static String decryptCaesar(String str, int shift)
    {
        return caesar(str, 26-(shift%26));
    }

    public static void shiftNumLeftModify(int[] numList, int shiftNum)
    {
        int[] temp = new int[shiftNum];
        for (int i = 0; i<shiftNum; i++)
        {
            temp[i] = numList[i];
        }
        for (int i = 0; i < numList.length - shiftNum;i++)
        {
            numList[i] = numList[i+shiftNum];
        }
        for (int i = numList.length - shiftNum; i < numList.length;i++)
        {
            numList[i] = temp[i - (numList.length - shiftNum)];
        }
    }

    public static void shiftCharTwoDRightModify(char[] numList, int shiftNum)
    {
        char[] temp = new char[shiftNum];
        for (int i = numList.length - shiftNum; i<numList.length; i++)
        {
            temp[i-(numList.length-shiftNum)] = numList[i];
        }
        char[] temp2 = new char[numList.length - shiftNum];
        for (int i = 0; i < numList.length - shiftNum;i++)
        {
            temp2[i] = numList[i];
        }
        for (int i = shiftNum; i<numList.length;i++)
        {
            numList[i] = temp2[i - shiftNum];
        }
        for (int i = 0; i < shiftNum;i++)
        {
            numList[i] = temp[i];
        }
    }

    public static char[] shiftCharTwoDRight(char[] numList, int shiftNum)
    {
        char[] numList2 = null;
        copyArr(numList,numList2);
        char[] temp = new char[shiftNum];
        for (int i = numList2.length - shiftNum; i<numList2.length; i++)
        {
            temp[i-(numList2.length-shiftNum)] = numList2[i];
        }
        char[] temp2 = new char[numList2.length - shiftNum];
        for (int i = 0; i < numList2.length - shiftNum;i++)
        {
            temp2[i] = numList2[i];
        }
        for (int i = shiftNum; i<numList2.length;i++)
        {
            numList2[i] = temp2[i - shiftNum];
        }
        for (int i = 0; i < shiftNum;i++)
        {
            numList2[i] = temp[i];
        }
        return numList2;
    }

    public static void copyArr(char[] arr1,char[] arr2)
    {
        arr2 = new char[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }

}
