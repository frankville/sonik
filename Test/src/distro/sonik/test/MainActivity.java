package distro.sonik.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.distro.test.R;

public class MainActivity extends ActionBarActivity {
	public static final String EXTRA_MESSAGE = "distro.sonik.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.main, menu);
       return super.onCreateOptionsMenu(menu);
       
    }
    
    public void sendMessage(View v){
    	Intent intent = new Intent(this, SecondActivity.class);
    	EditText editField = (EditText)this.findViewById(R.id.editField);
    	String message = editField.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    
    	switch(item.getItemId()){
    	case R.id.action_bar : 
    		openSearch();
    		return true;
    	case R.id.action_settings : 
    		openSettings();
    		return true;
    	default:
    		return super.onOptionsItemSelected(item);
    		
    	}
    	
    }
    
    public void openSearch(){
    	
    }
    
    public void openSettings(){
    	
    }
    
}
