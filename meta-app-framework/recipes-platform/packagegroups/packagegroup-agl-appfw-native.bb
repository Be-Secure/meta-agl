SUMMARY = "The software for application framework of AGL IVI profile"
DESCRIPTION = "A set of packages belong to AGL application framework which required by \
Native App Fw Subsystem"

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-appfw-native \
    "

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    "
