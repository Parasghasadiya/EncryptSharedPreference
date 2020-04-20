package com.encryptpreference

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.encryptpreference.test", appContext.packageName)

        val pref = EncPref.Builder()
            .setContext(appContext)
            .serPrefName("${appContext.packageName}_test")
            .serUseDefaultPref(false)
            .setDebuggable(false)
            .build()

        val stringBuilder = StringBuilder()
        for (i in 1..500) {
            pref.putString(i.toString(), i.toString())
            pref.putInt(i.toString(), kotlin.random.Random.nextInt(1, i+1))
            pref.putBoolean("${i}_bool", i % 2 == 0)
            pref.putLong("${i}_long", kotlin.random.Random.nextLong(1, (i+1).toLong()))
            pref.putDouble("${i}_double", kotlin.random.Random.nextDouble(1.0, (i+1).toDouble()))
            pref.putFloat("${i}_float", kotlin.random.Random.nextFloat())
        }
        for (i in 1..500) {
            val valueString = pref.getString(i.toString())
            assertEquals(true, valueString.isNotEmpty())
            stringBuilder.append(valueString)

            stringBuilder.append("\n")

            val valueInt = pref.getInt(i.toString())
            assertEquals(true, valueInt > 0)
            stringBuilder.append(valueInt)

            stringBuilder.append("\n")

            val valueBool = pref.getBoolean("${i}_bool")
            assertEquals(i % 2 == 0, valueBool)
            stringBuilder.append(valueBool)

            stringBuilder.append("\n")

            val valueLong = pref.getLong("${i}_long")
            assertEquals(true, valueLong != 0L)
            stringBuilder.append(valueLong)

            stringBuilder.append("\n")

            val valueDouble = pref.getDouble("${i}_double")
            assertEquals(true, valueDouble != 0.0)
            stringBuilder.append(valueDouble)

            stringBuilder.append("\n")

            val valueFloat = pref.getFloat("${i}_float")
            assertEquals(true, valueFloat != 0.0f)
            stringBuilder.append(valueFloat)
        }
        Log.d("PrefValue", stringBuilder.toString())

    }
}
