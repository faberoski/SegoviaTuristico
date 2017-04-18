package faberm.segoviaturistico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class TabDrawerActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    //private SectionsPagerAdapter mSectionsPagerAdapter;

    Intent intent;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;


    //String username="",email="";/////////////

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private String title;
    private String nameTab1;
    private String nameTab2;
    private String nameTab3;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private String sel;
    private Fragment tab1Fragment;
    private Fragment tab2Fragment;
    private Fragment tab3Fragment;
    String titulo;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_drawer);
        extras = getIntent().getExtras();
        sel= extras.getString("sel");
        prefs=getSharedPreferences("preferencias",MODE_PRIVATE);
        editor=prefs.edit();
        if (sel.equals("Hotel")){

            setStringNames(getString(R.string.hotel_title), getString(R.string.hotel1),
                    getString(R.string.hotel2), getString(R.string.hotel3));
            setFragments(1);
        }else if (sel.equals("Rest")){

            setStringNames(getString(R.string.restaurant_title), getString(R.string.restaurant1),
                    getString(R.string.restaurant2), getString(R.string.restaurant3));
            setFragments(2);
        }else if (sel.equals("Bar")){

            setStringNames(getString(R.string.tour_title), getString(R.string.bar1),
                    getString(R.string.bar2), getString(R.string.bar3));
            setFragments(3);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(sel);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            intent=new Intent(TabDrawerActivity.this,NavigationDrawerActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tab_drawer, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_hoteles2) {
            intent=new Intent(TabDrawerActivity.this,TabDrawerActivity.class);            //intent.putExtra("username",username);
            //intent.putExtra("email",correo);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Hotel");
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_bares2) {
            intent=new Intent(TabDrawerActivity.this,TabDrawerActivity.class);
            //intent.putExtra("username",username);
            //intent.putExtra("email",correo);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Bar");
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_restaurantes2) {
            intent=new Intent(TabDrawerActivity.this,TabDrawerActivity.class);
            //intent.putExtra("password",password);
            //intent.putExtra("email",correo);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Rest");
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_perfil2) {
            intent=new Intent(TabDrawerActivity.this,PerfilDrawerActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_mapa2) {
            intent=new Intent(TabDrawerActivity.this,MapsActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            //intent.putExtra("password",password);
            //intent.putExtra("email",correo);
            //intent.putExtra("sel", "Rest");
            startActivity(intent);
            finish();

        }else if (id == R.id.nav_logout2) {
            editor.putInt("flag",-1);
            editor.commit();
            intent=new Intent(TabDrawerActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setStringNames(String _title, String _nameTab1, String _nameTab2, String _nameTab3){
        title = _title;
        nameTab1 = _nameTab1;
        nameTab2 = _nameTab2;
        nameTab3 = _nameTab3;
    }
    private void setFragments(int option){
        switch (option){
            case 1:
                tab1Fragment = new HotelFragment();
                tab2Fragment = new hotel2Fragment();
                tab3Fragment = new hotel3Fragment();
                break;
            case 2:
                tab1Fragment = new restaurante1Fragment();
                tab2Fragment = new restaurante2Fragment();
                tab3Fragment = new restaurante3Fragment();
                break;
            case 3:
                tab1Fragment = new barFragment();
                tab2Fragment = new bar2Fragment();
                tab3Fragment = new bar3Fragment();
                break;
        }
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return tab1Fragment;
                case 1:
                    return tab2Fragment;
                case 2:
                    return tab3Fragment;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return nameTab1;
                case 1:
                    return nameTab2;
                case 2:
                    return nameTab3;
            }
            return null;
        }
    }
}
