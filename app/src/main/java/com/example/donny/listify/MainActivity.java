package com.example.donny.listify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int numLists;
    SharedPreferences prefs;
    private boolean delete;
    private View[] deleteButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = this.getSharedPreferences("mainPrefs", Context.MODE_PRIVATE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        delete = false;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();

                prefs.edit().putInt("numLists",++numLists).apply();
                switch(numLists -1) {
                    case 0:
                        Intent intent0 = new Intent(getApplicationContext(), list0.class);
                        startActivityForResult(intent0, 0);
                        int id0 = R.id.list0;
                        TextView text0 = (TextView) findViewById(id0);
                        text0.setVisibility(View.VISIBLE);
                        if(delete){
                            findViewById(R.id.delete0).setVisibility(View.VISIBLE);
                        }
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), list1.class);
                        startActivityForResult(intent1,1);
                        int id1 = R.id.list1;
                        TextView text1 = (TextView) findViewById(id1);
                        text1.setVisibility(View.VISIBLE);
                        if(delete){
                            findViewById(R.id.delete1).setVisibility(View.VISIBLE);
                        }
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), list2.class);
                        startActivityForResult(intent2, 2);
                        int id2 = R.id.list2;
                        TextView text2 = (TextView) findViewById(id2);
                        text2.setVisibility(View.VISIBLE);
                        if(delete){
                            findViewById(R.id.delete2).setVisibility(View.VISIBLE);
                        }
                        break;
                    case 3:
                        Intent intent3 = new Intent(getApplicationContext(), list3.class);
                        startActivityForResult(intent3, 3);
                        int id3 = R.id.list3;
                        TextView text3 = (TextView) findViewById(id3);
                        text3.setVisibility(View.VISIBLE);
                        if(delete){
                            findViewById(R.id.delete3).setVisibility(View.VISIBLE);
                        }
                        break;
                    case 4:
                        Intent intent4 = new Intent(getApplicationContext(), list4.class);
                        startActivityForResult(intent4, 4);
                        int id4 = R.id.list4;
                        TextView text4 = (TextView) findViewById(id4);
                        text4.setVisibility(View.VISIBLE);
                        if(delete){
                            findViewById(R.id.delete4).setVisibility(View.VISIBLE);
                        }
                        break;
                    default:
                        Toast myToast = Toast.makeText(getApplicationContext(),"Currently only supports 5 lists", Toast.LENGTH_LONG);
                        myToast.show();
                        prefs.edit().putInt("numLists",--numLists).apply();
                        break;
                }

            }
        });
        //prefs.edit().clear().apply();
        numLists = prefs.getInt("numLists",0);
        for(int i = 0; i < numLists; i++){
            int id = R.id.list0 + i;
            findViewById(id).setVisibility(View.VISIBLE);
            TextView text = (TextView) findViewById(id);

            switch(i){
                case 0:
                    String header0 = getApplicationContext().getSharedPreferences("list0",0).getString("header","new list");
                    if(header0.equals("")){
                        header0 = "new list";
                    }
                    text.setText(header0);
                    break;
                case 1:
                    String header1 = getApplicationContext().getSharedPreferences("list1",0).getString("header","new list");
                    if(header1.equals("")){
                        header1 = "new list";
                    }
                    text.setText(header1);
                    break;
                case 2:
                    String header2 = getApplicationContext().getSharedPreferences("list2",0).getString("header","new list");
                    if(header2.equals("")){
                        header2 = "new list";
                    }
                    text.setText(header2);
                    break;
                case 3:
                    String header3 = getApplicationContext().getSharedPreferences("list3",0).getString("header","new list");
                    if(header3.equals("")){
                        header3 = "new list";
                    }
                    text.setText(header3);
                    break;
                case 4:
                    String header4 = getApplicationContext().getSharedPreferences("list4",0).getString("header","new list");
                    if(header4.equals("")){
                        header4 = "new list";
                    }
                    text.setText(header4);
                    break;
                case 5:
                    text.setText(getApplicationContext().getSharedPreferences("list5",0).getString("header","new list"));
                    break;
                case 6:
                    text.setText(getApplicationContext().getSharedPreferences("list6",0).getString("header","new list"));
                    break;
                case 7:
                    text.setText(getApplicationContext().getSharedPreferences("list7",0).getString("header","new list"));
                    break;
                case 8:
                    text.setText(getApplicationContext().getSharedPreferences("list8",0).getString("header","new list"));
                    break;
                case 9:
                    text.setText(getApplicationContext().getSharedPreferences("list9",0).getString("header","new list"));
                    break;
            }
        }
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
        switch(item.getItemId()){
            case R.id.reset:
                prefs.edit().clear().apply();
                int tempNum = numLists;
                for(int i = 0; i < tempNum; i++){
                    int id = R.id.list0 + i;
                    findViewById(id).setVisibility(View.INVISIBLE);
                    TextView text = (TextView) findViewById(id);
                    text.setText("new list");
                    switch(i){
                        case 0:
                            getApplicationContext().getSharedPreferences("list0",0).edit().clear().apply();
                            findViewById(R.id.delete0).setVisibility(View.INVISIBLE);
                            numLists = 0;
                            break;
                        case 1:
                            getApplicationContext().getSharedPreferences("list1",0).edit().clear().apply();
                            findViewById(R.id.delete1).setVisibility(View.INVISIBLE);
                            numLists = 0;
                            break;
                        case 2:
                            getApplicationContext().getSharedPreferences("list2",0).edit().clear().apply();
                            findViewById(R.id.delete2).setVisibility(View.INVISIBLE);
                            numLists = 0;
                            break;
                        case 3:
                            getApplicationContext().getSharedPreferences("list3",0).edit().clear().apply();
                            findViewById(R.id.delete3).setVisibility(View.INVISIBLE);
                            numLists = 0;
                            break;
                        case 4:
                            getApplicationContext().getSharedPreferences("list4",0).edit().clear().apply();
                            findViewById(R.id.delete4).setVisibility(View.INVISIBLE);
                            numLists = 0;
                            break;
                        case 5:
                            getApplicationContext().getSharedPreferences("list5",0).edit().clear().apply();
                            numLists = 0;
                            break;
                        case 6:
                            getApplicationContext().getSharedPreferences("list6",0).edit().clear().apply();
                            numLists = 0;
                            break;
                        case 7:
                            getApplicationContext().getSharedPreferences("list7",0).edit().clear().apply();
                            numLists = 0;
                            break;
                        case 8:
                            getApplicationContext().getSharedPreferences("list8",0).edit().clear().apply();
                            numLists = 0;
                            break;
                        case 9:
                            getApplicationContext().getSharedPreferences("list9",0).edit().clear().apply();
                            numLists = 0;
                            break;
                    }
                    numLists = 0;
                    delete = false;
                }
                prefs.edit().putInt("numLists",0).apply();
                numLists = 0;
                Toast myToast = Toast.makeText(getApplicationContext(),"Reset your preferences...", Toast.LENGTH_LONG);
                myToast.show();
                return true;
            case R.id.toggle_delete:
                for(int i = 0; i < numLists; i++){
                    switch(i){
                        case 0:
                            if(delete) {
                                findViewById(R.id.delete0).setVisibility(View.INVISIBLE);
                            } else {
                                findViewById(R.id.delete0).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 1:
                            if(delete) {
                                findViewById(R.id.delete1).setVisibility(View.INVISIBLE);
                            } else {
                                findViewById(R.id.delete1).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 2:
                            if(delete) {
                                findViewById(R.id.delete2).setVisibility(View.INVISIBLE);
                            } else {
                                findViewById(R.id.delete2).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 3:
                            if(delete) {
                                findViewById(R.id.delete3).setVisibility(View.INVISIBLE);
                            } else {
                                findViewById(R.id.delete3).setVisibility(View.VISIBLE);
                            }
                            break;
                        case 4:
                            if(delete) {
                                findViewById(R.id.delete4).setVisibility(View.INVISIBLE);
                            } else {
                                findViewById(R.id.delete4).setVisibility(View.VISIBLE);
                            }
                            break;

                    }
                }
                delete = !delete;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View v){
        int id = v.getId();
        switch(id){
            case R.id.list0:
                Intent intent0 = new Intent(getApplicationContext(),list0.class);
                startActivityForResult(intent0, 0);
                break;
            case R.id.list1:
                Intent intent1 = new Intent(getApplicationContext(),list1.class);
                startActivityForResult(intent1, 1);
                break;
            case R.id.list2:
                Intent intent2 = new Intent(getApplicationContext(),list2.class);
                startActivityForResult(intent2, 2);
                break;

            case R.id.list3:
                Intent intent3 = new Intent(getApplicationContext(),list3.class);
                startActivityForResult(intent3, 3);
                break;

            case R.id.list4:
                Intent intent4 = new Intent(getApplicationContext(),list4.class);
                startActivityForResult(intent4, 4);
                break;

        }
    }

    public static TextView getTextView(int n){
        TextView textView = (TextView) getTextView(R.id.list0 +n);
        return textView;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch(requestCode){
            case 0:
                int id0 = R.id.list0;
                TextView text0 = (TextView) findViewById(id0);
                if(resultCode == Activity.RESULT_OK){ //save was pressed
                    if(data.getStringExtra("result").equals("")){
                        text0.setText("new list");
                    } else {
                        text0.setText(data.getStringExtra("result"));
                    }
                }
                break;
            case 1:
                int id1 = R.id.list1;
                TextView text1 = (TextView) findViewById(id1);
                if(resultCode == Activity.RESULT_OK){ //save was pressed
                    if(data.getStringExtra("result").equals("")){
                        text1.setText("new list");
                    } else {
                        text1.setText(data.getStringExtra("result"));
                    }
                }
                break;

            case 2:
                int id2 = R.id.list2;
                TextView text2 = (TextView) findViewById(id2);
                if(resultCode == Activity.RESULT_OK){ //save was pressed
                    if(data.getStringExtra("result").equals("")){
                        text2.setText("new list");
                    } else {
                        text2.setText(data.getStringExtra("result"));
                    }
                }
                break;
            case 3:
                int id3 = R.id.list3;
                TextView text3 = (TextView) findViewById(id3);
                if(resultCode == Activity.RESULT_OK){ //save was pressed
                    if(data.getStringExtra("result").equals("")){
                        text3.setText("new list");
                    } else {
                        text3.setText(data.getStringExtra("result"));
                    }
                }
                break;
            case 4:
                int id4 = R.id.list4;
                TextView text4 = (TextView) findViewById(id4);
                if(resultCode == Activity.RESULT_OK){ //save was pressed
                    if(data.getStringExtra("result").equals("")){
                        text4.setText("new list");
                    } else {
                        text4.setText(data.getStringExtra("result"));
                    }
                }
                break;
        }
    }

    public void delete(View v){
        int id = v.getId();
        switch(id){
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
        }
    }

    private void delete(int n){
        int curId = R.id.list0 + n;
        String curPrefHandle = "list" + n;
        String nextPrefHandle = "list" + (n + 1);
        getApplicationContext().getSharedPreferences(curPrefHandle,0).edit().clear().apply();
        while(n < numLists -1){
            curPrefHandle = "list" + n;
            curId = R.id.list0 + n;
            nextPrefHandle = "list" + (++n);
            int numPrefs = getApplicationContext().getSharedPreferences(nextPrefHandle,0).getInt("count",0);
            String header = getApplicationContext().getSharedPreferences(nextPrefHandle,0).getString("header","");
            if(header.equals("".trim())){
                header = "new list";
            }  else {
                getApplicationContext().getSharedPreferences(curPrefHandle, 0).edit().putString("header", header).apply();
            }
            TextView text  = (TextView) findViewById(curId);
            text.setText(header);
            for(int i = 0; i < numPrefs; i++) { // copy list items from next to cur
                String nextItem = getApplicationContext().getSharedPreferences(nextPrefHandle,0).getString("count" + i,"").toString();
                getApplicationContext().getSharedPreferences(curPrefHandle,0).edit().putString("count" +i,nextItem).apply();

            }
            getApplicationContext().getSharedPreferences(curPrefHandle,0).edit().putInt("count",numPrefs).apply();
        }
        getApplicationContext().getSharedPreferences(nextPrefHandle,0).edit().clear().apply();
        TextView lastText = (TextView) findViewById(R.id.list0 + (numLists -1 ));
        lastText.setText("");
        lastText.setVisibility(View.INVISIBLE);
        switch(numLists -1){
            case 0:
                findViewById(R.id.delete0).setVisibility(View.INVISIBLE);
                break;
            case 1:
                findViewById(R.id.delete1).setVisibility(View.INVISIBLE);
                break;
            case 2:
                findViewById(R.id.delete2).setVisibility(View.INVISIBLE);
                break;
            case 3:
                findViewById(R.id.delete3).setVisibility(View.INVISIBLE);
                break;
            case 4:
                findViewById(R.id.delete4).setVisibility(View.INVISIBLE);
                break;

        }
        prefs.edit().putInt("numLists",--numLists).apply();
    }
}
