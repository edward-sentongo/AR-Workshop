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
**Scene**: things you're adding to the world, 3d models. This is what u define 
**View**: where your scene will be drawn
**Node** A Node represents a transformation within the scene graph's hierarchy. It can contain a renderable for the rendering engine to render. 
Each node can have an arbitrary number of child nodes and one parent. The parent may be another node, or the scene.
You can add touchlisteners to nodes and these events are propagated through the scene graph like android view hierachy.
a Node can contain 3d models or simple android view like textView

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
    -@Project:
        app -> sampledata -> models|sfa|obj|mtl|png. All these are needed for rendering your asset
        main -> assets/sfb
    -@Poly: https://poly.google.com/
    -"cow", unzip obj, mtl and png to sampledata -> models.
    -Performance over rendering. That's why Poly is ideal. Otherwise you'll get low quality anyway
    

**Manipulate object characteristics:**
    SFB - Materials[metallic, roughness, opacity, baseColorTint]
    SFB - Models [scale]


Run it on your phone or simulator and scene the scene being created automatically for you
