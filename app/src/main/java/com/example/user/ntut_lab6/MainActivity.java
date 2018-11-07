package com.example.user.ntut_lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    class Data{
        int photos;
        String name;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Data[] transData=new Data[4];
        for(int i=0;i<transData.length;i++){
            transData[i]=new Data();
        }
        transData[0].name="腳踏車";
        transData[1].name="機車";
        transData[2].name="汽車";
        transData[3].name="巴士";
        transData[0].photos=R.drawable.trans1;
        transData[1].photos=R.drawable.trans2;
        transData[2].photos=R.drawable.trans3;
        transData[3].photos=R.drawable.trans4;
        myAdapter transApadter =new myAdapter(transData,R.layout.trans_list);
        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(transApadter);

        String[] messageData=new String[]{"訊息1","訊息2","訊息3","訊息4","訊息5","訊息6"};
        ArrayAdapter<String> messageAdaper =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,messageData);
        ListView listView=(ListView) findViewById(R.id.listview);
        listView.setAdapter(messageAdaper);

        Data[] cubeeData=new Data[10];
        for (int i=0;i<cubeeData.length;i++){
            cubeeData[i]=new Data();
        }
        cubeeData[0].name="哭哭";
        cubeeData[1].name="發抖";
        cubeeData[2].name="再見";
        cubeeData[3].name="生氣";
        cubeeData[4].name="昏倒";
        cubeeData[5].name="竊笑";
        cubeeData[6].name="很棒";
        cubeeData[7].name="你好";
        cubeeData[8].name="驚嚇";
        cubeeData[9].name="大笑";
        cubeeData[0].photos=R.drawable.cubee1;
        cubeeData[1].photos=R.drawable.cubee2;
        cubeeData[2].photos=R.drawable.cubee3;
        cubeeData[3].photos=R.drawable.cubee4;
        cubeeData[4].photos=R.drawable.cubee5;
        cubeeData[5].photos=R.drawable.cubee6;
        cubeeData[6].photos=R.drawable.cubee7;
        cubeeData[7].photos=R.drawable.cubee8;
        cubeeData[8].photos=R.drawable.cubee9;
        cubeeData[9].photos=R.drawable.cubee10;
        myAdapter cubeeAdapter =new myAdapter(cubeeData,R.layout.cubee_list);
        GridView gridView=(GridView) findViewById(R.id.gridview);
        gridView.setNumColumns(3);
        gridView.setAdapter(cubeeAdapter);

    }
    public class myAdapter extends BaseAdapter
    {
        private Data[] data;
        private int view;
        public  myAdapter(Data[] data, int view){
            this.data=data;
            this.view=view;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View rowView, ViewGroup parent) {
            rowView=getLayoutInflater().inflate(view,parent,false);
            TextView name=(TextView) rowView.findViewById(R.id.name);
            ImageView imageView=(ImageView) rowView.findViewById(R.id.imageView);
            name.setText(data[position].name);
            imageView.setImageResource(data[position].photos);
            return rowView;
        }
    }
}
