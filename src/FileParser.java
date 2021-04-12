
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import  java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.*;


/**
 Вариант №4, 10, 16, 22, 28
 В программу подается текст из файла, в котором находится некий текст, либо набор текстов.
 Необходимо определить “настроение” текста. Это значит, что если в тексте будет употреблено много
 негативных слов, то текст будет иметь отрицательное значение “настроения”. Должно быть вычислено
 точно число “настроения”, для возможности сравнения различных текстов.
 */

public class FileParser {
    static String[] GeTextStats(String file_name) throws Exception
    {
        InputStream fi = null;
        String[] stats = new String[]{"", "", ""};
        try {
            String cur = null;
            int all_words = 0;
            int neg_words = 0;

            String neg_words_reg_expr = "([ .,]смерть)|([ .,]боль)|([ .,]тоска)|([ .,]горе)|([ .,](не)[a-яА-я]+)"; //слова с негативным окрасом
            String word_reg_expr = "[ .,][a-яА-я]{3,}"; //все слова, кроме 1 и слов длиной меньшей 3

            Pattern neg_pattern = Pattern.compile(neg_words_reg_expr);
            Pattern all_words_pattern = Pattern.compile(word_reg_expr);
            /*чтение файла*/
            fi = new FileInputStream(file_name);
            BufferedReader br = new BufferedReader(new InputStreamReader(fi));

            while ((cur = br.readLine()) != null) {

                Matcher m1 = all_words_pattern.matcher(cur);
                Matcher m2 = neg_pattern.matcher(cur);

                while (m1.find()) {
                    String tmp = m1.group();
                    //System.out.println(tmp);
                    all_words++;
                }
                while (m2.find()) {
                    String tmp = m2.group();
                    //System.out.println(tmp);
                    neg_words++;
                }
            }
            stats[0] = "all words: " + all_words;
            stats[1] = "neg words: " + neg_words;
            stats[2] = "неготивность текста: " + ((float) neg_words / all_words) * 100 + "%";
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            try {fi.close();}catch(Exception e) {}
        }
        return stats;
    }
}
