package com.example.ex06_dialog1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = (Button) findViewById(R.id.button1);

        boolean []checked1 = {false, false, false};
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.다이얼로그 만들기
                //2.다이얼러고 옵션 설정(아이콘, 타이틀, "내용", 버튼(ok, 취소)

                String []fruit = {"사과","딸기","포도"};
//                boolean []checked1 = {false, false, false};

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목");
                dlg.setIcon(R.mipmap.ic_launcher);
//                dlg.setMessage("내용이지~!");
//                dlg.setItems(fruit, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int position) {
//                        Toast.makeText(getApplicationContext(), fruit[position] +" 클릭했음!", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dlg.setSingleChoiceItems(fruit,1,null);
                dlg.setMultiChoiceItems(fruit, checked1, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean b) {

                        String str1 = "";
                        int cnt = 0;

                        for(int i=0; i<fruit.length;++i)//배열을 돌면서
                        {
                            if(checked1[i])//만약에 체크가 되어있으면
                            {
                                cnt++;

                                if(cnt == 1)//첫번째 이면
                                    str1 = fruit[i]; //쉼표 없음
                                else
                                    str1 = str1 + "," + fruit[i];


                            }
                        }

                        button1.setText(str1);

//                        button1.setText(fruit[position]);
                    }
                });



                dlg.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "확인눌렀음!", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setPositiveButton("취소",null);


                dlg.show();
            }
        });
    }
}
