
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import  java.util.regex.Pattern;


/**
 Вариант №4, 10, 16, 22, 28
 В программу подается текст из файла, в котором находится некий текст, либо набор текстов.
 Необходимо определить “настроение” текста. Это значит, что если в тексте будет употреблено много
 негативных слов, то текст будет иметь отрицательное значение “настроения”. Должно быть вычислено
 точно число “настроения”, для возможности сравнения различных текстов.
 */

public class FileParser {
    static String[] GeTextStats()
    {
        String text = "В художественном стиле текстов могут встречаться как все из перечисленных элементов, так и только некоторые из них. Каждый выполняет определенную функцию, но все служат одной цели: насытить текст и наполнить его красками, чтобы максимально вовлечь читателя в передаваемую атмосферу.";

        int all_words = 0;
        int neg_words = 0;
        String[] stats = new String[3];

        String neg_words_reg_expr = "([ .,]смерть)|([ .,]боль)|([ .,]тоска)|([ .,]горе)|([ .,](не)[a-яА-я]+)"; //слова с негативным окрасом
        String word_reg_expr = "[ .,][a-яА-я]{3,}"; //все слова, кроме 1 и слов длиной меньшей 3
        Pattern neg_pattern = Pattern.compile(neg_words_reg_expr);
        Pattern all_words_pattern = Pattern.compile(word_reg_expr);

        Matcher m1 = all_words_pattern.matcher(text);
        Matcher m2 = neg_pattern.matcher(text);

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

        stats[0] = "all words: " + all_words;
        stats[1] = "neg words: " + neg_words;
        stats[2] = "negotivnost: " + (neg_words / all_words) * 100 + "%";
        return stats;
    }
}
