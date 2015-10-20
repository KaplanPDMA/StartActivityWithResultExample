package sg.com.kaplan.pdma.explicitintentexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends ActionBarActivity {

    TextView textViewQuestion;
    EditText editTextAnswer;
    Button buttonSubmitAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        editTextAnswer = (EditText) findViewById(R.id.editTextReply);
        buttonSubmitAnswer = (Button) findViewById(R.id.buttonSubmitAnswer);

        Bundle extras = getIntent().getExtras();

        String question = extras.getString("question");
        textViewQuestion.setText(question);

        buttonSubmitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reply = editTextAnswer.getText().toString();
                if(reply.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Answer cannot be blank",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent data = new Intent();
                data.putExtra("reply", reply);
                setResult(RESULT_OK, data);
                buttonSubmitAnswer.setEnabled(false);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
