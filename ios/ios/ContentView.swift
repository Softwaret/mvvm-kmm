import SwiftUI

struct ContentView: View {
    
    @ObservedObject
    var booksViewModelAdapter: BooksViewModelAdapter

	var body: some View {
        Text("ELO \(booksViewModelAdapter.bookTiles.count)")
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
