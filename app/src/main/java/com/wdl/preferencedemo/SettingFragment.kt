package com.wdl.preferencedemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

/**
 * A simple [Fragment] subclass.
 */
class SettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        val click = findPreference<Preference>("click")
        /**
         * 设置点击事件
         */
        click?.setOnPreferenceClickListener {
            true
        }
    }
}
