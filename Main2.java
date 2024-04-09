import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main2 {
    public static void main(String[]args) throws  Exception {
        Scanner scanner = new Scanner(System.in);
        String cal =scanner.nextLine();
        char action;
        String[] data;
        if(cal.contains("+")) {
          data=cal.split("\\+");
          action='+';
        }else if (cal.contains("-")){
            data = cal.split("-");
            action = '-';
        }else if (cal.contains("*")){
            data=cal.split("\\*");
            action= '*';
        }else if (cal.contains("/")){
            data=cal.split("/");
            action='/';
        }else {
            throw new Exception("Некоректный знак действия");
        }
        if (action =='*'|| action == '/'){
            if(data[1].contains("\""))  throw new Exception("Строчку можно делить или умножать на число");
        }
        for (int i = 0; i < data.length; i++)
        {
            data[i] = data[i].replace("\"", "");
        }
        if (action == '+')
        {
            printInQuotes(data[0] + data[1]);
        }else if (action == '*') {
            int calc = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < calc; i++) {
                result += data[0];
            }
            printInQuotes (result);
        }else if(action == '-') {
            int index = (data[0].indexOf(data[1]));
            if (index == -1) {
                printInQuotes(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index+data[1].length());
                printInQuotes(result);
            }
        }else {
            int newLen=data[0].length()/Integer.parseInt(data[1]);
            String result = data[0].substring(0,newLen);
            printInQuotes(result);
        }
        }
        static void printInQuotes (String text ) {
            System.out.println("\"" + text + "\"");
    }
}
