package zp.dv.KOM.mychat;

import java.util.Date;
import java.util.Random;

public class Bot {
    private static String botName = "Bot";
    private static String[] botSentence = {"Да", "Нет", "Возможно", "Я не уверен", "Так точно", "Ты тоже?",
            "Возможно ты прав!", "Я здесь"};
    private static Random random = new Random();

    public static String getBotName() {
        return botName;
    }

    public static Message genBotMessage() {
        return new Message(botName
                , botSentence[random.nextInt(botSentence.length)]
                , ChatActivity.simpleDateFormat.format(new Date()));
    }
}
