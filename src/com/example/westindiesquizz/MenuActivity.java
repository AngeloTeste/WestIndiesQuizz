package com.example.westindiesquizz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {
	
	private Button mButtonConnexion ;
	private Button mButtonTutoriel;
	private Button mButtonJouer;
	private Button mButtonScores;
	
	@Override
	protected void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		mButtonTutoriel = (Button)findViewById(R.id.buttonTutoriel);
		mButtonTutoriel.setOnClickListener( new View.OnClickListener(){
		
		@Override
		public void onClick (View v1) {
			Intent i1= new Intent(MenuActivity.this , FirstActivity.class );
			startActivity(i1);
			
		}
		
		
	});
		
	mButtonJouer = (Button)findViewById(R.id.buttonJouer);
	mButtonJouer.setOnClickListener( new View.OnClickListener(){
		
		@Override
		public void onClick (View v2) {
			Intent i2 = new Intent(MenuActivity.this , MainActivity.class );
			startActivity(i2);
			
		}
	});
	}

}
