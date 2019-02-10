package com.example.anderson.passwords;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class Activity_Two extends AppCompatActivity {

    private DBHelper dh;
    EditText edtloginname, edtsenhapass, edtdescricao, edtoutros;
    Button btinserirbd, btlistarbd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__two);

        dh = new DBHelper(this);

        edtloginname = (EditText) findViewById(R.id.edtnameoulogin);
        edtsenhapass = (EditText) findViewById(R.id.edtpassword);
        edtdescricao = (EditText) findViewById(R.id.edtdescricao);
        edtoutros  = (EditText)  findViewById(R.id.edtoutros);

        btinserirbd = (Button) findViewById(R.id.btinserirbd);
        btlistarbd = (Button) findViewById(R.id.btlistar);

        btinserirbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtloginname.getText().length() > 0 && edtsenhapass.getText().length() > 0 &&
                        edtdescricao.getText().length() > 0 && edtoutros.getText().length() > 0){

                    dh.insert(edtloginname.getText().toString(), edtsenhapass.getText().toString(),
                            edtdescricao.getText().toString(), edtoutros.getText().toString());

                    AlertDialog.Builder adb = new AlertDialog.Builder(Activity_Two.this);

                    adb.setTitle("Sucesso...");
                    adb.setMessage("Cadastro Realizado, Cretino!!");
                    adb.show();
                    edtloginname.setText("");
                    edtsenhapass.setText("");
                    edtdescricao.setText("");
                    edtoutros.setText("");
                }else {
                    AlertDialog.Builder adb = new AlertDialog.Builder(Activity_Two.this);
                    adb.setTitle("ERRO...");
                    adb.setMessage("Preencha todos os campo, Otário!");
                    adb.show();
                }
            }
        });

        btlistarbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contato> contatos = dh.queryGetAll();

                if(contatos == null){
                    AlertDialog.Builder adb = new AlertDialog.Builder(Activity_Two.this);
                    adb.setTitle("Messagem...");
                    adb.setMessage("Não Há Registros..");
                    adb.show();
                    }

                    for(int i = 0; i < contatos.size(); i++){
                        Contato contato = (Contato) contatos.get(i);
                        AlertDialog.Builder adb = new AlertDialog.Builder(Activity_Two.this);
                        adb.setTitle("REGISTRO DE NÚMERO: " + i);
                        adb.setMessage("Login: "+ contato.getLogin()+ "\nSenha: "+ contato.getSenha()+"\nDescrição: "+ contato.getDescricao()+"\nOutros: " + contato.getOutros());

                        adb.setPositiveButton("OK BB", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        adb.show();

                    }
            }
        });

    }

}
