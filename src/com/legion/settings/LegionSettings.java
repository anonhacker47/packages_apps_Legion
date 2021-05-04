/*
 * Copyright (C) 2020 The Pure Nexus Project
 * used for Project Streak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.legion.settings;

import com.android.internal.logging.nano.MetricsProto;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Surface;
import android.preference.Preference;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.ComponentName;
import com.google.android.material.card.MaterialCardView;

import com.android.settings.R;
import com.legion.settings.fragments.QuickSettings;
import com.legion.settings.fragments.StatusBarSettings;
import com.legion.settings.fragments.Themes;
import com.legion.settings.fragments.LockScreenSettings;
import com.legion.settings.fragments.NotificationsSettings;
import com.legion.settings.fragments.GestureSettings;
import com.legion.settings.fragments.NavigationBarSettings;
import com.legion.settings.fragments.ButtonSettings;
import com.legion.settings.fragments.PowerMenuSettings;
import com.legion.settings.fragments.AnimationSettings;
import com.legion.settings.fragments.MiscSettings;
import com.legion.settings.fragments.About;

import com.android.settings.SettingsPreferenceFragment;

public class LegionSettings extends SettingsPreferenceFragment implements View.OnClickListener {

    MaterialCardView mlegionqsCard;
    MaterialCardView mlegionstCard;
    MaterialCardView mlegionthemesCard;
    MaterialCardView mlegionlockscreenCard;
    MaterialCardView mlegionnotificationCard;
    MaterialCardView mlegiongestureCard;
    MaterialCardView mlegionnavbarCard;
    MaterialCardView mlegionbuttonCard;
    MaterialCardView mlegionpowermenuCard;
    MaterialCardView mlegionanimationCard;
    MaterialCardView mlegionmiscCard;	
	MaterialCardView mlegionaboutCard;	

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.legion_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
		    getActivity().getActionBar().hide();
                    getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);

        mlegionqsCard = (MaterialCardView) view.findViewById(R.id.legionqs_card);
        mlegionqsCard.setOnClickListener(this);

        mlegionstCard = (MaterialCardView) view.findViewById(R.id.legionst_card);
        mlegionstCard.setOnClickListener(this);

        mlegionthemesCard = (MaterialCardView) view.findViewById(R.id.legionthemes_card);
        mlegionthemesCard.setOnClickListener(this);

        mlegionlockscreenCard = (MaterialCardView) view.findViewById(R.id.legionlockscreen_card);
        mlegionlockscreenCard.setOnClickListener(this);

        mlegionnotificationCard = (MaterialCardView) view.findViewById(R.id.legionnotification_card);
        mlegionnotificationCard.setOnClickListener(this);

        mlegiongestureCard = (MaterialCardView) view.findViewById(R.id.legiongesture_card);
        mlegiongestureCard.setOnClickListener(this);

        mlegionnavbarCard = (MaterialCardView) view.findViewById(R.id.legionnavbar_card);
        mlegionnavbarCard.setOnClickListener(this);

        mlegionbuttonCard = (MaterialCardView) view.findViewById(R.id.legionbutton_card);
        mlegionbuttonCard.setOnClickListener(this);
		
        mlegionpowermenuCard = (MaterialCardView) view.findViewById(R.id.legionpowermenu_card);
        mlegionpowermenuCard.setOnClickListener(this);		

        mlegionanimationCard = (MaterialCardView) view.findViewById(R.id.legionanimation_card);
        mlegionanimationCard.setOnClickListener(this);
		
        mlegionmiscCard = (MaterialCardView) view.findViewById(R.id.legionmisc_card);
        mlegionmiscCard.setOnClickListener(this);	

        mlegionaboutCard = (MaterialCardView) view.findViewById(R.id.legionabout_card);
        mlegionaboutCard.setOnClickListener(this);		
        }

    @Override
    public void onClick(View view) {
        int id = view.getId();
            if (id == R.id.legionqs_card)
              {
                QuickSettings qsfragment = new QuickSettings();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.replace(this.getId(), qsfragment);
                transaction.addToBackStack(null);
                transaction.commit();
               }
            if (id == R.id.legionst_card)
              {
                StatusBarSettings statusbarfragment = new StatusBarSettings();
                FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                transaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction1.replace(this.getId(), statusbarfragment);
                transaction1.addToBackStack(null);
                transaction1.commit();
              }
            if (id == R.id.legionthemes_card)
              {
               Themes themesfragment = new Themes();
                FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
                transaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction2.replace(this.getId(), themesfragment);
                transaction2.addToBackStack(null);
                transaction2.commit();
               }
            if (id == R.id.legionlockscreen_card)
              {
                LockScreenSettings lockscreenfragment = new LockScreenSettings();
                FragmentTransaction transaction3 = getFragmentManager().beginTransaction();
                transaction3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction3.replace(this.getId(), lockscreenfragment);
                transaction3.addToBackStack(null);
                transaction3.commit();
               }
            if (id == R.id.legionnotification_card)
              {
                NotificationsSettings notificationfragment = new NotificationsSettings();
                FragmentTransaction transaction4 = getFragmentManager().beginTransaction();
                transaction4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction4.replace(this.getId(), notificationfragment);
                transaction4.addToBackStack(null);
                transaction4.commit();
              }
            if (id == R.id.legiongesture_card)
              {
                GestureSettings gesturefragment = new GestureSettings();
                FragmentTransaction transaction5 = getFragmentManager().beginTransaction();
                transaction5.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction5.replace(this.getId(), gesturefragment);
                transaction5.addToBackStack(null);
                transaction5.commit();
               }
            if (id == R.id.legionnavbar_card)
              {
                NavigationBarSettings navbarfragment = new NavigationBarSettings();
                FragmentTransaction transaction6 = getFragmentManager().beginTransaction();
                transaction6.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction6.replace(this.getId(), navbarfragment);
                transaction6.addToBackStack(null);
                transaction6.commit();
               }
            if (id == R.id.legionbutton_card)
              {
                ButtonSettings buttonfragment = new ButtonSettings();
                FragmentTransaction transaction7 = getFragmentManager().beginTransaction();
                transaction7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction7.replace(this.getId(), buttonfragment);
                transaction7.addToBackStack(null);
                transaction7.commit();
               }
            if (id == R.id.legionpowermenu_card)
              {
                PowerMenuSettings powermenufragment = new PowerMenuSettings();
                FragmentTransaction transaction7 = getFragmentManager().beginTransaction();
                transaction7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction7.replace(this.getId(), powermenufragment);
                transaction7.addToBackStack(null);
                transaction7.commit();
               }
            if (id == R.id.legionanimation_card)
              {
                AnimationSettings animationfragment = new AnimationSettings();
                FragmentTransaction transaction7 = getFragmentManager().beginTransaction();
                transaction7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction7.replace(this.getId(), animationfragment);
                transaction7.addToBackStack(null);
                transaction7.commit();
               }
            if (id == R.id.legionmisc_card)
              {
                MiscSettings miscfragment = new MiscSettings();
                FragmentTransaction transaction7 = getFragmentManager().beginTransaction();
                transaction7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction7.replace(this.getId(), miscfragment);
                transaction7.addToBackStack(null);
                transaction7.commit();
               }
            if (id == R.id.legionabout_card)
              {
                About aboutfragment = new About();
                FragmentTransaction transaction7 = getFragmentManager().beginTransaction();
                transaction7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction7.replace(this.getId(), aboutfragment);
                transaction7.addToBackStack(null);
                transaction7.commit();
               }			   
        }
        
    @Override           
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.LEGION_SETTINGS;
    }

    public static void lockCurrentOrientation(Activity activity) {
        int currentRotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int orientation = activity.getResources().getConfiguration().orientation;
        int frozenRotation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
        switch (currentRotation) {
            case Surface.ROTATION_0:
                frozenRotation = orientation == Configuration.ORIENTATION_LANDSCAPE
                        ? ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                        : ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                break;
            case Surface.ROTATION_90:
                frozenRotation = orientation == Configuration.ORIENTATION_PORTRAIT
                        ? ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
                        : ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                break;
            case Surface.ROTATION_180:
                frozenRotation = orientation == Configuration.ORIENTATION_LANDSCAPE
                        ? ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
                        : ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                break;
            case Surface.ROTATION_270:
                frozenRotation = orientation == Configuration.ORIENTATION_PORTRAIT
                        ? ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                        : ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                break;
        }
        activity.setRequestedOrientation(frozenRotation);
    }
}
