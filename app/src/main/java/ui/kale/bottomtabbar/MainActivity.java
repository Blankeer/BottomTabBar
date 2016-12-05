package ui.kale.bottomtabbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import kale.ui.view.BottomTab;
import kale.kale.bottomtab.BottomTabImpl;
import kale.ui.view.BottomTabGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BottomTabGroup root = (BottomTabGroup) findViewById(R.id.bottom_bar_root);

        BottomTab tab02 = (BottomTab) root.getChildAt(1);
        BottomTab tab03 = (BottomTab) root.getChildAt(2);


        BottomTab tab01 = (BottomTab) root.getChildAt(0);
        tab01.getHint().setBackgroundResource(R.drawable.red_hint); // 设置提示红点的背景
        tab01.setHint("99+"); // 设置提示红点上的文字
        tab01.getHint().setTextColor(0xffffffff); // 设置提示红点上文字的颜色

        tab02.getHint().setBackgroundResource(R.drawable.red_hint);
        tab02.getHint().setTextSize(6);

        tab03.setHint(1314520);

        BottomTab tab04 = (BottomTab) root.getChildAt(3);
        tab04.setTabDrawable(R.drawable.abc_btn_check_material) // 设置按钮的图片
                .setTabText("自定义") // 设置按钮下面的文字
                .setHint(520); // 设置提示红点部分的文字

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
            public void onCheckedChanged(BottomTabGroup root, int checkedId, int position) {

                Toast.makeText(getBaseContext(), "第" + position + "个", Toast.LENGTH_SHORT).show();
            }
        });
        Button bu = (Button) findViewById(R.id.test_click);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.checkByPosition((root.getCheckedPosition() + 1) % root.getChildCount());
            }
        });
    }

}
