package com.facebook.react.uimanager;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.Callback;

import android.app.Activity;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.views.textinput.ReactEditText;

@ReactModule(name = ReplaceSelectedModule.NAME)
public class ReplaceSelectedModule extends ReactContextBaseJavaModule {
  public static final String NAME = "ReplaceSelected";

  public ReplaceSelectedModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  private ReactEditText getEditById(int id) {
    UIViewOperationQueue uii = null;
    ReactEditText edit = null;

    while (edit == null) {
      uii = this.getReactApplicationContext().getNativeModule(UIManagerModule.class).getUIImplementation().getUIViewOperationQueue();

      try {
        edit = (ReactEditText) uii.getNativeViewHierarchyManager().resolveView(id);
      } catch (IllegalViewOperationException e) {

      }
    }

    return edit;
  }

  @ReactMethod
  public void replaceSelected(final int tag, final String text) {
    UiThreadUtil.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        final Activity activity = getCurrentActivity();
        final ReactEditText edit = getEditById(tag);
        if (edit == null) {
          return;
        }

        int start = Math.max(edit.getSelectionStart(), 0);
        int end = Math.max(edit.getSelectionEnd(), 0);
        edit.getText().replace(Math.min(start, end), Math.max(start, end), text, 0, text.length());
      }
    });
  }
}
