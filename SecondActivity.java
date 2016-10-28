package com.jsonapp;




import java.util.ArrayList;

import com.database.Database;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;




public class SecondActivity extends Activity 
{

		
	Database db;

	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{



		super.onCreate(savedInstanceState);


		

		setContentView(R.layout.activity_second);
		
	}




@Override
protected void onResume() 
{
	// TODO Auto-generated method stub
	super.onResume();   
	db=new Database(SecondActivity.this);

	
	Cursor cursor=db.getContacts();
	ListView listView = (ListView) findViewById(R.id.listview);
	listView.setAdapter(new SimpleCursorAdapter(SecondActivity.this, R.layout.list, cursor,new String[] {"CONTACT_ID","FIRST_NAME","LAST_NAME","AGE","ADDRESS","CITY","STATE","POSTALCODE","NUMBER"}, new int[] {R.id.Contact,R.id.Name,R.id.Name1,R.id.Age,R.id.Address1,R.id.Address2,R.id.Address3,R.id.Address4,R.id.Number},0));
	

}

}



