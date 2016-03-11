package sugintas.com.whatweather.utils;

import sugintas.com.whatweater.R;

/**
 * Created by vytautassugintas on 11/03/16.
 */
public class WeatherIconPicker {

    private int mWeatherIconDrawable;

    public int getWeatherIcon() {
        return mWeatherIconDrawable;
    }

    public void pickIcon(String id) {
        switch (id) {
            case "01d":
                mWeatherIconDrawable = R.drawable.ic_weather_sunny_grey600_48dp;
                break;
            case "01n":
                mWeatherIconDrawable = R.drawable.ic_weather_night_grey600_48dp;
                break;
            case "02d":
                mWeatherIconDrawable = R.drawable.ic_weather_partlycloudy_grey600_48dp;
                break;
            case "02n":
                mWeatherIconDrawable = R.drawable.ic_weather_partlycloudy_grey600_48dp;
                break;
            case "03d":
                mWeatherIconDrawable = R.drawable.ic_weather_cloudy_grey600_48dp;
                break;
            case "03n":
                mWeatherIconDrawable = R.drawable.ic_weather_cloudy_grey600_48dp;
                break;
            case "04d":
                mWeatherIconDrawable = R.drawable.ic_weather_cloudy_grey600_48dp;
                break;
            case "04n":
                mWeatherIconDrawable = R.drawable.ic_weather_cloudy_grey600_48dp;
                break;
            case "09d":
                mWeatherIconDrawable = R.drawable.ic_weather_pouring_grey600_48dp;
                break;
            case "09n":
                mWeatherIconDrawable = R.drawable.ic_weather_pouring_grey600_48dp;
                break;
            case "10d":
                mWeatherIconDrawable = R.drawable.ic_weather_rainy_grey600_48dp;
                break;
            case "10n":
                mWeatherIconDrawable = R.drawable.ic_weather_rainy_grey600_48dp;
                break;
            case "11d":
                mWeatherIconDrawable = R.drawable.ic_weather_lightning_grey600_48dp;
                break;
            case "11n":
                mWeatherIconDrawable = R.drawable.ic_weather_lightning_grey600_48dp;
                break;
            case "13d":
                mWeatherIconDrawable = R.drawable.ic_weather_snowy_grey600_48dp;
                break;
            case "13n":
                mWeatherIconDrawable = R.drawable.ic_weather_snowy_grey600_48dp;
                break;
            case "50d":
                mWeatherIconDrawable = R.drawable.ic_weather_fog_grey600_48dp;
                break;
            case "50n":
                mWeatherIconDrawable = R.drawable.ic_weather_fog_grey600_48dp;
                break;
        }
    }

}
