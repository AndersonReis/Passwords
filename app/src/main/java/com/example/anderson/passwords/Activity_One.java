package com.example.anderson.passwords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_One extends AppCompatActivity {

    EditText edtemail, edtsenha;
    Button btlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__one);

        edtemail = ( EditText ) findViewById(R.id.edtemail);
        edtsenha = ( EditText ) findViewById(R.id.edtsenha);
        btlogin = ( Button ) findViewById(R.id.btlogin);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_informado = edtemail.getText().toString();
                String senha_informado = edtsenha.getText().toString();

                if(("123".equals(email_informado))&&("123".equals(senha_informado))){
                    IrTelaDados();
                    Toast.makeText(getApplicationContext(), "Acesso Permitido", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Email ou Senha incorretos...", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    void IrTelaDados() {
        Intent intent = new Intent();
        intent.setClass(Activity_One.this, Activity_Two.class);
        startActivity(intent);
        finish();
    }
}
