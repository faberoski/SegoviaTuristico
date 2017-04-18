package faberm.segoviaturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        extras=getIntent().getExtras();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng ubicacion1 = new LatLng(7.079817,-74.7017515);
        mMap.addMarker(new MarkerOptions().position(ubicacion1).title("Parque principal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion1,15));

        LatLng ubicacion2 = new LatLng(7.0782083,-74.7015477);
        mMap.addMarker(new MarkerOptions().position(ubicacion2).title("Hotel Torre Londres"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion1,15));

        LatLng ubicacion3 = new LatLng(7.0765151,-74.7019236);
        mMap.addMarker(new MarkerOptions().position(ubicacion3).title("Nuestra Senora del carmen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion3,15));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(MapsActivity.this,NavigationDrawerActivity.class);
        intent.putExtra("username",extras.getString("username"));
        intent.putExtra("email",extras.getString("email"));
        startActivity(intent);
        finish();
    }
}
