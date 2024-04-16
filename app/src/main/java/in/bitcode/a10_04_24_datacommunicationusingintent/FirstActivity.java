package in.bitcode.a10_04_24_datacommunicationusingintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FirstActivity extends Activity {

    TextView txtResult;
    EditText edtInfo;
    Button btnNext;
    String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initializeViews();
        initListeners();
    }

    private void initializeViews(){
        txtResult = findViewById(R.id.txtResult);
        edtInfo = findViewById(R.id.edtInfo);
        btnNext = findViewById(R.id.btnNext);
    }

    private void initListeners(){
        btnNext.setOnClickListener(new BtnNextClickListener());
    }

    class BtnNextClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(
                    FirstActivity.this,
                    SecondActivity.class
            );

            intent.putExtra("name",edtInfo.getText().toString());
            intent.putExtra("rollNumber",10);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        result = bundle.getString("result");
        txtResult.setText(result);
    }
}