//
//  BooksViewModelAdapter.swift
//  ios
//
//  Created by Jan Starczewski on 13/08/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
import Combine

class BooksViewModelAdapter: ObservableObject {
    
    @Published var bookTiles = [BookTile]()

    private let scope = CloseableCoroutineScope()
    private let viewModel: BooksViewModel

    private var subscription: AnyCancellable?
    
    init(id: Int) {
        self.viewModel = BooksViewModelKt.BooksViewModel(scope: scope, paramsHolder: IosParamsHolder(params: ["id" : id]))
        subscription = BooksUiStatePublisher(viewModel: viewModel)
            .sink { [weak self] state in
                self?.bookTiles = state.bookTiles.map(BookTile.init)
            }
    }
    
    func fetch() {
        viewModel.fetch()
    }
    
    deinit {
        viewModel.onClear()
        subscription?.cancel()
        scope.close()
    }
}
