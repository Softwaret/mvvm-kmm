//
//  BooksUiStatePublisher.swift
//  ios
//
//  Created by Karol Bielski on 09/09/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Combine
import shared

struct BooksUiStatePublisher: Publisher {

    typealias Output = BooksUiState
    typealias Failure = Never

    private let viewModel: BooksViewModel

    init(viewModel: BooksViewModel) {
        self.viewModel = viewModel
    }

    func receive<S: Subscriber>(subscriber: S) where S.Input == BooksUiState, S.Failure == Failure {
        let subscription = BooksUiStateSubscription(viewModel: viewModel, subscriber: subscriber)
        subscriber.receive(subscription: subscription)
    }

    final class BooksUiStateSubscription<S: Subscriber>: Subscription where S.Input == BooksUiState, S.Failure == Failure {
        private var subscriber: S?
        private var job: Kotlinx_coroutines_coreJob? = nil
        private let scope = CloseableCoroutineScope()

        private let viewModel: BooksViewModel

        init(viewModel: BooksViewModel, subscriber: S) {
            self.viewModel = viewModel
            self.subscriber = subscriber

            job = NativeFlowTypeWrapper<BooksUiState>(flow: viewModel.uiState)
                .subscribe(
                    scope: scope,
                    onEach: { state in
                        _ = subscriber.receive(state!)
                    },
                    onComplete: {
                        subscriber.receive(completion: .finished)
                    },
                    onThrow: { error in
                        debugPrint(error)
                    }
                )
        }

        func cancel() {
            subscriber = nil
            job?.cancel(cause: nil)
        }

        func request(_ demand: Subscribers.Demand) {}
    }
}
