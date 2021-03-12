package pollub.ism.lab02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView poleTekstowe = null;
    private EditText poleEdycyjne = null;
    private Button przycisk1 = null, przycisk2 = null, przycisk3 = null;

    private int licznikCreate = 0, licznikStart = 0, licznikResume = 0, licznikPause = 0,
            licznikStop = 0, licznikRestart = 0, licznikDestroy = 0;

    private static String KEY_CREATE = "Wartosc licznika create",
            KEY_START = "Wartosc licznika start",
            KEY_RESUME = "Wartosc licznika resume",
            KEY_PAUSE = "Wartosc licznika pause",
            KEY_STOP = "Wartosc licznika stop",
            KEY_RESTART = "Wartosc licznika restart",
            KEY_DESTROY = "Wartosc licznika destroy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poleTekstowe = (TextView) findViewById(R.id.textView2);
        poleEdycyjne = (EditText) findViewById(R.id.editText);
        przycisk1 = (Button) findViewById(R.id.button1);
        przycisk2 = (Button) findViewById(R.id.button2);
        przycisk3 = (Button) findViewById(R.id.button3);

        poleEdycyjne.setEnabled(false);
        przycisk2.setText(getResources().getString(R.string.odblokuj));

        powiedzCoWykonujesz("onCreate");
        licznikCreate += 1;
    }

    private void powiedzCoWykonujesz(String info) {
        poleTekstowe.setText(info);
        poleEdycyjne.append(info + "\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        powiedzCoWykonujesz("onStart");
        licznikStart += 1;
    }

    @Override
    protected void onResume() {
        super.onResume();
        powiedzCoWykonujesz("onResume");
        licznikResume += 1;
    }

    @Override
    protected void onPause() {
        super.onPause();
        powiedzCoWykonujesz("onPause");
        licznikPause += 1;
    }

    @Override
    protected void onStop() {
        super.onStop();
        powiedzCoWykonujesz("onStop");
        licznikStop += 1;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        powiedzCoWykonujesz("onRestart");
        licznikRestart += 1;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        powiedzCoWykonujesz("onDestroy");
        licznikDestroy += 1;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CREATE, licznikCreate);
        outState.putInt(KEY_START, licznikStart);
        outState.putInt(KEY_RESUME, licznikResume);
        outState.putInt(KEY_PAUSE, licznikPause);
        outState.putInt(KEY_STOP, licznikStop);
        outState.putInt(KEY_RESTART, licznikRestart);
        outState.putInt(KEY_DESTROY, licznikDestroy);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        licznikCreate = savedInstanceState.getInt(KEY_CREATE, 0);
        licznikStart = savedInstanceState.getInt(KEY_START, 0);
        licznikResume = savedInstanceState.getInt(KEY_RESUME, 0);
        licznikPause = savedInstanceState.getInt(KEY_PAUSE, 0);
        licznikStop = savedInstanceState.getInt(KEY_STOP, 0);
        licznikRestart = savedInstanceState.getInt(KEY_RESTART, 0);
        licznikDestroy = savedInstanceState.getInt(KEY_DESTROY, 0);
    }

    public void wyczyscPoleEdycyjne(View view) {
        poleEdycyjne.setText("");
    }

    public void zablokujOdblokujPoleEdycyjne(View view) {
        poleEdycyjne.setEnabled(!poleEdycyjne.isEnabled());
        if (poleEdycyjne.isEnabled()) przycisk2.setText(getResources().getString(R.string.zablokuj));
        else przycisk2.setText(getResources().getString(R.string.odblokuj));
    }

    public void wyswietlZmienne(View view) {
        String info = "create=" + licznikCreate +
                " start=" + licznikStart +
                " resume=" + licznikResume +
                "\npause=" + licznikPause +
                " stop=" + licznikStop +
                " restart=" + licznikRestart +
                "\ndestroy=" + licznikDestroy;

        poleEdycyjne.append(info+"\n");
    }


}