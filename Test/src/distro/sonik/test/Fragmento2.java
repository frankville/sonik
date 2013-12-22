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
	
	
	@Override
	public void onStart(){
		super.onStart();
	
	}
	
	public void setMessageForFragment(String msg){
		
		TextView txtvw = (TextView)getActivity().findViewById(R.id.frag2textView);
		txtvw.setText(msg);
	}
	
}
