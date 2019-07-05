import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RandomWordGenerator
{
    File file;
    ArrayList<String> list;
    Random rand;

    public RandomWordGenerator(File f)
    {
        this.file = f;
        list = new ArrayList<String>();
        rand = new Random();
    }

    public String read() throws IOException, FileNotFoundException
    {
        FileReader fr = new FileReader(this.file);
        BufferedReader br = new BufferedReader(fr);

        String aux;
        while ((aux = br.readLine()) != null)
        {
            list.add(aux);
        }

        br.close();
        return list.get(rand.nextInt(list.size()));
    }
    public static void main(String[] args) throws IOException, FileNotFoundException
    {
        File f = new File("mostCommonWords.txt");
        RandomWordGenerator wordGen = new RandomWordGenerator(f);
        System.out.println(wordGen.read());
    }
}