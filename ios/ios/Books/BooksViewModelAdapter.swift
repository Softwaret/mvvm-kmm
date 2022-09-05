//
//  BooksViewModelAdapter.swift
//  ios
//
//  Created by Jan Starczewski on 13/08/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

struct BookTile {
    let title: String
    let author: String
    let imageUrl: String
}

class BooksViewModelAdapter : ObservableObject {
    
    private let scope = CloseableCoroutineScope()
    
    private let viewModel : BooksViewModel
    
    private var uiStateTask : Task<Void, Error>? = nil
    
    @Published var bookTiles = [BookTile]()
    
    init(id: Int) {
        //Should be in some kind of AppDelegate etc.
        SharedApp().initialize(baseUrl: "https://wolnelektury.pl/api/", baseUrlParameters: [:])
        self.viewModel = BooksViewModelKt.BooksViewModel(scope: scope, paramsHolder: IosParamsHolder(params: ["id" : id]))
        uiStateTask = Task.init {
            try await AsyncFlowAdapter<BooksUiState>().subscribe(scope: scope, flow: viewModel.uiState) { state in
                self.bookTiles = state.bookTiles.map { commonTile in
                    BookTile(title: commonTile.title, author: commonTile.author, imageUrl: commonTile.imageUrl)
                }
            }
        }
    }
    
    func fetch() {
        viewModel.fetch()
    }
    
    deinit {
        viewModel.onClear()
        uiStateTask?.cancel()
        scope.close()
    }
}
