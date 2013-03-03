package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	public final static double TIP_PERCENTAGE = 10.0 / 100; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
    public void onCalculateClick (View view) {
    	// Retrieve views from Layout.
    	EditText edtBillAmount = (EditText) findViewById(R.id.edtBillAmount);
    	TextView txtTipResult = (TextView) findViewById(R.id.txtTipResult);
    	CheckBox chkRound = (CheckBox) findViewById(R.id.chkRound);
    	
    	// Retrieve information.
    	double bill = Float.valueOf(edtBillAmount.getText().toString());
    	boolean toRound = chkRound.isChecked();
    	
    	// Calculate and display tip.
    	double tip = bill * TIP_PERCENTAGE; 
    	String tipText = toRound ? String.format("%d", (int) Math.ceil(tip)) : String.format("%.2f", tip);
    	
    	txtTipResult.setText(getString(R.string.tip_result) + tipText);
    	
    }
}
