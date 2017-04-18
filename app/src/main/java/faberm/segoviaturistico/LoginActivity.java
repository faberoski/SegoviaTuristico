package faberm.segoviaturistico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText eUsuario,ePassword;
    Button bIniciar;
    TextView tRegistrarse;
    String username,password,correo;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
        setContentView(R.layout.activity_login);
        Bundle extras=getIntent().getExtras();
            prefs=getSharedPreferences("preferencias",MODE_PRIVATE);
            editor=prefs.edit();
            username=prefs.getString("username","noname");
            correo=prefs.getString("correo","nomail");
            password=prefs.getString("password","nopassword");

            if (prefs.getInt("flag", -1)== 1){
                Intent intent=new Intent(LoginActivity.this, NavigationDrawerActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("email", correo);
                startActivity(intent);
                finish();
            }
        username=extras.getString("username");
        correo=extras.getString("email");
        password=extras.getString("password");}catch (Exception e){}


        eUsuario=(EditText)findViewById(R.id.eUsuario);
        ePassword=(EditText)findViewById(R.id.ePassword);
        bIniciar=(Button)findViewById(R.id.bLoguear);
        tRegistrarse=(TextView)findViewById(R.id.tRegistrarse);

        /*Bundle extras= getIntent().getExtras();
        Toast.makeText(this,extras.getString("username"), Toast.LENGTH_SHORT).show();*/


        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent,1234);

            }
        });


        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validar que el usuario y contraseña sean iguales a los recibidos
                if(eUsuario.getText().toString().equals(username)&&ePassword.getText().toString().equals(password)){
                    editor.putInt("flag",1);
                    editor.commit();

                    Intent intent =new Intent(LoginActivity.this,NavigationDrawerActivity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("email",correo);
                    intent.putExtra("password",password);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Datos  incorrectos", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(requestCode==1234 && resultCode==RESULT_OK){
           username=data.getExtras().getString("username");
           password=data.getExtras().getString("password");
           correo=data.getExtras().getString("email");
           editor.putString("username",username);
           editor.putString("correo",correo);
           editor.putString("password",password);
           editor.commit();

           /*Log.d("nombre",data.getExtras().getString("username"));
           Log.d("correo",data.getExtras().getString("email"));
            Toast.makeText(this, data.getExtras().getString("username"), Toast.LENGTH_SHORT).show();*/
        }
        if(requestCode==1234&& resultCode==RESULT_CANCELED){
            Toast.makeText(this,"Error en login", Toast.LENGTH_SHORT).show();
        }
    }
}
