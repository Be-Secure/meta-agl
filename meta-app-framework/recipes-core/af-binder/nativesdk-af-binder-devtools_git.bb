require af-binder_${PV}.inc

DEPENDS = "nativesdk-json-c"

inherit cmake pkgconfig nativesdk

EXTRA_OECMAKE:append = " -DONLY_DEVTOOLS=TRUE"

