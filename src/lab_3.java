
public class lab_3 {

    public static void main(String[] args)
    {
        try {
            String[] mm = FileParser.GeTextStats("text.txt");

            for (String i : mm)
                System.out.println(i);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
