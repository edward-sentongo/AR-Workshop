# AR-Workshop:  Part 3
Let's add some motion and transformation to our app.  
You previous had a node, we'd like to make it transformable in order to scale it and move it anywhere. -> <strong>Transformable node.</strong>
**Replace the cow.sfb with any model you created.** 
1. Make a subclass 'TransformableNode' and call it Animal. Overide any defaults.  
  - Vector 3: a 3d location.  
  - Quaternion: a Vector 3 + angular motion. 
  You can simply copy the code below to save time:
```
public class Animal extends TransformableNode {


    @Nullable
    private ObjectAnimator walkingAnimation = null;

    @Nullable
    private ObjectAnimator rotationAnimation = null;

    public Animal(TransformationSystem transformationSystem) {
        super(transformationSystem);
    }

    @Override
    public void onUpdate(FrameTime frameTime) {
        super.onUpdate(frameTime);

        if (walkingAnimation != null) {
            walkingAnimation.resume();
            float animatedFraction = walkingAnimation.getAnimatedFraction();
            walkingAnimation.setDuration(getAnimationDuration());
            walkingAnimation.setCurrentFraction(animatedFraction);
        }
    }

    @Override
    public void onActivate() {
    }

    @Override
    public void onDeactivate() {
        stopWalkingAnimation();
    }

    private long getAnimationDuration() {
        return (long) (1000 * 360 / (47f * 2));
    }


    /*****
     * WALKING
     * ******/
    public void startWalkingAnimation() {
        if (walkingAnimation != null) {
            return;
        }
        walkingAnimation = createWalkingAnimator(this);
        walkingAnimation.setTarget(this);
        walkingAnimation.setDuration(getAnimationDuration());
        walkingAnimation.start();
    }

    public void stopWalkingAnimation() {
        if (walkingAnimation == null) {
            return;
        }
        walkingAnimation.cancel();
        walkingAnimation = null;
    }



    /** Returns an ObjectAnimator that makes this node move forward. */
    private static ObjectAnimator createWalkingAnimator(Animal nodeToWalk) {
        /* Notes:
        Vector3
        x: makes it move sideways.
        y: makes it ascend a.k.a climb upwards
        z: makes it move "forward" to wards the phone

        thus,
         - if facing away from phone, move -Z, if facing phone, move +z
         - if facing left, move -X, if facing right, move +X
         - else up & down for choice you may wish
         */
        Vector3 location1 = new Vector3(0.0f, 0.0f, nodeToWalk.getLocalPosition().x - 0.1f);
        Vector3 location2 = new Vector3(0.0f, 0.0f, nodeToWalk.getLocalPosition().x - 0.2f);
        Vector3 location3 = new Vector3(0.0f, 0.0f, nodeToWalk.getLocalPosition().x - 0.3f);
        Vector3 location4 = new Vector3(0.0f, 0.0f, nodeToWalk.getLocalPosition().x - 0.4f);


        ObjectAnimator linearAnimation = new ObjectAnimator();
        linearAnimation.setObjectValues(location1, location2, location3, location4);

        // Next, give it the localRotation property.
        linearAnimation.setPropertyName("localPosition");

        // Use Sceneform's QuaternionEvaluator.
        linearAnimation.setEvaluator(new Vector3Evaluator());

        //  Allow orbitAnimation to repeat forever
        linearAnimation.setInterpolator(new LinearInterpolator());
        linearAnimation.setAutoCancel(true);

        return linearAnimation;
    }


    /******
     * ROTATION
     * ******/
    public void startRotationAnimation() {
        if (rotationAnimation != null) {
            return;
        }
        rotationAnimation = createRotationAnimator();
        rotationAnimation.setTarget(this);
        rotationAnimation.setDuration(getAnimationDuration());
        rotationAnimation.start();
    }

    public void stopRotationAnimation() {
        if (rotationAnimation== null) {
            return;
        }
        rotationAnimation.cancel();
        rotationAnimation = null;
    }

    /** Returns an ObjectAnimator that makes this node rotate. */
    private static ObjectAnimator createRotationAnimator() {
        // Node's setLocalRotation method accepts Quaternions as parameters.
        // First, set up orientations that will animate a circle.
        Quaternion orientation1 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 0);
        Quaternion orientation2 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 120);
        Quaternion orientation3 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 240);
        Quaternion orientation4 = Quaternion.axisAngle(new Vector3(0.0f, 1.0f, 0.0f), 360);

        ObjectAnimator orbitAnimation = new ObjectAnimator();
        orbitAnimation.setObjectValues(orientation1, orientation2, orientation3, orientation4);

        // Next, give it the localRotation property.
        orbitAnimation.setPropertyName("localRotation");

        // Use Sceneform's QuaternionEvaluator.
        orbitAnimation.setEvaluator(new QuaternionEvaluator());

        //  Allow orbitAnimation to repeat forever
        orbitAnimation.setRepeatCount(ObjectAnimator.INFINITE);
        orbitAnimation.setRepeatMode(ObjectAnimator.RESTART);
        orbitAnimation.setInterpolator(new LinearInterpolator());
        orbitAnimation.setAutoCancel(true);

        return orbitAnimation;
    }
}
```

2. Modify the addToScene class inside main to look like below. It will now have a tap listener on the your node:
```
    //3. Now add it to AR Fragment
    private void addNodeToScene(ArFragment fragment, Anchor anchor, Renderable renderable) {
        AnchorNode anchorNode = new AnchorNode(anchor);
        //Now we have a transformable node
        Animal animal = new Animal(fragment.getTransformationSystem());
        animal.setRenderable(renderable);
        animal.setParent(anchorNode);

        animal.setOnTapListener(new Node.OnTapListener() {
            @Override
            public void onTap(HitTestResult hitTestResult, MotionEvent motionEvent) {
                //animal.startWalkingAnimation();
                animal.startRotationAnimation();
            }
        });
        fragment.getArSceneView().getScene().addChild(anchorNode);
    }
```
3. Running the code now should give you a scalable object which can rotate. Tip: you can make it move side ways as well.
4. Let's try the linear motion animator: Vector3Evaluator().  
5. Let's use the angular motion animator: QuaternionEvaluator().  
6. Download the code in this repository and play with it.  
  
Ask questions please.  
Run it on your phone or simulator and scene the scene being created automatically for you.  
Extra, go to [Edward's fun project](https://github.com/edward-sentongo/AR-Workshop-123), clone it and modify it the way you wish.



