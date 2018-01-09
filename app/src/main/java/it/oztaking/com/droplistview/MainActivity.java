package it.oztaking.com.droplistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et_input;
    private ListView listView;
    private ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        et_input = (EditText) findViewById(R.id.et_input);
        findViewById(R.id.ib_dropdown).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        showPopupWindow();
    }

    private void showPopupWindow() {
        initListView();
        //显示下拉选择框
        PopupWindow popupWindow = new PopupWindow(listView, et_input.getWidth(), 300);
        //显示在指定的控件下
        popupWindow.showAsDropDown(et_input,0,-5);
    }

    //初始化要显示的内容
    private void initListView() {
        listView = new ListView(this);
        //去掉分割线
        listView.setDividerHeight(0);
        listView.setBackgroundResource(R.drawable.listview_background);
        datas = new ArrayList<String>();
        //创建一些数据
        for (int i=0; i<30; i++){
            datas.add((1000+i)+"");
        }
        listView.setAdapter(new MyAdapter());

    }


    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            //view 复用
            if (convertView ==  null){
                view = View.inflate(parent.getContext(),R.layout.item_number_qq,null);
            }else {
                view = convertView;
            }

            //设置内容
            TextView tv_number_qq = (TextView) view.findViewById(R.id.tv_number_qq);
            tv_number_qq.setText(datas.get(position));
            return view;
        }
    }
}
