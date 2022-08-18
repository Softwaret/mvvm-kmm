//
//  AsyncNativeFlowAdapter.swift
//  ios
//
//  Created by Jan Starczewski on 16/08/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared


enum AsyncError: Error {
    
    case NilUpdate
    case OnThrow(throwable: KotlinThrowable)
}

class AsyncNatvieFlowTypeWrapper<T : AnyObject> {
    
    @MainActor
    func subscribe(
        scope: CloseableCoroutineScope,
        flow: Kotlinx_coroutines_coreFlow,
        update: @MainActor @escaping (T) -> ()
    ) async throws {
        try await withCheckedThrowingContinuation { continuation in
            NativeFlowTypeWrapper<T>(flow: flow).subscribe(scope: scope) { item in
                if(item == nil) {
                    continuation.resume(throwing: AsyncError.NilUpdate)
                }
                update(item!)
            } onComplete: {
                continuation.resume()
            } onThrow: { throwable in
                continuation.resume(throwing: AsyncError.OnThrow(throwable: throwable))
            }
        }
    }
}
