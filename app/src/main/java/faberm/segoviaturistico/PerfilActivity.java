package faberm.segoviaturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {
    TextView tUsername,tCorreo;
    Intent intent;
    String username="",email="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tUsername=(TextView)findViewById(R.id.tUsuarioperfil);
        tCorreo=(TextView)findViewById(R.id.tCorreoperfil);

        Bundle extras=getIntent().getExtras();
        username=extras.getString("username");
        email=extras.getString("email");
        tUsername.setText(username);
        tCorreo.setText(email);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id) {
            case R.id.mPerfil:
                intent=new Intent(PerfilActivity.this,PerfilActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",email);
                startActivity(intent);
                finish();
                break;
            case R.id.mRestaurantes:
                intent=new Intent(PerfilActivity.this,tabActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",email);
                intent.putExtra("sel", "Rest");
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:
                intent=new Intent(PerfilActivity.this,tabActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",email);
                intent.putExtra("sel", "Bar");
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent=new Intent(PerfilActivity.this,tabActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",email);
                intent.putExtra("sel", "Hotel");
                startActivity(intent);
                finish();
                break;
            case R.id.mLogOut:
                intent=new Intent(PerfilActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intent=new Intent(PerfilActivity.this,MainActivity.class);
        intent.putExtra("username",username);
        intent.putExtra("email",email);
        startActivity(intent);
        finish();
    }
}
