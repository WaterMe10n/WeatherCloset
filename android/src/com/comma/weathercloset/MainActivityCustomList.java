package com.example.weathercloset;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivityCustomList extends Activity {
  ListView list;
  String[] web = {
    "ABC���� ȸ������ ������ �����մϴ�.",
      "CD���� ȸ������ �ȷο��մϴ�.",
      "DE���� ȸ������ ������ �����մϴ�.",
      "DEW���� ȸ������ ������ �����մϴ�.",
      "DEW���� ȸ������ ������ ����� ������ϴ�.",
      "WER���� ȸ������ ������ �����մϴ�.",
      "ABC���� ȸ������ ������ ����� ������ϴ�."
  } ;
  Integer[] imageId = {
      R.drawable.mypagebtn,
      R.drawable.mypagebtn,
      R.drawable.mypagebtn,
      R.drawable.mypagebtn,
      R.drawable.mypagebtn,
      R.drawable.mypagebtn,
      R.drawable.mypagebtn
  };
 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_notice);
    CustomList adapter = new
        CustomList(MainActivityCustomList.this, web, imageId);
    list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Toast.makeText(MainActivityCustomList.this, " " +web[+ position], Toast.LENGTH_SHORT).show();
                }
            });
  }
}
