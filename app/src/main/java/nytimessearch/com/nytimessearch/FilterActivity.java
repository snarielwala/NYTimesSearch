package nytimessearch.com.nytimessearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class FilterActivity extends AppCompatActivity {

    EditText etStartDate;
    EditText etSortOrder;
    CheckBox cbArts;
    CheckBox cbSports;
    CheckBox cbFashion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        etStartDate=(EditText)findViewById(R.id.etStartDate);
        etSortOrder=(EditText)findViewById(R.id.etSortOrder);
        cbArts = (CheckBox) findViewById(R.id.cbArts);
        cbSports = (CheckBox) findViewById(R.id.cbSports);
        cbFashion = (CheckBox) findViewById(R.id.cbFashion);
        Toast.makeText(this,"Select/Add one of more filters",Toast.LENGTH_LONG).show();
    }

    public void onFilterSave(View view){

        String date = etStartDate.getText().toString();
        String sortOrder=etSortOrder.getText().toString();
        boolean isArts=cbArts.isChecked();
        boolean isSports=cbSports.isChecked();
        boolean isFashion=cbFashion.isChecked();


        Intent result = new Intent();
        result.putExtra("date", date);
        result.putExtra("sort", sortOrder);
        result.putExtra("Arts", isArts);
        result.putExtra("Sports", isSports);
        result.putExtra("Fashion",isFashion);
        setResult(RESULT_OK, result);
        finish();
    }
}
