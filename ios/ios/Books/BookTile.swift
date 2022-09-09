//
//  BookTile.swift
//  ios
//
//  Created by Karol Bielski on 09/09/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

struct BookTile: Identifiable {
    
    let id = UUID()
    let title: String
    let author: String
    let imageUrl: String

    init(tile: shared.BookTile) {
        title = tile.title
        author = tile.author
        imageUrl = tile.imageUrl
    }
}
