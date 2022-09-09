import SwiftUI
import shared

@main
struct iOSApp: App {
    
	var body: some Scene {
		WindowGroup {
			ContentView(booksViewModelAdapter: BooksViewModelAdapter(id: 4))
		}
	}

    init() {
        SharedApp().initialize(baseUrl: "https://wolnelektury.pl/api/", baseUrlParameters: [:])
    }
}
