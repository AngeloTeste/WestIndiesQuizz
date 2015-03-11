package com.example.westindiesquizz;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private TextView mQuestion;
	private static TextView mScore;
	private Button btnA;
	private Button btnB;
	private Button btnC;
	private Button btnD;
	
	private Button btnR;
	int listeDeQuestion [];
	ArrayList<Integer> listedequestion =new ArrayList<Integer>();//déclaration de la liste des questions
	int numero_question = (int) (Math.random() * 19) + 1;  // choisit un nombre entre 1 et 4  
	String id_a;
	String id_b;
	String id_c;
	String id_d;
	String id_question;
	//String id_r;
	
	public static int nbCorrect  = 0 ;
	
	
	public void RecupQuestion(){
		
		boolean j = true; // la première fois on a besoin qu'il soit vrai pour lancer la boucle
		while(j){
		    j = false;  // on part du principe que le numéro est pas encore tombé
		    for(int i = 0; i < listedequestion.size(); i++)  // on scanne la liste
		    {
		        if(listedequestion.get(i) == numero_question)  // si le numéro a la position i est = à aleat 
		            j = true;   // le nombre est déja dans la liste
		    }
		    if(j) // le nombre est dans la liste donc on doit en choisir un autre
		        numero_question = (int) (Math.random() * 19) + 1;
		} listedequestion.add(numero_question);//ajout le numero à la liste.
		
		
		 id_a ="a" + numero_question;
		 id_b ="b"+numero_question;
		 id_c ="c"+numero_question;
		 id_d ="d"+numero_question;
		// id_r="a"+numero_question;

		 id_question = "q" + numero_question;
		//String id_a ="a" + numero_question;
		//String id_r="r" + numero_question;//rajout pour donner la bonne réponse
		
		String q = getResources().getString(getResources().getIdentifier(id_question,"string", "com.example.westindiesquizz"));
		String a = getResources().getString(getResources().getIdentifier(id_a,"string", "com.example.westindiesquizz"));
		String c = getResources().getString(getResources().getIdentifier(id_c,"string", "com.example.westindiesquizz"));
		String d = getResources().getString(getResources().getIdentifier(id_d,"string", "com.example.westindiesquizz"));
		//String r = getResources().getString(getResources().getIdentifier(id_r,"string","com.example.westindiesquizz"));
		String b = getResources().getString(getResources().getIdentifier(id_b,"string","com.example.westindiesquizz"));
		
		int numero_layout = (int) (Math.random() * 4) + 1;  // choisit un nombre entre 1 et 4
		if (numero_layout == 1){
			
			
			 btnA = (Button)findViewById(R.id.a);
			 btnB = (Button)findViewById(R.id.b);
			 btnC =(Button)findViewById(R.id.d);
			 btnD =(Button)findViewById(R.id.c);
			 
			} 
			
			else if (numero_layout ==3) {
				btnA = (Button)findViewById(R.id.b);
			
			 	btnB = (Button)findViewById(R.id.c);
			 	btnC =(Button)findViewById(R.id.a);
				btnD =(Button)findViewById(R.id.d);}
			
			else if (numero_layout ==4) {
				btnA = (Button)findViewById(R.id.b);
			
			 	btnB = (Button)findViewById(R.id.c);
			 	btnC =(Button)findViewById(R.id.d);
				btnD =(Button)findViewById(R.id.a);}
		
			else {
				btnA = (Button)findViewById(R.id.c);
				
			 	btnB = (Button)findViewById(R.id.a);
			 	btnC =(Button)findViewById(R.id.b);
				btnD =(Button)findViewById(R.id.d);}
			
		
		
	
		Log.d("affichervariable", "affichervariable : "+numero_layout);	
		String id_r="r"+numero_question;
		
		
		mQuestion.setText(q);
		btnA.setText(a);
		btnB.setText(b);
		btnC.setText(c);
		btnD.setText(d);
		//btnR.setText(r);
		//btnR.setText(a);
		
		
		
	
	}
	/*
	 * Méthode pour vérifier si la question est bonne 
	 *Solution possible de créer un tableau qui reprend le numero_question et qui pourra indiquer si c'est id_a, id_b,id_c id_d
	 * */
	
	public void CheckAnswer(Button BoutonAppuyer){
		String id_r="r"+numero_question;
		String h;
		
		String k = getResources().getString(getResources().getIdentifier(id_r,"string", "com.example.westindiesquizz"));
		 btnR.setText(k);
		//btnR =(Button)findViewById(R.id.a);
		
		//if (BoutonAppuyer.getText().toString().equals(k))
		if (BoutonAppuyer.equals(btnR)){
			
			 h= getResources().getString(R.string.a1);
			 nbCorrect++;
		}else{
			 h=getResources().getString(R.string.q1);
		}
		Log.d("affichervariable", "affichervariable : "+k+" / "+BoutonAppuyer.getText().toString());
		Toast.makeText(this, h, Toast.LENGTH_SHORT) .show();
		mScore = (TextView)findViewById(R.id.score);
		mScore.setText(Integer.toString(nbCorrect));
		}
	
	
	/*
	 * Méthode pour changer les Emplacements de boutons 
	 */
	public void ChangeBouton(){
		//btnR =(Button)findViewById(R.id.a);
		/*int numero_layout = (int) (Math.random() * 3) + 1;  // choisit un nombre entre 1 et 4
		if (numero_layout == 2){
			
			
			 btnA = (Button)findViewById(R.id.b);
			 btnB = (Button)findViewById(R.id.a);
			 btnC =(Button)findViewById(R.id.d);
			 btnD =(Button)findViewById(R.id.c);
			 
			} 
			
			else if (numero_layout ==3) {
				btnA = (Button)findViewById(R.id.b);
			
			 	btnB = (Button)findViewById(R.id.c);
			 	btnC =(Button)findViewById(R.id.a);
				btnD =(Button)findViewById(R.id.d);}
			
			else if (numero_layout ==4) {
				btnA = (Button)findViewById(R.id.b);
			
			 	btnB = (Button)findViewById(R.id.c);
			 	btnC =(Button)findViewById(R.id.d);
				btnD =(Button)findViewById(R.id.a);}
		
			else {
				btnA = (Button)findViewById(R.id.a);
				
			 	btnB = (Button)findViewById(R.id.c);
			 	btnC =(Button)findViewById(R.id.b);
				btnD =(Button)findViewById(R.id.d);}
			
		
		
	
		Log.d("affichervariable", "affichervariable : "+numero_layout);	*/
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quizz);
		
		mQuestion = (TextView) findViewById(R.id.question);
		
		ChangeBouton();
			
		 
		 RecupQuestion();// Pour avoir une question dès le départ
		
		btnA.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v){
				//RecupQuestion();
				//ChangeBouton();
				CheckAnswer(btnA);
				
				//ChangeBouton();
				
				RecupQuestion();
				ChangeBouton();
				
				
				
			}

		});
		
		btnB.setOnClickListener ( new View.OnClickListener() {
			@Override
			public void onClick (View v){
				//RecupQuestion();
				//ChangeBouton();
				CheckAnswer(btnB);
				//ChangeBouton();
				RecupQuestion();
				ChangeBouton();
				
				//RecupQuestion();
				
				
			}
		});
		
		btnC.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v){
				//RecupQuestion();
				//ChangeBouton();
				CheckAnswer(btnC);
				
				//ChangeBouton();
				
				RecupQuestion();
				ChangeBouton();
				
				
				
			}

		});
		
		btnD.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v){
				//RecupQuestion();
				//ChangeBouton();
				CheckAnswer(btnD);
				
				//ChangeBouton();
				
				RecupQuestion();
				ChangeBouton();
				
				
				
			}

		});
		

		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
