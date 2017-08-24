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
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class list1 extends AppCompatActivity {
    private final int NUMFIELDS = 10;
    private int count;
    private boolean delete;
    static SharedPreferences prefs;
    String result;
    ArrayList<EditText> texts;
    ArrayList<View> buttons;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = this.getSharedPreferences("list1", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_list1);
        delete = false;
        texts = new ArrayList<>();
        buttons = new ArrayList<>();
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
            texts.add(cur);
            // }
        }

        buttons.add(findViewById(R.id.delete0));
        buttons.add(findViewById(R.id.delete1));
        buttons.add(findViewById(R.id.delete2));
        buttons.add(findViewById(R.id.delete3));
        buttons.add(findViewById(R.id.delete4));
        buttons.add(findViewById(R.id.delete5));
        buttons.add(findViewById(R.id.delete6));
        buttons.add(findViewById(R.id.delete7));
        buttons.add(findViewById(R.id.delete8));
        buttons.add(findViewById(R.id.delete9));
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
        switch(id){
            case R.id.reset:

                for(int i = 0; i < count ;i++){
                    EditText cur = (EditText) findViewById(R.id.count0 +i);
                    cur.setText("");
                    cur.setVisibility(View.INVISIBLE);
                    buttons.get(i).setVisibility(View.INVISIBLE);
                }
                EditText header = (EditText)findViewById(R.id.Header);
                header.setText("");
                prefs.edit().clear().apply();
                count = 0;
                return true;
            case R.id.toggle_delete:
                for(int i = 0; i < count; i++){
                    switch(i){
                        case 0:
                            ;
                            if(delete) {
                                findViewById(R.id.delete0).setVisibility(View.INVISIBLE);
                            } else {
                                buttons.get(0).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 1:
                            if(delete) {
                                findViewById(R.id.delete1).setVisibility(View.INVISIBLE);
                            } else {
                                buttons.get(1).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 2:
                            if(delete) {
                                findViewById(R.id.delete2).setVisibility(View.INVISIBLE);
                            } else {
                                buttons.get(2).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 3:
                            if(delete) {
                                findViewById(R.id.delete3).setVisibility(View.INVISIBLE);
                            } else {
                                buttons.get(3).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 4:
                            if(delete) {
                                findViewById(R.id.delete4).setVisibility(View.INVISIBLE);
                            } else {
                                buttons.get(4).setVisibility(View.VISIBLE);;
                            }
                            break;
                        case 5:
                            if(delete) {
                                findViewById(R.id.delete5).setVisibility(View.INVISIBLE);
                            } else {
                                buttons.get(5).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 6:
                            if(delete) {
                                findViewById(R.id.delete6).setVisibility(View.INVISIBLE);
                            } else {
                                buttons.get(6).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 7:
                            if(delete) {
                                findViewById(R.id.delete7).setVisibility(View.INVISIBLE);
                            } else {
                                buttons.get(7).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 8:
                            if(delete) {
                                findViewById(R.id.delete8).setVisibility(View.INVISIBLE);
                            } else {
                                buttons.get(8).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 9:
                            if(delete) {
                                findViewById(R.id.delete9).setVisibility(View.INVISIBLE);
                            } else {
                                buttons.get(9).setVisibility(View.VISIBLE);
                            }
                            break;
                    }
                }
                if(!delete){ //if toggle delete on, hide keyboard
                    View view = this.getCurrentFocus();
                    if (view != null) {
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }
                delete = !delete;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void plus(View v){ // simple toast action
        if(count < NUMFIELDS) {
            int id = R.id.count0 + count;
            EditText curText = (EditText) findViewById(id);
            curText.setVisibility(View.VISIBLE);
            curText.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(curText,0);
            prefs.edit().putInt("count",++count).apply();
            texts.add(curText);
            if(delete){
                buttons.get(count -1).setVisibility(View.VISIBLE);
            }
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
        prefs.edit().putInt("count",count).apply();
        finish();
    }

    public void delete(View v){
        switch(v.getId()){
            case R.id.delete0:
                delete(0);
                break;
            case R.id.delete1:
                delete(1);
                break;
            case R.id.delete2:
                delete(2);
                break;
            case R.id.delete3:
                delete(3);
                break;
            case R.id.delete4:
                delete(4);
                break;
            case R.id.delete5:
                delete(5);
                break;
            case R.id.delete6:
                delete(6);
                break;
            case R.id.delete7:
                delete(7);
                break;
            case R.id.delete8:
                delete(8);
                break;
            case R.id.delete9:
                delete(9);
                break;
        }
    }

    private void delete(int n){
        for(;n < count - 1; n++){
            EditText curText = texts.get(n);
            EditText nexText = texts.get(n+1);

            String t1 = curText.getText().toString();
            String t2 = nexText.getText().toString();
            curText.setText(t2);
        }
        TextView last = texts.remove(n);
        if(count > 1){
            TextView secndlast = texts.get(n -1);
            secndlast.requestFocus();
        }
        last.setText("");
        last.setVisibility(View.INVISIBLE);
        Button b = (Button)buttons.get(count -1);
        b.setVisibility(View.INVISIBLE);
        count--;
    }
}
