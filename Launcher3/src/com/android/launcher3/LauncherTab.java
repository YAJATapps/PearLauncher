package com.android.launcher3;

import com.android.launcher3.Launcher.LauncherOverlay;
import com.android.launcher3.nowcompanion.GNowClient;

public class LauncherTab {

    private GNowClient mLauncherClient;

    public LauncherTab(Launcher launcher) {
        mLauncherClient = new GNowClient(launcher);

        launcher.setLauncherOverlay(new LauncherOverlays());
    }

    protected GNowClient getClient() {
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
