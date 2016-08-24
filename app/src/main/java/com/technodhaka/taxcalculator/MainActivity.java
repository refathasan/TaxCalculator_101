package com.technodhaka.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_basic_sal, edt_house_rent,edt_conv,edt_medical,edt_fest_bonus;
    TextView tex_total;
    Button btnSum;

   // String strBasicSal, strHouseRent, strConvene,strMedical,strFestBonus;
    int intBasicSal, intHouseRent, intConv, intMedical, intFestBonus, intTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewReference();
       // textChanged();
        //textConversion();
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textChanged();
                tex_total.setText(String.valueOf(sumTotal()));
                calculateTax();
            }
        });

    }

    private void viewReference()
    {
        edt_basic_sal =(EditText)findViewById(R.id.edt_basic_sal);
        edt_house_rent =(EditText)findViewById(R.id.edt_house_rent);
        edt_conv =(EditText)findViewById(R.id.edt_convence);
        edt_medical =(EditText)findViewById(R.id.edt_medical);
        edt_fest_bonus =(EditText)findViewById(R.id.edt_fest_bonus);
        tex_total =(TextView) findViewById(R.id.tex_total_sal);
        btnSum = (Button)findViewById(R.id.btnCount);
    }
    
    private void textChanged()
    {
       try
       {
           intBasicSal = Integer.parseInt(edt_basic_sal.getText().toString());
       }
       catch (NumberFormatException e)
       {
           intBasicSal = 0;
       }
        try
        {

            intHouseRent = Integer.parseInt(edt_house_rent.getText().toString());
        }
        catch (NumberFormatException e)
        {
            intHouseRent = 0;
        }
        try
        {
            intConv = Integer.parseInt(edt_conv.getText().toString());
        }
        catch (NumberFormatException e)
        {
            intConv = 0;
        }
        try
        {
            intMedical = Integer.parseInt(edt_medical.getText().toString());
        }
        catch (NumberFormatException e)
        {
            intMedical = 0;
        }
        try
        {
            intFestBonus = Integer.parseInt(edt_fest_bonus.getText().toString());
        }
        catch (NumberFormatException e)
        {
            intFestBonus = 0;
        }
    }

    private Integer sumTotal()
    {
        intTotal = (intBasicSal + intHouseRent + intConv + intMedical + intFestBonus);
        return intTotal;
    }

    private void calculateTax()
    {
        int tax;
        if(intBasicSal<=2200 && intBasicSal>300000) {
            tax = (intBasicSal * 0) / 100;
            Toast.makeText(MainActivity.this,"TAX is: "+tax, Toast.LENGTH_SHORT).show();
        }
    }


}
