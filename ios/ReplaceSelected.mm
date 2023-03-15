#import "ReplaceSelected.h"
#import "RCTUIManager.h"
#import "RCTBaseTextInputView.h"

@implementation ReplaceSelected
RCT_EXPORT_MODULE()

@synthesize bridge = _bridge;

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(replaceSelected:(nonnull NSNumber *)reactTag withText:(NSString*)text) {
    UITextField *view = (UITextField *)(((RCTBaseTextInputView*)[_bridge.uiManager viewForReactTag:reactTag]).backedTextInputView);

    [view replaceRange:view.selectedTextRange withText:text];
}

// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeReplaceSelectedSpecJSI>(params);
}
#endif

@end


