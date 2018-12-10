# AR-Workshop:  Part 1

In this session we'll set up Android Studio and get it ready for our first AR app.

1. Download the latest Android Studio from [here](https://developer.android.com/studio/)

2. Android Studio plugin: Sceneform. This will help us work with 3D assets.

3. Make a new app, Android 8+ 

4. Modify Android Manifest to include:
  	<uses-permission android:name="android.permission.CAMERA" />
	<uses-feature android:name="android.hardware.camera.ar" android:required="true"/>

	<meta-data android:name="com.google.ar.core" android:value="required" />

5. Modify 'project build.gradle' to include:
 classpath 'com.google.ar.sceneform:plugin:1.5.1'

6. Modify 'app build.gradle' to include: 
   apply plugin: 'com.google.ar.sceneform.plugin'

   compileOptions {
          sourceCompatibility JavaVersion.VERSION_1_8
          targetCompatibility JavaVersion.VERSION_1_8
   }
   
   dependencies {
       ....
   
       implementation "com.google.ar.sceneform:core:1.5.1"
       implementation "com.google.ar.sceneform.ux:sceneform-ux:1.5.1"
   }
      
7. In your main.xml, please add an ARFragment to make our lives easy.
      <fragment
          android:id="@+id/sceneform_fragment"
          android:name="com.google.ar.sceneform.ux.ArFragment"
          android:layout_width="match_parent"
          android:layout_height="match_parent"/>
          
Note: we've NOT included explicit ARCore capability checkers in order to make this example easy to follow.

8. Run your new app om on your phone and scene the scene being created automatically for you
