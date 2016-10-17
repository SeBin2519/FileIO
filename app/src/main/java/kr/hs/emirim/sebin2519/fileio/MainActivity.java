package kr.hs.emirim.sebin2519.fileio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button butOut, butIn;//참조변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butOut=(Button)findViewById(R.id.but_output);//참조값을 대입
        butIn=(Button)findViewById(R.id.but_input);//참조값을 대입
        //익명클래스로 핸들러 클래스 만들기
        butOut.setOnClickListener(new View.OnClickListener() { //상속받고
            //객체생성
            @Override
            public void onClick(View v){//파일저장하기 버튼을 누를때 호출됨(클릭- 누르고 땐다 / 터치-누르는 순간)
                try {
                    FileOutputStream out=openFileOutput("1017nsb.txt", Context.MODE_WORLD_WRITEABLE);//(저장할 파일이름, output모드) 매개변수  =>예외처리
                    //String massage="미림여자정보고 학생들이 제일 예쁘다";
                    String massage="우와오아아!";
                    out.write(massage.getBytes());
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        butIn.setOnClickListener(new View.OnClickListener() { //상속받고
            @Override
            public void onClick(View v){//파일저장하기 버튼을 누를때 호출됨(클릭- 누르고 땐다 / 터치-누르는 순간)
                try {
                    FileInputStream in=openFileInput("1017nsb.txt");
                   byte[] readMassage=new byte[200];
                    in.read(readMassage);//200바이트 만큼 읽어와
                    Toast.makeText(getApplicationContext(),new String(readMassage),Toast.LENGTH_LONG).show(); //new String(readMassage) =>string으로 변환
                    in.close();
                } catch (FileNotFoundException e) { //파일이 없을때
                    Toast.makeText(getApplicationContext(),"파일이 존재하지 않아요..(ㅠ.ㅠ)",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
