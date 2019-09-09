package pascaltriangle;
import java.util.ArrayList;

public class PascalTriangleEx {

    public static void main(String[] args) {

        PascalTriangleEx ex = new PascalTriangleEx();
        ex.printPascalTriangle(ex.createPascalTriangle(35));
    }

    public ArrayList<ArrayList<Long>> createPascalTriangle(int height) {

        ArrayList<ArrayList<Long>> trianglePascal = new ArrayList<>();
        if (height < 1) return trianglePascal;

        ArrayList<Long> initial = new ArrayList<Long>() {{ add(1L); }};
        trianglePascal.add(initial);
        if (height == 1) return trianglePascal;

        return createPascalTriangle(trianglePascal, height);
    }

    private ArrayList<ArrayList<Long>> createPascalTriangle(ArrayList<ArrayList<Long>> trianglePascal, int height) {

        ArrayList<Long> beforeRow;
        for (int i = 1; i < height; i++) {
            ArrayList<Long> newRow = new ArrayList<Long>() {{
                add(1L);
            }};
            beforeRow = trianglePascal.get(i - 1);
            for (int j = 0; j < beforeRow.size() - 1; j++)
                newRow.add(beforeRow.get(j) + beforeRow.get(j + 1));

            newRow.add(1L);
            trianglePascal.add(newRow);
        }
        return trianglePascal;
    }

    public void printPascalTriangle(ArrayList<ArrayList<Long>> list) {

        ArrayList<Long> lastRow = list.get(list.size() - 1);
        int widthOfSpace = lastRow.get(lastRow.size() / 2).toString().length() + 1;

        StringBuilder numbersWidth = new StringBuilder();
        while (numbersWidth.length() < widthOfSpace) numbersWidth.append(" ");

        StringBuilder rowSpace = new StringBuilder();
        for (int i = list.size() / 2; i <= list.size(); i++) rowSpace.append(numbersWidth);
        int rowPause = (widthOfSpace % 2 == 0) ? widthOfSpace / 2 : widthOfSpace / 2 + 1;

        for (ArrayList<Long> row : list) {

            System.out.print(rowSpace.toString());
            for (long num : row)
                System.out.print(centerString(widthOfSpace, num));

            System.out.println();
            if (rowSpace.length() - rowPause >= 0) rowSpace.setLength(rowSpace.length() - rowPause);
        }
    }

    private static String centerString(int width, long s) {
        return String.format(" %-" + width + "s", String.format("%" + (Long.toString(s).length() + (width - Long.toString(s).length()) / 2) + "s", s));
    }

}