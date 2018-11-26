# AR-Workshop:  Part 1

Initial Setup:
- Android Studio plugin: Sceneform
- Android Manifest:
  	<uses-permission android:name="android.permission.CAMERA" />
	<uses-feature android:name="android.hardware.camera.ar" android:required="true"/>

	<meta-data android:name="com.google.ar.core" android:value="required" />

- project build.gradle:
 classpath 'com.google.ar.sceneform:plugin:1.5.1'

- app build.gradle: 
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
      
      

- layout.xml:
      <fragment
          android:id="@+id/sceneform_fragment"
          android:name="com.google.ar.sceneform.ux.ArFragment"
          android:layout_width="match_parent"
          android:layout_height="match_parent"/>
          
          

Run it on your phone or simulator and scene the scene being created automatically for you
