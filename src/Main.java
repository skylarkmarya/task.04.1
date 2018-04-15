import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    private String s;
    private StringBuilder sb = new StringBuilder();
    private void readFile() {
        File file = new File("D:\\My tasks\\JAVA\\MASHA JAVA\\S0401\\src\\test.txt");
        try {
            InputStream in = new FileInputStream(file);
            int data = in.read();
            while (data != -1) {
                sb.append((char) data);
                data = in.read();
            }
            s = new String(sb);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int count = 0;
        Main r = new Main();
        r.readFile();
        String[] words = r.s.split("\\r\\n");
        String text = "";
        for (String w: words){
        Pattern p = Pattern.compile("abstract|continue|for|new|switch|" +
                "assert|default|goto*|package|synchronized|" +
                "boolean|do|if|private|this|" +
                "break|double|implements|protected|throw|" +
                "byte|else|import|public|throws|" +
                "case|enum|instanceof|return|transient|" +
                "catch|extends|int|short|try|" +
                "char|final|interface|static|void|" +
                "class|finally|long|strictfp|volatile|" +
                "const*|float|native|super|while");
        Matcher m = p.matcher(w);
        if(m.matches()){
            text = text + " " + w;
            count ++;
        }
        }
        text = text + " " + count;
        try(FileOutputStream fos = new FileOutputStream("D:\\My tasks\\JAVA\\MASHA JAVA\\S0401\\src\\outputData.txt"))
        {
            // перевод строки в байты
            byte[] buffer = text.getBytes();

            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(count);
        System.out.println(text);
    }
}