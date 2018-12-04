package com.sentongoapps.arworkshop;

import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.view.animation.LinearInterpolator;

import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.math.Vector3Evaluator;
import com.google.ar.sceneform.ux.TransformableNode;
import com.google.ar.sceneform.ux.TransformationSystem;

public class Animal extends TransformableNode {


    @Nullable
    private ObjectAnimator walkingAnimation = null;

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
}

