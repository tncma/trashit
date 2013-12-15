package com.cma.trashit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity {
	 // Google Map
    private GoogleMap googleMap;
    private Context context;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_main);
		context = this;
		 try {
	            // Loading map
	            initilizeMap();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	/**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();
            googleMap.setMyLocationEnabled(true);  
            
            /*Location location = googleMap.getMyLocation();
            LatLng myLocation = null;*/
            googleMap.addMarker(new MarkerOptions()
            .position(new LatLng(13.0011774, 80.2564957))
            .title("Bounty 25"));
            googleMap.addMarker(new MarkerOptions()
            .position(new LatLng(12.997023, 80.2564957))
            .title("Bounty 250"));
            googleMap.addMarker(new MarkerOptions()
            .position(new LatLng(12.989531, 80.251391))
            .title("Bounty 100"));
            googleMap.addMarker(new MarkerOptions()
            .position(new LatLng(13.0424661, 80.1570129))
            .title("No Bounty yet"));
            googleMap.addMarker(new MarkerOptions()
            .position(new LatLng(12.921172, 80.230361))
            .title("No Bounty yet"));
            
/*            if (location != null) {
                myLocation = new LatLng(location.getLatitude(),
                        location.getLongitude());
            }
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation,16));*/
            // check if map is created successfully or not
            
            googleMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
				
				@Override
				public void onInfoWindowClick(Marker arg0) {
					Intent intent = new Intent(context, ViewActivity.class);
					intent.putExtra("TITLE", arg0.getTitle());
					startActivity(intent);			
				}
			});
            
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.create_btn:       
	        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, 1003);
            Toast.makeText(context, "Image upload listeener start", Toast.LENGTH_LONG).show();
	        return true;	    
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}

}
