package com.example.zodiacsign;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Zodiac.Zodiac;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    EditText txtSearch;
    ListView lv;
    ArrayList<Zodiac> list=new ArrayList<>();
    ArrayList<Zodiac> filteredlist=new ArrayList<>();
    CustomAdapter adapter;
    AlertDialog dialog;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new Zodiac(R.drawable.img1,"Aries","March 21 – April 19", "The Aries Horoscope 2020 indicates that the New Year will be full of personal and professional success. You’ll find this coming year is far more active and goal-oriented, Aries, and any residual feelings of being mired down and stuck clear quickly."));
        list.add(new Zodiac(R.drawable.img2,"Taurus","April 20 - May 20", "The Taurus people are, usually, very rational. In every second of life, they focus their efforts working hard to obtain the desired well-being and standard of living. This doesn’t mean, however, that fortune can’t smile upon a Taurus if they try their chances at the lottery. "));
        list.add(new Zodiac(R.drawable.img4,"Cancer","June 21 - July 22", "People born in Cancer will be quite lucky in 2020. Even though they don’t generally believe in luck, and money and fortune are not that important for Cancer, the New Year will be a prosperous period for them."));
        list.add(new Zodiac(R.drawable.img3,"Gemini","May 21 - June 20", "According to Gemini 2020 horoscope, you’re coming shortly into a solid building period of your life, Gemini, so for 2020 use the remaining influence to dig into what you really hope to accomplish in your life."));
        list.add(new Zodiac(R.drawable.img5,"Leo","July 23 - August 22", "For Leos, the stars and the chances seem to keep smiling in 2020. The warning, however, is real for the Leos because they tend to exaggerate with money spending."));
        list.add(new Zodiac(R.drawable.img6,"Virgo","August 23 - September 22","You focus your attention on your family life, Virgo! Jupiter’s journey through the home, family, and domestic life gives you a boost to change your home, to renovate it, or even to increase its size."));
        list.add(new Zodiac(R.drawable.img7,"Libra","September 23 - October 22","With a new vision about things and life in general, 2020 is the year of relationships for Libras. And when we say relationships, we refer to all kinds of relationships: professional, friendship, family, love, amity, collaboration, etc."));
        list.add(new Zodiac(R.drawable.img8,"Scorpio","October 23 - November 21","According to your horoscope, 2020 will be major growing year, Scorpio, and much of what you reap in the way of rewards comes from efforts made in the past."));
        list.add(new Zodiac(R.drawable.img9,"Sagittarius","November 22 - December 21","According to your 2020 horoscope, it appears there is a lot of change coming into your life over the year, Sagittarius, and you get a chance to rework both how you present yourself to the world and what you present to the world."));
        list.add(new Zodiac(R.drawable.img10,"Capricorn","December 22 - January 19","According to your horoscope, 2020 is a year when you put your mind into full focus and create the world you have longed to live in Capricorn.Unlike in 2019, the year 2020 will be extraordinary for Capricorns. And here we are talking about all the aspects of their lives. "));
        list.add(new Zodiac(R.drawable.img11,"Aquarius","January 20 - February 18","According to the 2020 horoscope, with all the energy in your sign, Aquarius, this year promises to be more energized then last year. 2020 is a lucky year, a year of changes for the better. You will find peace, harmony, and happiness. "));
        list.add(new Zodiac(R.drawable.img12,"Pisces","February 19 - March 20","According to your 2020 horoscope, the abundance available to you this year is found within the relationship you can form with yourself. Is 2020 a lucky year for Pisces? In 2020, the Pisces will have a tremendous fortune in love, although they won’t realize it from the beginning. "));

        for(Zodiac student:list){
            filteredlist.add(student);
        }

        imageView=findViewById(R.id.imageView1);
        txtSearch=findViewById(R.id.txtSearch);
        lv=findViewById(R.id.listView1);
        adapter=new CustomAdapter(this,filteredlist);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

        txtSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filteredlist.clear();
                String regex=s.toString();
                Pattern p=Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                for(int i=0; i<list.size();i++){
                    Zodiac zodiac=list.get(i);
                    Matcher m=p.matcher(zodiac.getName());
                    if (m.find()){
                        filteredlist.add(zodiac);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.dialog, null);

       ImageView imageView = mView.findViewById(R.id.lblview);
       imageView.setPadding(10,10,10,10);imageView.setBaselineAlignBottom(true);
       TextView name =  mView.findViewById(R.id.lblNview);
        name.setPadding(10,10,10,10);
       TextView details =mView.findViewById(R.id.lblDetails);
       details.setPadding(10,10,10,10);

        imageView.setImageResource(filteredlist.get(position).getImage());
        name.setText(filteredlist.get(position).getName().toUpperCase());
       details.setText(filteredlist.get(position).getDetails());

        builder.setNeutralButton("\t\t\t\t\t\t\t\t\t\t\tOKAY",null);
        builder.setView(mView);
        dialog = builder.create();
        dialog.show();

    }
}