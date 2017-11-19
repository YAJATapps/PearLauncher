package com.android.launcher3;

import com.android.launcher3.Launcher.LauncherOverlay;
import com.android.launcher3.nowcompanion.ILauncherClient;

public class LauncherTab {

    private ILauncherClient mLauncherClient;

    public LauncherTab(Launcher launcher) {
        mLauncherClient = ILauncherClient.Companion.create(launcher);

        launcher.setLauncherOverlay(new LauncherOverlays());
    }

    protected ILauncherClient getClient() {
        return mLauncherClient;
    }

    private class LauncherOverlays implements LauncherOverlay {
        @Override
        public void onScrollInteractionBegin() {
            mLauncherClient.startMove();
        }

        @Override
        public void onScrollInteractionEnd() {
            mLauncherClient.endMove();
        }

        @Override
        public void onScrollChange(float progress, boolean rtl) {
            mLauncherClient.updateMove(progress);
        }
    }
}
