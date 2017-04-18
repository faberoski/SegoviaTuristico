package faberm.segoviaturistico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class NavigationDrawerActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
Intent intent;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        extras=getIntent().getExtras();
        prefs=getSharedPreferences("preferencias",MODE_PRIVATE);
        editor=prefs.edit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            intent=new Intent(NavigationDrawerActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
/*
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_perfil) {
            // Handle the camera action
            intent=new Intent(NavigationDrawerActivity.this,PerfilDrawerActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_bares) {
            intent=new Intent(NavigationDrawerActivity.this,TabDrawerActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            //intent.putExtra("username",username);
            //intent.putExtra("email",correo);
            intent.putExtra("sel", "Bar");
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_hoteles) {
            intent=new Intent(NavigationDrawerActivity.this,TabDrawerActivity.class);
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("username",extras.getString("username"));
            //intent.putExtra("username",username);
            //intent.putExtra("email",correo);
            intent.putExtra("sel", "Hotel");
            startActivity(intent);
            finish();

        }else if (id == R.id.nav_restaurantes) {
            intent=new Intent(NavigationDrawerActivity.this,TabDrawerActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            //intent.putExtra("password",password);
            //intent.putExtra("email",correo);
            intent.putExtra("sel", "Rest");
            startActivity(intent);
            finish();

        }else if (id == R.id.nav_mapa) {
            intent=new Intent(NavigationDrawerActivity.this,MapsActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            //intent.putExtra("password",password);
            //intent.putExtra("email",correo);
            //intent.putExtra("sel", "Rest");
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_logout) {
            editor.putInt("flag",-1);
            editor.commit();
            intent=new Intent(NavigationDrawerActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
