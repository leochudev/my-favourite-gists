# My Favourite Gists

A favourite gists app for practicing Android development best practice with Android Jetpack.

Introduction
------------
Android Jetpack is a set of components, tools and guidance to make great Android apps. Using Android Jetpack, we can easily write testable and scalable code.

Implemented feature
-----------------

Build a local database and fetch latest gists through [GitHub V3 API][40] at the background while first launching the app. For each gist, if the owner has shared more than 5 gists, show the owner's name and the share count. After clicking the gist item, go to the detail page. The detail page shows the information of the gist and has a favourite button. After clicking the favourite button, it changes the state of the gist at the gist list page. The favourite state of the gist will be stored locally at the device.

[40]: https://developer.github.com/v3/

To do list
-----------------

- Add class comments
- Swipe down the list and fetch new gists using GitHub v3 public API.
- Apply OAuth 2 to exceed the limit of GitHub v3 API call limit. (Currently call limit is 60.)
- Separate the api call for getting public gists list and each user share count for making the app more responsive.
- TBD

Libraries Used
--------------
* [Foundation][0] - Components for core system capabilities, Kotlin extensions and support for
  multidex and automated testing.
  * [AppCompat][1] - Degrade gracefully on older versions of Android.
  * [Android KTX][2] - Write more concise, idiomatic Kotlin code.
* [Architecture][10] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [Lifecycles][11] - Create a UI that automatically responds to lifecycle events.
  * [LiveData][12] - Build data objects that notify views when the underlying database changes.
  * [Navigation][13] - Handle everything needed for in-app navigation.
  * [Room][14] - Access your app's SQLite database with in-app objects and compile-time checks.
  * [ViewModel][15] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
  * [WorkManager][16] - Manage your Android background jobs.
* [UI][30] - Details on why and how to use UI Components in your apps - together or separate
  * [Fragment][31] - A basic unit of composable UI.
  * [Layout][32] - Lay out widgets using different algorithms.
* Third party
  * [Kotlin Coroutines][90] for managing background threads with simplified code and reducing needs for callbacks

[0]: https://developer.android.com/jetpack/components
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[10]: https://developer.android.com/jetpack/arch/
[11]: https://developer.android.com/topic/libraries/architecture/lifecycle
[12]: https://developer.android.com/topic/libraries/architecture/livedata
[13]: https://developer.android.com/topic/libraries/architecture/navigation/
[14]: https://developer.android.com/topic/libraries/architecture/room
[15]: https://developer.android.com/topic/libraries/architecture/viewmodel
[16]: https://developer.android.com/topic/libraries/architecture/workmanager
[30]: https://developer.android.com/guide/topics/ui
[31]: https://developer.android.com/guide/components/fragments
[32]: https://developer.android.com/guide/topics/ui/declaring-layout
[90]: https://bumptech.github.io/glide/
[90]: https://kotlinlang.org/docs/reference/coroutines-overview.html
