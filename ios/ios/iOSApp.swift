import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
			ContentView(booksViewModelAdapter: BooksViewModelAdapter(id: 4))
		}
	}
}
