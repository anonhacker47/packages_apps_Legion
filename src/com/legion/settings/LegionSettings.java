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
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Surface;
import android.preference.Preference;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;
import android.view.Window;  
import android.view.WindowManager;  
import android.view.WindowManager.LayoutParams;
import com.android.internal.policy.DecorView;
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
import com.legion.settings.utils.LUtils;

import com.android.settings.SettingsPreferenceFragment;

public class LegionSettings extends SettingsPreferenceFragment implements View.OnClickListener{

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
		    getActivity().getActionBar().hide();
                    getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
		    getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

       return inflater.inflate(R.layout.legion_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
            } else if (id == R.id.legionst_card)
              {
                StatusBarSettings statusbarfragment = new StatusBarSettings();
                FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                transaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction1.replace(this.getId(), statusbarfragment);
                transaction1.addToBackStack(null);
                transaction1.commit();
              
            } else if (id == R.id.legionthemes_card)
              {
               Themes themesfragment = new Themes();
                FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
                transaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction2.replace(this.getId(), themesfragment);
                transaction2.addToBackStack(null);
                transaction2.commit();
               
            } else if (id == R.id.legionlockscreen_card)
              {
                LockScreenSettings lockscreenfragment = new LockScreenSettings();
                FragmentTransaction transaction3 = getFragmentManager().beginTransaction();
                transaction3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction3.replace(this.getId(), lockscreenfragment);
                transaction3.addToBackStack(null);
                transaction3.commit();
               
            } else if (id == R.id.legionnotification_card)
              {
                NotificationsSettings notificationfragment = new NotificationsSettings();
                FragmentTransaction transaction4 = getFragmentManager().beginTransaction();
                transaction4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction4.replace(this.getId(), notificationfragment);
                transaction4.addToBackStack(null);
                transaction4.commit();
              
            } else if (id == R.id.legiongesture_card)
              {
                GestureSettings gesturefragment = new GestureSettings();
                FragmentTransaction transaction5 = getFragmentManager().beginTransaction();
                transaction5.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction5.replace(this.getId(), gesturefragment);
                transaction5.addToBackStack(null);
                transaction5.commit();
               
            } else if (id == R.id.legionnavbar_card)
              {
                NavigationBarSettings navbarfragment = new NavigationBarSettings();
                FragmentTransaction transaction6 = getFragmentManager().beginTransaction();
                transaction6.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction6.replace(this.getId(), navbarfragment);
                transaction6.addToBackStack(null);
                transaction6.commit();
               
            } else if (id == R.id.legionbutton_card)
              {
                ButtonSettings buttonfragment = new ButtonSettings();
                FragmentTransaction transaction7 = getFragmentManager().beginTransaction();
                transaction7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction7.replace(this.getId(), buttonfragment);
                transaction7.addToBackStack(null);
                transaction7.commit();
               
            } else if (id == R.id.legionpowermenu_card)
              {
                PowerMenuSettings powermenufragment = new PowerMenuSettings();
                FragmentTransaction transaction8 = getFragmentManager().beginTransaction();
                transaction8.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction8.replace(this.getId(), powermenufragment);
                transaction8.addToBackStack(null);
                transaction8.commit();
               
            } else if (id == R.id.legionanimation_card)
              {
                AnimationSettings animationfragment = new AnimationSettings();
                FragmentTransaction transaction9 = getFragmentManager().beginTransaction();
                transaction9.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction9.replace(this.getId(), animationfragment);
                transaction9.addToBackStack(null);
                transaction9.commit();
               
            } else if (id == R.id.legionmisc_card)
              {
                MiscSettings miscfragment = new MiscSettings();
                FragmentTransaction transaction10 = getFragmentManager().beginTransaction();
                transaction10.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction10.replace(this.getId(), miscfragment);
                transaction10.addToBackStack(null);
                transaction10.commit();
               
            } else if (id == R.id.legionabout_card)
              {
                About aboutfragment = new About();
                FragmentTransaction transaction11 = getFragmentManager().beginTransaction();
                transaction11.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction11.replace(this.getId(), aboutfragment);
                transaction11.addToBackStack(null);
                transaction11.commit();
              } 
        }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.LEGION_SETTINGS;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
}
