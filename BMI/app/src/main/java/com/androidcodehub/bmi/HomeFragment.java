package com.androidcodehub.bmi;



import java.util.Arrays;



import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;



public class HomeFragment extends Fragment 


{

	
Spinner sp1,sp2,sp3;
	
	
	String arr[]={"ft+in","cm"};
	
	String arr1[]={"kg","lb","st+lb"};
	
	String arr2[] = { "Sedentary", "Extremely Inactive", "Moderately Active", "Vigorously Active",
	"Extremely Active" };
	
	
	
	String arr3[]={"< 2260 kcal"," 2260 - 2744 kcal","2744-3228 kcal","3228-3874 kcal"," > 3874 kcal"};
	
	
	
	
	SpinnerAdapter madapter;
	

	Spinneradapter1 madapter1;
	
	
	Spinneradapter2 madapter2;
	
	
	ImageView iv1,iv2;
	
	EditText age;
	
	
	EditText et1,et2,et11,et12;
	
	//int sex=0;
	
	String height="feet";
	
	String weight ="kg";
	
	
	int age1=0;
	

	
	
	RelativeLayout rl1;
	
	
	String sex="0";
	
	
	
	
	   public static final String MyPREFERENCES = "custom" ;

	   SharedPreferences sharedpreferences;
	
	
	String check="";
	
	int position1=0;
	
	int position=0;
	
	int position2=0;
	
	double bmr=0.0;
	
	
	TextView bm;
	
    TextView energy;
	
	
	
	
	
	public HomeFragment() {
       
		
		
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
       
    	super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            
    		Bundle savedInstanceState) 
    
    
    {
    
    	
    	View rootView = inflater.inflate(R.layout.dashboard1, container, false);
    	
        
    	   sp1=(Spinner)rootView.findViewById(R.id.spinner1);

           
           iv1=(ImageView)rootView.findViewById(R.id.imageView1);
            
           iv2=(ImageView)rootView.findViewById(R.id.imageView2);

            et1=(EditText)rootView.findViewById(R.id.editText1);
         
            et2=(EditText)rootView.findViewById(R.id.editText2);
            
            et11=(EditText)rootView.findViewById(R.id.editText11);
       
            
            et12=(EditText)rootView.findViewById(R.id.editText12);
            
            age=(EditText)rootView.findViewById(R.id.editText111);
            
               sp2=(Spinner)rootView.findViewById(R.id.spinner2); 
               
           sp3=(Spinner)rootView.findViewById(R.id.spinner3) ;  
           
           
           bm=(TextView)rootView.findViewById(R.id.tv7);
           
          energy=(TextView)rootView.findViewById(R.id.tv9);
               
               
               
               
               
      //      bmitext=(TextView)rootView.findViewById(R.id.textView13) ;  
               
               
         
            
            rl1=(RelativeLayout)rootView.findViewById(R.id.relativeLayout1);


            sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);   
            
           if(sharedpreferences.contains("check")){
          	 
       	 
             check="true"; 
             
          	 
          } 
            
    
         if(sharedpreferences.contains("height")){
      	   
      	   
      height=sharedpreferences.getString("height","feet");	   
      
      weight=sharedpreferences.getString("weight","kg");
      
      
      position2=sharedpreferences.getInt("position2",0);
      
      
      
   String   age1=sharedpreferences.getString("age","0");

   
   String sex1=sharedpreferences.getString("sex","0");
   
   
  if(sex1.matches("0")){
  	
  	
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
      
      
      
      String hef=sharedpreferences.getString("hef","0");
      
      String hei=sharedpreferences.getString("hei","0");
      
      
      String wei=sharedpreferences.getString("wei","0");
      
      String wei1=sharedpreferences.getString("wei1","0");
      
      
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
           
           
           
           
     if(sex.matches("0")){
    	 
    	 
    		iv2.setImageResource(R.drawable.male1);	

    	  	iv1.setImageResource(R.drawable.female); 
    	 
    	 
     }      
           
           
           
  		   
  	madapter=new SpinnerAdapter();	
      
  	sp1.setAdapter(madapter);
  	
  	sp1.setSelection(position);
  	
  	
  	

  	
  	   
        madapter1=new Spinneradapter1();	

       sp2.setAdapter(madapter1);
  	
    
       sp2.setSelection(position1);
       
       
       
       
		   
	madapter2=new Spinneradapter2();	
   
	sp3.setAdapter(madapter2);
	
	sp3.setSelection(position2);
       
       
       
	
	sp3.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
		
			

		  	Editor e=sharedpreferences.edit();
		  	
		  	e.putInt("position2",position);
		  	
		  	e.commit();
		  	
	
		  	
		  	position2=position;
		  	
		  	
		  	
		  	calculation();
			
			
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
	
		
		
		
		
		
		}
	});
	
	
	
	
	
       
       
    //   iv2.setImageResource(R.drawable.male1);
       

     
     


  iv1.setOnClickListener(new OnClickListener() {
  	
  	@Override
  	public void onClick(View v) {
  		// TODO Auto-generated method stub
  	
//  		
  	iv2.setImageResource(R.drawable.male);	
//  		
  	iv1.setImageResource(R.drawable.female1);	
  	
  	
  	sex="1";
  	
  	

  	Editor e=sharedpreferences.edit();
  	
  	e.putString("sex","1");
  	
  	e.commit();
  	
  	double bmi1=calculation();
  	
  	
  	bm.setText(""+bmi1+""+"kcal");
  	
  	
  	
  		
  		
  	}
  });

  iv2.setOnClickListener(new OnClickListener() {
  	
  	@Override
  	public void onClick(View v) {
  		// TODO Auto-generated method stub
  	
  		
  	iv2.setImageResource(R.drawable.male1);	

  	iv1.setImageResource(R.drawable.female);
  	
  	
  	sex="0";
  	
  	
  	Editor e=sharedpreferences.edit();
  	
  	e.putString("sex","0");
  	
  	e.commit();
	double bmi1=calculation();
  	
  	
	bm.setText(""+bmi1+""+"kcal");	
  	
  		
  	}
  });


  age.addTextChangedListener(new TextWatcher() {
  	
  	@Override
  	public void onTextChanged(CharSequence s, int start, int before, int count) {
  		// TODO Auto-generated method stub
  		
  		

  		Editor e=sharedpreferences.edit();
  	  	
  	  	
  	  	e.putString("age",age.getText().toString());
  	  	e.commit();
  	  	
  		double bmi1=calculation();
  	  	
  	  	
  		bm.setText(""+bmi1+""+"kcal");
  	  	
  		
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
  		
  		
  //	double bmi1=calculation();
  	
  		double bmi1=calculation();
  	  	
  	  	
  		bm.setText(""+bmi1+""+"kcal");
 
  
  		
//  	rl1.setBackgroundColor(Color.GRAY);
  	
  	
  	
  		
  		
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
  	  	
  	  	
  		bm.setText(""+bmi1+""+"kcal");
  	
 	
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
  	  	
  	  	
  		bm.setText(""+bmi1+""+"kcal");
  	
  	

  		
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
  	  	
  	  	
  		bm.setText(""+bmi1+""+"kcal");
  	

  		
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
  	
  	
	bm.setText(""+bmi1+""+"kcal");
  	
  	

  	
       
       
   	}
  		
  	
  		if(position==0)
  	
  		{
  			
  		et2.setVisibility(View.VISIBLE);		

  		
  	height="feet";
  	
  	
	double bmi1=calculation();
  	
  	
	bm.setText(""+bmi1+""+"kcal");


  	
  		
  		}
  		
  		
  	}

  	@Override
  	public void onNothingSelected(AdapterView<?> parent) {
  		// TODO Auto-generated method stub
  	
  	
  		height="feet";
  		
  		
  		double bmi1=calculation();
  	  	
  	  	
  		bm.setText(""+bmi1+""+"kcal");
  	

  		
  	}
  });




  sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

  	@Override
  	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
  	
  		
  		if(position==2){
  			
  	
       et12.setVisibility(View.VISIBLE);
       
       weight="st";
       
	double bmi1=calculation();
  	
  	
	bm.setText(""+bmi1+""+"kcal");
  	

       
      	
  		}
  		
  	
  		if(position==0)
  	
  		{
  			
  		et12.setVisibility(View.GONE);	        
  		
  		
  		weight="kg";
  		
  		
  		double bmi1=calculation();
  	  	
  	  	
  		bm.setText(""+bmi1+""+"kcal");

  	
  	
  		}
  		

  		if(position==1)
  	
  		{
  			
  		et12.setVisibility(View.GONE);	
  		
  		
  		weight="lb";
  		
  		
  		double bmi1=calculation();
  	  	
  	  	
  		bm.setText(""+bmi1+""+"kcal");
  	

  		
  		
  			
  			
  		}	
  		
  		
  	}

  	@Override
  	public void onNothingSelected(AdapterView<?> parent) {
  		// TODO Auto-generated method stub
  	
  		
  		weight="kg";
  		
  		double bmi1=calculation();
  	  	
  	  	
  		bm.setText(""+bmi1+""+"kcal");
  	

  		
  		
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
	
	 
	 if(age.getText().toString().matches("")&&et1.getText().toString().matches("")){
			
			
	//	 0.0 Kcal
		

			energy.setText(" 0.0 Kcal");
		 
			
		}	
			  	
		else{
			
			
			energy.setText(arr3[position2]);
			
			
			
		}	  	
			  	
	 
	
    if(height.matches("cm")&&weight.matches("kg")){
	
	
    	
    	  System.out.println("jjjjjjjjjjjj"+weight);	
    	  
    	  System.out.println("jjjjjjjjjjjj"+height);
    	
	String hei=et1.getText().toString();
     
	String wei=et11.getText().toString();
	
	String age2=age.getText().toString();
	

	
	
if(check.matches("true")){	
	
	
	Editor e=sharedpreferences.edit();
	
	
	e.putString("height","cm");
	
	e.putString("age",age2);
	
	e.putString("sex",sex);
	
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
	
	if(age2.matches("")){
		
		
		age2="0";
		
		
	}
	

	
	
if(sex.matches("0")){
	
//66 + ( 13.7 x weight in kilos ) + ( 5 x height in cm ) - ( 6.8 x age in years )	
	
	
	int we=Integer.parseInt(wei);
	
	
	int he=Integer.parseInt(hei);
	
	
	int ae=Integer.parseInt(age2);
	
	
	
bmr=	66 + ( 13.7 * we) + ( 5 * he ) - ( 6.8 *ae );
	

}	
	
else{

	
	
	int we=Integer.parseInt(wei);
	
	
	int he=Integer.parseInt(hei);
	
	
	int ae=Integer.parseInt(age2);	
	
	
	
    bmr=	655 + ( 9.6 *we) + ( 1.8*he) - ( 4.7 *ae);	
	
	
	
	
}	
	
 
	
}	
	

if(height.matches("cm")&&weight.matches("lb")){

	
	
     System.out.println("jjjjjjjjjjjj"+weight);	
     System.out.println("jjjjjjjjjjjj"+height);
	

String hei=et1.getText().toString();

String wei=et11.getText().toString();


String age2=age.getText().toString();



if(hei.matches("")){
	
	
	hei="0";
	
	
}

if(wei.matches("")){
	
	
	wei="0";
	
	
}

if(age2.matches("")){
	
	
	age2="0";
	
	
}





if(check.matches("true")){	

Editor e=sharedpreferences.edit();


e.putString("height","cm");

e.putString("age",age2);


e.putString("sex",sex);



e.putString("weight","kg");


e.putString("hei",et1.getText().toString());

e.putString("weight","lb");

e.putString("wei",et11.getText().toString());

e.commit();


}





if(sex.matches("0")){

//66 + ( 13.7 x weight in kilos ) + ( 5 x height in cm ) - ( 6.8 x age in years )	


int we=Integer.parseInt(wei);


int he=Integer.parseInt(hei);


int ae=Integer.parseInt(age2);



bmr=	66 + ( 13.7 * we*0.453592) + ( 5 * he ) - ( 6.8 *ae );


}	

else{



int we=Integer.parseInt(wei);


int he=Integer.parseInt(hei);


int ae=Integer.parseInt(age2);	



bmr=	655 + ( 9.6 *we*0.453592) + ( 1.8*he) - ( 4.7 *ae);	




}	












}	
	
if(height.matches("cm")&&weight.matches("st")){

	
	
System.out.println("jjjjjjjjjjjj"+weight);	

System.out.println("jjjjjjjjjjjj"+height);


	
	

String hei=et1.getText().toString();

String wei=et11.getText().toString();

String wei1=et12.getText().toString();


String age2=age.getText().toString();



if(hei.matches("")){
	
	
	hei="0";
	
	
}
if(wei.matches("")){
	
	
	wei="0";
	
	
}

if(wei1.matches("")){
	
	
	wei1="0";
	
	
}


if(age2.matches("")){
	
	
	age2="0";
	
	
}







if(check.matches("true")){	

Editor e=sharedpreferences.edit();


e.putString("height","cm");

e.putString("age",age2);

e.putString("sex",sex);


e.putString("hei",et1.getText().toString());

e.putString("weight","st");

e.putString("wei",et11.getText().toString());

e.putString("wei1",et12.getText().toString());

e.commit();


}






if(sex.matches("0")){

//66 + ( 13.7 x weight in kilos ) + ( 5 x height in cm ) - ( 6.8 x age in years )	


int we=Integer.parseInt(wei);

int we1=Integer.parseInt(wei1);



int he=Integer.parseInt(hei);


int ae=Integer.parseInt(age2);



double w=6.35029*we+we1*0.453592;




bmr=	66 + ( 13.7 * w) + ( 5 * he ) - ( 6.8 *ae );


}	

else{



int we=Integer.parseInt(wei);


//int we=Integer.parseInt(wei);

int we1=Integer.parseInt(wei1);



int he=Integer.parseInt(hei);


int ae=Integer.parseInt(age2);



double w=6.35029*we+we1*0.453592;



bmr=	655 + ( 9.6 *w) + ( 1.8*he) - ( 4.7 *ae);	




}	


}	
		
	
if(height.matches("feet")&&weight.matches("kg")){

	
System.out.println("jjjjjjjjjjjj"+weight);	

System.out.println("jjjjjjjjjjjj"+height);


	
String hef=et1.getText().toString();

String hei=et2.getText().toString();

String wei=et11.getText().toString();


String age2=age.getText().toString();



if(hef.matches("")){
	
	
	hef="0";
	
	
}



if(hei.matches("")){
	
	
	hei="0";
	
	
}
if(wei.matches("")){
	
	
	wei="0";
	
	
}

if(age2.matches("")){
	
	
	age2="0";
	
	
}


if(check.matches("true")){	

Editor e=sharedpreferences.edit();


e.putString("height","feet");

e.putString("age",age2);

e.putString("sex",sex);


e.putString("hef",hef);

e.putString("hei",hei);

e.putString("weight","kg");

e.putString("wei",wei);

//e.putString("wei1",et12.getText().toString());

e.commit();

}





if(sex.matches("0")){

//66 + ( 13.7 x weight in kilos ) + ( 5 x height in cm ) - ( 6.8 x age in years )	


	System.out.println("zzzzzzz"+wei);
	
	System.out.println("zzzzzzz"+hef);
	
	System.out.println("zzzzzzz"+hei);
	
	System.out.println("zzzzzzz"+age2);
	
	

 int we=Integer.parseInt(wei);

//int we1=Integer.parseInt(wei1);


int he=Integer.parseInt(hef);

int he1=Integer.parseInt(hei);

          
int ae=Integer.parseInt(age2);

double h=he*30+he1*2.54;

//double w=6.35029*we+we1*0.453592;

 bmr=	66 + ( 13.7 * we) + ( 5 * h ) - ( 6.8 *ae );


}	

else

{


if(hef.matches("")){
	
	
	hef="0";
	
	
}



if(hei.matches("")){
	
	
	hei="0";
	
	
}
if(wei.matches("")){
	
	
	wei="0";
	
	
}

if(age2.matches("")){
	
	
	age2="0";
	
	
}

	 int we=Integer.parseInt(wei);

	//int we1=Integer.parseInt(wei1);


	int he=Integer.parseInt(hef);

	int he1=Integer.parseInt(hei);




	int ae=Integer.parseInt(age2);

	double h=he*30+he1*2.54;

	//double w=6.35029*we+we1*0.453592;

//	double bmr=	66 + ( 13.7 * we) + ( 5 * h ) - ( 6.8 *ae );




bmr=	655 + ( 9.6 *we) + ( 1.8*h) - ( 4.7 *ae);	




}	




}	
		

if(height.matches("feet")&&weight.matches("lb")){

	
	
System.out.println("jjjjjjjjjjjj"+weight);	

System.out.println("jjjjjjjjjjjj"+height);


	

String hef=et1.getText().toString();	

String hei=et2.getText().toString();

String wei=et11.getText().toString();


String age2=age.getText().toString();




if(check.matches("true")){	


Editor e=sharedpreferences.edit();


e.putString("height","feet");

e.putString("age",age2);
e.putString("sex",sex);



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

if(age2.matches("")){
	
	
age2="0";	
	
	
}


if(sex.matches("0")){

//66 + ( 13.7 x weight in kilos ) + ( 5 x height in cm ) - ( 6.8 x age in years )	


 int we=Integer.parseInt(wei);

//int we1=Integer.parseInt(wei1);


int he=Integer.parseInt(hef);

int he1=Integer.parseInt(hei);




int ae=Integer.parseInt(age2);

double h=he*30+he1*2.54;

//double w=6.35029*we+we1*0.453592;

 bmr=	66 + ( 13.7 * we*0.453592) + ( 5 * h ) - ( 6.8 *ae );


}	

else

{



	 int we=Integer.parseInt(wei);

	//int we1=Integer.parseInt(wei1);


	int he=Integer.parseInt(hef);

	int he1=Integer.parseInt(hei);




	int ae=Integer.parseInt(age2);

	double h=he*30+he1*2.54;

	//double w=6.35029*we+we1*0.453592;

//	double bmr=	66 + ( 13.7 * we) + ( 5 * h ) - ( 6.8 *ae );




bmr=	655 + ( 9.6 *we*0.453592) + ( 1.8*h) - ( 4.7 *ae);	


}	

}			
	
if(height.matches("feet")&&weight.matches("st")){

	
	
 System.out.println("jjjjjjjjjjjj"+weight);	
 
 System.out.println("jjjjjjjjjjjj"+height);
 
 
	
 
 String age2=age.getText().toString();
 


String hef=et1.getText().toString();	

String hei=et2.getText().toString();


String wei=et11.getText().toString();

String wei1=et12.getText().toString();



if(check.matches("true")){	


Editor e=sharedpreferences.edit();


e.putString("height","feet");


e.putString("age",age2);


e.putString("sex",sex);


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

if(age2.matches("")){
	
	
age2="0";	
	
	
}

if(sex.matches("0")){

//66 + ( 13.7 x weight in kilos ) + ( 5 x height in cm ) - ( 6.8 x age in years )	


 int we=Integer.parseInt(wei);

int we1=Integer.parseInt(wei1);


int he=Integer.parseInt(hef);

int he1=Integer.parseInt(hei);




int ae=Integer.parseInt(age2);

double h=he*30+he1*2.54;

double w=6.35029*we+we1*0.453592;

 bmr=	66 + ( 13.7 * w) + ( 5 * h ) - ( 6.8 *ae );


}	

else

{



	 int we=Integer.parseInt(wei);

	int we1=Integer.parseInt(wei1);


	int he=Integer.parseInt(hef);

	int he1=Integer.parseInt(hei);




	int ae=Integer.parseInt(age2);

	double h=he*30+he1*2.54;

	double w=6.35029*we+we1*0.453592;

//	double bmr=	66 + ( 13.7 * we) + ( 5 * h ) - ( 6.8 *ae );




bmr=	655 + ( 9.6 *w) + ( 1.8*h) - ( 4.7 *ae);	


}	




//double w=6.35029*we+we1*0.453592;



}




return bmr;	
		
	
}

 public class Spinneradapter2 extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arr2.length;
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
			
			
			tv1.setText(arr2[position]);
			
			
			
			return v;
		}
		
		
	}

}