package zp.dv.KOM.mychat;

import android.content.Context;
import android.graphics.Color;
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

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ChatAdapter(Context context, ArrayList<Message> messages) {
        this.context = context;
        this.linflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.messages = messages;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =  new ViewHolder();
        if (convertView == null) {
            convertView = linflater.inflate(R.layout.activity_item, null);
            holder.lUserName = (TextView) convertView.findViewById(R.id.topText);
            holder.lMessage = (TextView) convertView.findViewById(R.id.botText);
            holder.lDate = (TextView) convertView.findViewById(R.id.rightText);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.lUserName.setText(messages.get(position).getName());
        holder.lMessage.setText(messages.get(position).getText());
        holder.lDate.setText(String.valueOf(messages.get(position).getDate().toString()));

        if (holder.lUserName.getText().toString().equals(Bot.getBotName()))
            holder.lUserName.setTextColor(Color.BLUE);
        else holder.lUserName.setTextColor(Color.RED);
        convertView.setTag(holder);

        return convertView;
    }

    static class ViewHolder {
        TextView lUserName;
        TextView lMessage;
        TextView lDate;
    }
}