package zp.dv.KOM.mychat;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
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
    private static ArrayList<Message> messages = new ArrayList<Message>();
    private ChatAdapter chatAdapter;
    private ListView listViewChat;
    private EditText messageText;
    private Button buttonSend;

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
        outState.putSerializable("Message", messages);
//        outState.putParcelable("Message", (Parcelable) messages);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        messages = (ArrayList<Message>) savedInstanceState.getSerializable("Message");
//        messages = (ArrayList<Message>) savedInstanceState.getParcelable("Message");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        setMessageText((EditText) findViewById(R.id.editTextMessage));
        setButtonSend((Button) findViewById(R.id.buttonSendMessage));
        setListViewChat((ListView) findViewById(R.id.listViewChat));

        chatAdapter = new ChatAdapter(this, messages);

        setData();
        setButtonState();
    }

    /**
     * dd-MM-yy hh:mm:ss
     */
    public void onSend(View v) {
        addMessage();
        setData();
    }

    private void setData() {
        chatAdapter.setMessages(messages);
        listViewChat.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();
        messageText.setText("");
    }

    private void addMessage() {
        messages.add(new Message(LoginActivity.loginName,
                getMessageText().getText().toString(),
                new SimpleDateFormat("dd.MM.yy hh:mm:ss").format(new Date())));
        // Message Bot
        messages.add(new Message(Bot.BotName,
                Bot.genBotMessage().getText(),
                new SimpleDateFormat("dd.MM.yy hh:mm:ss").format(new Date())));
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
