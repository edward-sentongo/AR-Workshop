# AR-Workshop:  Part 1

In this session we'll set up Android Studio and get it ready for our first AR app.

1. Download the latest Android Studio from [here](https://developer.android.com/studio/)

2. Android Studio plugin: Sceneform. This will help us work with 3D assets.

3. Make a new app, Android 8+ 

4. Modify Android Manifest to include:
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="YOUR-APP-ID">

    <uses-permission android:name="android.permission.CAMERA" />
    <uses-feature android:name="android.hardware.camera.ar" 
    android:required="true" />

    <application
        <activity android:name=".MainActivity">
	......
        </activity>
        <meta-data
            android:name="com.google.ar.core"
            android:value="required" />
    </application>

</manifest>
```

5. Modify 'project build.gradle' to include:
```
 classpath 'com.google.ar.sceneform:plugin:1.9.0'
```

6. Modify 'app build.gradle' to include: 
   
```
apply plugin: 'com.android.application'

android {
    compileSdkVersion 28
    defaultConfig {
        applicationId "YOUR-APP-ID"
        minSdkVersion 27
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            ....
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation 'com.google.ar:core:1.9.0'
    ...
    implementation "com.google.ar.sceneform.ux:sceneform-ux:1.9.0"
}

apply plugin: 'com.google.ar.sceneform.plugin'
```
      
7. In your activity_main.xml, please add an ARFragment to make our lives easy.
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">
    <fragment
        android:id="@+id/sceneform_fragment"
        android:name="com.google.ar.sceneform.ux.ArFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
</LinearLayout>
```
You don't have to use LinearLayout. You may use FrameLayout, RelativeLayout, ConstraintLayout etc
 
8. In your MainActivity.java, please add import the fragment you made in step 7.
```
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.ar.sceneform.ux.ArFragment;

public class MainActivity extends AppCompatActivity {

    private ArFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = (ArFragment)
                getSupportFragmentManager().findFragmentById(R.id.sceneform_fragment);
    }
}
```

9. Run your new app om on your phone and scene the scene being created automatically for you
