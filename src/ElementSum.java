import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ElementSum {

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
    public static void writeFile(File file, int sum)
    {
        try
        {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(sum);
            System.out.println("Ghi file thành công!");
            bufferedWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("Lỗi không tìm thấy file!");
        }
    }

    public static int elementSum(List<Integer> list)
    {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
    public static void main(String[] args)
    {
        File readFile = new File("src/resources/number.txt");
        List<Integer> numberList = readFile(readFile);
        int sum = elementSum(numberList);
        File writeFile = new File("src/resources/result.txt");
        writeFile(writeFile, sum);
    }
}
