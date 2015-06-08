package ui.kale.bottomtabbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import kale.ui.view.BottomTab;
import kale.kale.bottomtab.BottomTabImpl;
import kale.ui.view.BottomTabGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomTabGroup root = (BottomTabGroup) findViewById(R.id.bottom_bar_root);
        
        BottomTab tab01 = (BottomTab) root.getChildAt(0);
        BottomTab tab02 = (BottomTab) root.getChildAt(1);
        BottomTab tab03 = (BottomTab) root.getChildAt(2);
        BottomTab tab04 = (BottomTab) root.getChildAt(3);

        tab01.getMsgTv().setBackgroundResource(R.drawable.red_hint);
        tab01.setMsgText("99+");
        tab01.getMsgTv().setTextColor(0xffffffff);

        tab02.getMsgTv().setBackgroundResource(R.drawable.red_hint);
        tab02.getMsgTv().setTextSize(6);
        
        tab03.setMsgText(1314520);
        
        tab04.setTabDrawable(R.drawable.abc_btn_check_material)
        .setTabText("自定义")
        .setMsgText(520);

        tab01.setChecked(true);
        tab01.setOnCheckedChangeListener(new BottomTabImpl.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(BottomTabImpl buttonView, boolean isChecked) {
                Log.d("tab", "tab01" + isChecked);
            }
        });

        tab02.setOnCheckedChangeListener(new BottomTabImpl.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(BottomTabImpl buttonView, boolean isChecked) {
                Log.d("tab", "tab02" + isChecked);
            }
        });

        tab03.setOnCheckedChangeListener(new BottomTabImpl.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(BottomTabImpl buttonView, boolean isChecked) {
                Log.d("tab", "tab03" + isChecked);
            }
        });
        tab04.setOnCheckedChangeListener(new BottomTabImpl.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(BottomTabImpl buttonView, boolean isChecked) {
                Log.d("tab", "tab04" + isChecked);
            }
        });

        root.setOnCheckedChangeListener(new BottomTabGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(BottomTabGroup root, int checkedId) {

                switch (checkedId) {
                    case R.id.tab_01:
                        Toast.makeText(getBaseContext(), "第1个", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab_02:
                        Toast.makeText(getBaseContext(), "第2个", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab_03:
                        Toast.makeText(getBaseContext(), "第3个", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab_04:
                        Toast.makeText(getBaseContext(), "第4个", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

}
