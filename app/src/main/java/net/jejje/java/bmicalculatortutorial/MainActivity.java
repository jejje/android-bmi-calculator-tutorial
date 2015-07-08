package net.jejje.java.bmicalculatortutorial;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    // Toast needs context
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find UI elements by ID and save to variable
        final EditText height = (EditText) findViewById(R.id.height_input);
        final EditText weight = (EditText) findViewById(R.id.weight_input);
        final TextView bmi_result = (TextView) findViewById(R.id.bmi_result);
        Button button = (Button) findViewById(R.id.bmi_calc_button);



        // Listen for our click event
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Check for null
                if (height.getText().toString().length() < 1)
                {
                    sendToast("You must enter your height!");
                    // Abort the onClick if null
                    return;
                }
                if (weight.getText().toString().length() < 1)
                {
                    sendToast("You must enter your weight, sorry!");
                    // Abort the onClick if null
                    return;
                }
                // Passed the null checks, let's do some math!

                /***
                 * Android is funny this way, but you have
                 * to convert it back and forth from integer/float
                 * to strings, you'll get used to it. ;)
                 */
                // Convert height from string to float
                float h = Float.valueOf(height.getText().toString());
                float w = Float.valueOf(weight.getText().toString());

                /***
                 * Time for math!
                 * BMI is calculated
                 * (weigth in kg / (height in meter * height in meter)
                 * But since we want the user to input in CM, we just
                 * multiply it with 10 000 to get the correct value.
                 */
                float BMI = w / (h * h) * 10000;

                // Set the bmi_result view item of the value of our BMI
                bmi_result.setText(String.valueOf(BMI));
            }
        });


    }

    /***
     * This method will send the user a Toast
     * which is a small black popup that is
     * only visible for a few seconds.
     *
     * Our method takes one argument of a
     * String with the message.
     *
     * @param msg
     */
    public void sendToast(String msg)
    {
        // Get the message from our method call
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
