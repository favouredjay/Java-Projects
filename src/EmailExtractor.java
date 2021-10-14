import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {
    Pattern pattern = Pattern.compile("[a-z0-9_.-]+[@][a-zA-Z]+[.-][a-z]+");
    public void extractEmail(String words){
        Matcher matcher = pattern.matcher(words);

        while (matcher.find())
            System.out.println(matcher.group());

        }





    public static void main(String[] args) {
        EmailExtractor email = new EmailExtractor();
        email.extractEmail("fghgjk,judom@ymail.com,gndvbdhsdhvc csv,chibuzor_760@email.com, 3526_yyy@gmail.com, olammakalu007@gmail.com,dhgsxzfgszdgcxzdzfg");
    }
}
