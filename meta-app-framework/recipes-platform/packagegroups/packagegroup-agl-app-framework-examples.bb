SUMMARY = "AGL Application Framework examples"
DESCRIPTION = "The set of examples associated to the AGL Application Framework"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-app-framework-examples \
    "

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    "
