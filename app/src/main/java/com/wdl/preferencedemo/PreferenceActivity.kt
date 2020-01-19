package com.wdl.preferencedemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class PreferenceActivity : AppCompatActivity(),
    PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat?,
        pref: Preference?
    ): Boolean {
        val args = pref?.extras
        /**
         * 初始化跳转的设置PreferenceFragment
         */
        val fragment =
            supportFragmentManager.fragmentFactory.instantiate(classLoader, pref!!.fragment)
        fragment.arguments = args
        fragment.setTargetFragment(caller, 0)

        // 替换
        supportFragmentManager.beginTransaction().replace(R.id.mContainer, fragment)
            .addToBackStack(null)
            .commit()

        return true
    }

    companion object {
        fun show(context: Context) =
            context.startActivity(Intent(context, PreferenceActivity::class.java))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)
        supportFragmentManager.beginTransaction().replace(R.id.mContainer, SettingFragment())
            .commit()
    }
}
