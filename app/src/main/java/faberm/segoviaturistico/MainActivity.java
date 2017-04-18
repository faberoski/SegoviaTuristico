package faberm.segoviaturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
String username,correo,password;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras=getIntent().getExtras();
        username=extras.getString("username");
        correo=extras.getString("email");
        password=extras.getString("password");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.mPerfil:
                intent=new Intent(MainActivity.this,PerfilActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mRestaurantes:
                intent=new Intent(MainActivity.this,tabActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",correo);
                intent.putExtra("sel", "Rest");
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:
                intent=new Intent(MainActivity.this,tabActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",correo);
                intent.putExtra("sel", "Bar");
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent=new Intent(MainActivity.this,tabActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",correo);
                intent.putExtra("sel", "Hotel");
                startActivity(intent);
                finish();
                break;
            case R.id.mLogOut:
                intent=new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                intent.putExtra("email",correo);
                startActivity(intent);
                finish();
                break;


        }
        return true;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();

    }
}
