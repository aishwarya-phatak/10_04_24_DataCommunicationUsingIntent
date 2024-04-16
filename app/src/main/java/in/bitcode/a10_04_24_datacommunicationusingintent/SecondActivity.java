package in.bitcode.a10_04_24_datacommunicationusingintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    TextView txtInfo;
    EditText edtResult;
    Button btnBack;

    String name;
    int rollNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        extractInput();
        initListeners();
    }

    private void initViews(){
        txtInfo = findViewById(R.id.txtInfo);
        edtResult = findViewById(R.id.edtResult);
        btnBack = findViewById(R.id.btnBack);
    }

    private void extractInput(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        rollNumber = bundle.getInt("rollNumber");
        name = bundle.getString("name");
        txtInfo.setText(name + " " + rollNumber);
    }

    private void initListeners(){
        btnBack.setOnClickListener(new BtnBackClickListener());
    }

    class BtnBackClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result",edtResult.getText().toString());
            setResult(1,intent);
            finish();
        }
    }
}
