package com.androidcodehub.bmi;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;


public class settings extends Fragment {
	
	
	
	ListView lv1;
	
	CheckBox cb1;
	
	ListViewAdapter madapter;
	
	String arr[]={"Share this app","Follow us on Facebook","Follow us on Twitter"};
	
	   public static final String MyPREFERENCES = "custom" ;

	   SharedPreferences sharedpreferences;
	
	
	   
	   
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	
	
	{
			
		
        View rootView = inflater.inflate(R.layout.settings, container, false);	
	 
        lv1=(ListView)rootView.findViewById(R.id.listView1);
        
      cb1=(CheckBox)rootView.findViewById(R.id.checkBox1);  
        
        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);   
        
  
    
        
        if(sharedpreferences.contains("check")){
        	
        	
        	
        	cb1.setChecked(true);
        	
        	
        	
        }
        
        
        
        
        
        
        madapter=new ListViewAdapter();
            
      
        lv1.setAdapter(madapter);
        
       
        
        cb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				
			if(isChecked==true){
				
         
		Editor e=sharedpreferences.edit();		
				
	     e.putString("check","check");
		
		     e.commit();
		
				
			}
			
			else
			
			{
				
				
		sharedpreferences.edit().clear().commit();		
				
				
				
			}	
			
			
			}
		});
        
        
        
        lv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
	
				
	if(position==0){
		
		
		shareTextUrl();
		
		
	}			
				
				
		
		if(position==1){
			
			
			Intent i=new Intent(getActivity(),Webclass.class);
			
			Bundle b=new Bundle();
			
			b.putString("face","facebook");
			
			i.putExtras(b);
			
			startActivity(i);
			
		}		
				
		if(position==2){
			
			
			Intent i=new Intent(getActivity(),Webclass.class);
			
           Bundle b=new Bundle();
			
			b.putString("face","twitter");
			
			i.putExtras(b);	
			
	    		startActivity(i);	
			
			
			
		}		
		
			}
	    
        });
        
        

		
		return rootView;	
	

	}	
	

class ListViewAdapter extends BaseAdapter {

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arr.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
	
		
	LayoutInflater infla=getActivity().getLayoutInflater();	
		
		
	View v=infla.inflate(R.layout.settinglistitem, null);	
		
	TextView tv1=(TextView)v.findViewById(R.id.textView1);	
	
	tv1.setText(arr[position]);
	
	
		return v;
	
	
	
	}
		
}	

private void shareTextUrl() {


	Intent share = new Intent(Intent.ACTION_SEND);
    share.setType("text/plain");
    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
 
    // Add data to the intent, the receiving app will decide
    // what to do with it.
    share.putExtra(Intent.EXTRA_SUBJECT, "");
    share.putExtra(Intent.EXTRA_TEXT, "");
 
    startActivity(Intent.createChooser(share, "Share App"));



}

	
}
