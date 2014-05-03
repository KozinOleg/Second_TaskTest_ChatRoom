package zp.dv.KOM.mychat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {
    private Context ctx;
    private LayoutInflater linflater;
    private ArrayList<Message> messages;

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public LayoutInflater getLinflater() {
        return linflater;
    }

    public void setLinflater(LayoutInflater linflater) {
        this.linflater = linflater;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public ChatAdapter(Context ctx, ArrayList<Message> messages) {
        this.ctx = ctx;
        this.linflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        if (view == null) {
            view = linflater.inflate(R.layout.activity_item, parent, false);
        }

        Message msg = getMessage(position);

        ((TextView) view.findViewById(R.id.topText)).setText(msg.getName());
        ((TextView) view.findViewById(R.id.botText)).setText(msg.getText());
        ((TextView) view.findViewById(R.id.rightText)).setText(msg.getDate());

        return view;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Message getMessage(int position) {
        return (Message) getItem(position);  //To change body of created methods use File | Settings | File Templates.
    }
}
