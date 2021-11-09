package com.lampa.dogiz.ui.behavior

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewpager2.widget.ViewPager2

class DogsLayoutBehavior : CoordinatorLayout.Behavior<ViewPager2>() {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: ViewPager2, dependency: View): Boolean {
        return super.layoutDependsOn(parent, child, dependency)
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: ViewPager2, dependency: View): Boolean {
        animation(child, dependency)
        return true
    }

    private fun animation(
        child: ViewPager2, dependency: View
    ) {
        child.y = dependency.y;
        child.y = (dependency.y / 0.5f);
    }
}