### Android Application for Tecnoesis 2020

**required libraries :** 

1: butterknife

2: Android Architecture Components -- ViewModel and LiveData

3: Timber : for logging

4: Retrofit and GSON : for Api Requests

5: Material Design Components MDC


## Naming Patterns

**layouts**
`type_name`




|||
|--|--|
|MainActivity|activity_main|
|HomeFragment|fragment_home|
|for listLayouts in recyclers etc|item_user|

**id naming**

    type_context_viewType_purpose

|desc|id|
|-|-|
|TextView in MainActivty|act_main_tv_headline|
|Button in MainActivty|act_main_btn_submit|




## Project Structure



    |-- tenx
        |-- Config.java
        |-- data
        |   |-- AppDataManager.java
        |   |-- AppDataManagerHelper.java
        |   |-- models
        |   |   |-- EventResponse.java
        |   |-- rest
        |       |-- events
        |           |-- AppEventHelper.java
        |           |-- EventsApiService.java
        |-- logging
        |   |-- ReleaseTree.java
        |-- modules
        |   |-- RetrofitProvider.java
        |-- ui
            |-- MyApplication.java
            |-- main
            |   |-- MainActivity.java
            |   |-- MainViewModel.java
            |   |-- about
            |   |   |-- AboutFragment.java
            |   |   |-- AboutViewModel.java
            |   |-- events
            |   |   |-- EventsFragment.java
            |   |   |-- EventsViewModel.java
            |   |-- home
            |   |   |-- HomeFragment.java
            |   |   |-- HomeViewModel.java
            |   |   |-- HomeViewModelHelper.java
            |   |-- schedule
            |       |-- ScheduleFragment.java
            |       |-- ScheduleViewModel.java
            |-- splash
                |-- SplashActivity.java



| directory/files |purpose  |
|--|--|
|  `data`| Contains Data Services , REST calls , Firebase, Shared Prefs etc  |
|`AppDataManager`|Encapsulates all data sources into a single entity by combining the interfaces and implementing them|
|`modules`|provides service instances. Most singleton instances is created by `double checked synchronized block`|
|`logging`|This is not setup yet. It should upload errors to server|
|`ui`|contains the Activities and Fragments . The hierarchy is followed as Application ==> Activities ==> Fragments. An Application is a single entity of the application. But it can have multiple Activities. Each Activity also can have multiple fragments.|
|`ViewModels`|Each Activity and Fragment has its own view model. View model connects data to view. Remember the FragmentViewModel will live as long as the Fragment but its containing Activity will persist. So you have to decide wisely which Viewmodel to use and when. Also note that it is possible for an Application to only use its `own` viewmodel (not implemented here) and not others. An Activity can access its `own` view model and `appViewModel`. A Fragment View Model can access all three view models. This is because of the heirarchy stated above |
|`config`|contains configuration keys|
