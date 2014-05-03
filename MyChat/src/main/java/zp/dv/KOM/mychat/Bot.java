package zp.dv.KOM.mychat;

import java.util.Random;

public class Bot {
    public static String BotName = "Bot";

    public static Message genBotMessage() {
        String[] botSentence = {"Да", "Нет", "Возможно", "Я не уверен", "Так точно", "Ты тоже?",
                "Возможно ты прав!", "Я здесь"};

        Message tempMsg = new Message(BotName, botSentence[new Random().nextInt(botSentence.length)], "Test");

        return tempMsg;
    }
}
