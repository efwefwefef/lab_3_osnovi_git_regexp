
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
        String str = "we11z11iuhf10-88fg красивый eefugeu12-78ggc смешной bcbcb34-427gf";
        Pattern pp = Pattern.compile("[ ,.][а-яА-я]{1,}((ой)|(ый))[ ,.]");
        Matcher m = pp.matcher(str);
        while (m.find()) {
            String tmp = m.group();
            System.out.println(tmp);
        }
    }
}
