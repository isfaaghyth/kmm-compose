import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        HelperKt.initKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}