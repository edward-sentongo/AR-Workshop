# AR-Workshop:  Part 2

In this session we'll set up an Emulator for AR as well as add our first 3D model to our AR app.

### AR Emulator
1. Android Studio 3.1 +
2. Android Oreo: API 27 (x86) (with Google PlayStore services)
3. Verify Configuration -> Show Advanced Settings -> Camera Back == VirtualScene.
4. Camera: "VirtualScene"
5. Emulator -> Settings -> Advanced -> Renderer maximum (upto OpenGL ES 3.1)
6. Download "ARCore_*_x86_for_emulator.apk" from [here](https://github.com/google-ar/arcore-android-sdk/releases)
7. Drag & drop it on the emulator for it to install

**Controls:**
- Mouse click on screan
- Option/Alt + WASQED
- Just experiment around :) We'll load our first app into an emulator.

You can also load images for augumented images in your virtual world
[Emulator instructions](https://developers.google.com/ar/develop/java/emulator)


### 3D objects in our app.
1. Theory:
    Node:
    Transformable Nodes:
    3d objects: OBJ, SFX, SFB etc
    Model:
    Model Renderable:
    Pose:
    Anchor:

2. Import objects
    @Project:
        app -> sampledata -> models
        main -> assets 
                sfb, sfa

    @Poly: https://poly.google.com/
    "cow", unzip obj, mtl and png to sampledata -> models.


    Performance over rendering. Thus if your assets has many polygons and the engine wants to keep an optimum frame rate, render quality will be low.
    
    Sources of 3d models: 
    - https://poly.google.com/ [100% commercial and guaranteed compartibility]
    - https://clara.io/scenes
    - https://www.yobi3d.com/
    - https://pinshape.com/
    - https://free3d.com/

3. Manipulate object characteristics:
    SFB - Materials[metallic, roughness, opacity, baseColorTint]
    SFB - Models [scale]


Run it on your phone or simulator and scene the scene being created automatically for you
