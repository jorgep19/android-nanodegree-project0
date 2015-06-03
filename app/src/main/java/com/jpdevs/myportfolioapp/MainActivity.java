package com.jpdevs.myportfolioapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends ActionBarActivity {
    private static final String MSG_FORMAT = "This button will launch the %s app";
    private static final HashMap<Integer, Integer> VIEW_TO_LABEL_MAP = new HashMap<>();
    static {
        VIEW_TO_LABEL_MAP.put(R.id.spotify_btn, R.string.spotify_streamer);
        VIEW_TO_LABEL_MAP.put(R.id.scores_btn, R.string.scores_app);
        VIEW_TO_LABEL_MAP.put(R.id.library_btn, R.string.library_app);
        VIEW_TO_LABEL_MAP.put(R.id.build_it_btn, R.string.build_it_bigger);
        VIEW_TO_LABEL_MAP.put(R.id.reader_btn, R.string.xyz_reader);
        VIEW_TO_LABEL_MAP.put(R.id.capstone_btn, R.string.capstone);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void projectClicked(View view) {
        Integer stringId = VIEW_TO_LABEL_MAP.get(view.getId());
        if (stringId != null) {
            Toast toast = Toast.makeText(
                    getApplicationContext(),
                    String.format(MSG_FORMAT, getString(stringId)),
                    Toast.LENGTH_SHORT);

            View toastView = toast.getView();
            toastView.setBackgroundColor(getResources().getColor(R.color.blue_700));
            TextView text = (TextView) toastView.findViewById(android.R.id.message);
            text.setTextColor(getResources().getColor(R.color.white));
            text.setGravity(Gravity.CENTER);

            toast.show();
        }
    }
}
