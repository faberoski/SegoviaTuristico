package faberm.segoviaturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText eRUsuario,eRRepPassword,eRPassword,eCorreo;
    Button bRegistrarse,bCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        eRUsuario=(EditText)findViewById(R.id.eUsuario2);
        eRPassword=(EditText)findViewById(R.id.ePassword2);
        eRRepPassword=(EditText)findViewById(R.id.eRepassword2);
        eCorreo=(EditText)findViewById(R.id.eCorreo);
        bRegistrarse=(Button)findViewById(R.id.bRegistro);
        bCancelar=(Button)findViewById(R.id.bCancel);

        bRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(eRPassword.getText().toString().equals(eRRepPassword.getText().toString())){
                    Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                    intent.putExtra("username",eRUsuario.getText().toString());
                    intent.putExtra("password",eRPassword.getText().toString());
                    intent.putExtra("email",eCorreo.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }


            }
        });
        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

    }
}
