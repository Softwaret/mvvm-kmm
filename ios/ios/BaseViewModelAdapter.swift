//
//  BaseViewModelAdapter.swift
//  ios
//
//  Created by Jan Starczewski on 13/08/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class BaseViewModelAdapter<ViewModel : MvvmViewModel> : ObservableObject {
    
    let scope: CloseableCoroutineScope
    let viewModel: ViewModel
    
    init(
        viewModel: ViewModel,
        scope : CloseableCoroutineScope = CloseableCoroutineScope()
    ) {
        self.viewModel = viewModel
        self.scope = scope
    }
    
    deinit {
        viewModel.onClear()
        scope.close()
    }
}
