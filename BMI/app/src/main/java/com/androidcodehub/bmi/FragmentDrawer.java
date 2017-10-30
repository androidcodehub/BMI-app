package com.androidcodehub.bmi;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import com.androidcodehub.bmi.adapter.NavigationDrawerAdapter;
import com.androidcodehub.bmi.model.NavDrawerItem;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;





public class FragmentDrawer extends Fragment 


{


  	private static String TAG = FragmentDrawer.class.getSimpleName();

     private RecyclerView recyclerView;
    
     private ActionBarDrawerToggle mDrawerToggle;
    
      private DrawerLayout mDrawerLayout;
    
       private NavigationDrawerAdapter adapter;
   
       private View containerView;
    
       private static String[] titles = {"Body Mass Index","Basal Metabolic Rate","Settings"};
  
       private FragmentDrawerListener drawerListener;
    
       RelativeLayout rl1;
   
         String fullname;
      
        String image;
    
       SharedPreferences sharedpreferences;
   
   
	  public static final String MyPREFERENCES = "MyPrefs" ;

   
	  public FragmentDrawer() 
    
    {
    	
    	

    }

    public void setDrawerListener(FragmentDrawerListener listener) {
    
    	
    	this.drawerListener = listener;
  
    
    }

    public static List<NavDrawerItem> getData() {
        
    	
    	List<NavDrawerItem> data = new ArrayList<NavDrawerItem>();


        for(int i = 0; i < titles.length; i++) {
            
        	
        	NavDrawerItem navItem = new NavDrawerItem();
            
            
            navItem.setTitle(titles[i]);
          
            
            data.add(navItem);
        
        
        }
        
        
        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        
       super.onCreate(savedInstanceState);

  
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) 
    
    {
     
 	
    	View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        
        
        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE); 
        
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        
        rl1=(RelativeLayout)layout.findViewById(R.id.nav_header_container);
        
     
     
        adapter = new NavigationDrawerAdapter(getActivity(), getData());
          
        
             recyclerView.setAdapter(adapter);
      
        
           recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        
        
        
        
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
          
        	@Override
            public void onClick(View view, int position) {
                
            	
            	drawerListener.onDrawerItemSelected(view, position);
            
                mDrawerLayout.closeDrawer(containerView);
         
            
            }

            @Override
            public void onLongClick(View view, int position) {

        
            
            }
      
        }));

 
        if(sharedpreferences.contains("image"))
        
        {
        	
      image=sharedpreferences.getString("image",""); 
      
      fullname=sharedpreferences.getString("fullname","");
      
       
     System.out.println("iiiiiiiiiiiiiiiiiiiii"+image);  
       

     
 
        } 
     

     	  

     return layout;

    }

      private Target target = new Target() {
        
    	  @Override
   
        public void onBitmapLoaded( Bitmap bitmap, Picasso.LoadedFrom from)
    
    
    {
       

    	
 //        cv1.setImageBitmap(bitmap);
         
 
    }

 	public void onBitmapFailed(Drawable arg0) {
			// TODO Auto-generated method stub
			
	
 	}



		public void onPrepareLoad(Drawable arg0) {
			// TODO Auto-generated method stub
			
	
		}

}; 

    
    
    
    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) 
    
    {
    
    	containerView = getActivity().findViewById(fragmentId);
        
    	mDrawerLayout = drawerLayout;
        
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
        
        	@Override
            
        	public void onDrawerOpened(View drawerView) {
            
        		super.onDrawerOpened(drawerView);
            
                
                getActivity().invalidateOptionsMenu();
     
     }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
              
                getActivity().invalidateOptionsMenu();
         
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
              
            	super.onDrawerSlide(drawerView, slideOffset);
          
                toolbar.setAlpha(1 - slideOffset / 2);
          	
                
            }
        };

     
        mDrawerLayout.setDrawerListener(mDrawerToggle);
     
        mDrawerLayout.post(new Runnable() {
        
        	@Override
            public void run() {
            
            	mDrawerToggle.syncState();
           
            }
       
        });

    }

    public static interface ClickListener {
  
    	public void onClick(View view, int position);

        public void onLongClick(View view, int position);
 
    }

   
    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
    
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
           
        	this.clickListener = clickListener;
         
        	gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
         
        		@Override
        		
                public boolean onSingleTapUp(MotionEvent e) 
        	
        		{
                
                	return true;
            
                }

                @Override
                
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
              
                    	
                    	clickListener.onLongClick(child, recyclerView.getChildPosition(child));
               
                    
                    
                    }
                }
            });
        }

 
        
        
        @Override
    
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

  
        	View child = rv.findChildViewUnder(e.getX(), e.getY());
            
            
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
              
            	clickListener.onClick(child, rv.getChildPosition(child));
            
            }
          
            
            return false;
        }

        @Override
        
         public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        
        
        
        
        }

		@Override
		public void onRequestDisallowInterceptTouchEvent(boolean arg0) {
			// TODO Auto-generated method stub
			
		}
    }

    public interface FragmentDrawerListener {
       
    	public void onDrawerItemSelected(View view, int position);
        
    }

 }



