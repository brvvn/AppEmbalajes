package com.example.appembalaje;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appembalaje.R;

public class Crud extends AppCompatActivity {

    Spinner spSpinner;
    String[] tamaño = new String[]{"Pequeño", "Mediano", "Grande", "Extra Grande"};
    EditText edtCod, edtNom, edtCat, edtCan;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        //Defino los campos del Formulario
        edtCod = (EditText) findViewById(R.id.edtCod);
        edtNom = (EditText) findViewById(R.id.edtNom);
        edtCat = (EditText) findViewById(R.id.edtCat);
        edtCan = (EditText) findViewById(R.id.edtCan);
        spSpinner = (Spinner) findViewById(R.id.spSpinner);
        lista = (ListView) findViewById(R.id.lstLista);

        //Poblar el Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tamaño);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpinner.setAdapter(spinnerAdapter);
        CargarLista();
    }

    public  void onClickAgregar(View view){
        DataHelper dh=new DataHelper(this,"producto.db",null, 1);
        SQLiteDatabase bd= dh.getWritableDatabase();
        ContentValues reg= new ContentValues();
        reg.put("cod",edtCod.getText().toString());
        reg.put("nom",edtNom.getText().toString());
        reg.put("cat",edtCat.getText().toString());
        reg.put("can",edtCan.getText().toString());
        reg.put("tam", spSpinner.getSelectedItem().toString());
        long resp = bd.insert("producto", null, reg);
        bd.close();
        if (resp==-1){
            Toast.makeText(this,"No se puede ingresar el registro", Toast.LENGTH_LONG).show();
        }
        else {Toast.makeText(this,"Registro Agregado",Toast.LENGTH_LONG).show();}
        Limpiar();
        CargarLista();

    }
    public  void onClickModificar(View view){
        //Instancio la clase DataHelper llamando a la tabla producto donde se ingresan los datos
        DataHelper dh = new DataHelper(this, "producto.db", null, 1);
        //Usamos getWritableDatabase para sobreescribir la base de datos
        SQLiteDatabase bd = dh.getWritableDatabase();
        //Usamos ContentValues para el ingreso de los valores
        ContentValues reg = new ContentValues();
        //Primero llamamos el campo de la tabla y luego lo lanzamos con la variable donde se ingresara el texto
        reg.put("cod", edtCod.getText().toString());
        reg.put("nom", edtNom.getText().toString());
        reg.put("cat", edtCat.getText().toString());
        reg.put("can", edtCan.getText().toString());
        reg.put("tam", spSpinner.getSelectedItem().toString());

        long resp = bd.update("producto", reg, "cod=?", new String[]{edtCod.getText().toString()});
        bd.close();

        if (resp == -1){
            Toast.makeText(this, "No se pudo modificar el registro", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Registro Modificado", Toast.LENGTH_LONG).show();
        }
        Limpiar();
        CargarLista();

    }
    public  void onClickEliminar(View view){
        //Instancio la clase DataHelper llamado a la tabla producto donde se ingresaran los datos
        DataHelper dh = new DataHelper(this, "producto.db", null, 1);
        //Usamos getWritableDatabase para sobre escribir la base de datos
        SQLiteDatabase bd = dh.getWritableDatabase();
        //Declaramos una variable String llamada eCod que resivira el codigo que se ingrese
        String eCod = edtCod.getText().toString();
        long resp = bd.delete("producto", "cod=" + eCod, null);
        bd.close();
        //Aqui comprobamos si se elimino o no el registro y mostrar un mensaje adecuado.
        if (resp==-1){
            Toast.makeText(this, "Registro no encontrado",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Registro eliminado",Toast.LENGTH_LONG).show();
        }
        Limpiar();
        CargarLista();

    }

    public  void Limpiar(){
        //limpiar los campos de los editText
        edtCod.setText("");
        edtNom.setText("");
        edtCat.setText("");
        edtCan.setText("");

    }

    public void CargarLista(){
        DataHelper dh = new DataHelper(this, "producto.db", null, 1);
        SQLiteDatabase bd = dh.getReadableDatabase();
        Cursor c = bd.rawQuery("Select cod, nom, cat, can, tam from producto", null);
        String[] arr = new String[c.getCount()];
        if (c.moveToFirst() == true) {
            int i = 0;
            do {
                String linea = "  "+ c.getInt(0) + "  " + c.getString(1)
                        + "  " + c.getString(2) + "  " + c.getInt(3) + "  "+ c.getString(4) + "  ";
                arr[i] = linea;
                i++;
            } while (c.moveToNext() == true);
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, arr);
            lista.setAdapter(adaptador);
            bd.close();
        }
    }
}
