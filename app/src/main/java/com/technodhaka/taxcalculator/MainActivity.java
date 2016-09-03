package com.technodhaka.taxcalculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText edt_basic_sal, edt_house_rent,edt_conv,edt_medical,edt_fest_bonus;
    TextView text_total, text_Tax;
    Button btnSum, btnClear;
    Spinner spOperationSelection;
    String strOperationMode;
    Context mContext = MainActivity.this;
    String TAG = MainActivity.class.getSimpleName();


    CalTax ct;

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
                text_total.setText(String.valueOf(sumTotal()));
                taxCalculation();
                ct = new CalTax(MainActivity.this);

                ct.calculateTaxCom("av",null);
                //calculateTax();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_basic_sal.setText("");
                edt_house_rent.setText("");
                edt_conv.setText("");
                edt_medical.setText("");
                edt_fest_bonus.setText("");
                text_total.setText("");
                text_Tax.setText("");
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mContext,R.array.operation_Mode,R.layout.spinner_layout);
        spOperationSelection.setAdapter(adapter);
        if(strOperationMode!=null)
        {
            spOperationSelection.setSelection(getSpinnerIndex(spOperationSelection, strOperationMode));
        }
        spOperationSelection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strOperationMode = parent.getItemAtPosition(position).toString();

                if(strOperationMode.equals("Male"))
                {
                    //TODO:
                }
                else if(strOperationMode.equals("Female"))
                {
                    //TODO:
                }
                else if(strOperationMode.equals("65Y+Male"))
                {
                    //TODO:
                }
                else if(strOperationMode.equals("65Y+Female"))
                {
                    //TODO:
                }
                else if(strOperationMode.equals("Business"))
                {
                    //TODO:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
        text_total =(TextView) findViewById(R.id.text_total_sal);
        text_Tax =(TextView)findViewById(R.id.text_total_tax);
        btnSum = (Button)findViewById(R.id.btnCount);
        btnClear =(Button)findViewById(R.id.btnClear);
        spOperationSelection =(Spinner)findViewById(R.id.spOperationOption);
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
            //TODO
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
        return intTotal*12;
    }

    private int calculateBaseSal(int intBasicSal)
    {
        int baseSalary = 0;
        baseSalary = intBasicSal*12;
        return baseSalary;
    }

    private void taxCalculation()
    {

        double tax  = 0;
        int index   = calculateBaseSal(intBasicSal) ;
        int onFirst = 220000;
        int next1   = 300000 ;
        int next2   = 400000 ;
        int next3   = 500000;
        int next4   = 3000000 ;
        int rest    = 3000001;

        if(index >0 && index<onFirst)
        {
            Toast.makeText(MainActivity.this, "TAX: Nil", Toast.LENGTH_SHORT).show();
            text_Tax.setText("Nil");
        }
        else if(index>=onFirst && index<next1)
        {
            Toast.makeText(MainActivity.this, "TAX: Nil", Toast.LENGTH_SHORT).show();
            text_Tax.setText("Nil");
        }
        else if(index>=next1 && index<next2)
        {
            tax = (double)((index*10)/100);
            Toast.makeText(MainActivity.this, "TAX:"+tax, Toast.LENGTH_SHORT).show();
            text_Tax.setText(String.valueOf(tax));
        }
        else if(index>=next2 && index<next3)
        {
            tax = (double)((index*15)/100);
            Toast.makeText(MainActivity.this, "TAX:"+tax, Toast.LENGTH_SHORT).show();
            text_Tax.setText(String.valueOf(tax));
        }
        else if(index >= next3 && index<next4)
        {
            tax = (double)((index*20)/100);
            Toast.makeText(MainActivity.this, "TAX:"+tax, Toast.LENGTH_SHORT).show();
            text_Tax.setText(String.valueOf(tax));
        }
        else if(index>=next4 && index<rest )
        {
            tax = (double)((index*25)/100);
            Toast.makeText(MainActivity.this, "TAX:"+tax, Toast.LENGTH_SHORT).show();
            text_Tax.setText(String.valueOf(tax));
        }
        else if(index>=rest )
        {
            tax = (double)((index*30)/100);
            Toast.makeText(MainActivity.this, "TAX:"+tax, Toast.LENGTH_SHORT).show();
            text_Tax.setText(String.valueOf(tax));
        }
    }

    protected int getSpinnerIndex(Spinner spinner, String myString) {

        int index = 0;

        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(myString)) {
                index = i;
            }
        }
        return index;
    }

}
