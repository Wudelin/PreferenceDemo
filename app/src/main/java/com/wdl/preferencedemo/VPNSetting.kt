package com.wdl.preferencedemo

import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat

/**
 * https://developer.android.google.cn/guide/topics/ui/settings/customize-your-settings#kotlin
 * Create by: wdl at 2020/1/19 14:57
 */
class VPNSetting : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.vpn_preferences, rootKey)
        /**
         * 通过findPreference方法传入对应的key查找偏好设置
         */
        val state = findPreference<SwitchPreferenceCompat>("vpn_state")

        // xml中可通过isPreferenceVisible属性判断此偏好设置是否显示;代码设置
        state?.isVisible = true


        /**
         * SimpleSummaryProvider获取偏好设置的值（动态更新摘要值）
         * xml中使用useSimpleSummaryProvider=“true”也可实现
         * listPreference.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()也可实现
         */
        val name = findPreference<EditTextPreference>("vpn_name")
        name?.summaryProvider = Preference.SummaryProvider<EditTextPreference> { preference ->
            val text = preference.text
            if (TextUtils.isEmpty(text)) {
                "No set"
            } else {
                "Value is $text"
            }
        }

        val port = findPreference<EditTextPreference>("vpn_port")

        /**
         * 控制弹出输入框的输入限定等
         */
        port?.let {
            it.summaryProvider = EditTextPreference.SimpleSummaryProvider.getInstance()
            it.setOnBindEditTextListener { edit ->
                /**
                 * 限定只能输入数字
                 */
                edit.inputType = InputType.TYPE_CLASS_NUMBER
            }
        }
    }
}