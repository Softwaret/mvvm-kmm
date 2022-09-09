import SwiftUI

struct ContentView: View {
    
    @ObservedObject
    var booksViewModelAdapter: BooksViewModelAdapter

    var body: some View {
        List(booksViewModelAdapter.bookTiles) { book in
            Text(book.title)
        }
        .onAppear {
            booksViewModelAdapter.fetch()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(booksViewModelAdapter: BooksViewModelAdapter(id: 3))
    }
}
