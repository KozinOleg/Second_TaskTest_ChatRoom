package zp.dv.KOM.mychat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater linflater;
    private ArrayList<Message> messages;

//    public ArrayList<Message> getMessages() {
//        return messages;
//    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

//    public LayoutInflater getLinflater() {
//        return linflater;
//    }
//
//    public void setLinflater(LayoutInflater linflater) {
//        this.linflater = linflater;
//    }
//
//    public Context getContext() {
//        return context;
//    }
//
//    public void setContext(Context context) {
//        this.context = context;
//    }

    public ChatAdapter(Context context, ArrayList<Message> messages) {
        this.context = context;
        this.linflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.messages = messages;
    }

    @Override
    public int getCount() {
        return messages.size();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getItemId(int position) {
        return position;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Message msg = getMessage(position);

        if (view == null) {
            view = linflater.inflate(R.layout.activity_item, parent, false);
        }
        try {
            ((TextView) view.findViewById(R.id.topText)).setText(msg.getName());
            ((TextView) view.findViewById(R.id.botText)).setText(msg.getText());
            ((TextView) view.findViewById(R.id.rightText)).setText(msg.getDate());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return view;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Message getMessage(int position) {
        return (Message) getItem(position);  //To change body of created methods use File | Settings | File Templates.
    }
}
