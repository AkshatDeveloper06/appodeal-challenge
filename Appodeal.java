package com.anshuman.Appodeal;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.appodeal.ads.Appodeal;
import com.appodeal.ads.Native;
import com.appodeal.ads.NativeAd;
import com.appodeal.ads.NativeAdView;
import com.appodeal.ads.UserSettings;
import com.appodeal.ads.InterstitialCallbacks;
import com.appodeal.ads.utils.Log;

@DesignerComponent(
        version = 1,
        description = "Appodeal Extension by Anshuman Mishra",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "images/extension.png")

@SimpleObject(external = true)
@UsesLibraries(libraries = "appodeal.jar")
@UsesPermissions(permissionNames = "android.permission.ACCESS_NETWORK_STATE, android.permission.INTERNET, android.permission.ACCESS_COARSE_LOCATION, android.permission.WRITE_EXTERNAL_STORAGE, android.permission.ACCESS_WIFI_STATE, android.permission.VIBRATE, android.permission.ACCESS_FINE_LOCATION")
@UsesApplicationMetadata(metaDataElements = {@MetaDataElement(name="com.google.android.gms.ads.APPLICATION_ID", value="[ADMOB_APP_ID]")})
public class Appodeal extends AndroidNonvisibleComponent {

    //Activity and Context
    private Context context;
    private Activity activity;

    public Appodeal(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleFunction(description = "Initializes Appodeal")
    public void Initialize(String appKey){
    Appodeal.initialize(activity, appKey, Appodeal.INTERSTITIAL | Appodeal.REWARDED_VIDEO | Appodeal.NATIVE | Appodeal.BANNER | Appodeal.MREC, consent);
    }
    @SimpleFunction(description = "Shows Appodeal Ads")
    public void ShowInterstitial() {
        Appodeal.show(activity, Appodeal.INTERSTITIAL);
    }
    @SimpleFunction(description = "Is Interstitial Loaded") 
    public void isInterstitialLoaded() {
       return Appodeal.isLoaded(Appodeal.INTERSTITIAL);
    }
    @SimpleFunction(description = "Sets up ads") 
    public void SetupAds() {
        Appodeal.setInterstitialCallbacks(new InterstitialCallbacks() {
  @Override
  public void onInterstitialLoaded(boolean isPrecache) {
   InterstitialAdLoaded();
  }
  @Override
  public void onInterstitialFailedToLoad() {
    InterstitialAdFailedToLoad();
  }
  @Override
  public void onInterstitialShown() {
    InterstitialAdShown();
  }
  @Override
  public void onInterstitialShowFailed() {
   InterstitialAdShowFailed();
  }
  @Override
  public void onInterstitialClicked() {
   InterstitialAdClicked();
  }
  @Override
  public void onInterstitialClosed() {
   InterstitialAdClosed();
  }
  @Override
  public void onInterstitialExpired()  {
    InterstitialAdExpired();
  }
});
Appodeal.setRewardedVideoCallbacks(new RewardedVideoCallbacks() {
  @Override
  public void onRewardedVideoLoaded(boolean isPrecache) {
    RewardedVideoLoaded();
  }
  @Override
  public void onRewardedVideoFailedToLoad() {
    RewardedVideoFailedToLoad();
  }
  @Override
  public void onRewardedVideoShown() {
   RewardedVideoShown();
  }
  @Override
  public void onRewardedVideoShowFailed() {
   RewardedVideoShowFailed();
  }
  @Override
  public void onRewardedVideoClicked() {
   RewardedVideoClicked();
  }
  @Override
  public void onRewardedVideoFinished(double amount, String name) {
    RewardedVideoFinished();
  }
  @Override
  public void onRewardedVideoClosed(boolean finished) {
    RewardedVideoClosed();
  }
  @Override
  public void onRewardedVideoExpired() {
    RewardedVideoExpired();
  }
});
    }
    @SimpleFunction(description = "Caches Interstitial")
    public void CacheInterstitial() {
        Appodeal.setAutoCache(Appodeal.INTERSTITIAL, true);
        Appodeal.cache(activity, Appodeal.INTERSTITIAL);
    }
    @SimpleEvent(description = "On Interstitial Ad Loaded")
    public void InterstitialAdLoaded(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdLoaded");
    }
    @SimpleEvent(description = "On interstitial failed to load")
    public void InterstitialAdFailedToLoad(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdFailedToLoad");
    }
    @SimpleEvent(description = "On interstitial ad shown")
    public void InterstitialAdShown(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdShown");
    }
    @SimpleEvent(description = "On interstitial ad show failed")
    public void InterstitialAdShowFailed(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdShowFailed");
    }
    @SimpleEvent(description = "On interstitial ad clicked")
    public void InterstitialAdClicked(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdClicked");
    }
    @SimpleEvent(description = "On interstitial ad closed")
    public void InterstitialAdClosed(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdClosed");
    }
    @SimpleEvent(description = "On interstitial expired")
    public void InterstitialAdExpired(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdExpired");
    }
    @SimpleEvent(description = "")
    public void RewardedVideoLoaded(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdExpired");
    }
    @SimpleEvent(description = "On rewarded loaded")
    public void RewardedVideoLoaded(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoLoaded");
    }
    @SimpleEvent(description = "On rewarded video failed to load")
    public void RewardedVideoFailedToLoad(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoFailedToLoad");
    }
    @SimpleEvent(description = "On rewarded video shown")
    public void RewardedVideoShown(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoShown");
    }
    @SimpleEvent(description = "On rewarded show failed")
    public void RewardedVideoShowFailed(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoShowFailed");
    }
    @SimpleEvent(description = "On rewarded video clicked")
    public void RewardedVideoClicked(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoClicked");
    }
    @SimpleEvent(description = "On rewarded finished")
    public void RewardedVideoFinished(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoFinished");
    }
    @SimpleEvent(description = "On rewarded closed")
    public void RewardedVideoClosed(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoClosed");
    }
    @SimpleEvent(description = "On rewarded video expire")
    public void RewardedVideoExpired(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoExpired");
    }
    @SimpleFunction(description = "Shows rewarded ad")
    public void ShowRewarded() {
        Appodeal.show(activity, Appodeal.REWARDED_VIDEO);
    }
    @SimpleFunction(description = "Caches the reward")
    public void CacheRewarded() {
        Appodeal.setAutoCache(Appodeal.REWARDED_VIDEO, true);
        Appodeal.cache(activity, Appodeal.REWARDED_VIDEO);
    }
    @SimpleFunction(description = "Sets user id")
    public void SetUserId(String userId) {
        Appodeal.getUserSettings(activity).setUserID(userId)
    }
    

}
