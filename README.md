# Movie-Viewer

This is a test app that uses Kotlin. It is structured using Clean Architecture in a modular approach while using MVVM in the presentation layer. One of the advantages of having modular structure is faster build time. This is usually ideal for bigger app that may take 10 minutes or more to build. This type of structuring supports scalability in case you need to add more heavy functions while completing the roadmap, and enable you to easily reuse specific modules to another app. You can easily add more modules for additional big features (can be a feature flow), non ui module, and/or instant app. However, doing modular also comes with added complexity especially if it involves annotation processing. This is more challenging if you are used to developing single module which is easier and more straightforward. For that type of structuring, please see other projects of this account.

This app will be using popular libraries like Retrofit, Dagger, RX, Moshi and Architecture Components such as Livedata, Paging, Room, Lifecycle and ViewModel. It is also using JUnit, Google Truth, Espresso and Mockito for testing. This project is still a work in progress. Currently working on the presentation layer and may have to modify the domain and data layer.

TODO: Pagination

![Sample Preview](preview.gif)
