package zp.dv.KOM.mychat;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatRoom extends Activity {
    private ArrayList<Message> messages = new ArrayList<Message>();
    private EditText messageText;
    private Button buttonSend;

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public EditText getMessageText() {
        return messageText;
    }

    public void setMessageText(EditText messageText) {
        this.messageText = messageText;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("Message", messages);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        messages = (ArrayList<Message>) savedInstanceState.getSerializable("Message");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.activity_chat);

        this.setMessageText((EditText) findViewById(R.id.editTextMessage));

        buttonSend = (Button) findViewById(R.id.buttonSendMessage);
        buttonSend.setEnabled(false);
        messageText = (EditText) findViewById(R.id.editTextMessage);

        messageText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) buttonSend.setEnabled(true);
                else buttonSend.setEnabled(false);
            }
        });
    }

    /**
     * dd-MM-yy hh:mm:ss
     */
    @SuppressWarnings("ConstantConditions")
    public void onSend(View v) {
        this.setMessageText((EditText) findViewById(R.id.editTextMessage));
        // Message User
        messages.add(new Message(LoginActivity.loginName,
                getMessageText().getText().toString(),
                new SimpleDateFormat("dd.MM.yy hh:mm:ss").format(new Date())));
        // Message Bot
        messages.add(new Message(Bot.BotName,
                Bot.genBotMessage().getText(),
                new SimpleDateFormat("dd.MM.yy hh:mm:ss").format(new Date())));

        ChatAdapter chatAdapter = new ChatAdapter(this, messages);
        ListView lvChat = (ListView) findViewById(R.id.listViewChat);
        lvChat.setAdapter(chatAdapter);

        messageText.setText("");
    }
}
