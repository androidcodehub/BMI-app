package com.androidcodehub.bmi;





import java.util.Arrays;



import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class dashboard  extends Fragment {
	
	
	Spinner sp1,sp2;
	
	
	String arr[]={"ft+in","cm"};
	
	String arr1[]={"kg","lb","st+lb"};
	
	SpinnerAdapter madapter;
	

	Spinneradapter1 madapter1;
	
	ImageView iv1,iv2;
	
	EditText age;
	
	
	EditText et1,et2,et11,et12;
	
	//int sex=0;
	
	String height="feet";
	
	String weight ="kg";
	
	
	int age1=0;
	
	
	
	double bmi;
	
	
	TextView bmitext;
	
	
	ListView lv1;
	
	
	String arr3[]={"Very Severely Underweight < 16.0","Severely Underweight 16.0 - 16.9 ","Underweight 17.0 - 18.4 ","Normal 18.5 - 24.9","Overweight 25.0 - 29.9"," Obese 30.0 - 39.9","Obese+  >=40.0"};
	
	
	ListViewAdapter madapter2;
	
	RelativeLayout rl1;
	
	
	   public static final String MyPREFERENCES = "custom" ;

	   SharedPreferences sharedpreferences;
	
	
	String check="";
	
	int position1=0;
	
	int position=0;
	
	
	String sex="0";
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	
	
	{
			
		
        View rootView = inflater.inflate(R.layout.dashboard, container, false);	
		
		
         sp1=(Spinner)rootView.findViewById(R.id.spinner1);

        
         iv1=(ImageView)rootView.findViewById(R.id.imageView1);
          
         iv2=(ImageView)rootView.findViewById(R.id.imageView2);

          et1=(EditText)rootView.findViewById(R.id.editText1);
       
          et2=(EditText)rootView.findViewById(R.id.editText2);
          
          et11=(EditText)rootView.findViewById(R.id.editText11);
     
          
          et12=(EditText)rootView.findViewById(R.id.editText12);
          
          age=(EditText)rootView.findViewById(R.id.editText111);
          
             sp2=(Spinner)rootView.findViewById(R.id.spinner2); 
             
             
          bmitext=(TextView)rootView.findViewById(R.id.textView13) ;  
             
             
         lv1=(ListView)rootView.findViewById(R.id.listView1); 
          
          rl1=(RelativeLayout)rootView.findViewById(R.id.relativeLayout1);


          sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);   
          

   
         if(sharedpreferences.contains("check")){
        	 
     	 
           check="true"; 
           
        	 
        } 
          
  
       if(sharedpreferences.contains("height")){
    	   
    	   
    height=sharedpreferences.getString("height","feet");	   
    
    weight=sharedpreferences.getString("weight","kg");
    
 String   age1=sharedpreferences.getString("age","");

 
 sex=sharedpreferences.getString("sex","0");
 
 
if(sex.matches("0")){
	
	
	iv2.setImageResource(R.drawable.male1);	

	iv1.setImageResource(R.drawable.female);	
	
	
	
}


else{
	
	
	
	
	iv2.setImageResource(R.drawable.male);	

	iv1.setImageResource(R.drawable.female1);	
	
		
	
	
}




    
  position=  Arrays.asList(arr).indexOf(height);
    
    position1=Arrays.asList(arr1).indexOf(weight);

 
   
    
    age.setText(age1);
    
    
    
    String hef=sharedpreferences.getString("hef","");
    
    String hei=sharedpreferences.getString("hei","");
    
    
    String wei=sharedpreferences.getString("wei","");
    
    String wei1=sharedpreferences.getString("wei1","");
    
    
    if(height.matches("feet")){
    	
    	
    et1.setText(hef);	
    	
    et2.setText(hei);	
    	
    	
    }
    
    else{
    	
    et1.setText(hei);	
    	
    	
    	
    } 
    	   
   
    if(weight.matches("st")){
    	
    	
    et11.setText(wei);	
    	
    et12.setText(wei1);	
    	
    	
    }
    
    else{
    	
    et11.setText(wei);	
    	
    	
    	
    }
    
  	   
    	   
       }  
         

	madapter=new SpinnerAdapter();	
    
	sp1.setAdapter(madapter);
	
	sp1.setSelection(position);
	

      madapter1=new Spinneradapter1();	

     sp2.setAdapter(madapter1);
	
  
     sp2.setSelection(position1);
     

    if(sex.matches("0")){
    	
    	
    //	 iv2.setImageResource(R.drawable.male1);	
    	
    	iv2.setImageResource(R.drawable.male1);	

    	iv1.setImageResource(R.drawable.female);
    	
    } 
    
    else{
    	
    	iv2.setImageResource(R.drawable.male);	

    	iv1.setImageResource(R.drawable.female1);
    	
    	
    	
    }
    
    
    
     
     
     
     
  //   iv2.setImageResource(R.drawable.male1);
     
 
   
   madapter2=new ListViewAdapter();
   
   
   lv1.setAdapter(madapter2);
   
   InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
   imm.hideSoftInputFromWindow(age.getWindowToken(), 0);


iv1.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
//		
	iv2.setImageResource(R.drawable.male);	
//		
	iv1.setImageResource(R.drawable.female1);	
	
	
//	sex=1;

	Editor e=sharedpreferences.edit();
	
	e.putString("sex","1");
	
	e.commit();

		
	}
});

iv2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		
	iv2.setImageResource(R.drawable.male1);	

	iv1.setImageResource(R.drawable.female);
	
	
	//sex=0;
	
	
	Editor e=sharedpreferences.edit();
	
	e.putString("sex","0");
	
	e.commit();
	
	
		
	}
});


age.addTextChangedListener(new TextWatcher() {
	
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
		
if(age.getText().toString().length()>1)

{		
	
	
	
	rl1.setBackgroundColor(Color.GRAY);
	
	Editor e=sharedpreferences.edit();
	
	
	e.putString("age",age.getText().toString());
	e.commit();
	
	
	
		
}	
		
else{
	
	rl1.setBackgroundColor(Color.WHITE);
	
	
}
		
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}
});




et1.addTextChangedListener(new TextWatcher() {
	
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
		
	double bmi1=calculation();
	

	if(Double.isNaN(bmi1)){
		
		
	bmi1=0.0;	
		
		
	}
	
	
	
	
	bmitext.setText(""+bmi1);
	
	
	madapter2.notifyDataSetChanged();
	
		
//	rl1.setBackgroundColor(Color.GRAY);
	
	
	
		
		
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}
});



et2.addTextChangedListener(new TextWatcher() {
	
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
		
	double bmi1=calculation();
	
	
	if(Double.isNaN(bmi1)){
		
		
	bmi1=0.0;	
		
		
	}
	
	
	
	
	bmitext.setText(""+bmi1);
		
	madapter2.notifyDataSetChanged();
		
		
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}
});


et11.addTextChangedListener(new TextWatcher() {
	
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
	
		
	double bmi1=calculation();
	
	
	if(Double.isNaN(bmi1)){
		
		
	bmi1=0.0;	
		
		
	}
	
	
	
	bmitext.setText(""+bmi1);
	madapter2.notifyDataSetChanged();	
		
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}
});



et12.addTextChangedListener(new TextWatcher() {
	
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
	
		
	double bmi1=calculation();
	
	
	if(Double.isNaN(bmi1)){
		
		
	bmi1=0.0;	
		
		
	}
	

	bmitext.setText(""+bmi1);

	madapter2.notifyDataSetChanged();	
		
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}
});



sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
	
		
		if(position==1){
			
	
     et2.setVisibility(View.GONE);	
     
     
     height="cm";
     
     
		
	double bmi1=calculation();
	
	
	if(Double.isNaN(bmi1)){
		
		
	bmi1=0.0;	
		
		
	}
	
	
	bmitext.setText(""+bmi1);
	
	madapter2.notifyDataSetChanged();
	
     
     
 	}
		
	
		if(position==0)
	
		{
			
		et2.setVisibility(View.VISIBLE);		

		
	height="feet";
	
	
double bmi1=calculation();


if(Double.isNaN(bmi1)){
	
	
bmi1=0.0;	
	
	
}


bmitext.setText(""+bmi1);

madapter2.notifyDataSetChanged();	
	
		
		}
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
	
	
		height="feet";
		
		
	double bmi1=calculation();
	
	if(Double.isNaN(bmi1)){
		
		
	bmi1=0.0;	
		
		
	}
		
	
	
	
	
	bmitext.setText(""+bmi1);
	
	madapter2.notifyDataSetChanged();
	
		
	}
});




sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
	
		
		if(position==2){
			
	
     et12.setVisibility(View.VISIBLE);
     
     weight="st";
     
		
	double bmi1=calculation();
	
	
	if(Double.isNaN(bmi1)){
		
		
	bmi1=0.0;	
		
		
	}
		
	
	
	
	bmitext.setText(""+bmi1);
	
	madapter2.notifyDataSetChanged(); 
     
    	
		}
		
	
		if(position==0)
	
		{
			
		et12.setVisibility(View.GONE);	        
		
		
		weight="kg";
		
		
	double bmi1=calculation();
	
	if(Double.isNaN(bmi1)){
		
		
	bmi1=0.0;	
		
		
	}
		
	
	
	
	
	bmitext.setText(""+bmi1);	
	
	madapter2.notifyDataSetChanged();	
	
	
		}
		

		if(position==1)
	
		{
			
		et12.setVisibility(View.GONE);	
		
		
		weight="lb";
		
		
	double bmi1=calculation();
	
	
	if(Double.isNaN(bmi1)){
		
		
	bmi1=0.0;	
		
		
	}
	

	bmitext.setText(""+bmi1);
	
	madapter2.notifyDataSetChanged();	
		
		
			
			
		}	
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
	
		
		weight="kg";
		
	double bmi1=calculation();
	
	
	if(Double.isNaN(bmi1)){
		
		
	bmi1=0.0;	
		
		
	}
	
	
	bmitext.setText(""+bmi1);
	
	madapter2.notifyDataSetChanged();
		
		
	}
});

	
		return rootView;	
	

	}

class SpinnerAdapter extends BaseAdapter {

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
		
	
	View v =infla.inflate(R.layout.spinneritem,null);
	
	
	TextView tv1=(TextView)v.findViewById(R.id.textView1);
		
		
	tv1.setText(arr[position]);
	
	
		return v;
	}
	
	
	
}	

public class Spinneradapter1 extends BaseAdapter{

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arr1.length;
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
	public View getView(int position, View convertView, ViewGroup parent) 
	
	{
		// TODO Auto-generated method stub
	
		
		LayoutInflater infla=getActivity().getLayoutInflater();
		
		
		View v =infla.inflate(R.layout.spinneritem,null);
		
		
		TextView tv1=(TextView)v.findViewById(R.id.textView1);
		
		
		tv1.setText(arr1[position]);
		
		
		
		return v;
	}
	
	
}


  double calculation(){
	
	
    if(height.matches("cm")&&weight.matches("kg")){
	
	
    	
    	  System.out.println("jjjjjjjjjjjj"+weight);	
    	
	String hei=et1.getText().toString();
     
	String wei=et11.getText().toString();
	
	
	
	
	
	
if(check.matches("true")){	
	
	
	Editor e=sharedpreferences.edit();
	
	
	
	
	
	e.putString("height","cm");
	
	e.putString("hei",et1.getText().toString());
	
	e.putString("weight","kg");

	e.putString("wei",et11.getText().toString());
	
	e.commit();
	
	
}	
	
      
	if(hei.matches("")){
		
		
		hei="0";
		
		
	}

	if(wei.matches("")){
		
		
		wei="0";
		
		
	}
	
	
      double height1 = Double.parseDouble(hei)/100;	

        double weight=Double.parseDouble(wei);	

	
          System.out.println(""+height1*height1);    
 
  
        double heigh=height1*height1;
 

           bmi=weight/heigh;

           System.out.println("mmmmmmmmmmmmmmmmmmmmmmmm"+bmi);

                System.out.println("wwwwwwwwww"+weight);
 
	
}	
	

if(height.matches("cm")&&weight.matches("lb")){

	
	
     System.out.println("jjjjjjjjjjjj"+weight);	
	
	

String hei=et1.getText().toString();

String wei=et11.getText().toString();

if(check.matches("true")){	

Editor e=sharedpreferences.edit();


e.putString("height","cm");

e.putString("hei",et1.getText().toString());

e.putString("weight","lb");

e.putString("wei",et11.getText().toString());

e.commit();


}


if(hei.matches("")){
	
	
	hei="0";
	
	
}

if(wei.matches("")){
	
	
	wei="0";
	
	
}


double height1 = Double.parseDouble(hei)/100;	

double weight=Double.parseDouble(wei)*0.453592;	


System.out.println(""+height1*height1); 

System.out.println(""+weight);


double heigh=height1*height1;


bmi=weight/heigh;


System.out.println("mmmmmmmmmmmmmmmmmmmmmmmm"+bmi);

System.out.println("kkkkkkkkkkkkkk"+weight);


}	
	
if(height.matches("cm")&&weight.matches("st")){

	
	
System.out.println("jjjjjjjjjjjj"+weight);	
	
	

String hei=et1.getText().toString();

String wei=et11.getText().toString();

String wei1=et12.getText().toString();

if(check.matches("true")){	

Editor e=sharedpreferences.edit();


e.putString("height","cm");

e.putString("hei",et1.getText().toString());

e.putString("weight","st");

e.putString("wei",et11.getText().toString());

e.putString("wei1",et12.getText().toString());

e.commit();


}



if(hei.matches("")){
	
	
	hei="0";
	
	
}
if(wei.matches("")){
	
	
	wei="0";
	
	
}

if(wei1.matches("")){
	
	
	wei1="0";
	
	
}


double height1 = Double.parseDouble(hei)/100;	

double weight=Double.parseDouble(wei)*6.350+Double.parseDouble(wei1)*0.453592;	


System.out.println(""+height1*height1); 

System.out.println(""+weight);

//System.out.println(""+weight);



double heigh=height1*height1;


bmi=weight/heigh;




System.out.println("pppppppppppppp"+bmi);

System.out.println("kkkkkkkkkkkkkk"+weight);


}	
		
	
if(height.matches("feet")&&weight.matches("kg")){

	
System.out.println("jjjjjjjjjjjj"+weight);	
	
String hef=et1.getText().toString();

String hei=et2.getText().toString();

String wei=et11.getText().toString();


if(check.matches("true")){	

Editor e=sharedpreferences.edit();


e.putString("height","feet");

e.putString("hef",et1.getText().toString());

e.putString("hei",et2.getText().toString());

e.putString("weight","kg");

e.putString("wei",et11.getText().toString());

//e.putString("wei1",et12.getText().toString());

e.commit();

}



if(hef.matches("")){
	
	
	hef="0";
	
	
}



if(hei.matches("")){
	
	
	hei="0";
	
	
}
if(wei.matches("")){
	
	
	wei="0";
	
	
}


double h=Double.parseDouble(hef)*30+Double.parseDouble(hei)*2.5;


System.out.println("oooooooooooo"+h);



double height1 = h/100;	

double weight=Double.parseDouble(wei);	


System.out.println(""+height1*height1); 

System.out.println(""+weight);

//System.out.println(""+weight);



double heigh=height1*height1;


bmi=weight/heigh;




System.out.println("pppppppppppppp"+bmi);

System.out.println("kkkkkkkkkkkkkk"+weight);




}	
		

if(height.matches("feet")&&weight.matches("lb")){

	
	
System.out.println("jjjjjjjjjjjj"+weight);	
	

String hef=et1.getText().toString();	

String hei=et2.getText().toString();

String wei=et11.getText().toString();



if(check.matches("true")){	


Editor e=sharedpreferences.edit();


e.putString("height","feet");

e.putString("hef",et1.getText().toString());

e.putString("hei",et2.getText().toString());

e.putString("weight","lb");

e.putString("wei",et11.getText().toString());

//e.putString("wei1",et12.getText().toString());

e.commit();



}


if(hef.matches("")){
	
	

	hef="0";
		
	
}


if(hei.matches("")){
	
	
	hei="0";
	
	
}
if(wei.matches("")){
	
	
	wei="0";
	
	
}

double h=Double.parseDouble(hef)*30+Double.parseDouble(hei)*2.5;


System.out.println("oooooooooooo"+h);



double height1 = h/100;	

double weight=Double.parseDouble(wei)*0.453592;	


System.out.println(""+height1*height1); 

System.out.println(""+weight);




double heigh=height1*height1;


bmi=weight/heigh;




System.out.println("mmmmmmmmmmmmmmmmmmmmmmmm"+bmi);

System.out.println("kkkkkkkkkkkkkk"+weight);


}			
	
if(height.matches("feet")&&weight.matches("st")){

	
	
 System.out.println("jjjjjjjjjjjj"+weight);	
	
	



String hef=et1.getText().toString();	

String hei=et2.getText().toString();




String wei=et11.getText().toString();

String wei1=et12.getText().toString();



if(check.matches("true")){	


Editor e=sharedpreferences.edit();


e.putString("height","feet");

e.putString("hef",et1.getText().toString());

e.putString("hei",et2.getText().toString());

e.putString("weight","st");

e.putString("wei",et11.getText().toString());

e.putString("wei1",et12.getText().toString());

e.commit();


}

if(hef.matches("")){
	
	hef="0";
	
	
}


if(hei.matches("")){
	
	
	hei="0";
	
	
}
if(wei.matches("")){
	
	
	wei="0";
	
	
}

if(wei1.matches("")){
	
	
	wei1="0";
	
	
}


double h=Double.parseDouble(hef)*30+Double.parseDouble(hei)*2.5;


System.out.println("oooooooooooo"+h);



double height1 = h/100;	

double weight=Double.parseDouble(wei)*6.350+Double.parseDouble(wei1)*0.453592;	


System.out.println(""+height1*height1); 

System.out.println(""+weight);

//System.out.println(""+weight);



double heigh=height1*height1;


bmi=weight/heigh;




System.out.println("pppppppppppppp"+bmi);

System.out.println("kkkkkkkkkkkkkk"+weight);


}




return bmi;	
		
	
}

class ListViewAdapter extends BaseAdapter{

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arr3.length;
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
		
		
	View v=infla.inflate(R.layout.listitem,null);
	
	
	RelativeLayout rl1=(RelativeLayout)v.findViewById(R.id.relate);
	
		
	TextView tv1=(TextView)v.findViewById(R.id.textView1);	
	
	
	if(bmi<16.0){
		
		
	if(position==0){	
		
		
	rl1.setBackgroundColor(Color.RED);	

	tv1.setTextColor(Color.WHITE);	
		
	}	

	}
	
	if(bmi>16.0&&bmi<17.0){
	
		
		if(position==1){	
		
		rl1.setBackgroundColor(Color.MAGENTA);	
		tv1.setTextColor(Color.WHITE);		
		
		
		
		}
		
	}
	

	
if(bmi>16.9&&bmi<18.5){
	
		
		if(position==2){	
		
		rl1.setBackgroundColor(Color.DKGRAY);	
		tv1.setTextColor(Color.WHITE);		
		
		
		
		}
		
	}
	
if(bmi>18.4&&bmi<25.0){
	
	
	if(position==3){	
	
	rl1.setBackgroundColor(Color.DKGRAY);	
	tv1.setTextColor(Color.WHITE);		
	
	
	
	}
	
}




	if(bmi>24.9&&bmi<30.0){
	
		
		if(position==4){	
		
		rl1.setBackgroundColor(Color.BLUE);	
		tv1.setTextColor(Color.WHITE);		
		
		
		}	
		
		
	}
	

	if(bmi>30.0&&bmi<40.0){
		
		if(position==5){	
		
		rl1.setBackgroundColor(Color.GREEN);	
		tv1.setTextColor(Color.WHITE);		
		
		
		
		}		
		
	}	
		
	if(bmi>39.9){
		
		if(position==6){	
		
		rl1.setBackgroundColor(Color.YELLOW);	
		tv1.setTextColor(Color.BLACK);		
		
		
		
		}		
		
	}	
	
	
	
	
	
	tv1.setText(arr3[position]);
	
	
	
	
	
		
		
		return v;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

}
