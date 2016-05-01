package com.example.android.applicationlifecycleexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();

    public static final String VALUE_TAG = "value";

    EditText editText;

    /**
     * Called everytime the activity is created or killed(onDestroy)-created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: ");

        editText = (EditText) findViewById(R.id.test_save_instance_edittext);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            editText.setText(savedInstanceState.getString(VALUE_TAG));
        }

        Button showDialogButton = (Button) findViewById(R.id.activity_main_show_dialog_button);

        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button showActivityButton = (Button) findViewById(R.id.activity_main_show_normal_activity_button);
        showActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });



    }

    /**
     * The activity was no visible but it now becomes on the foreground again
     * called before onStart!
     * This callback is fired only when activity was not destroyed previously
     */
    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "onRestart: ");
    }

    /**
     * Called at the start of the VISIBLE lifetime of the activity
     * here: any UI change
     */
    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart: ");
    }

    /**
     * Called after the onStart() method
     *  The system calls onRestoreInstanceState() only if there is a saved state to restore, so you do not need to check whether the Bundle is null
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState: ");
        //  // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState: restoring value");
        editText.setText(savedInstanceState.getString(VALUE_TAG));

    }

    /**
     * The activity becomes active and ready for interact with the user
     * here: any UI updates and processing
     */
    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume: ");

    }

    /**
     * The activity stills visible but not interactive with the user
     * Example: a dialog-activity becomes to the foreground
     * Here: pause UI updates
     */
    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause: ");
    }

    /**
     * The activity is no longer visible
     * Here: stops any remaining update, thread. Save all data changed if you don't want to lose the changes.
     */
    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop: ");

    }

    /**
     * Called at the end of the whole activity lifetime.
     * Here: clean-up and close any open resource
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveIn12121stanceState: ");
        if(editText.getText().toString().trim().length() > 0) {
            Log.i(TAG, "onSaveInstanceState: Saving edittextvalue");
            outState.putString(VALUE_TAG, editText.getText().toString());
        }
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }
}
