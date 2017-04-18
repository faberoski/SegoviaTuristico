package faberm.segoviaturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class tabActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    private String title;
    private String nameTab1;
    private String nameTab2;
    private String nameTab3;

    private String sel;
    private Fragment tab1Fragment;
    private Fragment tab2Fragment;
    private Fragment tab3Fragment;
    String titulo;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        extras = getIntent().getExtras();
        sel= extras.getString("sel");


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
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent intent;
        switch (item.getItemId()){
            case R.id.mPerfil:
                intent=new Intent(tabActivity.this,PerfilActivity.class);
                intent.putExtra("username",extras.getString("username"));
                intent.putExtra("email",extras.getString("email"));
                startActivity(intent);
                finish();
                break;
            case R.id.mRestaurantes:

                intent=new Intent(tabActivity.this,tabActivity.class);
                intent.putExtra("username",extras.getString("username"));
                intent.putExtra("email",extras.getString("email"));
                intent.putExtra("sel", "Rest");
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:

                intent=new Intent(tabActivity.this,tabActivity.class);
                intent.putExtra("username",extras.getString("username"));
                intent.putExtra("email",extras.getString("email"));
                intent.putExtra("sel", "Bar");
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:

                intent=new Intent(tabActivity.this,tabActivity.class);
                intent.putExtra("username",extras.getString("username"));
                intent.putExtra("email",extras.getString("email"));
                intent.putExtra("sel", "Hotel");
                startActivity(intent);
                finish();
                break;
            case R.id.mLogOut:
                intent=new Intent(tabActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */





    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
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
    /** Method to set names to all string variables **/
    private void setStringNames(String _title, String _nameTab1, String _nameTab2, String _nameTab3){
        title = _title;
        nameTab1 = _nameTab1;
        nameTab2 = _nameTab2;
        nameTab3 = _nameTab3;
    }

    /** Method to set fragments to every tab **/
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
    @Override
    public void onBackPressed() {
        Intent intent;
        super.onBackPressed();
        intent=new Intent(tabActivity.this,MainActivity.class);
        intent.putExtra("username",extras.getString("username"));
        intent.putExtra("email",extras.getString("email"));
        startActivity(intent);
        finish();
    }
}
