package org.institutoserpis.ed.my_calculadora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.*;

import static android.widget.Toast.*;

public class Calculadora extends AppCompatActivity {

    private EditText oper1,oper2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        oper1=(EditText)findViewById(R.id.editText);
        oper2=(EditText)findViewById(R.id.editText2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
       // return true;}

        if (id == R.id.Calculadora) {
             makeText(this,getString(R.string.mensaje_1),LENGTH_LONG).show();}
        if (id == R.id.Cientifica) {
            makeText(this,getString(R.string.mensaje_2), LENGTH_LONG).show();}


        return super.onOptionsItemSelected(item);
    }

    public void SUMAR (View view){
        int n1=Integer.parseInt(oper1.getText().toString());
        int n2=Integer.parseInt(oper2.getText().toString());
        int sumar=n1+n2;
        mostrar(sumar);
    }
    public void RESTAR (View view){
        int n1=Integer.parseInt(oper1.getText().toString());
        int n2=Integer.parseInt(oper2.getText().toString());
        int restar=n1-n2;
        mostrar(restar);
    }
    public void MULTIPLICAR (View view){
        int n1=Integer.parseInt(oper1.getText().toString());
        int n2=Integer.parseInt(oper2.getText().toString());
        int multiplicar=n1*n2;
        mostrar(multiplicar);
    }
    public void DIVIDIR (View view){
        int n1=Integer.parseInt(oper1.getText().toString());
        int n2=Integer.parseInt(oper2.getText().toString());
        int dividir=n1/n2;
        mostrar(dividir);
    }

    public void EXPONENTE (View view){
        int n1=Integer.parseInt(oper1.getText().toString());
        int n2=Integer.parseInt(oper2.getText().toString());
        int exponente= (int) Math.pow(n1, n2);
        mostrar(exponente);
    }

    public void mostrar (int res){
        Toast toast1= makeText(Calculadora.this, "EL RESULTADO ES: " + res, LENGTH_LONG);
        toast1.show();

    }



}
