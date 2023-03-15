
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNReplaceSelectedSpec.h"

@interface ReplaceSelected : NSObject <NativeReplaceSelectedSpec>
#else
#import <React/RCTBridgeModule.h>

@interface ReplaceSelected : NSObject <RCTBridgeModule>
#endif

@end
