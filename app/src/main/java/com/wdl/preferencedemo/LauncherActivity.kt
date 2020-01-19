package com.wdl.preferencedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        Toast.makeText(this, intent.getStringExtra("extra_name"), Toast.LENGTH_LONG).show()
    }
}
