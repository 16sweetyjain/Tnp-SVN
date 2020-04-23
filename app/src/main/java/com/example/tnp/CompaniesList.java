package com.example.tnp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CompaniesList extends AppCompatActivity {

    ListView list;
    String[] web = {
            "  Accenture",
            "  Ahuliwala",
            "  Alstom",
            "  Areva",
            "  Bhel",
            "  Birlasoft",
            "  Canon",
            "  CMC Limited",
            "  CSC",
            "  E Gateway",
            "  Eicher",
            "  GDA Technologies",
            "  HAL",
            "  HCL Infosystems LTD",
            "  Hindustan Uniliver Limited",
            "  I-flex Solutions",
            "  Infosys",
            "  Jaypee Group",
            "  Reliance Companies",
            "  Rockwell Automation",
            "  Sahara",
            "  Saraswati Dyanamic",
            "  Shriram Pistons and Rings Limited",
            "  Siemens",
            "  ST Microelectronics",
            "  Syntel Consider IT Done",
            "  Tata Consultancy Services",
            "  Tech Mahindra",
            "  TeleSoft",
            "  The Scooters India",
            "  Videocon",
            "  Wipro",
            "  Xansas",
            "  Yash Papers Limited"
    } ;
   /* Integer[] imageId = {
            R.drawable.accenture,
            R.drawable.ahuliwalia,
            R.drawable.alstom,
            R.drawable.arevalogo,
            R.drawable.bhel,
            R.drawable.birlasoft,
            R.drawable.canon_logo,
            R.drawable.cmc,
            R.drawable.csc,
            R.drawable.egateway,
            R.drawable.eicher,
            R.drawable.gda,
            R.drawable.hal,
            R.drawable.hclinfosystems,
            R.drawable.hlllogo,
            R.drawable.iflex,
            R.drawable.infosys,
            R.drawable.jp,
            R.drawable.reliance,
            R.drawable.rockwell,
            R.drawable.sahara,
            R.drawable.shriram,
            R.drawable.siemenslogo,
            R.drawable.stlogo,
            R.drawable.syntel,
            R.drawable.tcs,
            R.drawable.techmahindralogo,
            R.drawable.telesoft,
            R.drawable.th_scooters_india,
            R.drawable.videocon,
            R.drawable.wipro,
            R.drawable.xansas,
            R.drawable.yashlogo


    };*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies_list);

        CustomList adapter = new
                CustomList(CompaniesList.this, web);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(CompaniesList.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
    }
}
