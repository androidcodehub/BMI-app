package com.androidcodehub.bmi;



import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webclass extends AppCompatActivity{


	
	WebView wv1;
	
	
	String test;
	
	 private Toolbar mToolbar;
	 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	setContentView(R.layout.webview);
	
	wv1=(WebView)findViewById(R.id.webView1);
	
    
 mToolbar = (Toolbar) findViewById(R.id.toolbar);
 

 
      setSupportActionBar(mToolbar);
      
      getSupportActionBar().setHomeButtonEnabled(true);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      
	
	
      wv1.setWebViewClient(new MyBrowser());
	
	
	
	
	if(getIntent().getExtras()!=null){
		
		
	test=	getIntent().getExtras().getString("face");
	
	
	System.out.println("tttttttt"+test);
	
		
		
	}
	
	
if(test.matches("facebook")){	
	
	   wv1.getSettings().setLoadsImagesAutomatically(true);
       wv1.getSettings().setJavaScriptEnabled(true);
       wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
     
	
	wv1.loadUrl("https://www.google.co.in/");
	
}
	
	
else{
	
	   wv1.getSettings().setLoadsImagesAutomatically(true);
       wv1.getSettings().setJavaScriptEnabled(true);
       wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
     	
     	wv1.loadUrl("https://www.google.co.in/");
	
	
}



mToolbar.setNavigationOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		
		onBackPressed();
		
		
		
		
	}
});









	}




	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
	

	
	private class MyBrowser extends WebViewClient {
	      @Override
	      public boolean shouldOverrideUrlLoading(WebView view, String url) {
	      
	    	  
	    	  
	    	  view.loadUrl(url);
	     
	    	  
	    	  return true;
	      }
	   }	
	
	
}
