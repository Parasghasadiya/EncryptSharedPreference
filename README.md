# Encrypt Shared Preference Wrapper/Helper 
A small library containing a wrapper/helper for encrypting and decrypting data using the **[Google open Source Tink project](https://opensource.google/projects/tink)**. Tink will store keys in private shared preferences. On Android M or newer, the keys are further encrypted with a master key stored in Android Keystore.

 [![](https://jitpack.io/v/Parasghasadiya/encryptsharedpreference.svg)](https://jitpack.io/#Parasghasadiya/encryptsharedpreference)
# Dependency
Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        maven { 
            url 'https://jitpack.io' 
        }
    }
 }
```

Add the dependency
```
dependencies {
    implementation 'com.github.Parasghasadiya:encryptsharedpreference:1.0'
}
```

# Initialize
Using this library first of need to initialize share preference inside the OnCreate method at Application class of your app.
```
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        EncPref.Builder()
            .setContext(this) // Application context
            .serPrefName(this.packageName) //Your preference name
            .serUseDefaultPref(true) //With true the preference name will concat with suffix default_Pref
            .setDebuggable(false) //If true then library will not encrypt data.
            .build()
    }
}

```

# Features

- Supports api level 19(Kitkat) and above.
- Easy integration
- Supported data type String, Int, Boolean, Long, Double, Float


# How To Store Data

- ``` EncPref.putString(KEY, VALUE) ```
- ``` EncPref.putInt(KEY, VALUE) ```
- ``` EncPref.putBoolean(KEY, VALUE) ```
- ``` EncPref.putLong(KEY, VALUE) ```
- ``` EncPref.putDouble(KEY, VALUE) ```
- ``` EncPref.putFloat(KEY, VALUE) ```


# How To Retrieve Data

- ``` EncPref.getString(KEY) //Default value will "" ```
- ``` EncPref.getInt(KEY) //Default value will 0 ```
- ``` EncPref.getBoolean(KEY) //Default value will false ```
- ``` EncPref.getLong(KEY) //Default value will 0L ```
- ``` EncPref.getDouble(KEY) //Default value will 0.0 ```
- ``` EncPref.getFloat(KEY) //Default value will 0.0f ```

# Proguard-rule
```
-keep public class com.google.crypto.tink.** {
 private public protected *;
}
```

# License
```
Copyright 2020 Paras Ghasadiya

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
