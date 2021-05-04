/*
 *  Copyright (C) 2015 The OmniROM Project
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.legion.settings.fragments;

import com.android.internal.logging.nano.MetricsProto;

import android.app.Activity;
import android.content.Context;
import android.content.ContentResolver;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;
import androidx.preference.PreferenceScreen;
import androidx.preference.Preference.OnPreferenceChangeListener;
import android.provider.Settings;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import com.legion.settings.preferences.CustomSeekBarPreference;
import com.legion.settings.preferences.SystemSettingSwitchPreference;
import com.legion.settings.preferences.SystemSettingSeekBarPreference;
import com.legion.settings.preferences.SecureSettingListPreference;

public class LockScreenSettings extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String FOD_ICON_PICKER_CATEGORY = "fod_icon_picker_category";

    private Preference mFODIconPicker;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getActivity().getActionBar();
        addPreferencesFromResource(R.xml.legion_settings_lockscreen);

        ContentResolver resolver = getActivity().getContentResolver();
        final PreferenceScreen prefScreen = getPreferenceScreen();
        Resources resources = getResources();

        mFODIconPicker = (Preference) findPreference(FOD_ICON_PICKER_CATEGORY);
        if (mFODIconPicker != null
                && !getResources().getBoolean(com.android.internal.R.bool.config_needCustomFODView)) {
            prefScreen.removePreference(mFODIconPicker);
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

