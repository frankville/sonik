package distro.sonik.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.distro.test.R;

public class Fragmento2 extends Fragment {
	public static String MESSAGE="distro.sonik.test.MESSAGE";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.frag2,container,false);
	}
	
	/*
	@Override
	public void onStart(){
		super.onStart();
		Bundle args = getArguments();
		String msg = args.getString(MESSAGE);
		TextView txtvw = (TextView)getActivity().findViewById(R.id.frag2txtView);
		txtvw.setText("Mensaje del fragmento 1 "+msg);
	}
	*/
	public void setMessageForFragment(String s){
	
		TextView txtvw = (TextView)getActivity().findViewById(R.id.frag2txtView);
		txtvw.setText(s);
	}
	
}
