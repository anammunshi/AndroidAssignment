

package com.jsonapp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.database.Database;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;


public class MainActivity extends Activity 
{
	Button ok;
	String myjsonstring;
	Database db;
	String mContact_id,mFname,mLname,mAge,mSAddr,mCity,mState,mPostal,mType,mNum;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

       db=new Database(MainActivity.this);

        ok = (Button) findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() 
        {

                        

                        @Override

                        public void onClick(View v) 
                        {
                        	
                        	StringBuffer sb = new StringBuffer();
                    		BufferedReader br = null;
                    		try
                    		{
                    			br = new BufferedReader(new InputStreamReader(getAssets().open(
                    					"hollywood_contact.json")));
                    			String temp;
                    			while ((temp = br.readLine()) != null)
                    				sb.append(temp);
                    		} 
                    		catch (IOException e)
                    		{
                    			e.printStackTrace();
                    		} 
                    		finally 
                    		{
                    			try 
                    			{
                    				br.close(); 
                    			} 
                    			catch (IOException e) 
                    			{
                    				e.printStackTrace();
                    			}
                    		}

                    		myjsonstring = sb.toString();

                
                    		try 
                    		{
                    			
                    			JSONObject jsonObjMain = new JSONObject(myjsonstring);
                    			JSONArray jsonArray1 = jsonObjMain.getJSONArray("contact");

                    			for (int i = 0; i < jsonArray1.length(); i++) 
                    			{

                    				
                    				JSONObject jsonObj = jsonArray1.getJSONObject(i);

                    				
                    				mContact_id=jsonObj.getString("contactId");
                    				mFname = jsonObj.getString("firstName");
                    				mLname = jsonObj.getString("lastName");
                    				mAge = jsonObj.getString("age");

                    				JSONObject jsonObj1 = jsonObj.getJSONObject("address");




                    				mSAddr = jsonObj1.getString("streetAddress");
                    				mCity = jsonObj1.getString("city");
                    				mState = jsonObj1.getString("state");
                    				mPostal = jsonObj1.getString("postalCode");

                    				JSONObject jsonObj2 = jsonObj.getJSONObject("phoneNumber");
                    				mType = jsonObj2.getString("type");
                    				mNum = jsonObj2.getString("number");

                    				
                 				    db.addContacts(mContact_id,mFname, mLname, mAge, mSAddr,mCity,mState,mPostal,mType,mNum);
                    				




                    			}




                                Intent homepage = new Intent(MainActivity.this, SecondActivity.class);

                                startActivity(homepage);
                    		}
                    		catch (JSONException e) {
                    			// TODO Auto-generated catch block
                    			e.printStackTrace();
                    		}
                        }

                });

	}    

	
}





