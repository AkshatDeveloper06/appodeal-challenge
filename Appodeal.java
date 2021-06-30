package com.anshuman.Appodeal;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

@DesignerComponent(
        version = 1,
        description = "Appodeal Extension by Anshuman Misrha",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "images/extension.png")

@SimpleObject(external = true)
//Libraries
@UsesLibraries(libraries = "appodeal.jar")
//Permissions
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

    @SimpleFunction()
    public void Initialize(String appKey){
    Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL | Appodeal.REWARDED_VIDEO | Appodeal.NATIVE | Appodeal.BANNER | Appodeal.MREC, consent);
    }
    @SimpleFunction()
    public void ShowInterstitial() {
        Appodeal.show(activity, Appodeal.INTERSTITIAL);
    }
    @SimpleFunction() 
    public void isInterstitialLoaded() {
       return Appodeal.isLoaded(Appodeal.INTERSTITIAL);
    }
    @SimpleFunction() 
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
    @SimpleFunction()
    public void CacheInterstitial() {
        Appodeal.setAutoCache(Appodeal.INTERSTITIAL, true);
        Appodeal.cache(activity, Appodeal.INTERSTITIAL);
    }
    @SimpleEvent()
    public void InterstitialAdLoaded(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdLoaded");
    }
    @SimpleEvent()
    public void InterstitialAdFailedToLoad(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdFailedToLoad");
    }
    @SimpleEvent()
    public void InterstitialAdShown(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdShown");
    }
    @SimpleEvent()
    public void InterstitialAdShowFailed(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdShowFailed");
    }
    @SimpleEvent()
    public void InterstitialAdClicked(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdClicked");
    }
    @SimpleEvent()
    public void InterstitialAdClosed(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdClosed");
    }
    @SimpleEvent()
    public void InterstitialAdExpired(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdExpired");
    }
    @SimpleEvent()
    public void RewardedVideoLoaded(){
        EventDispatcher.dispatchEvent(this, "InterstitialAdExpired");
    }
    @SimpleEvent()
    public void RewardedVideoLoaded(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoLoaded");
    }
    @SimpleEvent()
    public void RewardedVideoFailedToLoad(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoFailedToLoad");
    }
    @SimpleEvent()
    public void RewardedVideoShown(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoShown");
    }
    @SimpleEvent()
    public void RewardedVideoShowFailed(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoShowFailed");
    }
    @SimpleEvent()
    public void RewardedVideoClicked(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoClicked");
    }
    @SimpleEvent()
    public void RewardedVideoFinished(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoFinished");
    }
    @SimpleEvent()
    public void RewardedVideoClosed(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoClosed");
    }
    @SimpleEvent()
    public void RewardedVideoExpired(){
        EventDispatcher.dispatchEvent(this, "RewardedVideoExpired");
    }
    @SimpleFunction()
    public void ShowRewarded() {
        Appodeal.show(activity, Appodeal.REWARDED_VIDEO);
    }
    @SimpleFunction()
    public void CacheInterstitial() {
        Appodeal.setAutoCache(Appodeal.REWARDED_VIDEO, true);
        Appodeal.cache(activity, Appodeal.REWARDED_VIDEO);
    }
    @SimpleFunction()
    public void SetUserId(String userId) {
        Appodeal.getUserSettings(activity).setUserID(userId)
    }
    

}
