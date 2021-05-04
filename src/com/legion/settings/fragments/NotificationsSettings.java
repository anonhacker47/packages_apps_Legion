package com.legion.settings.fragments;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;
import androidx.preference.PreferenceScreen;
import androidx.preference.Preference.OnPreferenceChangeListener;

import com.android.internal.logging.nano.MetricsProto;

import android.content.Context;
import android.content.ContentResolver;
import android.os.UserHandle;
import android.provider.Settings;
import android.os.Bundle;
import android.widget.Toast;
import com.android.settings.R;

import com.android.settings.SettingsPreferenceFragment;
import net.margaritov.preference.colorpicker.ColorPickerPreference;
import com.legion.settings.preferences.CustomSeekBarPreference;
import com.legion.settings.preferences.SystemSettingSeekBarPreference;

public class NotificationsSettings extends SettingsPreferenceFragment
                         implements OnPreferenceChangeListener {

    private Preference mChargingLeds;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getActivity().getActionBar();

        ContentResolver resolver = getActivity().getContentResolver();
        addPreferencesFromResource(R.xml.legion_settings_notifications);

        PreferenceScreen prefScreen = getPreferenceScreen();
        mChargingLeds = (Preference) findPreference("charging_light");
        if (mChargingLeds != null
                && !getResources().getBoolean(
                        com.android.internal.R.bool.config_intrusiveBatteryLed)) {
            prefScreen.removePreference(mChargingLeds);
        }
    }

    public boolean onPreferenceChange(Preference preference, Object newValue) {
         ContentResolver resolver = getActivity().getContentResolver();

        return false;
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.LEGION_SETTINGS;
    }
}

