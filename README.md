# Euclidean Sequence Generator

[![Download](https://api.bintray.com/packages/volcanomobile/public/euclidean-sequence-generator/images/download.svg?version=0.3.0) ](https://bintray.com/volcanomobile/public/euclidean-sequence-generator/0.3.0/link)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Build Status](https://travis-ci.org/VolcanoMobile/euclidean-sequence-generator.svg?branch=master)](https://travis-ci.org/VolcanoMobile/euclidean-sequence-generator)

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
    repositories {
        maven { url "https://dl.bintray.com/volcanomobile/public" }
    }
}
```

Then, add the library to your module `build.gradle`
```gradle
dependencies {
    implementation 'net.volcanomobile:euclidean-sequence-generator:0.3.0'
}
