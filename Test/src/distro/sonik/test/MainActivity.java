package distro.sonik.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.distro.test.R;
import com.distro.test.SecondActivity;

public class MainActivity extends Activity {
	public static final String EXTRA_MESSAGE = "distro.sonik.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void sendMessage(View v){
    	Intent intent = new Intent(this, SecondActivity.class);
    	EditText editField = (EditText)this.findViewById(R.id.editField);
    	String message = editField.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
}
