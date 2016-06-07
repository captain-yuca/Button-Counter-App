package halocode.com.buttonclickcounter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button ourButton;
    private TextView ourMessage;
    private int numTimeClicked =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ourButton = (Button) findViewById(R.id.buttonKawaii);
        ourMessage = (TextView) findViewById(R.id.textView);

        View.OnClickListener  ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numTimeClicked = numTimeClicked +1;
                String result = "Th- Th- Thank you senpai!!!!!!! '>.< \n button has been pressed " + numTimeClicked + " time";
                if(numTimeClicked != 1){
                    result += "s...";
                }
                ourMessage.setText(result);

            }
        };
        ourButton.setOnClickListener(ourOnClickListener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You are clicking in the wrong place buddy", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Toast toastMessage = Toast.makeText(this, "Text Value is now "+ ourMessage.getText(), Toast.LENGTH_LONG);
            toastMessage.show();
            numTimeClicked =0;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
