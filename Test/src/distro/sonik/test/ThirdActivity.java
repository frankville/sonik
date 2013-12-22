package distro.sonik.test;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.distro.test.R;

import distro.sonik.test.Fragmento1.OnShowFragment2TappedListener;

public class ThirdActivity extends ActionBarActivity implements OnShowFragment2TappedListener {
	public static String MESSAGE = "distro.sonik.test.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.third_activity);
		// Show the Up button in the action bar.
		setupActionBar();
		if(findViewById(R.id.fragsContainer) != null ){ 
			/* esto es mas importante que la merdd! si tenes dos fragment containers
				para pantallas grandes y chicas entonces aca se decide si se cargan los
				fragmentos a mano (como el metodo addFragmentsToActivity() ) para pantallas chicas
				o si los fragmentos se cargan automaticamente (pantallas grandes como la tab)
			*/
			 addFragmentsToActivity();
		}
	
	}
	
	private void addFragmentsToActivity(){
			
			Fragmento1 firstFrag = new Fragmento1();
			
			Bundle args = getIntent().getExtras();
			firstFrag.setArguments(args);
			getSupportFragmentManager().beginTransaction().add(R.id.fragsContainer, firstFrag).commit();
		}
	
	
	 @Override
	 public void onStart(){
		 super.onStart();
		
	 }
	

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void showFragmento2(View v) {
		Fragmento2 frag2 = (Fragmento2)getSupportFragmentManager().findFragmentById(R.id.fragmento2);
		TextView txt = (TextView)findViewById(R.id.frag1MsgView);
		String msg = txt.getText().toString();
		if(frag2 != null){
			//el frag esta visible y solo hay que actualizar su contenido
			String s = "El fragmento 2 ya esta visible. Estas en una pantalla large madafakah!!";
			
			frag2.setMessageForFragment(s+msg);

		}else{
			Fragmento2 nvoFrag2 = new Fragmento2();
			FragmentTransaction transact = getSupportFragmentManager().beginTransaction();
			Bundle argums = new Bundle();
			argums.putString(Fragmento2.MESSAGE, msg);
			System.out.println("Entra en el esle");
			nvoFrag2.setArguments(argums);
			
			transact.replace(R.id.fragsContainer, nvoFrag2);
			transact.addToBackStack(null);
			transact.commit();
			
			
		}
		
	}


}
