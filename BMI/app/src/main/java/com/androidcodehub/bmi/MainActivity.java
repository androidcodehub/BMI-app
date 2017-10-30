package com.androidcodehub.bmi;


import java.util.ArrayList;



import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;






public class MainActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener 



{

    private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
  
    private FragmentDrawer drawerFragment;
    

 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
 
    	super.onCreate(savedInstanceState);
      
        setContentView(R.layout.activity_main);
        
 
           
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        
     
        
             setSupportActionBar(mToolbar);
    
		  
	       getSupportActionBar().setDisplayShowHomeEnabled(true);
	  
        
	     drawerFragment = (FragmentDrawer)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
      
         drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
      
         drawerFragment.setDrawerListener(this);
        
        
           displayView(0);

        
               

    }

   @Override
  
    public void onDrawerItemSelected(View view, int position) 
    
    {
    
    	
    	displayView(position);
    	
     
    }

   
    private void displayView(int position) {
    	
     
    	Fragment fragment = null;
        
       	FragmentManager fragmentManager = getSupportFragmentManager();
        
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        
        
      
        String title = getString(R.string.app_name);
        
   
        switch (position) {
            
        
        case 0:
                
        	
        	fragment = new dashboard();
                
              	title  =  "Body Mass Index";
              	
     fragmentTransaction.replace(R.id.container_body, fragment,"home");
             
                fragmentTransaction.commit();

          
                getSupportActionBar().setTitle(title);       	
              	
                    break;
         
        case 1:
  
        	fragment = new HomeFragment();
              
                title = "Basal Metabolic Rate";
                
      
               
                fragmentTransaction.replace(R.id.container_body, fragment,"about");
             
                fragmentTransaction.commit();

          
                getSupportActionBar().setTitle(title);          
                
     
                break;

                
          case 2:
                        
                	
                	fragment = new settings();
                        
                      	title  =  "Settings";
                      	
             fragmentTransaction.replace(R.id.container_body, fragment,"settings");
                     
                        fragmentTransaction.commit();

                  
                        getSupportActionBar().setTitle(title);       	
                      	
                            break;  
                
                
      
        default:
                
            	break;
       
        
        }

        if (fragment != null) 
        
        {
          
        	
        	 getSupportActionBar().setTitle(title);	
            
            
            
        }
    }
    

	
	}

