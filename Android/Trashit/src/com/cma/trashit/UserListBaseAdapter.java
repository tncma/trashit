package com.cma.trashit;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserListBaseAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;

    private static ArrayList<User> userList;
    private final Context context;

    public UserListBaseAdapter(Context context, ArrayList<User> userList) {
            this.userList = userList;
            this.context = context;
            mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
            return userList.size();
    }

    @Override
    public Object getItem(int position) {
            return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
            return position;
    }

    public void removeItem(int position) {
            userList.remove(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                    convertView = mInflater.inflate(R.layout.viewpager_item, null);
                    holder = new ViewHolder();
                    holder.txtName = (TextView) convertView.findViewById(R.id.user);
                    holder.txtRank = (TextView) convertView.findViewById(R.id.rank);
                    holder.txtbounty = (TextView) convertView.findViewById(R.id.bounty);
                    
                    holder.avatar = (ImageView) convertView.findViewById(R.id.list_image);
                    convertView.setTag(holder);
            } else {
                    holder = (ViewHolder) convertView.getTag();
            }
            holder.txtName.setText(userList.get(position).getUser());
            holder.txtRank.setText(userList.get(position).getRank() + "");
            holder.txtbounty.setText(userList.get(position).getBounty() + "");
            
            holder.avatar.setImageResource(userList.get(position).getImageid());
            
            return convertView;
    }


    static class ViewHolder {
            TextView txtName;
            TextView txtRank;
            ImageView avatar;
            TextView txtbounty;
    }

}
