package com.example.will.android;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import Compartilhado.comando;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    TextView Resultado;
    EditText middlware, A, B, Operacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        middlware = findViewById(R.id.ipMiddleware);
        A = findViewById(R.id.valorA);
        B = findViewById(R.id.valorB);
        Operacao = findViewById(R.id.operacao);
        Resultado = findViewById(R.id.Resultado);
    }

    public void calcular(View v){
        int A = Integer.valueOf(this.A.getText().toString());
        int B = Integer.valueOf(this.B.getText().toString());
        int Operacao = Integer.valueOf(this.Operacao.getText().toString());
        String Middleware = this.middlware.getText().toString();
        System.out.println(Middleware);
        comando com = new comando(A,B,Operacao);
        try {
            Socket socket = new Socket(Middleware,8000);
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            ObjectInputStream ois = new ObjectInputStream(is);
            //
            oos.writeObject(com);
            System.out.println("Enviou");
            com = (comando)ois.readObject();
            System.out.println("Recebeu");
            //
            ois.close();
            oos.close();
            is.close();
            os.close();
            socket.close();
            Resultado.setText(Integer.toString(com.result));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
