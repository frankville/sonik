package distro.sonik.test;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.distro.test.R;

public class Fragmento1 extends Fragment {

OnShowFragment2TappedListener frag2Interface;

	public interface OnShowFragment2TappedListener {
		public void showFragmento2(View v);
	}
	
	@Override
	public void onCreate(Bundle savedState){
		super.onCreate(savedState);
		Bundle args = getArguments();
		System.out.println("valor args frag 1 "+args);
		String message = args.getString(MESSAGE);
		System.out.println("Mensaje desde la 3ra actividad:"+message);
		TextView txtvw = (TextView)getActivity().findViewById(R.id.frag1MsgView);

		txtvw.setText(message);
	}
	
	public static String MESSAGE="distro.sonik.test.MESSAGE";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		return inflater.inflate(R.layout.frag1, container,false);
	
		
	}
	/*
	@Override
	public void onStart(){
		super.onStart();
		Bundle args = getActivity().getIntent().getExtras();
		
		
		
	}
	*/
	@Override
	public void onAttach(Activity act){
		super.onAttach(act);
		try{
			frag2Interface = (OnShowFragment2TappedListener)act;
		}catch(ClassCastException cce){
			cce.printStackTrace();
		}
	}
	

	

}

