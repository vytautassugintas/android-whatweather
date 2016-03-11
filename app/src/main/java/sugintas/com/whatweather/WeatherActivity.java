package sugintas.com.whatweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sugintas.com.whatweater.R;
import sugintas.com.whatweather.utils.WeatherIconPicker;

public class WeatherActivity extends AppCompatActivity {

    ImageView weatherIconImage;
    TextView cityText;
    TextView temperatureText;
    RequestQueueController requestQueueController;
    WeatherIconPicker weatherIconPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        requestQueueController = RequestQueueController.getInstance();
        weatherIconPicker = new WeatherIconPicker();

        weatherIconImage = (ImageView) findViewById(R.id.weather_icon);
        cityText = (TextView) findViewById(R.id.text_view_city);
        temperatureText = (TextView) findViewById(R.id.text_view_temp);

        requestQueueController.addToRequestQueue(weatherGetRequest("Vilnius"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_wheater, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public JsonObjectRequest weatherGetRequest(String city) {
        String jsonUrl = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&appid=27526a947237eb1d1248c29cf27111c5";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, jsonUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    temperatureText.setText(response.getJSONObject("main").getString("temp"));
                    cityText.setText(response.getString("name"));
                    JSONArray jsonArray = response.getJSONArray("weather");
                    weatherIconPicker.pickIcon(jsonArray.getJSONObject(0).getString("icon"));
                    weatherIconImage.setImageResource(weatherIconPicker.getWeatherIcon());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                cityText.setText(R.string.connection_error);
            }
        });

        return jsonObjectRequest;
    }

}
