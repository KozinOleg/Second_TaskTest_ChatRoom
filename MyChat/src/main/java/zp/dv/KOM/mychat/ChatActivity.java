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

public class ChatActivity extends Activity {
    private final String MESSAGE = "Message";
    private static ArrayList<Message> messages = new ArrayList<Message>();
    private ChatAdapter chatAdapter;
    private ListView listViewChat;
    private EditText messageText;
    private Button buttonSend;

    private final static String PATTERN_DATE = "dd.MM.yy hh:mm:ss";
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN_DATE);

    public void setButtonSend(Button buttonSend) {
        this.buttonSend = buttonSend;
        buttonSend.setEnabled(false);
    }

    public void setListViewChat(ListView listViewChat) {
        this.listViewChat = listViewChat;
    }

    public EditText getMessageText() {
        return messageText;
    }

    public void setMessageText(EditText messageText) {
        this.messageText = messageText;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(MESSAGE, messages);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        messages = (ArrayList<Message>) savedInstanceState.getSerializable(MESSAGE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        setMessageText((EditText) findViewById(R.id.editTextMessage));
        setButtonSend((Button) findViewById(R.id.buttonSendMessage));
        setListViewChat((ListView) findViewById(R.id.listViewChat));

        chatAdapter = new ChatAdapter(this, messages);
        listViewChat.setAdapter(chatAdapter);

        setData();
        setButtonState();
    }

    public void onSend(View v) {
        addMessage();
        setData();
    }

    private void setData() {
        chatAdapter.setMessages(messages);
        chatAdapter.notifyDataSetChanged();
        messageText.setText("");
    }

    private void addMessage() {
        // Message User
        messages.add(new Message(LoginActivity.loginName,
                getMessageText().getText().toString(),
                simpleDateFormat.format(new Date())));
        // Message Bot
        messages.add(Bot.genBotMessage());
    }

    private void setButtonState() {
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
}
