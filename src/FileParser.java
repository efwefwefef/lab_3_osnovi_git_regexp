
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
    static void GetAllPhrases()
    {
        String text = "собака. негативынй,некрасивый, дом. Зоопарк, бы";

        String neg_words_reg_expr = "([ .,]смерть)|([ .,]боль)|([ .,]тоска)|([ .,]горе)|([ .,](не)[a-яА-я]+)"; //слова с негативным окрасом
        String word_reg_expr = "[ .,][a-яА-я]{3,}"; //все слова, кроме 1 и слов длиной меньшей 3
        Pattern neg_pattern = Pattern.compile(neg_words_reg_expr);
        Pattern all_words = Pattern.compile(word_reg_expr);

        Matcher m = neg_pattern.matcher(text);
        while (m.find()) {
            String tmp = m.group();
            System.out.println(tmp);
        }
    }
}
