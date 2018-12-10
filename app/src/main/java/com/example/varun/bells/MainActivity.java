package com.example.varun.bells;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] districts;
    ArrayList<DistrictNames> arraylist = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProcessing();
        //showDialogSchools();

    }

    public void listProcessing()
    {
        districts = new String[]{"Fremont Union High School District (FUHSD)",
                "Santa Clara Unified School District (SCUSD)",
                "Palo Alto Unified School District (PAUSD)",
                "Fremont Unified School District (FUSD)",
                "Milpitas Unified School District (MUSD)",
                "Newark Unified School District (NUSD"};


        list = findViewById(R.id.listview);

        for (int i = 0; i < districts.length; i++) {
            DistrictNames districtNames = new DistrictNames(districts[i]);
            arraylist.add(districtNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


            }

        });

        editsearch = findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    public void showDialogSchools(String [] schools)
    {
        //example array
        //String[] schools = {"Fremont HS", "Cupertino HS", "Lynbrook HS", "Homestead HS", "Monta Vista HS"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick a School");
        builder.setItems(schools, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                if(position == 0) {} //todo: change action for appropriate school
                //fill the rest of the space with conditionals for the rest of the district
            }
        });
        builder.show();
    }


    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}