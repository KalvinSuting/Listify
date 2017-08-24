package com.example.donny.listify;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;

import java.util.HashSet;
import java.util.Set;

public class list extends AppCompatActivity {
    private final int NUMFIELDS = 10;
    private int count;
    static SharedPreferences prefs;
    String result;
    Set<EditText> texts;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = this.getSharedPreferences("list", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_list);
        texts = new HashSet<>();

        for(int i = 0; i < NUMFIELDS; i++){ //create textwatchers
            final EditText cur = (EditText) findViewById(R.id.count0+i);
            cur.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String text = cur.getText().toString();
                    String name = getResources().getResourceEntryName(cur.getId());
                    saveText(name, text);
                    Toast testToast = Toast.makeText(getApplicationContext(),"changed text value of " + name, Toast.LENGTH_LONG);
                    //testToast.show();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        final EditText header = (EditText)findViewById(R.id.Header);
        header.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                prefs.edit().putString("header",header.getText().toString()).apply();
                result = header.getText().toString().trim();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        count = prefs.getInt("count",0);
        for(int i = 0; i < count; i++) { // add textfields after close/ change of activity.
            //if (prefs.getBoolean("count" + i +"b", false)) {
            EditText cur = (EditText) findViewById(R.id.count0+i);
            cur.setVisibility(View.VISIBLE);
            cur.setText(prefs.getString("count" + i, null));
            cur.requestFocus();
            // }
        }
        header.setText(prefs.getString("header",""));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void plus(View v){ // simple toast action
        Toast myToast = Toast.makeText(getApplicationContext(),"new textbox is now visible", Toast.LENGTH_LONG);
        if(count < NUMFIELDS) {
            int id = R.id.count0 + count;
            EditText curText = (EditText) findViewById(id);
            curText.setVisibility(View.VISIBLE);
            curText.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(curText,0);
            prefs.edit().putInt("count",++count).apply();
            //count++;
            //myToast.show();
        }
    }

    public void minus(View v){
        Toast myToast = Toast.makeText(getApplicationContext(),"hid last textbox",Toast.LENGTH_LONG);
        if(count > 0) {
            prefs.edit().putInt("count",--count).apply();
            //count--;
            final EditText cur = (EditText) findViewById(R.id.count0+count);
            String name = getResources().getResourceEntryName(cur.getId());
            int id = R.id.count0 + count;
            TextView text = (TextView) findViewById(id);
            text.setText("");
            findViewById(id).setVisibility(View.INVISIBLE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(name +"b",false).apply();
            findViewById(R.id.count0 + count -1).requestFocus();
            // myToast.show();
        }
    }

    public void saveText(String name, String val){
        SharedPreferences.Editor  editor = prefs.edit();
        editor.putString(name, val);
        editor.putBoolean(name + "b",true); //testing this, probably wrong.
        editor.apply();
    }

    public void save(View v){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",result);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
