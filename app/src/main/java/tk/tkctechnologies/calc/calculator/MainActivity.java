package tk.tkctechnologies.calc.calculator;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2, mem_tv;
    String prevR = "0";
    String val;
    String lastVal = "";
    DrawerLayout drawerLayout;
    RelativeLayout relativeL;
    LinearLayout sclinearLayout;
    ArrayList<String> equations = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.draw);
        relativeL = (RelativeLayout) findViewById(R.id.leftDrawer);
        sclinearLayout = (LinearLayout) findViewById(R.id.sc);
        setSupportActionBar(toolbar);
        toolbar.setTitle("HyperCalco");
//        getSupportActionBar()
//        toolbar.setMenu(new MenuBuilder(this));
//        Toolbar toolbar = getSupp
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        mem_tv = (TextView) findViewById(R.id.mem_tv);
        Button mem_btn = (Button) findViewById(R.id.mem_btn);
        mem_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(justCalculated){
                tv1.setText(mem);
                }
                else{
                    tv1.append(mem);
                }
                return false;
            }
        });
        TextView cosTextView =
                (TextView) findViewById(R.id.cos);
//        cos TextView
        cosTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (!tv2.getText().toString().isEmpty()) {
                    tv2.setText(String.valueOf(Math.acos(Double.parseDouble(tv2.getText().toString()))));
                } else if (!tv1.getText().toString().isEmpty()) {
                    calc(view);
                    tv2.setText(String.valueOf(Math.acos(Double.parseDouble(tv2.getText().toString()))));
                }
                return false;
            }
        });

        TextView sinTextView = (TextView) findViewById(R.id.sin);
        //sin TextView
        sinTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (!tv2.getText().toString().isEmpty()) {
                    tv2.setText(String.valueOf(Math.asin(Double.parseDouble(tv2.getText().toString()))));
                } else if (!tv1.getText().toString().isEmpty()) {
                    calc(view);
                    tv2.setText(String.valueOf(Math.asin(Double.parseDouble(tv2.getText().toString()))));
                }
                return false;
            }
        });


//        tan TextView
        TextView tanTextView = (TextView) findViewById(R.id.tan);
        tanTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (!tv2.getText().toString().isEmpty()) {
                    tv2.setText(String.valueOf(Math.atan(Double.parseDouble(tv2.getText().toString()))));
                } else if (!tv1.getText().toString().isEmpty()) {
                    calc(view);
                    tv2.setText(String.valueOf(Math.atan(Double.parseDouble(tv2.getText().toString()))));
                }
                return false;
            }
        });

//        exp
        TextView expTextView = (TextView) findViewById(R.id.exp);
        expTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return false;
            }
        });
        TextView ex = (TextView) findViewById(R.id.ex);
        ex.setText(Html.fromHtml("e<sup>x</sup>"));
        final TextView x3 = (TextView) findViewById(R.id.x3);
        x3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                x3p(x3);
                return false;
            }
        });
        x3.setText(Html.fromHtml("x<sup>3</sup>"));
        final TextView x2 = (TextView) findViewById(R.id.x2);
        x2.setText(Html.fromHtml("x<sup>2</sup>"));
        x2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                x2p(x2);
                return false;
            }
        });
        TextView sqrtX = (TextView) findViewById(R.id.sqrtX);
        sqrtX.setText(Html.fromHtml("&#8730;x"));
        TextView cubertX = (TextView) findViewById(R.id.cubertX);
        cubertX.setText(Html.fromHtml("&#8731;x"));
        final TextView tenX = (TextView) findViewById(R.id.tenX);
        tenX.setText(Html.fromHtml("10<sup>x</sup>"));
        tenX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenX(tenX);
            }
        });
        final TextView oneX = (TextView) findViewById(R.id.onex);
        oneX.setText(Html.fromHtml("x<sup>-1</sup>"));
        oneX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one2X(view);
            }
        });

    }

    public void squareroot(View view) {
        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());
            if (r < 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.sqrt(r)));
            }
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());
            if (r < 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.sqrt(r)));
            }
        }
    }

    public void cuberoot(View view) {
        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());
            if (r < 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.cbrt(r)));
            }
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());
            if (r < 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.cbrt(r)));
            }
        }
    }
    public void one2X(View view) {
        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());
            if (r == 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf((1/r)));
            }
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());
            if (r == 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf((1/r)));
            }
        }
    }
    public void oneX(View view) {
        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());
            if (r == 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.pow(10, r)));
            }
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());
            if (r == 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.pow(10, r)));
            }
        }
    }

    public void tenX(View view) {
        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());

            tv2.setText(String.valueOf(Math.pow(10, r)));

        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());

            tv2.setText(String.valueOf(Math.pow(10, r)));

        }
    }

    public void x2p(View view) {

        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());
            if (r == 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.pow(r, -2)));
            }
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());
            if (r == 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.pow(r, -2)));
            }
        }
    }

    public void x3p(View view) {

        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());
            if (r == 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.pow(r, -3)));
            }
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());
            if (r == 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.pow(r, -3)));
            }
        }
    }

    public void x2(View view) {

        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());

            tv2.setText(String.valueOf(Math.pow(r, 2)));

        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());

            tv2.setText(String.valueOf(Math.pow(r, 2)));

        }
    }

    public void x3(View view) {
        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());

            tv2.setText(String.valueOf(Math.pow(r, 3)));

        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());

            tv2.setText(String.valueOf(Math.pow(r, 3)));

        }
    }

    public void e(View view) {
        tv1.append(Math.E + "");
    }

    public void ln(View view) {

        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());
            if (r <= 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.log(r)));
            }
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());
            if (r <= 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.log(r)));
            }
        }
    }

    public void log(View view) {

        if (!tv2.getText().toString().isEmpty()) {
            double r = Double.parseDouble(tv2.getText().toString());
            if (r <= 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.log10(r)));
            }
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(view);
            double r = Double.parseDouble(tv2.getText().toString());
            if (r <= 0) {
                Toast.makeText(MainActivity.this, "NaN", Toast.LENGTH_SHORT).show();
            } else {
                tv2.setText(String.valueOf(Math.log10(r)));
            }
        }
    }

    public void btnCl(View v) {
        Button button = (Button) v;
        if (justCalculated){
            tv1.setText(button.getText());
            justCalculated=false;
        }
        else{
            tv1.append(button.getText());
        }
     /*   String text = button.getText().toString();
        if(text.equals("*") || text.equals("+") || text.equals("/") || text.equals("-")){
            val = prevR+""+button.getText();
        }
        else{
            lastVal = text;
            calc(v);
        }*/
    }

    public void btnClear(View v) {
        tv1.setText("");
        tv2.setText("");
        containsStartBracket = false;

    }

    public void sin(View v) {
        if (!tv2.getText().toString().isEmpty()) {
            tv2.setText(String.valueOf(Math.sin(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(v);
            tv2.setText(String.valueOf(Math.sin(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        }
    }

    public void cos(View v) {
        if (!tv2.getText().toString().isEmpty()) {
            tv2.setText(String.valueOf(Math.cosh(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(v);
            tv2.setText(String.valueOf(Math.cos(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        }
    }

    public void tan(View v) {
        if (!tv2.getText().toString().isEmpty()) {
            tv2.setText(String.valueOf(Math.tan(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(v);
            tv2.setText(String.valueOf(Math.tan(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        }
    }

    public void sinh(View v) {
        if (!tv2.getText().toString().isEmpty()) {
            tv2.setText(String.valueOf(Math.sinh(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(v);
            tv2.setText(String.valueOf(Math.sinh(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        }
    }

    public void cosh(View v) {
        if (!tv2.getText().toString().isEmpty()) {
            tv2.setText(String.valueOf(Math.cosh(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(v);
            tv2.setText(String.valueOf(Math.cosh(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        }
    }

    public void tanh(View v) {
        if (!tv2.getText().toString().isEmpty()) {
            tv2.setText(String.valueOf(Math.tanh(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        } else if (!tv1.getText().toString().isEmpty()) {
            calc(v);
            tv2.setText(String.valueOf(Math.tanh(calcAngle(Double.parseDouble(tv2.getText().toString())))));
        }
    }

    boolean justCalculated = false;

    public void calc(View v) {
        if (!tv1.getText().toString().isEmpty()) {
            try {
                tv2.setText(String.valueOf(StringManager.evaluate(tv1.getText().toString())));
                equations.add(tv1.getText().toString());
                justCalculated = true;
            } catch (Exception e) {
                tv2.setText("0.0");
            }
        }
    }

    public void sc(View v) {
        if (sclinearLayout.getVisibility() == View.GONE)
            sclinearLayout.setVisibility(View.VISIBLE);
        else
            sclinearLayout.setVisibility(View.GONE);
    }

    public void btnBack(View v) {
        if (!tv1.getText().toString().isEmpty()) {
            String text = tv1.getText().toString();
            if (text.length() > 1) {
                tv1.setText(text.substring(0, text.length() - 1));
                if (text.charAt(text.length() - 1) == ')') {
                    containsStartBracket = true;
                } else {
                    containsStartBracket = false;
                }
            } else {
                tv1.setText("");
                containsStartBracket = false;
            }
        }
    }
 /*   public void calc(View v) {
        Log.i("hello", tv1.getText().toString() + " is val sent to ");
//    tv2.setText(String.valueOf(StringManager.evaluate(tv1.getText().toString())));

        String text = val+lastVal;
        Toast.makeText(this, ""+text, Toast.LENGTH_SHORT).show();
        Double one, two;
        if (text.contains("*")) {
            String[] strings = text.split("[*]");
            try {
                one = Double.parseDouble(strings[0]);
                two = Double.parseDouble(strings[1]);
                tv2.setText("" + (one * two));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                Toast.makeText(this, "Please input correctly", Toast.LENGTH_SHORT).show();
//                Snackar.make(v, "Please input correctly", Snackbar.LENGTH_SHORT).show();
                return;
            }
        }
        if (text.contains("+")) {
            String[] strings = text.split("[+]");
            try {
                one = Double.parseDouble(strings[0]);
                two = Double.parseDouble(strings[1]);
                tv2.setText("" + (one + two));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                Toast.makeText(this, "Please input correctly", Toast.LENGTH_SHORT).show();
//                Snackbar.make(v, "Please input correctly", Snackbar.LENGTH_SHORT).show();
                return;
            }
        }
        if (text.contains("-")) {
            String[] strings = text.split("-");
            try {
                one = Double.parseDouble(strings[0]);
                two = Double.parseDouble(strings[1]);
                tv2.setText("" + (one - two));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                Toast.makeText(this, "Please input correctly", Toast.LENGTH_SHORT).show();
//                Snackbar.make(v, "Please input correctly", Snackbar.LENGTH_SHORT).show();
                return;
            }
        }
        if (text.contains("/")) {
            String[] strings = text.split("/");
            try {
                one = Double.parseDouble(strings[0]);
                two = Double.parseDouble(strings[1]);
                if (two != 0)
                    tv2.setText("" + (one / two));
                else
                    throw new Exception("NumberFormation");
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Please input correctly", Toast.LENGTH_SHORT).show();
//                Snackbar.make(v, "Please input correctly", Snackbar.LENGTH_SHORT).show();
                return;
            }
        }
        if(!tv2.getText().toString().isEmpty()){
            prevR =tv2.getText().toString();
        }

    *//*    if(v.getId() == R.id.button22){
            tv1.setText("");
        }*//*
    }*/
int currentIndex=0;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.up:
                if(currentIndex < equations.size() -1  && !equations.isEmpty()){
                    currentIndex++;
                    tv1.setText(equations.get(currentIndex));

                }
            break;
            case R.id.down:
                if(currentIndex > 0 && !equations.isEmpty()){
                    currentIndex--;
                    tv1.setText(equations.get(currentIndex));
                }
                break;
            case R.id.drawer:
                if (sclinearLayout.getVisibility() == View.GONE)
                    sclinearLayout.setVisibility(View.VISIBLE);
                else
                    sclinearLayout.setVisibility(View.GONE);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    boolean containsStartBracket = false;

    public void bracket(View v) {
        if (!containsStartBracket) {
            tv1.append("(");
            containsStartBracket = true;
        } else {
            tv1.append(")");
            containsStartBracket = false;
        }
    }

    String mem = "";

    public void memory(View v) {
        if (mem.equals("") && !tv2.getText().toString().isEmpty()) {
            mem_tv.setText("M");
            mem = tv2.getText().toString();
        } else {
            mem = "";
            mem_tv.setText("");
        }
    }

    public Double calcAngle(double dble) {
        return dble * (Math.PI / 180);
    }
}
