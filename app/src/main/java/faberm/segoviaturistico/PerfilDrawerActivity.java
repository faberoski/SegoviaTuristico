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
import android.widget.TextView;

public class PerfilDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView tUsername,tCorreo;
    Intent intent;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String username="",email="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        prefs=getSharedPreferences("preferencias",MODE_PRIVATE);
        editor=prefs.edit();

        tUsername=(TextView)findViewById(R.id.tUsuarioperfil);
        tCorreo=(TextView)findViewById(R.id.tCorreoperfil);

        Bundle extras=getIntent().getExtras();
        username=extras.getString("username");
        email=extras.getString("email");
        tUsername.setText(username);
        tCorreo.setText(email);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout1);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            intent=new Intent(PerfilDrawerActivity.this,NavigationDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();

        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_perfil1) {
            intent=new Intent(PerfilDrawerActivity.this,PerfilDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_bares1) {
            intent=new Intent(PerfilDrawerActivity.this,TabDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            intent.putExtra("sel", "Bar");
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_hoteles1) {
            intent=new Intent(PerfilDrawerActivity.this,TabDrawerActivity.class);            //intent.putExtra("username",username);
            //intent.putExtra("email",correo);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            intent.putExtra("sel", "Hotel");
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_restaurantes1) {
            intent=new Intent(PerfilDrawerActivity.this,TabDrawerActivity.class);
            //intent.putExtra("password",password);
            //intent.putExtra("email",correo);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            intent.putExtra("sel", "Rest");
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_mapa1) {
            intent=new Intent(PerfilDrawerActivity.this,MapsActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            //intent.putExtra("password",password);
            //intent.putExtra("email",correo);
            //intent.putExtra("sel", "Rest");
            startActivity(intent);
            finish();

        }else if (id == R.id.nav_logout1) {
            editor.putInt("flag",-1);
            editor.commit();
            intent=new Intent(PerfilDrawerActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout1);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
