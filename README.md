# AR-Workshop:  Part 2

In this session we'll set up an Emulator for AR as well as add our first 3D model to our AR app.

### 1. AR Emulator
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


### 2. 3D objects in our app.
**Scene**: things you're adding to the world, 3d models. This is what u define<br/><br/> 
**View**: where your scene will be drawn<br/><br/>
**Node** A Node represents a transformation within the scene graph's hierarchy. It can contain a renderable for the rendering engine to render 
Each node can have an arbitrary number of child nodes and one parent. The parent may be another node, or the scene.
You can add touchlisteners to nodes and these events are propagated through the scene graph like android view hierachy.
a Node can contain 3d models or simple android view like textView<br/>

=> What is a transformable node?

**Anchor** Describes a fixed location and orientation in the real world. To stay at a fixed location in physical space, the numerical description of this position will update as ARCore's understanding of the space improves.

**Supported 3d model files**
- obj
- fbx
- glTF

**Sources of 3d model files:**
- [Poly](https://poly.google.com/)
- [Clara](https://clara.io/scenes)
- [Yobi](https://www.yobi3d.com/)
- [PinShape](https://pinshape.com/)
- [Free3D](https://free3d.com/)
- Use your talent


**Import objects**
1. Create a sampledata folder in your app. Right click 'app' folder, New -> sampledata. You may create extra folders in there according to your models.
2. Create assets folder inside the main folder of your app. Right click 'main' folder, New -> Folder -> Assets folder.
3. Go to [Poly](https://poly.google.com/) and search for any object. In the sample code, I searched for "cow"
4. Unzip your object into sampledata folder. You will use many objects so create a unique folder for each object you unzip.
Your folder should contain atleast an .obj file. It could also contain .mtl and other files.
5. Right click on you assets folder, New -> Sceneform Asset and import your object. The .sfb goes to the assets folder, .sfa goes to the sampledata folder.
6. Go to the code in this repo to see how to include your new 3d object into your scene :) 

Run it on your phone or simulator and scene the scene being created automatically for you.

**Manipulate object characteristics:**
- SFB - Materials[metallic, roughness, opacity, baseColorTint]
- SFB - Models [scale]

You can just download the code in this repo and play with it
