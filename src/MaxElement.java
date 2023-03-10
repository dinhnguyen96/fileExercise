import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaxElement {

    public static List<Integer> readFile(File file)
    {
        List<Integer> numberList = new ArrayList<>();
        try
        {
            FileReader reader  = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null)
            {
                if (line.equals(""))
                {
                    continue;
                }
                numberList.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        }
        catch (IOException e)
        {
            System.out.println("Lỗi không tìm thấy file!");
        }
        return numberList;
    }

    public static void writeFile(File file, int maxElement)
    {
        try
        {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(String.valueOf(maxElement));
            System.out.println("Ghi file thành công!");
            bufferedWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("Lỗi không tìm thấy file!");
        }

    }
    public static int maxElement(List<Integer> numberList)
    {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < numberList.size(); i++)
        {
            if (numberList.get(i) > maxElement)
            {
                maxElement = numberList.get(i);
            }
        }
        return maxElement;
    }
    public static void main(String[] args)
    {
        File readFile = new File("src/resources/number.txt");
        List<Integer> numberList = readFile(readFile);
        int maxElement = maxElement(numberList);
        File writeFile = new File("resources/result.txt");
        writeFile(writeFile, maxElement);

    }
}