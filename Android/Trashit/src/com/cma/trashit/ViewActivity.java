package com.cma.trashit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewActivity extends Activity {
	

    // Declare Variables
    ViewPager viewPager;
    ViewPager viewPager2;
    PagerAdapter adapter;
    PagerAdapter adapter2;
    int[] rank;
    String[] user;
    int[] bounty;
    int[] flag;
    Context context;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from viewpager_main.xml
        setContentView(R.layout.view_pager_person);
        context = this;
        // Generate sample data
        rank = new int[] {1, 5, 7, 4, 45, 345, 47, 48, 39, 410 };
 
        user = new String[] { "Sesha", "Ramya", "Charu",
                "Thiru", "Manoj", "Andal", "Mangai", "Ramswamy",
                "Aravindh", "Sulekha" };
 
        bounty = new int[] { 350, 125,
                120, 330, 220, 225,
                300, 150, 160, 135 };               
 
        flag = new int[] { R.drawable.a, R.drawable.b,
                R.drawable.c, R.drawable.d,
                R.drawable.e, R.drawable.f, R.drawable.g,
                R.drawable.h, R.drawable.i, R.drawable.j };
        ArrayList<User> userList = new ArrayList<User>();
        for (int i=0; i<flag.length;i++){
        	User u = new User(rank[i], user[i], bounty[i], flag[i]);
        	userList.add(u);
        }
        
        System.out.println(userList);
        ListView userListView = (ListView) findViewById(R.id.userlist);
        UserListBaseAdapter userListBaseAdapter = new UserListBaseAdapter(context, userList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list, R.id.label, user);
            userListView.setAdapter(userListBaseAdapter);            
        
       /* ListView userListView = (ListView) findViewById(R.id.userList);
        userListView.setAdapter(new UserListBaseAdapter(context, userList));*/
 
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view, menu);
		return true;
	}

}
